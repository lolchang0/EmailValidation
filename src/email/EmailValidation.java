package email;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
	
	//Regex to check for the pattern of an email address
	public static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	
	//Main function
	public static void main(String[] args) {
		//Creating an Arraylist to store the email addresses as Strings
		List<String> emails = new ArrayList<String>();
		
		//Filling up the Arraylist with some emails to start off with
		emails.add("kevin.chang@mail.com");
		emails.add("jonny.jon@mail.com");
		emails.add("my.email@mail.com");
		emails.add("bobby.lee@mail.com");
		
		//Initializing scanners, one for char input and one for String input
		Scanner scanChar = new Scanner(System.in);
		Scanner scanStr = new Scanner(System.in);
		Scanner scanSearch = new Scanner(System.in);
	
		String input = "", search = "";
		char option = 0;
		
		//Welcome Message
		System.out.println("Welcome to my Email Validation Program!");
		
		//do while loop to continuously loop the program until the user exits
		do{
			System.out.println("1. Enter an email address.");
			System.out.println("2. Check the current list of emails");
			System.out.println("3. Search for an email");
			System.out.println("4. Exit the program.");
			System.out.println("Select an option: ");
			
			option = scanChar.next().charAt(0);
			
			//Switch case to take in the different input cases
			switch(option) {
			
			//Option 1: Entering a new email address (Checks email for validity)
			case '1': 
				do {
					System.out.println("Please enter a valid email address: ");
				    input = scanStr.nextLine();
					
				    //Takes the input and puts it through the isValid method, which checks regex to see if input matches email pattern
				    //If true, add email to list
					if(isValid(input) == true) {
						emails.add(input);
						System.out.println("\n" + input + " has been successfully added to the list!\n");
					}
					//If String input fails pattern matching, prompts user to try again, loops until valid email is input.
					else {
						System.out.println("\n" + input + " is an invalid email. Try again.\n");
					}
				}while(isValid(input) == false);
				break;
				
			//Option 2: Displaying the list of current email addresses
			case '2':
				System.out.println("\nCurrent list of Valid emails: ");
				for(String email : emails) {
					System.out.println(email);
				}
				System.out.println();
				break;
				
			//Option 3: Searching the current list for a specific email
			case '3':
				System.out.println("Please enter an email to check if it is in our system: ");
				search = scanSearch.nextLine();
				
				emailSearch(search, emails);
				break;
			//Option 4: Exiting the Program
			case '4':
				System.out.println("\nYou have successfully exited the program!");
				System.exit(0);
				
			//Covering different cases in the case user inputs a character that does not match one of the available options
			default:
				System.out.println("\nInvalid Option Please try again.\n");
				break;
			}
		}while(option != '4');
	}
	
	//Method that checks if the String of email input is a valid email pattern or not
	public static boolean isValid(String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		boolean matches = matcher.matches();
		
		return matches;
	}
	
	//Method that loops through the existing String array and checks if the email exists in the array
	public static boolean emailSearch(String search, List<String> emails) {
		boolean check = false;
		
		for(String eml : emails) {
			if(eml.contains(search)) {
				System.out.println("\n" + search + " is an existing email in our system. \n");
				check = true;
				return check;
			}
		}
		System.out.println("\n" + search + " was not found in our system.");
		System.out.println("Here are the existing emails in our system: \n");
		for(String email: emails) {
			System.out.println(email);
		}
		System.out.println();
		return check;
	}
}
