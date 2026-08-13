# Dalton the Teacher &mdash; Codeforces 1855A

**Platform:** Codeforces **Problem:** 1855A &ndash; Dalton the Teacher **Rating:** 800 **Constraints:** `1 ≤ t ≤ 1000`
test cases, `2 ≤ n ≤ 10^5`, sum of `n` over all test cases `≤ 10^5`
**Time limit:** 1 second &nbsp;|&nbsp; **Memory limit:** 256 megabytes

## Problem Summary

There are `n` students seated on `n` chairs, with student `i` on chair `p_i`, where `p` is a permutation. A student is
**happy** if their number differs from their chair number (`p_i ≠ i`); otherwise they're **sad**. Each move swaps the
chairs of two chosen students. Find the minimum number of moves needed to make every student happy.

## Approach

Let `s` be the number of sad students at the start, i.e. the number of fixed points of the permutation (positions `i`
with `p_i = i`).

**Claim:** the answer is `⌈s / 2⌉`.

**Lower bound:** a single swap only changes the chairs of two students, so it can turn at most 2 sad students into happy
ones. Hence at least `⌈s / 2⌉`
moves are required.

**This bound is achievable:**

- While at least 2 sad students remain, pick any two of them, `i` and `j`
  (so `p_i = i` and `p_j = j`), and swap their chairs. Afterward `p_i = j ≠ i`
  and `p_j = i ≠ j` &mdash; both become happy in a single move.
- If exactly one sad student `i` is left, swap them with *any* other student
  `j`. Since `p` is a permutation and `p_i = i` already, the value `i` cannot appear anywhere else in the array, so
  whatever value student `j` was holding is guaranteed to differ from `i` &mdash; student `i` becomes happy. Student `j`
  's new value is `i`, and since `i ≠ j`, student `j` stays happy too. So the last sad student is always resolved in
  exactly one move, without creating a new sad student.

Repeating this pairs up sad students two at a time, using one extra move if
`s` is odd, for a total of exactly `⌈s / 2⌉` moves &mdash; matching the lower bound.

## Algorithm

Count `s`, the number of indices `i` with `p_i = i`, and output `⌈s / 2⌉`
(equivalently `(s + 1) / 2` using integer division).

```pseudo
while (t-- > 0) {
    int n = Integer.parseInt(br.readLine().trim());
    st = new StringTokenizer(br.readLine().trim());
    int[] p = new int[n];
    for (int i = 0; i < n; i++)
        p[i] = Integer.parseInt(st.nextToken());

    int fixed = 0;
    for (int i = 0; i < n; i++)
        if (p[i] == i + 1)
            fixed++;

    int ans = (fixed + 1) / 2;
    res.append(ans).append("\n");
}
```

## Complexity

- Time: `O(n)` per test case, `O(sum of n)` overall
- Space: `O(1)` extra

> Problem Link: [Dalton the Teacher](https://codeforces.com/problemset/problem/1855/A)