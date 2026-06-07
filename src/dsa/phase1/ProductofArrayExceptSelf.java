package dsa.phase1;
import java.util.Arrays;

/*
 * LC 238 - Product of Array Except Self
 * Pattern: Prefix + Suffix Product
 *
 * Brute Force: for each i, multiply all except i — O(n²) O(n)
 * Prefix+Suffix: precompute left[] and right[] arrays — O(n) O(n) ✅
 */

public class ProductofArrayExceptSelf {

    public int[] productBrute(int[] nums){

        int[] ans= new int[nums.length];

        for(int i=0; i<nums.length; i++){
           int result=1;     //[1,2,3,4]
            for(int j=0; j<nums.length; j++){
                if(j!=i) result= result*nums[j];

            }
            ans[i]= result;
        }
        return ans;
    }

    public int[] productOptimised(int[] nums){
        int result=1;
        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        for(int i=0; i<nums.length; i++){

            if(i==0) left[i]=1;
            else{
                result=result* nums[i-1];
                left[i]= result;
            }

        }

        int[] right = new int[nums.length];
        int result1=1;
        for(int j=(nums.length-1); j>=0; j--){

            if(j== nums.length-1) right[j]=1;
            else{
                result1 *= nums[j+1];
                right[j]= result1;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;

    }
    public static void main(String[] args){
        ProductofArrayExceptSelf product= new ProductofArrayExceptSelf();
        int[] answer= product.productBrute(new int[]{2,4,6,8});
        System.out.println(Arrays.toString(answer));

        int[] answer1= product.productOptimised(new int[]{2,4,6,8});
        System.out.println(Arrays.toString(answer1));
    }
}
