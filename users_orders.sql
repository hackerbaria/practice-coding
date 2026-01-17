DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    status TEXT NOT NULL,
    total_amount NUMERIC(10,2) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_orders_user
        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_name TEXT NOT NULL,
    quantity INT NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    CONSTRAINT fk_items_order
        FOREIGN KEY (order_id) REFERENCES orders(id)
);

TRUNCATE TABLE
    order_items,
    orders,
    users
CASCADE;


-- Insert users (100k)
INSERT INTO users (email, created_at)
SELECT
    'user' || g || '@test.com',
    now() - (g || ' days')::interval
FROM generate_series(1, 100000) g;


--Insert orders (1M, FK-safe)
INSERT INTO orders (user_id, status, total_amount, created_at)
SELECT
    u.id,
    CASE WHEN random() < 0.7 THEN 'PAID' ELSE 'PENDING' END,
    round((random() * 500)::numeric, 2),
    now() - (random() * 365) * interval '1 day'
FROM users u
ORDER BY random()
LIMIT 1000000;

---Insert order_items (3M, FK-safe)
INSERT INTO order_items (order_id, product_name, quantity, price)
SELECT
    o.id,
    'product_' || (random() * 100)::int,
    (random() * 5)::int + 1,
    round((random() * 100)::numeric, 2)
FROM orders o
ORDER BY random()
LIMIT 3000000;


---Step 1 Index for filtering (user_id + status)
EXPLAIN ANALYZE
SELECT *
FROM orders
WHERE user_id = 12345
  AND status = 'PAID'
ORDER BY created_at DESC
LIMIT 20;

CREATE INDEX idx_orders_user_status_created
ON orders (user_id, status, created_at DESC);


--- problem 2(join)
EXPLAIN ANALYZE
SELECT o.id, o.total_amount, u.email
FROM orders o
JOIN users u ON u.id = o.user_id
WHERE o.status = 'PAID'
  AND o.created_at >= now() - interval '30 days'
ORDER BY o.created_at DESC;

CREATE INDEX idx_orders_status_created_user
ON orders (status, created_at DESC, user_id);

-- Problem 3 Slow query #3 (aggregation)
EXPLAIN ANALYZE
SELECT u.id, u.email, COUNT(o.id) AS order_count
FROM users u
JOIN orders o ON o.user_id = u.id
WHERE o.created_at >= now() - interval '90 days'
GROUP BY u.id, u.email
ORDER BY order_count DESC
LIMIT 10;

CREATE INDEX idx_orders_created_user
ON orders (created_at, user_id);




