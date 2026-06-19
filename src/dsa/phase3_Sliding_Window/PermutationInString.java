import java.util.*;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map= new HashMap<>();
        for(char c: s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int left=0;
        for(int r=0; r<s2.length(); r++){
            if(!map.containsKey(s2.charAt(r))){
                left++;
                continue;
            }




        }
    }



}
