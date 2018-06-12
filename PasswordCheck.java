import java.io.Console;
import java.util.Scanner;
/**
 * @author gowthc
 *
 */
public class PasswordCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Console console = System.console(); 
		String userName;
		String userPass;
		if(console == null) 
		{
			System.out.print("No console available");
			return;
		}
		do{
			System.out.println("Enter the user name : ");
			userName = scanner.next();
			System.out.println("Enter the password : ");
			char passArr[] = console.readPassword();
			userPass = String.valueOf(passArr);
			System.out.println(userName);
			System.out.println(userPass);
		}while(!(userName.equalsIgnoreCase("gowtham") && userPass.equalsIgnoreCase("password")));
	}
}
