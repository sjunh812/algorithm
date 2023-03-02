import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Stock> s = new Stack<>();
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            Stock stock = new Stock(i, prices[i]);
            
            while (!s.isEmpty()) {
                if (s.peek().getPrice() > prices[i]) {
                    answer[s.peek().getIndex()] = i - s.peek().getIndex();
                    s.pop();
                } else {
                    break;
                }
            }
            
            s.push(stock);
        }
        
        while (!s.isEmpty()) {
            Stock stock = s.pop();
            answer[stock.getIndex()] = prices.length - stock.getIndex() - 1;
        }
        
        return answer;
    }
}

class Stock {
    
    private int index;
    private int price;
    
    public Stock(int index, int price) {
        this.index = index;
        this.price = price;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public int getPrice() {
        return this.price;
    }
}