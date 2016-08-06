/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        ArrayList<Integer> list = new ArrayList<>();
        while ( !queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            
            if (cur == null) {
                results.add(new ArrayList<Integer>(list));
                list.clear();
                if(!queue.isEmpty())
                    queue.add(null);
            } else {
                list.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            
        }
        
        return results;
    }
}