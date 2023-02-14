
import java.util.Scanner;
import java.util.ArrayList;

class Transaction {
  private String type;
  private int amount;

  public Transaction(String type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  public String getType() {
    return type;
  }

  public int getAmount() {
    return amount;
  }
}

class Account {
  private int balance;
  private ArrayList<Transaction> transactions;

  public Account(int balance) {
    this.balance = balance;
    this.transactions = new ArrayList<Transaction>();
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void showTransactions() {
	System.out.println("===============================================================================================");
    System.out.println("Transactions History");
    System.out.println("Type\t\tAmount");
    for (Transaction t : transactions) {
      System.out.println(t.getType() + "\t" + t.getAmount());
    }
	System.out.println("===============================================================================================");
  }

  public void withdraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
      transactions.add(new Transaction("Withdraw", amount));
	  System.out.println("===============================================================================================");
      System.out.println("Withdraw successful. Remaining balance: " + balance);
	  System.out.println("===============================================================================================");
    } else {
      System.out.println("Insufficient balance");
    }
  }

  public void deposit(int amount) {
    balance += amount;
    transactions.add(new Transaction("Deposit\t", amount));
	System.out.println("===============================================================================================");
    System.out.println("Deposit successful. New balance: " + balance);
	System.out.println("===============================================================================================");
  }

  public void transfer(Account recipient, int amount) {
    if (balance >= amount) {
      balance -= amount;
      recipient.setBalance(recipient.getBalance() + amount);
      transactions.add(new Transaction("Transfer", -amount));
      recipient.addTransaction(new Transaction("Transfer", amount));
	  System.out.println("===============================================================================================");
      System.out.println("Transfer successful.");
    } else {
	  System.out.println("===============================================================================================");
      System.out.println("Insufficient balance");
    }
  }
}

public class ATM4 {
  private static String username = "admin";
  private static String password = "password";
  public static void main(String[] args) {
	while(true){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter username: ");
    String inputUsername = sc.nextLine();
    System.out.print("Enter password: ");
    String inputPassword = sc.nextLine();

    if (inputUsername.equals(username) && inputPassword.equals(password)) {
      System.out.println("Login successful");
    
    Account account = new Account(1000); // initial balance
    Account recipient = new Account(500);
	int amount=0;


    while (true) {
	  System.out.println("===============================================================================================");
      System.out.println("1. Transactions History");
      System.out.println("2. Withdraw");
      System.out.println("3. Deposit");
      System.out.println("4. Transfer");
      System.out.println("5. Quit");
	  System.out.println("===============================================================================================");
      System.out.print("Enter your choice: ");

      int choice = sc.nextInt();
      if (choice == 5) {
        break;
      }

      switch (choice) {
        case 1:
          account.showTransactions();
          break;
        case 2:
          System.out.print("Enter amount: ");
          int withdrawAmount = sc.nextInt();
          account.withdraw(withdrawAmount);
		  break;
		case 3:
		  System.out.print("Enter amount: ");
		  int depositAmount = sc.nextInt();
		  account.deposit(depositAmount);
		  break;
		case 4:
		  System.out.print("Enter amount: ");
		  amount=sc.nextInt();
		  account.transfer(recipient,amount);
		  break;

	  }
	}
	break;
  }
   else {
      System.out.println("Login failed");

    }
	}
}
}
		  
         









