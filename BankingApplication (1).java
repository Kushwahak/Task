
import java.util.Scanner;


 class BankAccount{

    private String Name;
    private String AcctNo;
    private long Balance;
    Scanner sc = new Scanner(System.in);
    
    //Create new BankAccount
    public void openAccount() {
        System.out.println("Enter Your Account Number:");
        AcctNo = sc.next();
        System.out.println("Enter Customer Name:");
        Name = sc.next();
        System.out.println("Enter Your Amount: ");
        Balance = sc.nextLong();
    }

    //shows account details
    public void showAccount() {
        System.out.println("Name of Account Holder:" + Name);
        System.out.println("Account Number:" + AcctNo);
        System.out.println("Balance Amount:" + Balance);
    }

    //Deposit Amount
    public void deposit() 
    {
        long amount;
        System.out.println("Enter Amount you want to deposit: ");
        amount = sc.nextLong();
        if (amount > 0) 
        {
            Balance = Balance + amount;
        }
    }

    //Withdraw Amount and updating
    public void withdraw() 
    {
        long amount;
        System.out.println("Enter the amount you want to withdraw: ");
        amount = sc.nextLong();
        if (Balance >= amount)
        {
            Balance = Balance - amount;
            System.out.println("Balance after Withdrawal: " + Balance);
        }
        else{
            System.out.println("Your Balance is less than " + amount + "   Transaction Failed..!!!!");
        }
    }

    //display balance
    public void balance() 
    {
        System.out.println("Name:" + Name + " " + "Balanced Amount:" + Balance);
    }

    //search account
    public boolean search(String acct_no) 
    {
        if (AcctNo.equals(acct_no)) 
        {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankingApplication {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many customers you want to input? ");
        int n = sc.nextInt();

        BankAccount C[] = new BankAccount[n];
        for (int i = 0; i < C.length; i++) 
        {
            C[i] = new BankAccount();
            C[i].openAccount();
        }

        int ch;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Balance Amount \n 6.Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch(ch) 
            {
                case 1:
                    for(int i = 0; i < C.length; i++) 
                    {
                        C[i].showAccount();
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter Account No. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for(int i = 0; i < C.length; i++)
                    {
                        found = C[i].search(ac_no);
                        if (found) 
                        {
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Search failed!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found)
                        {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) 
                    {
                        System.out.println("Search failed!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) 
                        {
                            C[i].withdraw();
                            break;
                        }
                    }
                    if (!found) 
                    {
                        System.out.println("Search failed!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Your Account Number:");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) 
                    {
                        found = C[i].search(ac_no);
                        if (found) 
                        {
                            C[i].balance();
                            break;
                        }
                    }
                        if (!found) 
                        {
                        System.out.println("Search failed!");
                    }
                    break;
                case 6:
                    System.out.println("Transaction Completed...ThankYou!");
                    break;
            }
        } while (ch != 6);
    }
}
    

