# Java Interview Practice – DSA, Multithreading, Lambdas

This is my personal Java/Maven playground for preparing coding interviews and job searches.

It contains small, focused examples for:
- Data structures & algorithms (DSA)
- Common problem-solving patterns (sliding window, two pointers, etc.)
- Multithreading & concurrency
- Modern Java features like lambdas
- (Future) Spring Boot, Spring Security, and design patterns

---

## Tech Stack & Prerequisites

- Java (version as defined in `pom.xml`)
- Maven (standard Maven project with `pom.xml`)
- IntelliJ IDEA (recommended IDE)

---

## Beyond DSA: Backend & Design Skills to Practice

DSA gets you past online assessments and coding rounds, but real-world Java roles also expect:

- **Spring Boot** – building REST APIs, handling configuration, profiles, and dependency injection.
- **Spring Security & Authentication** – securing endpoints, JWT / OAuth2, method-level security, and common auth flows.
- **Design Patterns** – writing clean, maintainable code using patterns like Strategy, Factory, Builder, Singleton, Template Method, etc.

### How I plan to use this repo for non-DSA practice

- Add a `spring/` module or package with:
  - Small Spring Boot REST endpoints.
  - Examples of exception handling, validation, and logging.
- Add security-focused examples:
  - Basic auth vs. token-based auth.
  - Role/authority-based access control.
- Add design-pattern-focused packages, e.g.:
  - `patterns/creational`, `patterns/structural`, `patterns/behavioral`.
  - Each pattern gets a minimal, focused example class with a short comment explaining when to use it.

This way the repo covers both **algorithmic skills (DSA)** and **practical backend skills (Spring + design patterns)** I need for job interviews.

---

## DSA Patterns Cheat Sheet

DSA problems are **pattern-based**, not problem-based.
Once you master these core techniques:

- Sliding Window
- Two Pointers
- Hashing (HashMap / HashSet)
- Binary Search
- Dynamic Programming (DP)

…you can solve a large portion of typical interview problems.

### How to Choose the Right Technique

1. **Continuous subarray / substring?** → Sliding Window  
2. **Sorted + pair search?** → Two Pointers / Binary Search  
3. **Repeated calculation?** → DP / Prefix Sum  
4. **Need fast lookup?** → Hashing  
5. **All combinations?** → Backtracking  
6. **Optimization?** → Greedy / DP  

### 1. Sliding Window

**When to use**
- Input is array or string
- You are dealing with **continuous elements**
- You need longest / shortest / count subarray or substring

**Keywords / signals**
- substring / subarray
- consecutive / continuous
- longest / shortest
- "at most" / "at least"
- window of size `k`

**Common cases**
- Longest substring without repeating characters
- Longest substring with at most `K` distinct characters
- Longest substring with exactly `K` distinct characters
- Minimum window substring
- Max / average sum subarray of size `K`
- Permutation in string

#### Sliding Window Template (REMEMBER THIS)

```text
left = 0
right = 0

while right < length(s):
    add s[right] to window

    while window is invalid:
        remove s[left] from window
        left = left + 1

    update answer
    right = right + 1
```

**Don’t use when**
- You need a **subsequence** (not necessarily contiguous)
- Negative numbers break the window logic (some sum problems)

### 2. Two Pointers

**When to use**
- Array / string is **sorted**
- You need pairs / triplets
- You compare elements from both ends

**Keywords / signals**
- sorted
- pair / triplet
- palindrome
- remove duplicates in-place

**Common cases**
- Two Sum (sorted array)
- Container With Most Water
- Valid palindrome
- Remove duplicates from sorted array
- 3Sum / 4Sum

**Don’t use when**
- Data is unsorted (unless you sort first)
- You need non-contiguous elements

### 3. Hashing (HashMap / HashSet)

**When to use**
- Need **fast lookup**
- Tracking frequency
- Detecting duplicates
- Mapping values to indices

**Keywords / signals**
- first occurrence
- frequency
- count
- duplicates
- mapping

**Common cases**
- Two Sum (unsorted)
- Anagram check
- Longest consecutive sequence
- Majority element
- Group anagrams

**Don’t use when**
- Order matters and can’t be stored separately
- Memory is extremely limited

### 4. Binary Search

**When to use**
- Data is **sorted**, or
- Answer space is **monotonic** (yes/no as you move in one direction)
- You need minimum / maximum feasible value

**Keywords / signals**
- sorted
- first / last occurrence
- minimum / maximum
- feasible / possible

