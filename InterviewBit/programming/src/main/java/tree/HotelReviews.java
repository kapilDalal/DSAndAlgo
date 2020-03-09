package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HotelReviews {
	
	/*public static class Review{ 
		String review;
		int rating;
		int index;
		public Review(String rev, int r,int index) {
			this.review = rev;
			this.rating = r;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return "Review [review=" + review + ", rating=" + rating + "]";
		}
				
		
	}
	
	
	static public class Trie{
		boolean endOfWord;
		Trie[] children;
		public Trie(){
			children = new Trie[26];
			for(int i=0;i<26;i++)
				children[i] = null;
		}
	}
	static Trie root = new Trie();
	static void insert(String str){
		Trie temp = root;
		for(int i=0;i<str.length();i++){
			int ch = str.charAt(i)-'a';
			if(temp.children[ch]==null){
				temp.children[ch] = new Trie();
			}
			temp = temp.children[ch];
		}
		temp.endOfWord = true;
	}
	static boolean isGoodWord(String str){
		Trie temp = root;
		for(int i=0;i<str.length();i++){
			int ch = str.charAt(i) - 'a';
			if(temp.children[ch]==null)
				return false;
			temp = temp.children[ch];
		}
		if(temp.endOfWord==false)
			return false;
		return true;
	}
	
	
	static public ArrayList<Integer> solveOptimised(String A, ArrayList<String> B){
		ArrayList<Integer>  res = new ArrayList<>();
		String[] goodWords = A.split("_");
		String[] r = new String[B.size()];
		for(int i=0;i<goodWords.length;i++){
			insert(goodWords[i]);
		}
		ArrayList<Review> reviews = new ArrayList<>();
		for(int i=0;i<B.size();i++){
			String review = B.get(i);
			String[] reviewWords = review.split("_");
			int rating = 0;
			for(int j=0;j<reviewWords.length;j++){
				if(isGoodWord(reviewWords[j]))
					rating++;
			}
			Review re = new Review(B.get(i), rating, i);
			reviews.add(re);			
		}
		
		Collections.sort(reviews, new Comparator<Review>() {
			@Override
			public int compare(Review arg0, Review arg1) {
				// TODO Auto-generated method stub
				if(arg0.rating==arg1.rating)
					return arg0.index - arg1.index;
				
				return arg1.rating-arg0.rating;
			}
		});
		
		for(Review review: reviews){
			res.add(review.index);
		}
		System.out.println(res);
		return res;
	}*/
	
	
	//corect ans
	static public class Solution {
	    static class Trie
	    {
	        boolean isLeave;
	        Trie[] children = new Trie[26];
	        Trie()
	        {
	            isLeave=false;
	            for(int i=0;i<26;i++)
	            {
	                children[i] = null;
	            }
	        }
	    }
	    static Trie root;
	    public static void insert(String key)
	    {
	        int level;
	        int index;
	        int len= key.length();
	        Trie head = root;
	        for(level=0;level<len;level++)
	        {
	            index = key.charAt(level)-'a';
	            if(head.children[index] == null)
	            {
	                head.children[index] = new Trie();
	            }
	            head = head.children[index];
	        }
	        head.isLeave=true;
	    }
	    
	    public static boolean search(String key)
	    {
	        int level;
	        int index;
	        int len= key.length();
	        Trie head = root;
	        for(level=0;level<len;level++)
	        {
	            index = key.charAt(level)-'a';
	            if(head.children[index] == null)
	            {
	               return false;
	            }
	            head = head.children[index];
	        }
	        return head.isLeave==true ? true : false;
	    }
	    class Data
	    {
	        int cnt;
	        int index;
	        Data(int cnt, int index)
	        {
	            this.cnt=cnt;
	            this.index= index;
	        }
	    }
	    public ArrayList<Integer> solve(String A, ArrayList<String> B)
	    {
	        ArrayList<Integer> res = new ArrayList<>();
	        if(B==null || B.size()==0)
	        {
	            return res;
	        }
	        root = new Trie();
	        String [] praisingWords = A.split("_");
	        for(String word : praisingWords)
	        {
	            Solution.insert(word);
	        }
	        ArrayList<Data> list = new ArrayList<>();
	        int cnt;
	        for(int i=0;i<B.size();i++)
	        {
	            String [] praisingWordInReviews = B.get(i).split("_");
	            cnt = 0;
	            for(String praisingWordInReview : praisingWordInReviews)
	            {
	                if(Solution.search(praisingWordInReview))
	                {
	                    cnt++;
	                }
	            }
	            list.add(new Data(cnt, i));
	        }
	       Collections.sort(list, new Comparator<Data>(){
	            
	            @Override
	            public int compare(Data a, Data b)
	            {
	                if(a.cnt == b.cnt)
	                {
	                    return a.index - b.index;
	                }
	                return b.cnt - a.cnt;
	            }
	        });
	        for(Data d :list )
	        {
	            res.add(d.index);
	        }
	        return res;
	    }
	}
	

	public static void main(String[] args) {
		//solveOptimised("cool_ice_wifi", new ArrayList<String>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")));
	}

}
