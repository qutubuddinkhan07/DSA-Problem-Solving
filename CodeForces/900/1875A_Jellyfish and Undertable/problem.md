# Jellyfish and Undertale — Codeforces 1875A

**Platform:** Codeforces  
**Problem:** 1875A - Jellyfish and Undertale **Rating:** 900

## Problem Summary

Given 3 inputs `a`, `b` and `n`, then an array of length 'n' The bomb has a timer that is initially set to b. Every
second, the timer will decrease by 1. When the timer reaches 0, the bomb will explode!
To give the residents of Snowdin enough time to evacuate, you will need to delay the bomb from exploding for as long as
possible.

## Approach

Add `b` to the sum of min `(x[i], a-1)` across all `i`, capping each at `a-1` keeps the timer from reaching `a`, giving
the longest delay.

## Complexity

- Time: `O(n)`
- Space: `O(n)`

> Problem Link : <a href="https://codeforces.com/contest/1875/problem/A" target="_blank" rel="noopener noreferrer">
> Jellyfish and Undertale</a>