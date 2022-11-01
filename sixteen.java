//653. Two Sum IV - Input is a BST
//Approach - 1
//Perform inoder traversal and store them in a arraylist
//Since inorder traversal gives sorted order,now use two pointers
//Time : O(N)
//Space : O(N)

// class Solution {
    
//     ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> Al){
        
//         if(root.left != null)
//             Al = inorder(root.left,Al);
        
//         Al.add(root.val);
        
//         if(root.right != null)
//             Al = inorder(root.right,Al);
        
//         return Al;
        
//     }
    

//     public boolean findTarget(TreeNode root, int k) {
//         ArrayList<Integer> Al = new ArrayList<>();
//         Al = inorder(root,Al);
        
//         int i=0,j=Al.size()-1;
        
//         while(i<j){
//             int sum = Al.get(i)+Al.get(j);
            
//             if(sum == k)
//                 return true;
//             else if(sum>k)
//                 j-=1;
//             else if(sum<k)
//                 i+=1;
            
//         }
//         return false;        
//     }
// }


//Approach - 2
//Refer striver
//Time : O(2N)
//Space : O(2H)
//Refer https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/2678395/Daily-LeetCoding-Challenge-October-Day-9
//for better approaches

import java.util.*;

class BSTIterator {
    
    Stack<TreeNode> st;
    boolean reverse;
    public BSTIterator(TreeNode root,boolean reverse) {
        st = new Stack<>();
        this.reverse = reverse;
        pushAll(root,reverse);
    }
    
    public int next() {
        TreeNode s = st.pop();
        if(reverse == true)
            pushAll(s.left,reverse);
        else
            pushAll(s.right,reverse);
        return s.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    public void pushAll(TreeNode root,boolean reverse){
        
        if(reverse == true){
            while(root != null){
                st.push(root);
                root = root.right;
            }
        }else{
            while(root != null){
                st.push(root);
                root = root.left;
            }
        }
    }
    
}



class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator next = new BSTIterator(root,false);
        BSTIterator before = new BSTIterator(root,true);
        
        int i = next.next(),j = before.next();
        
        
        // i gives elements in ascending order
        // j gives elements in descending order
        // Two pointer approach
        // Since BST cannot have duplictaes we can run loop till i<j
        while(i<j){
            if(i+j == k)
                return true;
            
            else if(i+j<k)
                i = next.next();
            
            else if(i+j>k)
                j = before.next();
        }
        return false;
    }
}
