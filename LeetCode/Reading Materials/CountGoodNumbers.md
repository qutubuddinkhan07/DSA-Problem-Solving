# LeetCode 1922 — Count Good Numbers

## Problem Summary

Build digit strings of length `n` where:

- **Even index** (0, 2, 4, ...) → must be an **even digit**: `{0, 2, 4, 6, 8}` → **5 choices**
- **Odd index** (1, 3, 5, ...) → must be a **prime digit**: `{2, 3, 5, 7}` → **4 choices**

A string satisfying both rules is called a **good number** (leading zeros allowed, e.g. `"04"` is valid).

**Goal:** Count how many such strings exist, modulo `10^9 + 7` (since `n` can be up to `10^15`).

> `"2582"` is just *one example* of a valid good number, not a target output. The problem asks you to **count all valid
strings**, not produce one.

---

## Understanding With Small Examples

### n = 1

Only index 0 (even) → 5 valid strings: `"0", "2", "4", "6", "8"`
**Answer: 5**

### n = 2

- Index 0 (even): 5 choices
- Index 1 (odd): 4 choices

Total = 5 × 4 = **20** valid strings (e.g. `"02"`, `"03"`, `"22"`, `"23"`, ...)

### n = 4

- Index 0 (even): 5
- Index 1 (odd): 4
- Index 2 (even): 5
- Index 3 (odd): 4

Total = 5 × 4 × 5 × 4 = **400**

`"2582"` (2-even ✓, 5-prime ✓, 8-even ✓, 2-prime ✓) is one of these 400 strings.

| n  | Meaning                         | Output    |
|----|---------------------------------|-----------|
| 1  | good strings of length 1        | 5         |
| 4  | good strings of length 4        | 400       |
| 50 | good strings of length 50 (mod) | 564908303 |

---

## The Formula

```
even_count = ceil(n / 2)   // number of even-index positions
odd_count  = floor(n / 2)  // number of odd-index positions

answer = 5^even_count * 4^odd_count   (mod 1_000_000_007)
```

Since `n` can be as large as `10^15`, you **cannot** loop and multiply digit by digit — you need **fast modular
exponentiation** to compute `base^exp mod MOD` in `O(log exp)` time.

---

## Python Solution

```python
class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD = 10**9 + 7
        even_count = (n + 1) // 2   # positions 0, 2, 4, ...
        odd_count  = n // 2         # positions 1, 3, 5, ...
        return (pow(5, even_count, MOD) * pow(4, odd_count, MOD)) % MOD
```

Python's built-in `pow(base, exp, mod)` already performs fast modular exponentiation.

---

## Java Solution (Corrected)

### Bugs Found in the Original Attempt

