import java.util.Scanner;
import java.util.Stack;

public class Lab8_4 {

    public static double ans(double c , double d , String a){
        if(a.equals("+")){
            return c+d;
        }
        else if(a.equals("-")){
            return c-d;
        }
        else if(a.equals("*")){
            return c*d;
        }
        else if(a.equals("/")){
            return c/d;
        }
        else if(a.equals("^")){
            return Math.pow(c, d);
        }
        else{
            return 1;
        }
    }

    public static double evalute(String post){
        String[] str = post.split(",");
        Stack<Double> s = new Stack<>();
        int rank = 0 ;
        double ans;
        for(int i=0 ; i<str.length ; i++){
            String a = str[i];
            if (a.equals("+") || a.equals("-") | a.equals("*") || a.equals("/") || a.equals("^")) {
                rank--;
            }
            else{
                rank++;
            }
        }
        System.out.println(rank);
        
        if (rank==1) {
            for(int i=str.length-1 ; i>=0 ; i--){
                String a = str[i];
                double c , d;
                if (a.equals("+") || a.equals("-") | a.equals("*") || a.equals("/") || a.equals("^")) {
                    c = s.pop();
                    d = s.pop();
                    s.push(ans(c, d, a));
                }
                else{
                    double num = Double.parseDouble(a);
                    s.push(num);
                }
            }
        }
        if (!s.isEmpty()) {
            ans = s.pop();
        }
        else{
            ans = -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String post = sc.nextLine();
        double ans = evalute(post);
        System.out.println(ans);
        sc.close();
    }
}