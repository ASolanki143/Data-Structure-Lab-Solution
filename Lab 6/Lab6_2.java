//Create class Employee_Detail with attributes Employee_ID, Name, Designation, and Salary. Write a program to read the detail from user and print it. 

import java.util.Scanner;

public class Lab6_2 {
    public static void main(String[] args) {

        //declare an object of class Employee_Detail
        Employee_Detail e1 = new Employee_Detail();

        //call setDetails method for set properties of e1 object
        e1.setDetails();

        //call getDetails method for get or print properties of e1 object
        e1.getDetails();
    }
}

class Employee_Detail{

    //define properties 
    int employee_ID;
    String name;
    String designation;
    double salary;

    //define a method for set properties of employee
    public void setDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id : ");
        employee_ID = sc.nextInt();
        System.out.println("Enter employee name : ");
        name = sc.next();
        System.out.println("Enter employee designation : ");
        designation = sc.next();
        System.out.println("Enter employee salary : ");
        salary = sc.nextDouble();
        sc.close();
    }

    //define a method for get or print properties of employee
    public void getDetails(){
        System.out.println("----------------Employee Details---------------");
        System.out.println("ID : "+employee_ID);
        System.out.println("Name : "+name);
        System.out.println("Designation : "+designation);
        System.out.println("Salary : "+salary);
    }
}
