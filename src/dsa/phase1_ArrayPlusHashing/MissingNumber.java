package dsa.phase1;

import java.util.HashSet;

//LC 268 - Missing Number
//Approaches considered:
//
//1. Brute Force
//TC: O(n²), SC: O(1)
//
//2. HashSet
//TC: O(n), SC: O(n)
//
//3. Mathematical Formula
//TC: O(n), SC: O(1)
//Limitation: integer overflow
//
//4. XOR (Implemented)
//TC: O(n), SC: O(1)

public class MissingNumber {

    public int missingNumberBruteHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {

            set.add(n);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }

        }
        return -1;
    }

    public int missingNumberBruteMathematicalApproach(int[] nums){
        int n=nums.length;
        int actual=n*(n+1)/2;
        int expected=0;
        for(int num: nums){
            expected+=num;
        }
        return actual-expected;


    }

    public int missingNumberXor(int[] nums){
        int xor= nums.length;

        for(int i=0; i<nums.length; i++){
            xor ^= i;
            xor ^= nums[i];
        }

        return xor;
    }


    public static void main(String[] args){
        MissingNumber missing= new MissingNumber();
//        int result= missing.missingNumberBruteHashSet(new int[]{0,1,2,4,5,6,7,8});
//        System.out.println(result);

        int result1= missing.missingNumberBruteMathematicalApproach(new int[]{9,3,0,1,2,4,5,6,7,8});
        System.out.println(result1);

        int result2= missing.missingNumberXor(new int[]{0,1,2,4,5,6,7,8,3,9,10});
        System.out.println(result2);
    }
}