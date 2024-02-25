package Solution;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}

    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    //24.2.10
    //leetcode No.94
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public static void inorder(TreeNode treeNode,List<Integer> list){
        if(treeNode == null){
            return;
        }
        inorder(treeNode.left,list);
        list.add(treeNode.val);
        inorder(treeNode.right,list);
    }
    //24.2.11
    //leetcode No.144 又是二叉树
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
    public static void preorder(TreeNode treeNode,List<Integer> list){
        if(treeNode == null){
            return;
        }
        list.add(treeNode.val);
        preorder(treeNode.left,list);
        preorder(treeNode.right,list);
    }
    //24.2.12
    //leetcode No.145
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public static void postorder(TreeNode treeNode,List<Integer> list){
        if(treeNode == null){
            return;
        }
        postorder(treeNode.left,list);
        postorder(treeNode.right,list);
        list.add(treeNode.val);
    }
    /*
    dfs模板
     */
    public static void dfs(TreeNode root){
        if(root == null){
            return;
        }
        /*
        要做的操作，留空
         */
        dfs(root.left);
        dfs(root.right);
    }
}
