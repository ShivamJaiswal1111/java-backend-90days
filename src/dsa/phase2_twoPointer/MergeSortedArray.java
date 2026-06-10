package dsa.phase2_twoPointer;

import java.util.Arrays;

// LC-88 Merge Sorted Array
// Pattern: Two pointers from the end
// Approaches:
//   Brute Force: copy nums2 into nums1 + sort — TC O((m+n) log(m+n)) SC O(1)
//   Two Pointers: compare from end, fill backwards — TC O(m+n) SC O(1)

public class MergeSortedArray {
    public void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<n; i++){
            nums1[m]=nums2[i];
            m++;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {

            if (nums1[p1] >= nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
                p--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }

        }
        while(p2 >= 0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static void main(String[] args){
        MergeSortedArray obj= new MergeSortedArray();
        obj.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);

        MergeSortedArray obj1= new MergeSortedArray();
        obj1.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
