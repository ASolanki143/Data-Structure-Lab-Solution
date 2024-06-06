public class Lab14_4 {
    public static void main(String[] args) {
        int[] arr = {5,1,1,2,3,3,2};
        BTree tree = new BTree();
        TreeNode root = tree.convertArrayToBTree(arr, 0);

        Symmetric s = new Symmetric();
        System.out.println(s.isSymmetric(root.left, root.right));
    }
}

class Symmetric{
    
    public boolean isSymmetric(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        boolean ans1 , ans2;
        if(root1.data == root2.data){
            ans1 = isSymmetric(root1.left, root2.right);
            ans2 = isSymmetric(root1.right, root2.left);
        }
        else{
            return false;
        }

        return ans1 && ans2;
    }
}