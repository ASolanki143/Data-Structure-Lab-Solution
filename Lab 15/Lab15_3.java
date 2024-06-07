public class Lab15_3 {
    public static void main(String[] args) {
        Node root = new Node(1234567890 , "d");
        PhoneBook pb = new PhoneBook();
        pb.insertMobileNumber(new Node(1234567890 , "b") , root);
        pb.insertMobileNumber(new Node(1234567890 , "a") , root);
        pb.insertMobileNumber(new Node(1234567890 , "c") , root);
        pb.insertMobileNumber(new Node(1234567890 , "e") , root);
        pb.insertMobileNumber(new Node(1234567890 , "f") , root);

        System.out.println();
        pb.preOrder(root);

        root = pb.delete(root, "a");
        System.out.println();
        pb.preOrder(root);
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

    public static Node replace(Node root){
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

    public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.name  + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.println(root.name  + " ");
            String a = (root.left == null) ? "-" : root.left.name;
            System.out.println("Left = "+a);
            String b = (root.right == null) ? "-" : root.right.name;
            System.out.println("right = "+b);
            preOrder(root.left);
            preOrder(root.right);
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
