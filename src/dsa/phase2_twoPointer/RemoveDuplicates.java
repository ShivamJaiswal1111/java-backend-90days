package dsa.phase2_twoPointer;

// LC-26 Remove Duplicates from Sorted Array
// Pattern: Slow/Fast Pointers
// Approaches:
//   Brute: use HashSet to store unique elements — O(n) O(n)
//   Optimal: in-place slow/fast pointers — O(n) O(1)

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int f = 0; f < nums.length; f++) {
            if (f > 0 && nums[f] == nums[f - 1]) {
                continue;
            } else {
                nums[slow] = nums[f];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        int k = removeDuplicates(nums);
        System.out.print("k = " + k + " | nums: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
