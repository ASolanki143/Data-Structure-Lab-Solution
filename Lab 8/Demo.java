import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a : ");
        double a = sc.nextDouble();
        System.out.println("Enter b : ");
        double b = sc.nextDouble();
        System.out.println("Enter c : ");
        double c = sc.nextDouble();

        double D = b * b - 4.0 * a * c;

        if(D > 0.0){
            double root1 = (-b + Math.pow(D, 0.5)) / (2.0 * a);
            double root2 = (-b - Math.pow(D, 0.5)) / (2.0 * a);
            System.out.println("The roots are  : ");
            System.out.println("First : "+root1);
            System.out.println("First : "+root2);
        }

        else if(D == 0.0){
            double root1 = -b / (2.0 * a);
            System.out.println("The root is " + root1);
        }

        else{
            System.out.println("Roots are not real");
        }
        
    }
}
