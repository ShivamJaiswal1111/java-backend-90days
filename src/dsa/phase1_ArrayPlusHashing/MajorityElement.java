package dsa.phase1;

//Problem: Majority Elements
//Brute Force: O(n) time O(n) space
//Optimised Sol(Boyer-Moore Voting Algorithm): O(n) time, O(1) space

import java.util.HashMap;

public class MajorityElement {


    public int majorityElementBrute(int[] nums){
        HashMap<Integer, Integer> map= new HashMap<>();
        int n= nums.length;
        for(int n1:nums){
            map.put(n1, map.getOrDefault(n1,0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key)> n/2) return key;
        }

        return -1;
    }

    public int majorityElementOptimised(int[] nums){
        int candidate=0;
        int count=0;

        for(int num:nums){
            if(count==0){
                candidate = num;
            }
            if(num==candidate) count++;
            else count--;

        }
        return candidate;

    }

    public static void main(String[] args){
        MajorityElement element= new MajorityElement();
//        int result= element.majorityElementBrute(new int[]{1, 2, 3, 4, 2,2, 2});
//        System.out.println(result);

        int result1= element.majorityElementOptimised(new int[] {2,3,2,2,4,5,3,2,2});
        System.out.println(result1);
    }
}
