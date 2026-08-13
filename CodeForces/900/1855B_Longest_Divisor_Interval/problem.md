# Longest Divisor Interval &mdash; Codeforces 1855B

**Platform:** Codeforces  
**Problem:** 1855B &ndash; Longest Divisor Interval **Rating:** 900

## Problem Summary

Given a positive integer `n`, find the maximum size of an interval `[l,r]` of positive integers such that, for every `i`
in the interval (i.e., `l≤i≤r`), `n` is a multiple of `i`.

## Approach

Argument: If for `n`, there was some segment `[l, r]` that such every element in this `[l, r]` divided by `n`. Thus
`[1, r - l + 1]` will also work because for every element `i` in `[1, r - l + 1]`
is having at least `1` multiple in `[l, r]` range.

{l, l+1, l+2, l+3, ... ..... , r} \
{1, 2, 3, ... \
Z % 2 = {0, 1}

## Complexity

- Time: `O(60) ~ O(log n)`
- Space: `O(1)`

> Problem Link : <a href="https://codeforces.com/problemset/problem/1855/B" target="_blank" rel="noopener noreferrer">
> Longest Divisor Interval</a>