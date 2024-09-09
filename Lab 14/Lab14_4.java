public class Lab14_4 {
    public static void main(String[] args) {
        // Initialize an array to be converted into a binary tree
        int[] arr = {5,1,1,2,3,3,2};
        BTree tree = new BTree();
        
        // Convert the array into a binary tree
        TreeNode root = tree.convertArrayToBTree(arr, 0);

        // Check if the binary tree is symmetric
        Symmetric s = new Symmetric();
        System.out.println(s.isSymmetric(root.left, root.right)); // Print the result
    }
}

class Symmetric {
    // Method to check if two trees are symmetric
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true; // Both subtrees are empty
        if (root1 == null || root2 == null) return false; // One subtree is empty and the other is not

        boolean ans1, ans2;
        if (root1.data == root2.data) { // Compare the data of the roots
            ans1 = isSymmetric(root1.left, root2.right); // Recursively check left and right subtrees
            ans2 = isSymmetric(root1.right, root2.left); // Recursively check right and left subtrees
        } else {
            return false; // Data mismatch
        }

        return ans1 && ans2; // Both subtrees must be symmetric
    }
}