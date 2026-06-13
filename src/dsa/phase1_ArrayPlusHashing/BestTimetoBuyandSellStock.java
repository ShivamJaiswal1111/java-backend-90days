package dsa.phase1;
import java.util.*;

//  LC 121 - Best Time to Buy and Sell Stock
//  Pattern: Greedy / Track Running Minimum

//  Brute Force: try every buy-sell pair — O(n²) O(1)
//  Optimal:     track minPrice so far, check profit each day — O(n) O(1) ✅


public class BestTimetoBuyandSellStock {

    public int bestProfit(int[] prices){

        int maxProfit= 0;

        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                int profit = prices[j] - prices[i];        //4
                maxProfit = Math.max(maxProfit, profit);  //4

            }

        }
        return maxProfit;
    }
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice , prices[i]);

            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

        }
        return maxProfit;
    }



    public static void main(String args[]){
        BestTimetoBuyandSellStock best= new BestTimetoBuyandSellStock();
        int result1 = best.bestProfit(new int[]{7,1,5,3,6,9,4});
        System.out.println(result1);

        int result = best.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(result);
    }
}
