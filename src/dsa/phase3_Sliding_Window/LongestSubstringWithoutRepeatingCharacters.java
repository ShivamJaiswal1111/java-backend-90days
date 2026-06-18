import java.util.*;

/* LC 3 - Longest Substring Without Repeating Characters
   Problem Statement: Find the length of the longest substring without repeating characters.
   Pattern: Sliding Window (Variable Size) + HashSet

   Brute Force: Check every possible substring and validate uniqueness using a HashSet
     — TC O(n²) SC O(n)

   Sliding Window: Expand the window, and whenever a duplicate appears, shrink it
     from the left until all characters are unique — TC O(n) SC O(n)
*/

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        for(int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<s.length(); j++){
                char c= s.charAt(j);
                if(set.contains(c)){
                    break;
                }
                set.add(c);
                maxLength= Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringOptimised(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters longest= new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longest.lengthOfLongestSubstring("abcdabcsedf"));
        System.out.println(longest.lengthOfLongestSubstringOptimised("abcdasasedf"));

    }

}
