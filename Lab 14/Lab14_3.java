public class Lab14_3 {
    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9};
        BTree tree1 = new BTree();
        TreeNode root1 = tree1.convertArrayToBTree(arr1, 0);
        BSTTree t = new BSTTree();
        t.preOrder(root1);

        int[] arr2 = {0,1,2,3,4,5,7,8,9};
        BTree tree2 = new BTree();
        TreeNode root2 = tree2.convertArrayToBTree(arr2, 0);

        CheckSameTree c = new CheckSameTree();
        System.out.println(c.checkTree(root1, root2));
    }
}

class CheckSameTree{
    public boolean checkTree(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null) return false;
        if(root2 == null) return false;

        boolean left , right;
        if(root1.data == root2.data){
            left = checkTree(root1.left, root2.left);
            right = checkTree(root1.right, root2.right);
        }
        else{
            return false;
        }
        return left && right;
    }
}
class BTree{
 
    public TreeNode convertArrayToBTree(int[] arr , int index){
        TreeNode root = null;
        if(index < arr.length){
            root = new TreeNode(arr[index]);
            root.left = convertArrayToBTree(arr, index * 2 + 1);
            root.right = convertArrayToBTree(arr, index * 2 + 2);
        }
        return root;
    }
}
