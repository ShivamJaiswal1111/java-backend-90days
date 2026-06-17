
public class TrappingRainWater {

/* LC 42 - Trapping Rain Water
   Problem Statement: Given heights of bars, compute total water trapped after raining.
   Pattern: Two Pointers (left/right, greedy)

   Brute Force: for each i, scan left and right for maxLeft/maxRight, water = min(maxLeft,maxRight)-height[i] — O(n^2) O(1)
   Two Pointer: move pointer on smaller side, track leftMax/rightMax as running max — O(n) O(1)
*/



    public int trappedWaterBrute(int[] height){

        int result=0;
        for(int i=0; i<height.length; i++){
            int maxLeft=0; int maxRight=0;
            for(int j=0; j<i; j++){
                maxLeft= Math.max(maxLeft, height[j]);
            }
            for(int j=i; j<height.length; j++){
                maxRight= Math.max(maxRight, height[j]);
            }
            result += Math.max(Math.min(maxLeft, maxRight) - height[i], 0);
        }
        return result;


    }
    public int trappedWaterOptimised(int[] height){
        int l=0; int r=height.length -1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= leftMax) leftMax = height[l];
                else water += leftMax - height[l];
                l++;
            } else {
                if (height[r] >= rightMax) rightMax = height[r];
                else water += rightMax - height[r];
                r--;
            }
        }
        return water;
    }

    public static void main(String[] args){
        TrappingRainWater rain= new TrappingRainWater();
        System.out.println(rain.trappedWaterOptimised(new int[]{4,2,0,6,3,2,5}));

        System.out.println(rain.trappedWaterBrute(new int[]{4,2,0,6,3,2,5}));
    }


}