1. **Wrong MOD constant**
   `1_000_000_07` = `100,000,007` (underscores don't add digits — this is missing a zero). Correct value:
   `1_000_000_007` = `1,000,000,007` = `10^9 + 7`.

2. **`Math.pow` uses `double`**
   `double` only has ~15–17 significant decimal digits of precision. `Math.pow(5, 25)` etc. silently loses accuracy
   before the modulo is even applied.

3. **Modulo applied only at the end**
   `5^25 * 4^25` is astronomically large — far beyond what `double`/`int` can represent exactly. You must reduce `% MOD`
   **at every multiplication step**, not just once at the end (this is the entire point of modular exponentiation).

### Fixed Code

```java
public class CountGoodNumbers {
    public static void main(String[] args) {
        MathematicalCountSolution obj1 = new MathematicalCountSolution();
        System.out.println(obj1.countGoodNumbers(1));
        System.out.println(obj1.countGoodNumbers(4));
        System.out.println(obj1.countGoodNumbers(50));
    }
}

class MathematicalCountSolution {
    private static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long result = (modPow(5, evenCount) * modPow(4, oddCount)) % MOD;
        return (int) result;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;                      // keep base < MOD before squaring (overflow safety)
        while (exp > 0) {
            if ((exp & 1) == 1) {         // current lowest bit of exp is 1?
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;   // square base: 5^1 -> 5^2 -> 5^4 -> 5^8 ...
            exp >>= 1;                     // move to next bit
        }
        return result;
    }
}
```

**Output:**

```
5
400
564908303
```

---

## How `modPow` Works (Fast Modular Exponentiation)

Also called **exponentiation by squaring**. It computes `base^exp mod MOD` without ever forming the true, astronomically
large value of `base^exp`.

### Core idea

Any exponent can be decomposed via its **binary representation**. Example:

```
25 in binary = 11001 = 16 + 8 + 1
5^25 = 5^16 * 5^8 * 5^1
```

Each power-of-two term (`5^1, 5^2, 5^4, 5^8, 5^16, ...`) is obtained by repeatedly **squaring** the previous one — so
reaching `5^16` takes only 4 squarings instead of 16 multiplications. This gives `O(log exp)` time.

### Line-by-line

```java
private long modPow(long base, long exp) {
    long result = 1;    // accumulates the answer
    base %= MOD;    // reduce base upfront so it's guaranteed < MOD

    while (exp > 0) {
        if ((exp & 1) == 1) {    // is the lowest bit of exp 1(is exp odd)?
            result = (result * base) % MOD;    // fold this power of base into result
        }

        base = (base * base) % MOD;    // square base
        exp >>= 1;    // shift to the next bit
    }

    return result;
}
```

- `exp & 1` checks the least significant bit — tells us whether this power of `base` belongs in the product.
- `exp >>= 1` is integer division by 2 (bit shift), advancing to the next bit.
- Every multiplication is immediately reduced `% MOD`, so intermediate values never exceed roughly `MOD²` (~10^18) —
  safely within `long` range (max ~9.2 × 10^18).

### Dry Run: `modPow(5, 25)` (ignoring MOD for clarity)

`25` in binary = `11001`

| Step | exp (binary) | exp odd? | result before | result after           | base after squaring |
|------|--------------|----------|---------------|------------------------|---------------------|
| 1    | 11001 (25)   | yes      | 1             | 1 × 5 = **5**          | 5² = 25             |
| 2    | 01100 (12)   | no       | 5             | 5 (unchanged)          | 25² = 625           |
| 3    | 00110 (6)    | no       | 5             | 5 (unchanged)          | 625² = 390625       |
| 4    | 00011 (3)    | yes      | 5             | 5 × 390625 = 1953125   | 390625² = ...       |
| 5    | 00001 (1)    | yes      | 1953125       | × base⁴ → final `5^25` | —                   |

`result` only multiplies in `base` on iterations where the current bit is `1` — exactly matching the `16 + 8 + 1`
decomposition.

### Why `base %= MOD` at the start?

Not strictly needed here since `base` is only ever `4` or `5` (already `< MOD`). But it's a **defensive habit**:

- If `base` were large (e.g. `3,000,000,000`, bigger than `MOD ≈ 10^9`), squaring it directly (`base * base`) could get
  close to `long`'s overflow limit (~9.2 × 10^18) before the modulo is applied.
- Reducing `base %= MOD` once upfront guarantees `base < MOD` (~10^9), so every subsequent squaring is at most
  `(10^9)² = 10^18` — comfortably within `long` range.
- If `base` is already small, this line is a harmless no-op.

**Rule of thumb:** Reduce operands `% MOD` *before* multiplying, not just after — keep every intermediate value bounded
rather than relying on `long` "just barely" not overflowing.

---

## Complexity

| Aspect | Complexity                                                                 |
|--------|----------------------------------------------------------------------------|
| Time   | `O(log n)` — modular exponentiation over both `even_count` and `odd_count` |
| Space  | `O(1)` — no extra data structures, constant number of variables            |

This is what makes the solution feasible even for `n` up to `10^15`, where a naive `O(n)` loop would be far too slow.

---

## Alternative: Recursive (Per-Digit-Position) Approach

A tempting first attempt is to recurse one digit position at a time, branching over the valid digit choices at each
index.

### The Buggy Version

```java
class RecursiveCountNumbers {
    final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        return helper(0, (int) n);
    }

    private int helper(int index, int n) {
        if (index == n)
            return 1;

        int result = 0;
        if (index % 2 == 0) {
            int[] evenDigits = {0, 2, 4, 6, 8};
            for (int digit : evenDigits) {
                result = (result + helper(index + 1, n)) % MOD;
            }
        } else {
            int[] primeDigits = {2, 3, 5, 7};
            for (int digit : primeDigits) {
                result = (result + helper(index + 1, n)) % MOD;
            }
        }

        return result;
    }
}
```

### Bugs in This Version

1. **`(int) n` truncates the input.**
   `n` can be up to `10^15`, but `int` maxes out around `2.1 × 10^9`. Casting silently overflows/wraps for large `n`,
   producing garbage before recursion even starts.

2. **Exponential blow-up — no memoization, redundant recursive calls.**
   The loop calls `helper(index + 1, n)` **again for every digit**, even though that call doesn't depend on which digit
   was picked. Instead of computing the "rest of the string" count once and multiplying, each digit choice re-triggers
   the entire remaining subtree from scratch. Total calls grow like `5^evenCount * 4^oddCount` — literally the size of
   the final answer. For `n = 50` that's already ~`10^32` calls; it will never finish.

3. **Recursion depth = `n` → stack overflow.**
   Even with memoization, one call frame per index means depth `n`. Java's default stack (a few tens of thousands of
   frames) can't handle `n` in the millions, let alone `10^15`.

