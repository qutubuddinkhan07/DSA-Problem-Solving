# Chemistry — Codeforces 1883B

**Platform:** Codeforces  
**Problem:** 1883B - Chemistry  
**Rating:** 800

## Problem Summary

Given a string of length `n` and an integer `k`, determine whether the
characters can be rearranged into a palindrome after removing at most
`k` characters.

## Approach

Count the frequency of each character.

For a palindrome, at most one character can have an odd frequency.

Therefore, count how many characters have odd frequencies.

If the number of odd-frequency characters is at most `k + 1`,
the answer is `YES`; otherwise, it is `NO`.

## Complexity

- Time: `O(n)`
- Space: `O(n)`

## Key Takeaway

A palindrome can have at most one character with an odd frequency.

> Problem Link : <a href="https://codeforces.com/contest/1883/problem/B" target="_blank" rel="noopener noreferrer">Chemistry 1883B</a>