**Common cases**
- Search in rotated sorted array
- First / last position of element
- Find minimum in rotated array
- Capacity to ship packages within `D` days
- Koko eating bananas

**Don’t use when**
- Data / answer space has no monotonic property
- A simple linear scan is already optimal

### 5. Dynamic Programming (DP)

**When to use**
- Problem has **overlapping subproblems**
- Has **optimal substructure**
- Recursive solution repeats work

**Keywords / signals**
- maximum / minimum
- number of ways
- best / optimal
- choose or skip
- overlapping

**Common cases**
- Fibonacci
- Coin change
- Knapsack
- Longest common subsequence
- Longest increasing subsequence

**Don’t use when**
- A greedy solution works
- Subproblems are independent

### One-glance Comparison

| Problem signal           | Technique         |
|--------------------------|-------------------|
| Continuous window        | Sliding Window    |
| Sorted + pairs           | Two Pointers      |
| Fast lookup / count      | Hashing           |
| Sorted / answer range    | Binary Search     |
| Optimal + overlapping    | DP                |

### Interview Mental Shortcut

Ask yourself:
1. Is it **continuous**? → Sliding Window  
2. Is it **sorted**? → Two Pointers / Binary Search  
3. Need **lookup / count**? → Hashing  
4. Need **best result repeatedly**? → DP

---

## Quick Start

### 1. Open & Run in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. **File → Open…** and select the folder that contains `pom.xml`.
3. Let IntelliJ import the Maven project and download dependencies.
4. Find the main class at `src/main/java/org/example/Main.java`.
5. Right‑click the class and choose **Run 'Main.main()'**.
6. To run specific exercises (e.g. `dsa.slidingWindow.array.MergeSortedArrays`), open the class, right‑click it, and run its `main` method (if present) or its tests (when added).

### 2. Run from Maven CLI

From the project root (where `pom.xml` lives):

```bash
# Compile
mvn clean compile

# (Optional) Run the main entry point – requires exec-maven-plugin configured in pom.xml
mvn exec:java -Dexec.mainClass="org.example.Main"

# (Optional) Run tests once they are added
mvn test
```

---

## Project Structure

Code is grouped by topic and common interview patterns.

- `src/main/java/dsa`
  - `common`
    - Classic interview problems and utilities
    - e.g. `LongestSubString`, `SellStock`
  - `slidingWindow`
    - `array` – sliding window problems on arrays (`MergeSortedArrays`, `RevertString`)
    - `hashmap` – problems using hash maps (`TwoSum`)
    - `hashtable` – frequency / recurrence problems (`FirstRecurringCharacter`)
  - `twoPointers`
    - Two‑pointer style problems (`PalindromeNumber`)

- `src/main/java/multithreading`
  - Concurrency and parallelism examples
  - `AsyncApiSimulation`
  - `BankTransferExample`, `BankTransferDeadlockExample`
  - `ExecutorExample`, `ScheduledExample`
  - `RecursiveSumTask`, `FileProcessingSimulation`

- `src/main/java/lambda`
  - Simple examples to contrast pre‑lambda and lambda style
  - `BeforeLambda`, `Bird`

- `src/main/java/org/example/Main.java`
  - Optional entry point to quickly run or dispatch to different examples.

---

## How I Use This Repo

- When preparing for interviews or a job search, I:
  - Pick a topic (e.g. sliding window, two pointers, multithreading).
  - Implement or re‑implement a problem in the matching package.
  - Try multiple approaches and compare readability/performance.
  - Add comments or TODOs about edge cases and improvements.
  - (Planned) Add JUnit tests to automatically check solutions.

This keeps my Java skills sharp and gives me a quick place to revisit patterns before interviews.

---

## Ideas for Future Exercises & Extensions

**DSA & Problem Solving**
- Add more patterns: binary search, fast/slow pointers, backtracking, dynamic programming, graphs, trees, heaps.
- Implement classic interview problems (LRU cache, producer–consumer, rate limiter, etc.).
- Add JUnit tests for each problem to cover edge cases.

**Multithreading & Concurrency**
- Examples using `CompletableFuture` and parallel streams.
- More demos of deadlocks, race conditions, and their fixes.
- Simulate small real‑world systems (job queue, bounded buffer, async pipeline).

**Modern Java & Tooling**
- More lambdas/streams exercises (map/filter/reduce).
- Refactor some solutions using streams and Optionals.
- Add basic static analysis or formatting rules if needed.

This README is mainly a reminder for future me, but it should also make sense if I share the repo with interviewers or friends.
