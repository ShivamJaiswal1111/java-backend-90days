# Greedy Algorithm Patterns — DSA Interview Notes
> Fresher to Intermediate Level | LeetCode Focused
> Review this in Week 10 before interviews

---

## What is Greedy?

**Definition:**
At every step, make the locally optimal choice hoping it leads to the globally optimal solution. Never backtrack. Never reconsider.

**Greedy works when:**
- A locally optimal choice never hurts the global answer
- You can mathematically prove that discarding a choice is safe
- This proof is called the **Greedy Exchange Argument**

**Greedy vs DP:**
| | Greedy | Dynamic Programming |
|---|---|---|
| Decisions | One pass, no backtrack | Consider all subproblems |
| Speed | O(n) or O(n log n) | Usually O(n²) or O(n³) |
| When to use | Proof exists that local = global | Overlapping subproblems exist |
| Example | Two Pointers, Interval scheduling | Knapsack, LCS, Coin Change |

---

## Pattern 1: Two Pointers (Greedy on Arrays)

**Core Idea:**
Place two pointers at opposite ends. At each step, greedily eliminate the pointer that cannot possibly give a better answer.

**Greedy Exchange Argument:**
If `height[l] < height[r]`, moving `r` inward can never improve the answer because `l` is the bottleneck. So we greedily discard `l`.

### Template:
```java
int l = 0, r = arr.length - 1;
while (l < r) {
    // compute current answer
    // greedy decision: move the worse pointer
    if (condition) l++;
    else r--;
}
```

### Problems:

**LC-11 Container With Most Water**
```java
public int maxArea(int[] height) {
    int l = 0, r = height.length - 1;
    int maxWater = 0;
    while (l < r) {
        int water = Math.min(height[l], height[r]) * (r - l);
        maxWater = Math.max(maxWater, water);
        // Greedy: move the shorter side — taller side can never help
        if (height[l] < height[r]) l++;
        else r--;
    }
    return maxWater;
}
// TC: O(n) | SC: O(1)
```

**LC-42 Trapping Rain Water**
```java
public int trap(int[] height) {
    int l = 0, r = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;
    while (l < r) {
        if (height[l] < height[r]) {
            // Greedy: left side is bottleneck
            if (height[l] >= leftMax) leftMax = height[l];
            else water += leftMax - height[l];
            l++;
        } else {
            if (height[r] >= rightMax) rightMax = height[r];
            else water += rightMax - height[r];
            r--;
        }
    }
    return water;
}
// TC: O(n) | SC: O(1)
```

**LC-15 3Sum**
```java
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums); // Sort first — enables greedy two pointer
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i-1]) continue; // skip duplicates
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l+1]) l++;
                while (l < r && nums[r] == nums[r-1]) r--;
                l++; r--;
            } else if (sum < 0) l++; // Greedy: need bigger value
            else r--;               // Greedy: need smaller value
        }
    }
    return result;
}
// TC: O(n²) | SC: O(1)
```

---

## Pattern 2: Interval Scheduling (Greedy on Intervals)

**Core Idea:**
Sort intervals by end time. Greedily pick the interval that ends earliest — this leaves maximum room for future intervals.

**Greedy Exchange Argument:**
If interval A ends before interval B, choosing A over B never reduces future options. A always dominates B.

### Template:
```java
Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // sort by end time
int end = intervals[0][1];
for (int i = 1; i < intervals.length; i++) {
    if (intervals[i][0] >= end) {
        // non-overlapping — greedily take it
        end = intervals[i][1];
    }
}
```

### Problems:

**LC-435 Non-overlapping Intervals** (minimum removals)
```java
public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // sort by end
    int count = 0;
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < end) {
            // overlap — greedily remove this one (keep earlier ending)
            count++;
        } else {
            end = intervals[i][1];
        }
    }
    return count;
}
// TC: O(n log n) | SC: O(1)
```

**LC-56 Merge Intervals**
```java
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start
    List<int[]> result = new ArrayList<>();
    int[] current = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] <= current[1]) {
            // overlapping — greedily extend end
            current[1] = Math.max(current[1], intervals[i][1]);
        } else {
            result.add(current);
            current = intervals[i];
        }
    }
    result.add(current);
    return result.toArray(new int[0][]);
}
// TC: O(n log n) | SC: O(n)
```

**LC-57 Insert Interval**
```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0, n = intervals.length;
    // Add all intervals ending before newInterval starts
    while (i < n && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i++]);
    }
    // Greedily merge all overlapping intervals
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    result.add(newInterval);
    // Add remaining
    while (i < n) result.add(intervals[i++]);
    return result.toArray(new int[0][]);
}
// TC: O(n) | SC: O(n)
```

---

## Pattern 3: Greedy on Arrays (Local decisions)

**Core Idea:**
Scan array once. At each position make a greedy local decision — extend, reset, or skip.

### Problems:

