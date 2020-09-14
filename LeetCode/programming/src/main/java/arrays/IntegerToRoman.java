package arrays;

public class IntegerToRoman {

    public static String intToRoman(int num){
        String res = "";
        while(num>0){
            if(num>=1000){
                res = res + "M";
                num -= 1000;
            }else if(num>=900){
                res = res + "CM";
                num -= 900;
            }else if(num>=500){
                res = res + "D";
                num -= 500;
            }else if(num>=400){
                res = res + "CD";
                num -= 400;
            }else if(num>=100){
                res = res + "C";
                num -= 100;
            }else if(num>=90){
                res = res + "XC";
                num -= 90;
            }else if(num>=50){
                res = res + "L";
                num -= 50;
            }else if(num>=40){
                res = res + "XL";
                num -= 40;
            }else if(num>=10){
                res = res + "X";
                num -= 10;
            }else if(num>=9){
                res = res + "IX";
                num -= 9;
            }else if(num>=5){
                res = res + "V";
                num -= 5;
            }else if(num>=4){
                res = res + "IV";
                num -= 4;
            }else{
                res = res + "I";
                num--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

}
