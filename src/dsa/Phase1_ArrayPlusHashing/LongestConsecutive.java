package dsa.phase1;

import java.util.*;

// LC-128 Longest Consecutive Sequence
// Pattern: HashSet — sequence start detection
// Approaches:
//   Brute Force: sort + linear scan — TC O(n log n) SC O(n)
//   HashSet: only start counting from sequence start — TC O(n) SC O(n)

public class LongestConsecutive {

    public int longestConsecutiveBrute(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);


        int currentStreak=1;
        int maxStreak=1;
        for(int i=1; i<sorted.length; i++){
            if(sorted[i]==sorted[i-1]){
                continue;
            }
            if(sorted[i]==sorted[i-1]+1){
                currentStreak++;
            }else{
                maxStreak = Math.max(maxStreak, currentStreak);
                currentStreak=1;
            }

        }
        maxStreak = Math.max(maxStreak, currentStreak);
        return maxStreak;
    }

    public int longestConsecutiveOptimised(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        int longest = 0;

        for(int num : set){

            if(!set.contains(num - 1)){

                int currentNum = num;
                int maxStreaks = 1;

                while(set.contains(currentNum + 1)){
                    currentNum++;
                    maxStreaks++;
                }

                longest = Math.max(longest, maxStreaks);
            }
        }

        return longest;


    }
    public static void main(String[] args){
        LongestConsecutive cons = new LongestConsecutive();
//        int result= cons.longestConsecutiveBrute(new int[]{1,0,2,4,5,6,7,9,10});
//        System.out.println(result);

        int result1= cons.longestConsecutiveOptimised(new int[]{1,0,2,4,5,6,7,9,10});
        System.out.println(result1);
    }
}
