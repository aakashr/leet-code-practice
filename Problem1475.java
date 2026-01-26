import java.util.Stack;

public class Problem1475 {
    private static int[] finalPrices(int[] prices) {
        Stack<Integer> priceStack = new Stack<>();
        int[] result = new int[prices.length];
        for (int i=0; i<prices.length; i++) {
            while (!priceStack.isEmpty() &&  prices[priceStack.peek()] >= prices[i]) {
                int stackVal = priceStack.pop();
                result[stackVal] = prices[stackVal] - prices[i];
            }
            priceStack.push(i);
        }

        while (!priceStack.isEmpty()) {
            int stackVal = priceStack.pop();
            result[stackVal] = prices[stackVal];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] prices = {10,11,3,1};
        for (int i: finalPrices(prices)) {
            System.out.println(i);
        }
    }
}

// 10, 11, 3, 1

// 10, 11
