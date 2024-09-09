// Create a class BankAccount with attributes like account number, balance, account holder and name. Create an array of BankAccount objects to store bank accounts. Implement methods to deposit money, withdraw money and check balance

import java.util.Scanner;

public class Lab6_5 {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        for(int i = 0 ; i < 2 ; i++){
            accounts[i] = new BankAccount();
            accounts[i].setDetails();
        }

        //for demo

        accounts[0].depositMoney(1000);
        accounts[0].checkBalance();
        accounts[0].withdrawMoney(500);
        accounts[0].checkBalance();

    }
}

class BankAccount{

    //define properties
    int account_No;
    String name;
    double balance;

    //define a method for set properties
    public void setDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account no : ");
        account_No = sc.nextInt();
        System.out.println("Enter name : ");
        name = sc.next();
        System.out.println("Enter balance : ");
        balance = sc.nextDouble();
    }

    //define method for deposit money
    public void depositMoney(double amount){

        //add amount in balance
        balance += amount;
        System.out.println("Deposit Succesefull");
    }

    //define method for withdraw money
    public void withdrawMoney(double amount){

        //if balance is zero OR user have not sufficient balance then return 
        if(balance == 0 || balance - amount < 0){
            System.out.println("Not sufficient balance");
            return;
        }

        //subtract amount from balance
        balance -= amount;
        System.out.println("Withdraw Succesefully");
    }

    //define method for check balance
    public void checkBalance(){
        System.out.println("Balance = "+balance);
    }
}
