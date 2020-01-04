package strings;


import java.util.regex.Pattern; 
public class ValidateIpAddress {
	
	public static void main(String[] args) {
		
		System.out.println (Pattern.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", 
				"192.168.90.900")); 
				
	}

}
