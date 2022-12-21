//938. Range Sum of BST
  
class Solution {
    //Approach-1
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if(root == null)
            return 0;

        if(root.val>=low && root.val<=high)
            return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);

        return rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);

    }

    //Slightly optimized
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root.val>=low && root.val<=high)
            return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        //value at root is already less than low hence the left subtree has further smaller elements so no use of checking it,hence check only right
        else if(root.val<low)
            return rangeSumBST(root.right,low,high);

//value at root is already greater than high hence the right subtree has further greater elements so no use of checking it,hence check only left
        else if(root.val>low)//i.e greater than high
            return rangeSumBST(root.left,low,high);

    }

}