**LC-53 Maximum Subarray (Kadane's Algorithm)**
```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int current = nums[0];
    for (int i = 1; i < nums.length; i++) {
        // Greedy: if current sum is negative, reset — it only hurts us
        current = Math.max(nums[i], current + nums[i]);
        maxSum = Math.max(maxSum, current);
    }
    return maxSum;
}
// TC: O(n) | SC: O(1)
// Greedy decision: extend subarray OR start fresh
```

**LC-55 Jump Game**
```java
public boolean canJump(int[] nums) {
    int maxReach = 0;
    for (int i = 0; i < nums.length; i++) {
        // Greedy: if we can't reach this index, stop
        if (i > maxReach) return false;
        // Greedy: extend max reach as far as possible
        maxReach = Math.max(maxReach, i + nums[i]);
    }
    return true;
}
// TC: O(n) | SC: O(1)
```

**LC-45 Jump Game II** (minimum jumps)
```java
public int jump(int[] nums) {
    int jumps = 0, currentEnd = 0, farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        // Greedy: always track farthest reachable position
        farthest = Math.max(farthest, i + nums[i]);
        if (i == currentEnd) {
            // Must jump — greedily jump to farthest
            jumps++;
            currentEnd = farthest;
        }
    }
    return jumps;
}
// TC: O(n) | SC: O(1)
```

**LC-122 Best Time to Buy and Sell Stock II** (multiple transactions)
```java
public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
        // Greedy: take every upward movement
        if (prices[i] > prices[i-1]) {
            profit += prices[i] - prices[i-1];
        }
    }
    return profit;
}
// TC: O(n) | SC: O(1)
// Greedy: capture every positive difference
```

---

## Pattern 4: Greedy with Sorting + Priority Queue

**Core Idea:**
Sort input to bring order, then greedily assign resources using a heap/priority queue.

### Problems:

**LC-621 Task Scheduler**
```java
public int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char c : tasks) freq[c - 'A']++;
    Arrays.sort(freq);
    int maxFreq = freq[25];
    int idleTime = (maxFreq - 1) * n;
    // Greedy: fill idle slots with other tasks
    for (int i = 24; i >= 0 && idleTime > 0; i--) {
        idleTime -= Math.min(maxFreq - 1, freq[i]);
    }
    idleTime = Math.max(0, idleTime);
    return tasks.length + idleTime;
}
// TC: O(n) | SC: O(1)
```

**LC-406 Queue Reconstruction by Height**
```java
public int[][] reconstructQueue(int[][] people) {
    // Greedy: sort by height desc, then position asc
    Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
    List<int[]> result = new ArrayList<>();
    for (int[] p : people) {
        // Greedy: insert at position k — taller people already placed
        result.add(p[1], p);
    }
    return result.toArray(new int[0][]);
}
// TC: O(n²) | SC: O(n)
```

---

## Pattern 5: Greedy on Strings

**Core Idea:**
Build answer character by character, greedily choosing the best option at each step.

### Problems:

**LC-763 Partition Labels**
```java
public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    // Greedy: record last occurrence of each character
    for (int i = 0; i < s.length(); i++) {
        last[s.charAt(i) - 'a'] = i;
    }
    List<Integer> result = new ArrayList<>();
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        // Greedy: extend partition as far as needed
        end = Math.max(end, last[s.charAt(i) - 'a']);
        if (i == end) {
            result.add(end - start + 1);
            start = i + 1;
        }
    }
    return result;
}
// TC: O(n) | SC: O(1)
```

---

## How to Identify Greedy in an Interview

Ask yourself these questions:

```
1. Can I sort the input and make decisions in order?
   → Likely greedy (intervals, scheduling)

2. Am I scanning once and making a local decision at each step?
   → Likely greedy (Kadane's, Jump Game)

3. Am I eliminating impossible states at each step?
   → Likely greedy two pointer

4. Does taking the locally best option now never hurt future options?
   → Greedy exchange argument holds → use greedy
```

**If the answer changes based on previous decisions → use DP, not greedy.**

---

## Greedy vs DP Decision Table

| Problem | Greedy or DP? | Why |
|---|---|---|
| Maximum Subarray | Greedy (Kadane's) | Local reset never hurts global |
| Coin Change (min coins) | DP | Local best coin ≠ global best |
| Jump Game (can reach?) | Greedy | Extending max reach is always safe |
| Jump Game II (min jumps) | Greedy | Always jump to farthest |
| 0/1 Knapsack | DP | Taking item now affects future |
| Activity Selection | Greedy | Earliest end = always safe choice |
| Longest Common Subsequence | DP | Each char depends on previous |

---

## Interview Answer Template

When interviewer asks "why greedy here?":

```
"I used greedy here because at each step, [local decision].
This works because [greedy exchange argument — why discarding 
the other option is always safe].
This gives us O(n) instead of O(n²) with DP/brute force."
```

Example for Container With Most Water:
```
"I moved the shorter pointer because the area is always 
limited by the shorter side. Moving the taller side 
can never increase area since the bottleneck stays the same.
So discarding the shorter side is always safe — 
that's the greedy exchange argument here."
```

---

## Quick Reference — All Patterns

| Pattern | Sort needed? | Data structure | TC |
|---|---|---|---|
| Two Pointers | Sometimes | None | O(n) |
| Interval Scheduling | Yes (by end) | None | O(n log n) |
| Merge Intervals | Yes (by start) | List | O(n log n) |
| Kadane's / Array scan | No | Variable | O(n) |
| Jump Game | No | Variable | O(n) |
| Task Scheduler | Yes | Freq array | O(n) |
| Partition Labels | No | Last index map | O(n) |

---

> Last updated: Week 2
> Review again: Week 10 before interviews
> Add new patterns here as you encounter them