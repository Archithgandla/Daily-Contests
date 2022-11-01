import java.util.*;

//Approach - 1
//Consider all possible triplets
//Time : O(n3)

//Approach 
//Time : O(N2)
//First sort the array - nlogn
//Then fix an element then using outer loop and apply two pointer approach on remaining element
//and compare the absolute diff with target,consider the least difference


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE,sum = 0,ans = 0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            int j = i+1,k = nums.length-1;
            
            while(j<k){
                //System.out.println(j+" "+k);
                
                int temp_sum = nums[i]+nums[j]+nums[k];
                if(temp_sum == target)
                    return target;
                
                else if(temp_sum>target){
                    k-=1;
                }
                
                else if(temp_sum<target){
                    j+=1;
                }
                
                
                if(Math.abs(target-temp_sum)<min){
                    min = Math.abs(target-temp_sum);
                    ans = temp_sum;
                }
                    
            }
            
        }
        return ans;
        
    }
}