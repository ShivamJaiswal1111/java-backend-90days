package dsa.phase3_Sliding_Window;

public class MaximumAverageSubArray {

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
        return (double) maxSum / k;
    }


    public static void main(String[] args){
        MaximumAverageSubArray maxAvg = new MaximumAverageSubArray();
        System.out.println(maxAvg.findMaxAverage(new int[]{1,12,-5,-6,50,3}));
    }
}
