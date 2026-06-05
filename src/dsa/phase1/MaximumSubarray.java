package dsa.phase1;

/*
 * LC 53 - Maximum Subarray
 * Pattern: Kadane's Algorithm (Greedy / Running Max)
 *
 * Brute Force: try all subarrays with nested loop,O(n²) O(1)
 * Kadane's: at each index, extend or start fresh,O(n) O(1)
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums){


        int maxSum=nums[0];
        for(int i=0; i<nums.length; i++){

            int currentSum=nums[i];
            maxSum = Math.max(maxSum, currentSum);
            for (int j=i+1; j<nums.length; j++){
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }

        }
        return maxSum;
    }

    public int maxSubArrayKadane(int[] nums){
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;

    }

    public static void main(String args[]){
        MaximumSubarray maxSumValue= new MaximumSubarray();
        int result= maxSumValue.maxSubArrayKadane(new int[]{5,4,-1,7,8});
        System.out.println(result);
    }
}
