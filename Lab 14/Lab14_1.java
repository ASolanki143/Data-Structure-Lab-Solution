import java.util.Scanner;

public class Lab14_1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTTree tree = new BSTTree();
        TreeNode root = null;
        int x = 1;
        int element;

        while(x < 7){
            System.out.println("\nEnter 1 for insert");
            System.out.println("      2 for delete");
            System.out.println("      3 for search");
            System.out.println("      4 for preorder traversal");
            System.out.println("      5 for inorder traversal");
            System.out.println("      6 for postorder traversal");
            System.out.println("      7 for break");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("---------- Insert in BST ----------");
                    System.out.println("Enter element : ");
                    element = sc.nextInt();
                    root = tree.insertInBST(element, root);
                    break;
            
                case 2:
                    System.out.println("---------- Delete in BST ----------");
                    System.out.println("Enter element : ");
                    element = sc.nextInt();
                    root = tree.delete(root, element);
                    break;

                case 3:
                    System.out.println("---------- Search in BST ----------");
                    System.out.println("Enter element : ");
                    element = sc.nextInt();
                    tree.searchElement(element, root);
                    break;

                case 4:
                    System.out.println("---------- Preorder Traversal ----------");
                    tree.preOrder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("---------- Inorder Traversal ----------");
                    tree.inOrder(root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("---------- Postorder Traversal ----------");
                    tree.postOrder(root);
                    System.out.println();
                    break;

                default:
                    break;
            }
        }

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