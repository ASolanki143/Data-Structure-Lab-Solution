// Program to find the smallest and largest elements in a Binary Search Tree (BST)

import java.util.Scanner;

public class Lab15_2 {
    public static void main(String[] args) {
        // Create a Scanner object for reading input from the user
        Scanner sc = new Scanner(System.in);

        // Create an instance of BSTTree to manage BST operations
        BSTTree tree = new BSTTree();
        TreeNode root = null;  // Initialize the root of the BST

        // Prompt the user to enter elements of the BST
        System.out.println("Enter elements of BST \nEnter -1 to stop ");
        int element;

        // Read elements from the user until they enter -1
        while (true) {
            element = sc.nextInt();
            if (element == -1) break;  // Exit the loop if -1 is entered
            TreeNode n = new TreeNode(element);  // Create a new TreeNode
            if (root == null) {
                root = n;  // Set the first element as root
            } else {
                root = tree.insertInBST(element, root);  // Insert the element into the BST
            }
        }

        // Perform in-order traversal of the BST and print the elements
        tree.inOrder(root);
        System.out.println();

        // Find and print the smallest element in the BST
        System.out.println("Smallest element: " + tree.findMin(root));
        // Find and print the largest element in the BST
        System.out.println("Largest element: " + tree.findMax(root));

        // Close the Scanner
        sc.close();
    }
}

// Class to represent a Binary Search Tree (BST) and its operations
class BSTTree {

    // Method to insert an element into the BST
    public TreeNode insertInBST(int element, TreeNode root) {
        TreeNode n = new TreeNode(element);  // Create a new TreeNode with the given element
        if (root == null) {
            root = n;  // If the tree is empty, set the new node as root
            return root;
        }

        TreeNode temp = root;  // Temporary variable to traverse the tree

        // Traverse the tree to find the correct position for the new node
        while (temp != null) {
            if (temp.data == element) break;  // If the element already exists, do nothing
            if (temp.data > element) {
                if (temp.left == null) {
                    temp.left = n;  // Insert the new node as the left child
                    break;
                } else {
                    temp = temp.left;  // Move to the left child
                }
            } else if (temp.data < element) {
                if (temp.right == null) {
                    temp.right = n;  // Insert the new node as the right child
                    break;
                } else {
                    temp = temp.right;  // Move to the right child
                }
            }
        }

        return root;  // Return the updated root
    }

    // Method to delete an element from the BST
    public TreeNode delete(TreeNode root, int n) {
        if (root == null) return null;  // If the tree is empty, return null
        if (root.data == n) {
            return replace(root);  // If the element is found, replace it
        }
        if (root.data < n) root.right = delete(root.right, n);  // Recur on the right subtree
        if (root.data > n) root.left = delete(root.left, n);  // Recur on the left subtree
        return root;  // Return the updated root
    }

    // Helper method to replace a node in the BST
    public TreeNode replace(TreeNode root) {
        if (root.left == null && root.right == null) return null;  // No children
        if (root.right == null) return root.left;  // Only left child
        if (root.left == null) return root.right;  // Only right child
        TreeNode temp = root.right;  // Temporary variable for replacement

        // Find the appropriate position for the left subtree
        if (temp.left == null) {
            temp.left = root.left;
        } else {
            TreeNode temp2 = temp;
            while (temp2.left != null) {
                temp2 = temp2.left;
            }
            temp2.left = root.left;
        }
        return temp;  // Return the updated node
    }

    // Method to search for an element in the BST
    public void searchElement(int element, TreeNode root) {
        if (root == null) {
            System.out.println("---------- Element Not Found -----------");
            return;
        }
        if (root.data == element) {
            System.out.println("---------- Element Found ----------");
        } else if (root.data < element) {
            searchElement(element, root.right);  // Recur on the right subtree
        } else {
            searchElement(element, root.left);  // Recur on the left subtree
        }
    }

    // Method to perform in-order traversal of the BST and print elements
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // Method to perform pre-order traversal of the BST and print elements
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Method to perform post-order traversal of the BST and print elements
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Method to find the smallest element in the BST
    public int findMin(TreeNode root) {
        TreeNode temp = root;  // Temporary variable to traverse the tree
        while (temp.left != null) {
            temp = temp.left;  // Move to the leftmost node
        }
        return temp.data;  // Return the data of the leftmost node
    }

    // Method to find the largest element in the BST
    public int findMax(TreeNode root) {
        TreeNode temp = root;  // Temporary variable to traverse the tree
        while (temp.right != null) {
            temp = temp.right;  // Move to the rightmost node
        }
        return temp.data;  // Return the data of the rightmost node
    }

}

// Class to represent a node in the binary search tree
class TreeNode {
    int data;  // Data stored in the node
    TreeNode left;  // Reference to the left child
    TreeNode right;  // Reference to the right child

    // Default constructor
    public TreeNode() {
        this.left = null;
        this.right = null;
    }

    // Constructor to create a node with a specific data value
    public TreeNode(int data) {
        super();
        this.data = data;
    }
}
