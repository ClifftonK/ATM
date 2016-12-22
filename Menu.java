import java.util.Scanner;

public class Menu {

	private static double balance;
	private static Scanner sn;

	public static void main(String[] args) {
		// initialize defaults and counters
		balance = 150000.00;

		// show main menu
		showMain_menu();
	}

	public static void showMain_menu() {
		// display menu
		System.out.println("BEGIN");
		System.out.println("***********************************************");
		System.out.println("1. Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdrawal");
		System.out.println("4. Quit");
		System.out.println("Enter menu option(e.g 1):");

		// capture user input
		sn = new Scanner(System.in);
		String response = sn.next();

		System.out.println("***********************************************");

		// pass choice for processing
		checkPageChoice(response);
	}

	public static void showBalance() {
		// display menu
		System.out.println("BALANCE\n" + balance);
		System.out.println("Type menu and press enter to main menu");

		// capture user input
		sn = new Scanner(System.in);
		String response = sn.next();

		System.out.println("***********************************************");

		// pass choice for processing
		checkBalanceInput(response);
	}

	public static void showDeposit() {
		// display menu
		System.out.println("DEPOSIT");
		System.out.println("Enter amount and press enter:");

		// capture user input
		Scanner sn = new Scanner(System.in);
		double response = sn.nextDouble();

		// check deposit limits
		if (response > 40000) {
			// show error
			System.out.println("Limit exceeded!");
			// show deposit
			showDeposit();

			// stop
			return;
		}

		// add deposit to balance
		balance += response;

		System.out.println("***********************************************");

		// show balance
		showBalance();
	}

	public static void showWithdrawal() {
		// display menu
		System.out.println("WITHDRAWAL");
		System.out.println("CURRENT BALANCE: " + balance);
		System.out.println("Enter amount and press enter:");

		// capture user input
		Scanner sn = new Scanner(System.in);
		double response = sn.nextDouble();

		// check deposit limits
		if (response > balance) {
			// show error
			System.out.println("Amount not available!");
			// show withdrawal
			showWithdrawal();

			// stop
			return;
		}

		// add deposit to balance
		balance -= response;

		System.out.println("***********************************************");

		// show balance
		showBalance();
	}

	public static void quitApp() {
		// display menu
		System.out.println("***********************************************");
		System.out.println("QUIT");
		System.out.println("Are you sure you want to Quit?(Yes/No)");

		// capture user input
		Scanner sn = new Scanner(System.in);
		String response = sn.next();

		// check response
		if (response.equalsIgnoreCase("yes")) {
			// exit app
			System.exit(0);
		} else if (response.equalsIgnoreCase("no")) {
			// show main menu
			showMain_menu();
		} else {
			// show error
			System.out.println("Inavlid input");

			// show quit again
			quitApp();
		}

		System.out.println("***********************************************");
	}

	public static void checkBalanceInput(String response) {
		// check response
		if (response.equals("menu")) {
			// show main menu
			showMain_menu();
		} else {
			// invalid input
			System.out.println("Invalid input");

			// show balance
			showBalance();
		}

		System.out.println("***********************************************");
	}

	// checks current page
	private static void checkPageChoice(String response) {
		if (response.equals("1")) {
			// show balance page
			showBalance();
		} else if (response.equals("2")) {
			// Show deposit page
			showDeposit();
		} else if (response.equals("3")) {
			// show withdrawal page
			showWithdrawal();
		} else if (response.equals("4")) {
			// quit application
			quitApp();
		} else {
			// invalid input
			System.out.println("Invalid input");

			// show main menu
			showMain_menu();
		}
	}
}
