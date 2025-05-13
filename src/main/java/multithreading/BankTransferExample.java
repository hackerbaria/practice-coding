package multithreading;


// Deadlock-Free Bank Transfer Using Lock Ordering
public class BankTransferExample {
    static class Account {
        private final int id;
        private int balance;

        public Account(int id, int initialBalance) {
            this.id = id;
            this.balance = initialBalance;
        }

        public int getId() {
            return id;
        }

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient funds");
            }
        }

    }

    static class Bank {
        // Lock ordering based on account ID to prevent deadlock
        public void transfer(Account from, Account to, int amount) {
            Account firstLock = from.getId() < to.getId() ? from : to;
            Account secondLock = from.getId() < to.getId() ? to : from;

            synchronized (firstLock) {
                synchronized (secondLock) {
                    if(from.getBalance() >= amount) {
                        from.withdraw(amount);
                        to.deposit(amount);
                        System.out.printf("Transferred %d from A%d to A%d. Balances: A%d=%d, A%d=%d%n",
                                amount, from.getId(), to.getId(),
                                from.getId(), from.getBalance(), to.getId(), to.getBalance());
                    } else {
                        System.out.printf("Insufficient funds to transfer %d from A%d to A%d%n",
                                amount, from.getId(), to.getId());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account(1, 1000);
        Account account2 = new Account(2, 1000);

        Bank bank = new Bank();

        // Thread 1: A1 -> A2
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                bank.transfer(account1, account2, 100);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: A2 -> A1
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                bank.transfer(account2, account1, 100);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balances:");
        System.out.println("Account 1: " + account1.getBalance());
        System.out.println("Account 2: " + account2.getBalance());
    }
}
