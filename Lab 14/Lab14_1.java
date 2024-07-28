import java.util.Scanner;

public class Lab14_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input
        BSTTree tree = new BSTTree(); // Create a new Binary Search Tree (BST)
        TreeNode root = null; // Initialize the root of the BST
        int x = 1; // Control variable for the while loop
        int element; // Variable to store the element to be inserted, deleted, or searched
        // Menu-driven interface
        while (x < 7) {
            System.out.println("\nEnter 1 for insert");
            System.out.println("      2 for delete");
            System.out.println("      3 for search");
            System.out.println("      4 for preorder traversal");
            System.out.println("      5 for inorder traversal");
            System.out.println("      6 for postorder traversal");
            System.out.println("      7 for break");
            x = sc.nextInt(); // Read the user's choice

            switch (x) {
                case 1:
                    System.out.println("---------- Insert in BST ----------");
                    System.out.println("Enter element : ");
                    element = sc.nextInt(); // Read the element to be inserted
                    root = tree.insertInBST(element, root); // Insert the element into the BST
                    break;

                case 2:
                    System.out.println("---------- Delete in BST ----------");
                    System.out.println("Enter element : ");
                    element = sc.nextInt(); // Read the element to be deleted
                    root = tree.delete(root, element); // Delete the element from the BST
                    break;

                case 3:
                    System.out.println("---------- Search in BST ----------");
                    System.out.println("Enter element : ");
                    element = sc.nextInt(); // Read the element to be searched
                    tree.searchElement(element, root); // Search for the element in the BST
                    break;

                case 4:
                    System.out.println("---------- Preorder Traversal ----------");
                    tree.preOrder(root); // Perform preorder traversal
                    System.out.println();
                    break;

                case 5:
                    System.out.println("---------- Inorder Traversal ----------");
                    tree.inOrder(root); // Perform inorder traversal
                    System.out.println();
                    break;

                case 6:
                    System.out.println("---------- Postorder Traversal ----------");
                    tree.postOrder(root); // Perform postorder traversal
                    System.out.println();
                    break;

                default:
                    break; // Exit the loop if the user enters 7
            }
        }

        sc.close(); // Close the scanner
    }
}

class BSTTree {

    // Method to insert an element into the BST
    public TreeNode insertInBST(int element, TreeNode root) {
        TreeNode n = new TreeNode(element); // Create a new node
        if (root == null) { // If the tree is empty, set the new node as root
            root = n;
            return root;
        }

        TreeNode temp = root;

        // Traverse the tree to find the correct position for the new node
        while (temp != null) {
            if (temp.data == element)
                break; // If the element already exists, do nothing
            if (temp.data > element) { // If the current node's data is greater than the element
                if (temp.left == null) {
                    temp.left = n; // Insert the new node to the left
                    break;
                }
                else {
                    temp = temp.left; // Move to the left child
                }
            }
            else if (temp.data < element) { // If the current node's data is less than the element
                if (temp.right == null) {
                    temp.right = n; // Insert the new node to the right
                    break;
                }
                else {
                    temp = temp.right; // Move to the right child
                }
            }
        }

        return root; // Return the root of the tree
    }

    // Method to delete an element from the BST
    public TreeNode delete(TreeNode root, int n) {
        if (root == null)
            return null; // If the tree is empty, return null
        if (root.data == n) {
            return replace(root); // If the element is found, replace the node
        }
        if (root.data < n)
            root.right = delete(root.right, n); // Traverse the right subtree
        if (root.data > n)
            root.left = delete(root.left, n); // Traverse the left subtree
        return root; // Return the root of the tree
    }

    // Method to replace a node in the BST
    public TreeNode replace(TreeNode root) {
        if (root.left == null && root.right == null)
            return null; // If the node is a leaf, remove it
        if (root.right == null)
            return root.left; // If the node has only left child, replace with left child
        if (root.left == null)
            return root.right; // If the node has only right child, replace with right child
        TreeNode temp = root.right;
        if (temp.left == null) {
            temp.left = root.left; // If the right child has no left child, replace with right child
        }
        else {
            TreeNode temp2 = temp;
            while (temp2.left != null) {
                temp2 = temp2.left; // Find the leftmost node in the right subtree
            }
            temp2.left = root.left; // Replace with the leftmost node in the right subtree
        }
        return temp; // Return the replacement node
    }

    // Method to search for an element in the BST
    public void searchElement(int element, TreeNode root) {
        if (root == null) {
            System.out.println("---------- Element Not Found -----------");
            return;
        }
        if (root.data == element) {
            System.out.println("---------- Element found ----------");
        }
        else if (root.data < element) {
            searchElement(element, root.right); // Search in the right subtree
        }
        else {
            searchElement(element, root.left); // Search in the left subtree
        }
    }

    // Method for inorder traversal
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left); // Traverse the left subtree
            System.out.print(root.data + " "); // Visit the root
            inOrder(root.right); // Traverse the right subtree
        }
    }

    // Method for preorder traversal
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " "); // Visit the root
            preOrder(root.left); // Traverse the left subtree
            preOrder(root.right); // Traverse the right subtree
        }
    }

    // Method for postorder traversal
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left); // Traverse the left subtree
            postOrder(root.right); // Traverse the right subtree
            System.out.print(root.data + " "); // Visit the root
        }
    }
}

class TreeNode {
    int data; // Data of the node
    TreeNode left; // Left child
    TreeNode right; // Right child

    public TreeNode() {
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data) {
        this();
        this.data = data;
    }
}
