//645. Set Mismatch

//Approach - 1
//Store them in a hashmap/set and run a loop till n to find the missing element
//Time : O(n) space : (n)

//Approach-2
//Time : n space : 1 

class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = 0,n = nums.length;
        int repeat = -1;
        
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        
        //Finding the repeating number
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0){    
                repeat = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])-1]*=-1;
        }
        
        //System.out.println("repeat : "+repeat+" Sum : "+sum+" "+(n*(n+1)/2));
        
        return new int[]{repeat,(n*(n+1)/2)-(sum-repeat)};
        
    }
}