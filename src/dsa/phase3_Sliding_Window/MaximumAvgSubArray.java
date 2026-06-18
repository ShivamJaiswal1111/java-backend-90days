/* LC 643 - Maximum Average Subarray I
   Problem Statement: Given an array nums and integer k, find the contiguous
     subarray of length exactly k with the maximum average value.
   Pattern: Sliding Window (fixed size)

  Brute Force: Recompute the sum of all k elements for every starting index — TC O(n*k) SC O(1)
  Sliding Window : Slide the window by subtracting the element leaving (nums[i-k])
    and adding the element entering (nums[i]), reusing the overlap between
    consecutive windows instead of resumming from scratch — TC O(n) SC O(1)
        */

public class MaximumAvgSubArray {

    public double findMaxAverageBrute(int[] nums, int k) {
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i<=nums.length-k; i++){
            int sum=0;
            for(int j=i; j<=i+k-1; j++){
                sum+= nums[j];

            }
            maxSum= Math.max(maxSum, sum);
        }
        return (double) maxSum/k;
    }

    public double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;

        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        int maxSum = currentSum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        // Convert to double for precise division
        return (double) maxSum/k ;
    }


    public static void main(String[] args){
        MaximumAvgSubArray maxAvg = new MaximumAvgSubArray();
        System.out.println(maxAvg.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 5));

        System.out.println(maxAvg.findMaxAverageBrute(new int[]{1,12,-5,-6,50,3}, 5));
    }
}

