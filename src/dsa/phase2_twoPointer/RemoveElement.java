package dsa.phase2_twoPointer;

public class RemoveElement {

//  LC-27 Remove Element
//  Pattern: Slow/Fast Pointers
//  Approaches:
//   Brute: new array filter — O(n) O(n)
//   Optimal: in-place slow/fast — O(n) O(1)


    public static int removeElement(int[] nums, int val) {
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != val) {
                nums[s] = nums[f];
                s++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int k = removeElement(nums, val);
        System.out.print("k = " + k + " | nums: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}

