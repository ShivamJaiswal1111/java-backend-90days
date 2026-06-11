package dsa.phase2_twoPointer;

import java.util.Arrays;

// LC-283 Move Zeroes
// Pattern: Two Pointers
// Approaches:
//   Brute Force: copy non-zeros to new array, fill rest with 0, copy back — TC O(n) SC O(n)
//   Two Pointers: slow tracks next non-zero position, fast scans ahead — TC O(n) SC O(1)

public class MoveZeroes {

    public void moveZeroBrute(int[] nums) {
        int[] temp = new int[nums.length];
        int idx = 0;

        // copy all non-zero elements first
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp[idx++] = nums[i];
            }
        }

        // remaining spots auto-filled with 0 (Java default)

        // copy back
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public void moveZeroOptimised(int[] nums){
        int slow=0;
        int fast= 1;
        while(fast < nums.length){
            if(nums[fast]!=0){
                int temp= nums[slow];
                nums[slow]= nums[fast];
                nums[fast]= temp;
                fast++;
                slow++;
            }else{
                fast++;
            }
        }

    }

    public static void main(String args[]){
        MoveZeroes move= new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
//        move.moveZeroOptimised(nums);
//        System.out.println(Arrays.toString(nums));
        move.moveZeroBrute(nums);
        System.out.println(Arrays.toString(nums));
    }
}
