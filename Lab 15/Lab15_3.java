import java.util.Scanner;

public class Lab15_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node root = null;
        PhoneBook pb = new PhoneBook();
        
        int x = 1;

        while (x < 6) {
            System.out.println("Enter 1 for insert mobile number");
            System.out.println("      2 for delete mobile number");
            System.out.println("      3 for search mobile number");
            System.out.println("      4 for display mobile number in ascending order ");
            System.out.println("      5 for display mobile number in descending order ");
            System.out.println("      6 for break");

            x = sc.nextInt();
            
            switch (x) {
                case 1:
                    System.out.println("---------- Insert Mobile Number ----------");
                    System.out.println("Enter mobile number : ");
                    long number = sc.nextLong();
                    System.out.println("Enter a name : ");
                    String name = sc.next();
                    Node n = new Node(number, name);
                    if(root == null) root = n;
                    else pb.insertMobileNumber(n, root);
                    break;
            
                case 2:
                    System.out.println("---------- Delete Mobile Number ----------");
                    System.out.println("Enter name : ");
                    name = sc.next();
                    root = pb.delete(root, name);
                    break;

                case 3:
                    System.out.println("---------- Search Mobile Number ----------");
                    System.out.println("Enter name for search : ");
                    name = sc.next();
                    pb.searchElement(name, root);
                    break;

                case 4:
                    System.out.println("----------- Phone Dictonary ----------");
                    pb.ascending(root);
                    System.out.println();
                    break;
                    
                case 5:
                    System.out.println("----------- Phone Dictonary ----------");
                    pb.descending(root);
                    System.out.println();
                    break;    
                default:
                    break;
            }
        }

        sc.close();
    }
}

class PhoneBook {

    public void insertMobileNumber(Node phone, Node root) {
        if (root.name.compareTo(phone.name) == 0) {
            root.number = phone.number;
        }
        else if (root.name.compareTo(phone.name) > 0) {
            if (root.left == null) {
                root.left = phone;
            } 
            else {
                insertMobileNumber(phone, root.left);
            }
        }
        else{
            if (root.right == null) {
                root.right = phone;
            } 
            else {
                insertMobileNumber(phone, root.right);
            } 
        }
    }

    public Node delete(Node root ,String name){
        if(root == null) return null;
        if(root.name.compareTo(name) == 0){
            return replace(root);
        }
        if(root.name.compareTo(name) < 0)root.right = delete(root.right , name);
        if(root.name.compareTo(name) > 0) root.left = delete(root.left , name);
        return root;
    }

    public Node replace(Node root){
        if(root.left == null && root.right==null) return null;
        if(root.right == null) return root.left;
        if(root.left == null) return root.right;
        Node temp = root.right;
        if(temp.left == null){
            temp.left = root.left;
        }
        else{
            Node temp2 = temp;
            while(temp2.left != null){
                temp2 = temp2.left;
            }
            temp2.left = root.left;     
        }
        return temp;
    } 

    public void searchElement(String name , Node root){
        if(root == null){
            System.out.println("---------- Element Note Found -----------");
            return;
        }
        if(root.name.equals(name)){
            System.out.println("---------- " +root.name+ " : " +root.number+"----------");
        }
        else if(root.name.compareTo(name) < 0){
            searchElement(name, root.right);
        }
        else{
            searchElement(name, root.left);
        }

    }

    public void ascending(Node root){
        if(root != null){
            ascending(root.left);
            System.out.println(root.name  + " : " + root.number);
            ascending(root.right);
        }
    }

    public void descending(Node root){
        if(root != null){
            descending(root.right);
            System.out.println(root.name  + " : " + root.number);
            descending(root.left);
        }
    }
}

class Node {
    long number;
    String name;
    Node left;
    Node right;

    public Node() {
        this.number = 0;
        this.name = "";
        this.left = null;
        this.right = null;
    }

    public Node(long number) {
        this();
        this.number = number;
    }

    public Node(String name) {
        this();
        this.name = name;
    }

    public Node(long number, String name) {
        this();
        this.number = number;
        this.name = name;
    }
}
