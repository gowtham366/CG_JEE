import java.util.Scanner;
/**
 * @author gowthc
 *
 */
public class IpChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the IP Address : ");
		String[] ipAddress = scanner.next().split("\\.");
		if(ipAddress.length == 4)
		{
			int validRangeCount=0;
			for(String ip:ipAddress){
				int ipAdd = Integer.parseInt(ip);
				validRangeCount = (ipAdd>=0 && ipAdd<=255)?validRangeCount+1:validRangeCount-1;
			}
			if(validRangeCount == 4)
				System.out.println("Entered IP Address is valid");
			else
				System.out.println("Entered IP Address is Invalid");
		}
		else
		{
			System.out.println("Entered IP Address is Invalid");
		}
	}
}
