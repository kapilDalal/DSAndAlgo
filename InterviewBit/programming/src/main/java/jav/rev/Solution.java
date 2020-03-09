package jav.rev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {

	

	public static String getPotentialDomains(List<String> lines) {
		// Write your code here

		return null;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int size;
        
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("http[s]?://([a-zA-Z0-9-]+[.][a-zA-Z0-9.-]+).*?");
		Matcher matcher;
        
        String domain;
        String wwwPattern = "^www.(.*?)";
        String ww2Pattern = "^ww2.(.*?)";
        
        List<String> domains = new ArrayList<String>();
        
        for(int i=0;i<N;i++) {
            str = br.readLine();
            matcher = pattern.matcher(str);
            while(matcher.find()) {
            	domain = matcher.group(1);
            	domain = domain.replaceAll(wwwPattern, "$1");
            	domain = domain.replaceAll(ww2Pattern, "$1");
              	if(!domains.contains(domain))
                	domains.add(domain);
            }
        }
        
        Collections.sort(domains);
        size = domains.size();
        for(String d: domains) {
            if(--size == 0)
                System.out.print(d);
            else
                System.out.print(d+";");
        }
	}

}
