// Create array of object of class Student_Detail with attributes Enrollment_No, Name, Semester, CPI for 5 students, scan their information and print it. 

import java.util.Scanner;

public class Lab6_3 {
    public static void main(String[] args) {
        Student_Detail[] students = new Student_Detail[5];
        for(int i = 0 ; i < 5 ; i++){
            students[i] = new Student_Detail();
            System.out.println("Enter a details of student "+(i+1));
            students[i].setDetails();
        }

        for(int i = 0 ; i < 5 ; i++){
            students[i].getDetails();
        }
    }
}

class Student_Detail{
    int enrollment_No;
    String name;
    int semester;
    double CPI;

    public void setDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Enrollment No : ");
        enrollment_No = sc.nextInt();
        System.out.println("Enter name : ");
        name = sc.next();
        System.out.println("Enter semester :");
        semester = sc.nextInt();
        System.out.println("Enter CPI : ");
        CPI = sc.nextDouble();
        System.out.println();
    }

    public void getDetails(){
        System.out.println("----------------Student Details---------------");
        System.out.println("Enrollment No : "+enrollment_No);
        System.out.println("Name : "+name);
        System.out.println("Semester : "+semester);
        System.out.println("CPI : "+CPI);
        System.out.println("----------------------------------------------");
    }
}
