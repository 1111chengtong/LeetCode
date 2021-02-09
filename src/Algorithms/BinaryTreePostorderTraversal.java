package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> listLeft = postorderTraversal(root.left);
        List<Integer> listRight = postorderTraversal(root.right);
        for (int num : listLeft) {
            list.add(num);
        }
        for (int num : listRight) {
            list.add(num);
        }
        list.add(root.val);
        return list;
    }
}
