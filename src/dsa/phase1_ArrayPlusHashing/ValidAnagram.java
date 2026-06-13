package dsa.phase1;
import java.util.*;
//Problem: Valid Anagram
//BruteForce:O(n log n) time, O(n) space
//Optimised(): O(n), time, O(n) space

public class ValidAnagram {

    public boolean validAnagramBrute(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] arr= s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);

        char[] arrr= t.toCharArray();
        Arrays.sort(arrr);
        String sorted1 = new String(arrr);

        return sorted.equals(sorted1);

    }

    public boolean validAnagramBrute2(String s, String t){
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }

    public boolean validAnagramOptimised(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map= new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);

        }
        for(int val: map.values()){
            if(val != 0) return false;

        }
        return  true;
    }

    public static void main(String[] args){
        ValidAnagram valid =new ValidAnagram();
        boolean result = valid.validAnagramBrute("anagrmam", "nakgaram");
        System.out.println(result);


        boolean result3 = valid.validAnagramBrute2("anagrm", "nakgar");
        System.out.println(result3);
        boolean result4 = valid.validAnagramBrute2("aacv", "caav");
        System.out.println(result4);

        boolean result1= valid.validAnagramOptimised("analgram", "nalagram");
        System.out.println(result1);
        boolean result2= valid.validAnagramOptimised("analgrsam", "nalagwram");
        System.out.println(result2);

    }
}
