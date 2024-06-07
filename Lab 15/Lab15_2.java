// WAP to find the smallest and largest elements in the Binary Search Tree. 

import java.util.Scanner;

public class Lab15_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BSTTree tree = new BSTTree();
        TreeNode root = null;

        System.out.println("Enter elements of BST \nEnter -1 for break ");
        int element;

        while(true){
            element = sc.nextInt();
            if(element == -1) break;
            TreeNode n = new TreeNode(element);
            if(root == null) {
                root = n;
            }
            else{
                root = tree.insertInBST(element, root);
            }
        }

        tree.inOrder(root);
        System.out.println();

        System.out.println("Smallest element : "+tree.findMin(root));
        System.out.println("Largest element"+tree.findMax(root));

        sc.close();
    }
}

class BSTTree{

    public TreeNode insertInBST(int element , TreeNode root){
        TreeNode n = new TreeNode(element);
        if(root == null){
            root = n;
            return root;
        }

        TreeNode temp = root;

        while(temp != null){
            if(temp.data == element) break;
            if(temp.data > element){
                if(temp.left == null){
                    temp.left = n;
                    break;
                }
                else{
                    temp = temp.left;
                }
            }
            else if(temp.data < element){
                if(temp.right == null){
                    temp.right = n;
                    break;
                }
                else{
                    temp = temp.right;
                }
            }
        }

        return root;
    }

    public TreeNode delete(TreeNode root ,int n){
        if(root == null) return null;
        if(root.data==n){
            return replace(root);
        }
        if(root.data < n) root.right = delete(root.right , n);
        if(root.data > n) root.left = delete(root.left , n);
        return root;
    }

    public TreeNode replace(TreeNode root){
        if(root.left == null && root.right==null) return null;
        if(root.right == null) return root.left;
        if(root.left == null) return root.right;
        TreeNode temp = root.right;
        if(temp.left == null){
            temp.left = root.left;
        }
        else{
            TreeNode temp2 = temp;
            while(temp2.left != null){
                temp2 = temp2.left;
            }
            temp2.left = root.left;     
        }
        return temp;
    }

    public void searchElement(int element , TreeNode root){
        if(root == null){
            System.out.println("---------- Element Note Found -----------");
            return;
        }
        if(root.data == element){
            System.out.println("---------- Element found ----------");
        }
        else if(root.data < element){
            searchElement(element, root.right);
        }
        else{
            searchElement(element, root.left);
        }
    }

    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data  + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.data  + " ");
            // int a = (root.left == null) ? 0 : root.left.data;
            // System.out.println("Left = "+a);
            // int b = (root.right == null) ? 0 : root.right.data;
            // System.out.println("right = "+b);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public int findMin(TreeNode root){
        TreeNode temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }

    public int findMax(TreeNode root){
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.data;
    }

}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(){
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data){
        super();
        this.data = data;
    }
}