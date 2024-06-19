import java.util.Scanner;

// Main class to manage phonebook operations
public class Lab15_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object for reading input from the user
        Node root = null;  // Initialize the root of the phonebook (BST)
        PhoneBook pb = new PhoneBook();  // Create an instance of PhoneBook to manage phonebook operations

        int x = 1;  // Variable to store user choice

        // Loop to display menu and perform operations until the user chooses to exit
        while (x < 6) {
            System.out.println("Enter 1 for insert mobile number");
            System.out.println("      2 for delete mobile number");
            System.out.println("      3 for search mobile number");
            System.out.println("      4 for display mobile number in ascending order ");
            System.out.println("      5 for display mobile number in descending order ");
            System.out.println("      6 for break");

            x = sc.nextInt();  // Read user choice

            switch (x) {
                case 1:
                    System.out.println("---------- Insert Mobile Number ----------");
                    System.out.println("Enter mobile number : ");
                    long number = sc.nextLong();  // Read mobile number
                    System.out.println("Enter a name : ");
                    String name = sc.next();  // Read name
                    Node n = new Node(number, name);  // Create a new Node with the given number and name
                    if (root == null) root = n;  // Set the new node as root if tree is empty
                    else pb.insertMobileNumber(n, root);  // Insert the new node into the BST
                    break;

                case 2:
                    System.out.println("---------- Delete Mobile Number ----------");
                    System.out.println("Enter name : ");
                    name = sc.next();  // Read name to delete
                    root = pb.delete(root, name);  // Delete the node with the given name
                    break;

                case 3:
                    System.out.println("---------- Search Mobile Number ----------");
                    System.out.println("Enter name for search : ");
                    name = sc.next();  // Read name to search
                    pb.searchElement(name, root);  // Search for the node with the given name
                    break;

                case 4:
                    System.out.println("----------- Phone Dictionary ----------");
                    pb.ascending(root);  // Display phone numbers in ascending order
                    System.out.println();
                    break;

                case 5:
                    System.out.println("----------- Phone Dictionary ----------");
                    pb.descending(root);  // Display phone numbers in descending order
                    System.out.println();
                    break;

                case 6:
                    // Break out of the loop if the user chooses to exit
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        sc.close();  // Close the Scanner
    }
}

// Class to manage phonebook operations
class PhoneBook {

    // Method to insert a mobile number into the BST
    public void insertMobileNumber(Node phone, Node root) {
        if (root.name.compareTo(phone.name) == 0) {
            root.number = phone.number;  // Update number if name already exists
        } else if (root.name.compareTo(phone.name) > 0) {
            if (root.left == null) {
                root.left = phone;  // Insert on left if left child is null
            } else {
                insertMobileNumber(phone, root.left);  // Recur on left child
            }
        } else {
            if (root.right == null) {
                root.right = phone;  // Insert on right if right child is null
            } else {
                insertMobileNumber(phone, root.right);  // Recur on right child
            }
        }
    }

    // Method to delete a node from the BST
    public Node delete(Node root, String name) {
        if (root == null) return null;  // Return null if tree is empty
        if (root.name.compareTo(name) == 0) {
            return replace(root);  // Replace node if name matches
        }
        if (root.name.compareTo(name) < 0) root.right = delete(root.right, name);  // Recur on right subtree
        if (root.name.compareTo(name) > 0) root.left = delete(root.left, name);  // Recur on left subtree
        return root;  // Return the updated root
    }

    // Helper method to replace a node in the BST
    public Node replace(Node root) {
        if (root.left == null && root.right == null) return null;  // No children
        if (root.right == null) return root.left;  // Only left child
        if (root.left == null) return root.right;  // Only right child
        Node temp = root.right;  // Temporary variable for replacement

        // Find the appropriate position for the left subtree
        if (temp.left == null) {
            temp.left = root.left;
        } else {
            Node temp2 = temp;
            while (temp2.left != null) {
                temp2 = temp2.left;
            }
            temp2.left = root.left;
        }
        return temp;  // Return the updated node
    }

    // Method to search for a node by name
    public void searchElement(String name, Node root) {
        if (root == null) {
            System.out.println("---------- Element Not Found -----------");
            return;
        }
        if (root.name.equals(name)) {
            System.out.println("---------- " + root.name + " : " + root.number + " ----------");
        } else if (root.name.compareTo(name) < 0) {
            searchElement(name, root.right);  // Recur on right subtree
        } else {
            searchElement(name, root.left);  // Recur on left subtree
        }
    }

    // Method to display phone numbers in ascending order
    public void ascending(Node root) {
        if (root != null) {
            ascending(root.left);  // Recur on left subtree
            System.out.println(root.name + " : " + root.number);
            ascending(root.right);  // Recur on right subtree
        }
    }

    // Method to display phone numbers in descending order
    public void descending(Node root) {
        if (root != null) {
            descending(root.right);  // Recur on right subtree
            System.out.println(root.name + " : " + root.number);
            descending(root.left);  // Recur on left subtree
        }
    }
}

// Class to represent a node in the phonebook (BST)
class Node {
    long number;  // Mobile number
    String name;  // Name associated with the number
    Node left;  // Reference to the left child
    Node right;  // Reference to the right child

    // Default constructor
    public Node() {
        this.number = 0;
        this.name = "";
        this.left = null;
        this.right = null;
    }

    // Constructor to create a node with a specific number
    public Node(long number) {
        this();
        this.number = number;
    }

    // Constructor to create a node with a specific name
    public Node(String name) {
        this();
        this.name = name;
    }

    // Constructor to create a node with a specific number and name
    public Node(long number, String name) {
        this();
        this.number = number;
        this.name = name;
    }
}
