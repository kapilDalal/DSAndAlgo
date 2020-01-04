package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifiedText {
	
	public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
		
		ArrayList<String> res = new ArrayList<String>();		
		StringBuffer str = new StringBuffer();
		for(int i=0;i<A.size();i++){			
			if(str.length()+A.get(i).length()<=B){
				str.append(A.get(i));
				str.append(" ");
			}
			else{
				res.add(str.toString());
				str = new StringBuffer();
				str.append(A.get(i));
				str.append(" ");
			}			
		}		
		if(str.length()>0)
			res.add(str.toString());
		
		for(int i=0;i<res.size()-1;i++){
			justifyLine(res,i,B);
		}
		
		String s = res.get(res.size()-1);
		s=s.trim();
		while(s.length()<B)
			s = s + " ";
		res.remove(res.size()-1);
		res.add(s);
		
		return res;
    }
	
	private void justifyLine(ArrayList<String> res, int i,int b) {
		// TODO Auto-generated method stub

		String[] split = res.get(i).split(" ");
		
		if(split.length==1){
			while(split[0].length()<b)
				split[0] = split[0]+" ";
			res.remove(i);
			res.add(i, split[0]);
			return;
		}
		
		int sizeOfWords = 0;
		for(int j=0;j<split.length;j++)
			sizeOfWords += split[j].length();
		int spaceLeft = b-sizeOfWords;
		
		while(spaceLeft>0){
			for(int k=0;k<split.length-1;k++){
				split[k] = split[k] +" ";
				spaceLeft--;
				if(spaceLeft==0)
					break;
			}
		}
		String r = "";
		for(int k=0;k<split.length;k++)
			r += split[k];
		
		/*int spaceAfterWords = spaceLeft / (split.length-1);
		
		int firstWordSpace = spaceAfterWords;
		if(spaceLeft%(split.length-1)!=0)
			firstWordSpace = spaceAfterWords + (spaceLeft%(split.length-1));
		
		if(firstWordSpace!=spaceAfterWords){
			while(firstWordSpace>0){
				split[0] = split[0]+" ";
				firstWordSpace--;
			}
			for(int k=1;k<split.length-1;k++){
				for(int l=0;l<spaceAfterWords;l++)
					split[k] = split[k] + " ";
			}
		}else{
			for(int k=0;k<split.length-1;k++){
				for(int l=0;l<spaceAfterWords;l++)
					split[k] = split[k] + " ";
			}
		}
		String r = "";
		for(int k=0;k<split.length;k++)
			r += split[k];*/
		
		System.out.println(r.length());
		res.remove(i);
		res.add(i, r);
		
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		JustifiedText jt = new JustifiedText();
		List<String> l = Arrays.asList("lkgyyrqh", "qrdqusnh", "zyu", "w", "ukzxyykeh", "zmfqafqle", "e", "ajq", "kagjss", "mihiqla", "qekf", "ipxbpz", "opsndtyu", "x", "ec", "cbd", "zz", "yzgx", "qbzaffgf", "i", "atstkrdph", "jgx", "qiy", "jeythmm", "qgqvyz", "dfagnfpwat", "sigxajhjt", "zx", "hwmcgss");
		ArrayList<String> A = new ArrayList<>(l);
		ArrayList<String> fullJustify = jt.fullJustify(A, 178);
		for(String str: fullJustify)
			System.out.println(str);
	}

}
