package dsa.phase2_twoPointer;

public class TrappingRainWater {
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
    }
}