### The Corrected Version

The fix: compute `helper(index + 1, n)` **once**, then multiply by the number of valid digit choices at that index (5
for even, 4 for odd) instead of looping and re-recursing.

```java
class RecursiveCountNumbers {
    static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        return (int) helper(0, n);
    }

    private long helper(long index, long n) {
        if (index == n)
            return 1;

        long remaining = helper(index + 1, n); // compute the rest ONCE

        long result;
        if (index % 2 == 0) {
            result = (remaining * 5) % MOD;  // 5 even-digit choices: {0,2,4,6,8}
        } else {
            result = (remaining * 4) % MOD;  // 4 prime-digit choices: {2,3,5,7}
        }

        return result;
    }
}
```

**What changed:**

- `index` and `n` are `long` throughout — no truncation.
- `helper(index + 1, n)` is called exactly once per index, then the result is multiplied by 5 or 4 depending on parity —
  matching the same math as `result += helper(...)` repeated 5 or 4 times, without the wasted repeated calls.

### Dry Run (n = 4)

```
helper(4,4) = 1
helper(3,4) = helper(4,4) * 4 = 4        (index 3 is odd  -> 4 prime digits)
helper(2,4) = helper(3,4) * 5 = 20       (index 2 is even -> 5 even digits)
helper(1,4) = helper(2,4) * 4 = 80       (index 1 is odd  -> 4 prime digits)
helper(0,4) = helper(1,4) * 5 = 400      (index 0 is even -> 5 even digits)
```

`countGoodNumbers(4) = 400` ✓ matches the expected output.

### Complexity Comparison

| Version                                       | Time                   | Recursion depth       |
|-----------------------------------------------|------------------------|-----------------------|
| Buggy original                                | `O(5^n)` (exponential) | `n`                   |
| Corrected linear recursion                    | `O(n)`                 | `n`                   |
| `modPow`-based iterative solution (see above) | `O(log n)`             | `O(1)` (no recursion) |

### Caveat

The corrected linear recursion is genuinely correct and fine for moderate `n`, but it still makes **one recursive call
per index**, so it's `O(n)` time *and* `O(n)` recursion depth. For LeetCode's actual constraint (`n` up to `10^15`), the
call stack overflows long before reaching the base case, and `O(n)` time is far too slow regardless. **Only the `modPow`
-based `O(log n)` solution (see above) is fast enough to pass for the full constraint range.**

A middle ground that keeps a recursive *feel* while restoring `O(log n)` performance is a **divide-and-conquer recursive
`modPow`**, e.g. `helper(index, n) = helper(index, mid) * helper(mid, n)` — splitting the range in half each call
instead of stepping one index at a time.