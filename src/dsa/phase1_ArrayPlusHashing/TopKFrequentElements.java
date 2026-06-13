package dsa.phase1;

import java.util.*;

// LC-347 | Top K Frequent Elements
// Pattern: HashMap + Bucket Sort
//
// Approaches-
// 1.Brute Force: frequency map + sort by value; TC: O(n log n), SC: O(n)
// 2.Bucket Sort: frequency map + bucket by freq index; TC: O(n), SC: O(n)
//
// Optimal: Bucket Sort- frequencies range 1 to n,
//          so use array index as frequency bucket,
//          read right to left to get top k elements

public class TopKFrequentElements {

    public int[] topKElementBrute(int[] nums, int k){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int c: nums){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        entries.sort((a, b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
    return result;
    }

    public int[] topKElementOptimised(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int c : nums) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Integer>[] bucket= new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }
        int[] result = new int[k];
        int idx = 0;
           // loop from right to left
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[idx++] = num;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        TopKFrequentElements top= new TopKFrequentElements();
        int[] result= top.topKElementBrute(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(result));

        int[] result1= top.topKElementOptimised(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(result1));
    }
}
