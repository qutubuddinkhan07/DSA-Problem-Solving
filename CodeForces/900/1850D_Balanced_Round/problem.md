# Balanced Round — [CF 1850D](https://codeforces.com/problemset/problem/1850/D)

**Tags:** sorting, greedy, brute force · **Rating:** 900 · **Time limit:** 2s · **Memory limit:** 256MB

## Problem

You're setting a Codeforces round with `n` problems, where problem `i` has difficulty `a[i]`. You may:

- remove any number of problems, then
- arrange the rest in any order.

A round is **balanced** if the absolute difference between every pair of *consecutive* problems in that arrangement is
at most `k`.

Find the minimum number of problems you must remove so that some arrangement of the remaining problems is balanced.

**Constraints:** `1 ≤ t ≤ 1000`, `1 ≤ n ≤ 2·10^5` (sum of `n` over all test cases ≤ `2·10^5`), `1 ≤ k ≤ 10^9`,
`1 ≤ a[i] ≤ 10^9`.

## Intuition

Since we're free to reorder the kept problems however we like, the real question becomes: **what's the largest subset of
problems that *can* be arranged into a balanced sequence?** Whatever's left over is what we remove.

Two key observations get us there:

1. **Sorted order is always the best arrangement for a given subset.** If you fix which problems you're keeping,
   arranging them in sorted order minimizes the largest gap between any two consecutive problems. Any other ordering can
   only make some adjacent gap larger, never smaller. So checking whether a subset *can* be balanced reduces to checking
   whether its *sorted* consecutive differences are all `≤ k`.

2. **The best subset is always a contiguous run of the fully sorted array.** Suppose you picked some subset whose sorted
   consecutive gaps are all `≤ k`, but skipped over an element `x` that sits *between* two of your chosen elements in
   sorted order. Since the array is sorted, `x` is squeezed between two values that already differ by at most `k`, so
   `x` is even closer to each of its new neighbors than they were to each other. Adding it back in can never break the
   `≤ k` condition — it can only help. So there's never a reason to "skip" an element in the middle of a sorted range;
   the optimal kept set is always one unbroken stretch of the sorted array.

Putting these together: **sort the array, then find the longest run of consecutive elements where each adjacent pair
differs by at most `k`.** The answer is `n` minus the length of that longest run.

## Approach

1. Read `n`, `k`, and the array `a`.
2. Sort `a` (the code uses merge sort, `O(n log n)`).
3. Scan left to right, tracking the length of the current "balanced streak":
    - If `a[i] - a[i-1] ≤ k`, the streak continues, so increment `count`.
    - Otherwise the streak breaks, so reset `count = 1` (the element itself still starts a fresh streak of length 1).
    - Keep `largestLength` as the max `count` seen so far.
4. Output `n - largestLength` — the number of problems to remove.

## Walkthrough (first sample)

`n = 5`, `k = 1`, `a = [1, 2, 4, 5, 6]` (already sorted).

| i | a[i] | diff | count | largestLength |
|---|------|------|-------|---------------|
| 1 | 2    | 1    | 2     | 2             |
| 2 | 4    | 2    | 1     | 2             |
| 3 | 5    | 1    | 2     | 2             |
| 4 | 6    | 1    | 3     | 3             |

Longest balanced run is `[4, 5, 6]`, length 3. Answer: `5 - 3 = 2` ✅, matching the expected output — remove problems `1`
and `2` and keep `[4, 5, 6]`.

## Complexity

- **Time:** `O(n log n)` per test case for the sort, `O(n)` for the scan → `O(Σn · log n)` overall.
- **Space:** `O(n)` auxiliary space for the merge step.

## How to run

```bash
javac BalancedRound.java
java BalancedRound < input.txt
```

**Sample input**

```
7
5 1
1 2 4 5 6
1 2
10
8 3
17 3 1 20 12 5 17 12
4 2
2 4 6 8
5 3
2 3 19 10 8
3 4
1 10 5
8 1
8 3 1 4 5 10 7 3
```

**Expected output**

```
2
0
5
0
3
1
4
```