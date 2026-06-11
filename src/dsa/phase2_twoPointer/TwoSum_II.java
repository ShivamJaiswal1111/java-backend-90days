package dsa.phase2_twoPointer;

import java.util.Arrays;

// LC-167 Two Sum II
// Pattern: Two Pointers
// Approaches:
//   Brute Force: check every pair — O(n²) SC O(1)
//   Two Pointers: sorted array → shrink window from both ends — O(n) SC O(1)

public class TwoSum_II {

    public int[] twoSumBrute(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumOptimised(int[] numbers, int target) {
        int index1=0; int index2= numbers.length-1;
        while(index1<index2){
            if(numbers[index1] + numbers[index2] == target){
                return new int[]{index1+1, index2+1};
            }
            if(numbers[index1] + numbers[index2]< target){
                index1++;
            }else{index2--;}
        }
        return new int[]{-1, -1};
    }

    public static void main(String args[]){
        TwoSum_II sum= new TwoSum_II();
        int[] result=sum.twoSumBrute(new int[]{1,3,4,5,7,8,9}, 16);
        System.out.println(Arrays.toString(result));

        int[] result1=sum.twoSumOptimised(new int[]{1,3,4,5,7,8,9}, 14);
        System.out.println(Arrays.toString(result1));
    }
}
