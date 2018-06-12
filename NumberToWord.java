import java.util.Scanner;
public class NumberToWord {
    public static void main(String args[]){
       // TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        String[] tensNames = {""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};
	        String[] numNames = {""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten"," eleven",
	                " twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen"};
	        System.out.println("Enter the number to be converted to Words : ");
	        int number = scanner.nextInt();
	        if (number<1000 && number>0){
	            String result=null;
	            if (number % 100 < 20){
	                result = numNames[number % 100];
	                number /= 100;
	            }
	            else {
	                result = numNames[number % 10];
	                number /= 10;
	                result = tensNames[number % 10] + result;
	                if(number/10 != 0 )
	                {
	                	number /= 10;
		                result = numNames[number] + " hundred" + result;	
	                }
	                
	            }
	            System.out.println(result.toUpperCase().trim());
	        }
	        else
	        {
	            System.out.println("Enter the number between 1 - 999");
	        }
    }
}
