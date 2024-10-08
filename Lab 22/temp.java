import java.util.ArrayList;

public class temp {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        int i = 1, j = 2;
        while(true){
            if(i*j <= 100){
                arr.add(i*j);
                i++;
                j++;
            }
            else{
                break;
            }
        }
        System.out.println(arr);
    }
}
