//623. Add One Row to Tree
//Simple recursion



//Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 


class Solution {
    
    public TreeNode Util(TreeNode root,int val,int depth,int curr_depth){
        
        if(root == null)
            return root;
        
        if(curr_depth == depth-1){
            TreeNode temp_left = root.left,temp_right = root.right;
            TreeNode left = new TreeNode(val),right = new TreeNode(val);
            root.left = left;
            root.right = right;
            
            root.left.left = temp_left;
            root.right.right = temp_right;
            
            return root;
        }
        
        root.left = Util(root.left,val,depth,curr_depth+1);
        root.right = Util(root.right,val,depth,curr_depth+1);
               
        return root;
    }
    
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        
        return Util(root,val,depth,1);
        
    }
}
