package treesandgraphs;

import java.util.Random;

public class RandomNodeOptimised {

	int size = 0;
	int val;
	private RandomNodeOptimised left;
	private RandomNodeOptimised right;

	public RandomNodeOptimised(int d) {
		// TODO Auto-generated constructor stub
		this.val = d;
		this.size = 1;
	}

	public void insert(int val) {
		if (this.val >= val) {
			if (left == null)
				left = new RandomNodeOptimised(val);
			else
				left.insert(val);
		} else {
			if (right == null)
				right = new RandomNodeOptimised(val);
			else
				right.insert(val);
		}
		size++;
	}
	
	public RandomNodeOptimised getRandomNode()
	{
		Random rand = new Random();
		int index = rand.nextInt(size);
		return getIthNode(index);
	}

	private RandomNodeOptimised getIthNode(int i) {
		// TODO Auto-generated method stub
		
		int leftSize = (left==null) ? 0 : left.size;
		
		if(i<leftSize)
			return left.getIthNode(i);
		else if(i==leftSize)
			return this;		
		else
			return right.getIthNode(i-(leftSize+1));
				
	}

	public RandomNodeOptimised find(int val) {
		if (this.val == val)
			return this;
		else if (this.val > val) {
			return left == null ? null : left.find(val);
		} else {
			return right == null ? null : right.find(val);
		}
	}
	
	public static void main(String[] args) {
		RandomNodeOptimised root = new RandomNodeOptimised(20);
		root.insert(10);
		root.insert(5);
		root.insert(15);
		root.insert(50);
		root.insert(45);
		root.insert(60);
		
		System.out.println(root.getRandomNode().val);
		
	}

}
