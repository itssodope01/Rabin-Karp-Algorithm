# Rabin-Karp Rolling Hash Technique

Rabin-Karp is a string-search algorithm that uses a hash function to quickly find patterns. It computes the hash of the pattern and the hash of each substring in the text of the same length as the pattern. If the hash values match, the algorithm further verifies if the actual substring matches the pattern, reducing the need for direct string comparisons.

## Suspicious Points Finder with Rabin-Karp Algorithm

This repository provides both **Java** and **Python** implementations of a **pattern-matching algorithm** using the **Rabin-Karp rolling hash** technique. This method efficiently locates all occurrences of a given pattern `P` within a larger text `T`, commonly used for fast substring matching tasks.

## Table of Contents

- [Introduction](#introduction)
- [Problem Statement](#problem-statement)
- [Algorithm](#algorithm)
- [Setup and Usage](#setup-and-usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The **Rabin-Karp algorithm** is ideal for tasks involving fast text searching, such as:

- Plagiarism detection
- Keyword searching in large documents
- DNA sequence analysis
- Any context requiring multiple exact matches of a pattern within a large text

## Problem Statement

Given a string `T` (the text) and a string `P` (the pattern), find all starting indices in `T` where `P` appears as an exact substring. This task is often called **pattern matching**.

### Input

- `T`: A string representing the text.
- `P`: A string representing the pattern to find within the text.
- `q`: A prime number used as a modulus to reduce hash collisions.

### Output

- A list of all starting indices in `T` where `P` is found as an exact substring.

## Algorithm

The algorithm leverages the **Rabin-Karp rolling hash** approach:

1. Computes a hash value for the pattern `P` and for each substring of `T` of the same length.
2. If a substring hash matches the pattern hash, a direct comparison verifies the substring.
3. Uses a rolling hash to efficiently update the substring hash as the search window slides, avoiding recalculating the hash from scratch each time.

### Complexity

- **Time Complexity**: Average-case `O(n + m)`, where `n` is the length of `T` and `m` is the length of `P`.
- **Space Complexity**: `O(m)`, used primarily for storing the hash values.

## Setup and Usage

To run this code:

1. Clone this repository:
   ```bash
   git clone https://github.com/itssodope01/Rabin-Karp-Algorithm.git
   cd "Rabin-Karp-Algorithm"
   ```

### Java

2. Compile and run the Java program:

   ```bash
   cd java
   javac SuspiciousPointsFinder.java
   java SuspiciousPointsFinder
   ```

   ### Parameters

   You can change the text `T`, pattern `P`, and prime number `q` in the `main` method to test different cases.

### Python

Alternatively, you can run the Python version of the code:

```bash
cd python
python suspicious_points_finder.py
```

### Parameters

You can change the values of `T`, `P`, and `q` in the `if __name__ == "__main__"` section in `suspicious_points_finder.py` to test different cases.

## Examples

The following example searches for the pattern "26" in the text "31415926535":

### Java

```java
String T = "31415926535";
String P = "26";
int q = 11;

SuspiciousPointsFinder finder = new SuspiciousPointsFinder(T, P, q);
List<Integer> suspiciousPoints = finder.findSuspiciousPoints();
System.out.println("Suspicious points: " + suspiciousPoints);
```

### Python

```python
T = "31415926535"
P = "26"
q = 11

suspicious_points = find_suspicious_points(T, P, q)
print("Suspicious points:", suspicious_points)
```

**Expected Output**:

```
Suspicious points: [4, 6]
```

## Contributing

Contributions are welcome! Please open an issue to discuss any improvements or new features.

## License

This project is licensed under the MIT License.
