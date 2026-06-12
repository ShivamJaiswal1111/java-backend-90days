package dsa.phase2_twoPointer;

// LC-11: Container With Most Water
// Pattern: Two Pointers
// Brute Force: check all pairs — O(n²) O(1)
// Two Pointers: shrink from both ends, move shorter side inward — O(n) O(1)

public class ContainerWIthMostWater {
    public int mostWaterBrute(int[] nums){
        int maxArea=0;
        for(int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                int area= (Math.min(nums[i], nums[j])) *(j-i);
                maxArea=Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int mostWateroptimised(int[] height){
        int maxArea=0;
        int left=0; int right=height.length-1;
        while(left<right){
            int area= Math.min(height[left],height[right])*(right-left);
            if(height[left]<height[right]){
                left++;
            }else{ right--;}
            maxArea= Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main (String[] args){
        ContainerWIthMostWater mostWater= new ContainerWIthMostWater();
        int result= mostWater.mostWaterBrute(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result);

        int result1= mostWater.mostWateroptimised(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result1);
    }
}
