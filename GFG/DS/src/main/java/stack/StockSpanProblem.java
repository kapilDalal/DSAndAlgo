package stack;

public class StockSpanProblem {
	
	
	static Integer[] stockSpan(Integer[] stocks){
		Integer[] spans = new Integer[stocks.length];
		
		StackInt stack = new StackInt(stocks.length);
		
		for(int i=0;i<stocks.length;i++){
			
			while(!stack.isEmpty() && stocks[stack.peek()]<=stocks[i])
				stack.pop();
			
			spans[i] = stack.isEmpty() ? i+1 : i - stack.peek();
			
			stack.push(i);
			
		}
		
		
		return spans;
	}
	
	
	public static void main(String[] args) {
		
		Integer[] stocks = {60,70,60,75,85};
		
		Integer[] spans = stockSpan(stocks);
		
		for(int i=0;i<spans.length;i++)
			System.out.print(spans[i]+"\t");
		
	}

}
