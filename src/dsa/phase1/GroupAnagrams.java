package dsa.phase1;

import java.util.*;

// Pattern: HashMap Grouping
// Brute Force: sort each string, compare all pairs - O(n² * k log k)
// Optimal: sort each string as key, group originals - O(n * k log k) SC: O(n)

public class GroupAnagrams {

    public List<List<String>> groupAnagramsBrute(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i=0; i<strs.length; i++){
            if (visited[i]) continue;
            char[] arr =strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            List<String> group = new ArrayList<>();
            group.add(strs[i]);

            for(int j=i+1; j<strs.length; j++){
                if(visited[j]) {continue;}
                char[] arr1= strs[j].toCharArray();
                Arrays.sort(arr1);
                String sorted1= new String(arr1);
                if(sorted.equals(sorted1)) {
                    group.add(strs[j]);
                    visited[j] = true;
                }

            }
            result.add(group);
        }
        return result;
    }

    public List<List<String>> groupAnagramsOptimised(String[] strs){
        HashMap<String ,List<String>> map= new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
//            if (!map.containsKey(sorted)) {
//                map.put(sorted, new ArrayList<>());
//            }
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String args[]){
        GroupAnagrams anagram= new GroupAnagrams();
        List<List<String>> result1= anagram.groupAnagramsBrute(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(result1);

        List<List<String>> result2= anagram.groupAnagramsOptimised(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(result2);
    }
}
