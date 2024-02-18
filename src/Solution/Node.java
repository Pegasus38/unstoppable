package Solution;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
    //24.2.19 虽然每天都是树 但是还是得抄一下的
    //leetcode NO.590 N叉树的后序遍历 访问节点 再访问根节点值
    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        findPostOrder(root,res);
        return res;
    }
    public static void findPostOrder(Node root, List<Integer> res){
        if(root == null){
            return;
        }
        for(Node ch : root.children){
            findPostOrder(ch,res);
        }
        res.add(root.val);
    }
}
