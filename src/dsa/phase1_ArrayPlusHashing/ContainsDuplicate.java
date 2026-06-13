package dsa.phase1;
import java.util.*;
//problem: Contains Duplicates
//Brute Force: O(n²) time,O(1) space
//Optimised(HashSet): O(n) time, O(n) space


public class ContainsDuplicate {

    public boolean containsDuplicateBrute(int[] num){
        for(int i=0; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                if(num[i]==num[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicateOptimised(int[]  num){
        HashSet<Integer> set= new HashSet<>();
        for(int n: num){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
        }
        return false;
    }
    
    public static void main(String[] args){
        ContainsDuplicate duplicate= new ContainsDuplicate();
        boolean result= duplicate.containsDuplicateBrute(new int[]{1,2,3,4,5,7} );
        System.out.println(result);//false

        boolean result1= duplicate.containsDuplicateOptimised(new int[]{1,2,3,4});
        System.out.println(result1);  //false
        boolean result2 = duplicate.containsDuplicateOptimised(new int[]{1, 2, 3, 1});
        System.out.println(result2); // true
    }
}
