package dsa.phase2_twoPointer;

public class SquaresOfASortedArray {

// LC-977 Squares of a Sorted Array
// Pattern: Two Pointers (Left/Right)
// Approaches:
//   Brute: square all + sort — O(n log n) O(n)
//   Optimal: two pointers from both ends — O(n) O(n)

    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;

        while (l <= r) {
            int r_squr = nums[r] * nums[r];
            int l_squr = nums[l] * nums[l];

            if (r_squr > l_squr) {
                result[index] = r_squr;
                r--;
            } else {
                result[index] = l_squr;
                l++;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);
        System.out.print("Output: ");
        for (int n : result) {
            System.out.print(n + " ");
        }

    }

}
