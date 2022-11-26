//222. Count Complete Tree Nodes

class Solution {
        
    
    public int countNodes(TreeNode root) {
        //Time : O(n) Travelling all nodes
        //using inorder traversal
//         if(root == null)
//             return 0;
        
        
//         int count = 0;
        
//         count+=countNodes(root.left);
//         count+=1;
//         count+=countNodes(root.right);
//         return count;
        
//Time : O(logn logn)
//Not travelling all nodes
//
        if(root == null) return 0;
        
        
        int l = 1,r = 1;
        TreeNode left = root,right = root;
        
        while(left.left != null){
            left = left.left;
            l+=1;
        }
        
        while(right.right != null){
            right = right.right;
            r+=1;
        }
        
        //If it is a perfect binary tree
        if(l == r)
            return (1<<l)-1; //2^h-1
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
