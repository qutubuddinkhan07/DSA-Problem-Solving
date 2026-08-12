# Make It Zero — Codeforces 1869A

**Platform:** Codeforces  
**Problem:** 1869A - Make It Zero **Rating:** 900

## Problem Summary

You're given an array a of n integers. In one operation, you pick a range `[l, r]`, compute
`s = a[l] ⊕ a[l+1] ⊕ ... ⊕ a[r]`
(XOR of the whole range), and overwrite every element in `[l, r]` with s. Using at most 8 such operations, make every
element in the array equal to 0.

## Approach

Key trick: applying the same operation on the same range `[l, r]` twice zeros out that entire range, whenever the range
length is even.

* First application sets every element in `[l, r]` to s (the original XOR).
* Second application recomputes the XOR of the now-uniform range: `s ⊕ s ⊕ ... ⊕ s` (an even count of s's) = 0, so it
  overwrites the whole range with 0.

Using that:

* If `n` is even: apply the double-operation trick once on the full range `[1, n]` → 2 operations total.
* If `n` is odd: split into an even-length prefix `[1, n-1]` and a length-2 suffix `[n-1, n]`, and apply the
  double-operation trick to each separately → 4 operations total.

This always stays within the allowed 8 operations, and — notably — never needs to look at the actual values of `a[]`;
only the **parity of the segment length matters**, which is why your code reads the array but never uses its contents.

## Complexity

- Time: `O(n) = O(100)`
- Space: `O(n) = O(100)`

> Problem Link : <a href="https://codeforces.com/problemset/problem/1869/A" target="_blank" rel="noopener noreferrer">
> Make It Zero</a>