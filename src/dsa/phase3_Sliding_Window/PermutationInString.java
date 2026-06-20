import java.util.*;

/* LC 567 - Permutation in String
   Problem Statement: Return true if any permutation of s1 is a substring of s2
   Pattern: Sliding Window (Fixed Size)

   Brute Force: Generate all permutations of s1, check each against s2 substrings — O(n! * n)
   Optimal: Compare character frequency maps using fixed window of s1.length() — O(n) O(1) ✅
*/

public class PermutationInString {

    /* BRUTE FORCE - O(n! * n) */
    public boolean checkInclusionBrute(String s1, String s2) {
        List<String> permutations = new ArrayList<>();
        generatePermutations(s1.toCharArray(), 0, permutations);

        for (String perm : permutations) {
            if (s2.contains(perm)) return true;
        }
        return false;
    }

    private void generatePermutations(char[] arr, int start, List<String> result) {
        if (start == arr.length) {
            result.add(new String(arr));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            char temp = arr[start]; arr[start] = arr[i]; arr[i] = temp;
            generatePermutations(arr, start + 1, result);
            temp = arr[start]; arr[start] = arr[i]; arr[i] = temp;
        }
    }


    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1map= new HashMap<>();
        for(char c: s1.toCharArray()){
            s1map.put(c,s1map.getOrDefault(c,0)+1);
        }

        int left=0;
        Map<Character, Integer> windowMap = new HashMap<>();
        for(int r=0; r<s2.length(); r++){
            windowMap.put(s2.charAt(r),windowMap.getOrDefault(s2.charAt(r),0)+1);
            if(r - left + 1 == s1.length()){
                if(s1map.equals(windowMap)) return true;
                windowMap.put(s2.charAt(left), windowMap.get(s2.charAt(left)) - 1);
                if(windowMap.get(s2.charAt(left)) == 0){
                    windowMap.remove(s2.charAt(left));
                }
                left++;
            }




        }
        return false;
    }
    public static void main(String[] args){
        PermutationInString permutation= new PermutationInString();
        System.out.println(permutation.checkInclusion("ab", "eidbaooo"));

        System.out.println(permutation.checkInclusionBrute("ab", "eidbaooo"));
    }



}
