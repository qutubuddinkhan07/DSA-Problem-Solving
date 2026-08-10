# Vasilije in Cacak — Codeforces 1878C

**Platform:** Codeforces  
**Problem:** 18878C - Vasilije in Cacak **Rating:** 900

## Problem Summary

Given 3 inputs `n`, `k` and `x`, look for the numbers between 1 to n, select exactly k numbers whether their sum is x or
not. If sum equals to x then print `Yes` or `No` in any case.

## Approach

Easily we can calculate by checking the minimum value from `1 to k` then again maximum value from `(n-k) to n`

If the `x >= minimum sum` and `x <= maximum sum`, the answer is `YES`; otherwise, it is `NO`.

## Complexity

- Time: `O(1)`
- Space: `O(1)`

## Key Takeaway

`x` sum is possible iff it in between the minimum sum `(k * (k+1))/2` and maximum sum `((n - k) ((n - k) + 1)) / 2`.

> Problem Link : <a href="https://codeforces.com/problemset/problem/1878/C" target="_blank" rel="noopener noreferrer">
> Vasilije in Cacak</a>