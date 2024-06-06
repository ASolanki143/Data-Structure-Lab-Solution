//Create class Employee_Detail with attributes Employee_ID, Name, Designation, and Salary. Write a program to read the detail from user and print it. 

import java.util.Scanner;

public class Lab6_2 {
    public static void main(String[] args) {
        Employee_Detail e1 = new Employee_Detail();
        e1.setDetails();
        e1.getDetails();
    }
}

class Employee_Detail{
    int employee_ID;
    String name;
    String designation;
    double salary;

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

    public void getDetails(){
        System.out.println("----------------Employee Details---------------");
        System.out.println("ID : "+employee_ID);
        System.out.println("Name : "+name);
        System.out.println("Designation : "+designation);
        System.out.println("Salary : "+salary);
    }
}
