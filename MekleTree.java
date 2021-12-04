class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;
        
        while(curr != null){
            if(curr.left == null){
                if(prev != null && prev.val > curr.val){
                    if(first == null) first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode pred = findPred(curr);
                if(pred.right != null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    if(prev != null && prev.val > curr.val){
                        if(first == null) first = prev;
                        second = curr;
                    }
                    prev = curr;
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private TreeNode findPred(TreeNode curr){
        TreeNode node = curr.left;
        while(node.right != null && node.right != curr){
            node = node.right;
        }
        return node;
    }
}
