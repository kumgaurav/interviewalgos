/**
 * 
 */
package udemy.pdsai.mockinterview1;
/*
 * Problem
You've been given a list of historical stock prices for a single day for Amazon stock. The index of the list represents the timestamp, so the element at index of 0 is the initial price of the stock, the element at index 1 is the next recorded price of the stock for that day, etc. Your task is to write a function that will return the maximum profit possible from the purchase and sale of a single share of Amazon stock on that day. Keep in mind to try to make this as efficient as possible.

For example, if you were given the list of stock prices:

prices = [12,11,15,3,10]

Then your function would return the maximum possible profit, which would be 7 (buying at 3 and selling at 10).

Requirements
Try to solve this problem with paper/pencil first without using an IDE. Also keep in mind you should be able to come up with a better solution than just brute forcing every possible sale combination

Also you can't "short" a stock, you must buy before you sell the stock.
 */

/**
 * @author gkumargaur
 *
 */
public class SingleDayProfitInStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] prices = {12,11,15,3,10};
		if (prices.length>1) {
			int max_profit = findMaxProfit(prices);
			System.out.println("Max profit -> " + max_profit);
			int [] prices1 = {12,11,3,15,10};
			max_profit = findMaxProfit(prices1);
			System.out.println("Max profit2 -> " + max_profit);
			int [] prices2 = {10,12,14,12,13,11,8,7,6,13,23,45,11,10};
			max_profit = findMaxProfit(prices2);
			System.out.println("Max profit3 -> " + max_profit);
		}else {
			System.err.print("atleast 2 prices are required");
		}
	}
	
	public static int findMaxProfit(int prices[]) {
		int max_profit = -1;
		int min_price = prices[0];
		int len = prices.length;
		for(int i=1;i<len;i++) {
			//System.out.println("min_price ->"+min_price);
			//System.out.println("prices[i] ->"+prices[i]);
			min_price = Math.min(min_price, prices[i]);
			max_profit = Math.max(max_profit, prices[i] - min_price);
			//System.out.println("max_profit ->"+max_profit);
		}
		return max_profit;
	}

}
