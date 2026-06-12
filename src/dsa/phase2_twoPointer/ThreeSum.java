package dsa.phase2_twoPointer;

import java.util.*;

// LC-15: 3Sum
// Pattern: Two Pointers
// Brute Force: three nested loops, check all triplets — O(n³) O(1)
// Two Pointers: sort + fix i + converging pointers, skip duplicates — O(n²) O(1)

public class ThreeSum {
    public List<List<Integer>> threeSumBrute(int[] nums){
        List<List<Integer>> result= new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                       List<Integer> list=Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(list);

                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumOptimised(int[] nums){
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left= i+1; int right= nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> list= Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;

                }
                else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else if (nums[i]+nums[left]+nums[right]>0){
                    right--;
                }
            }

        }
        return result;
    }
    public static void main(String args[]){
        ThreeSum sum= new ThreeSum();
//        System.out.println(sum.threeSumBrute(new int[]{-1,0,-1,2,-1,-4}));

        System.out.println(sum.threeSumOptimised(new int[]{-1,0,1,2,-1,-4}));
    }
}
