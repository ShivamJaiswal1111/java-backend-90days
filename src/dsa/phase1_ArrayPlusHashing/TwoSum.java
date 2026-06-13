package dsa.phase1;
import java.util.Arrays;
import java.util.HashMap;

// Problem: Two Sum
// Brute force: O(n²) time, O(1) space
// Optimized(HashMap): O(n) time, O(n) space


public class TwoSum {

    public int[] twoSumBrute(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumOptimised(int[] num, int target){
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<num.length; i++){
            int complement= target-num[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(num[i],i);
        }
        return new int[]{};


    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] result = sol.twoSumBrute(new int[]{1, 3, 4, 7, 8}, 10);
        System.out.println(Arrays.toString(result));

        int[] resultOptimised= sol.twoSumOptimised(new int[]{2,4,5,6,7,9}, 14);
        System.out.println(Arrays.toString(resultOptimised));
    }
}