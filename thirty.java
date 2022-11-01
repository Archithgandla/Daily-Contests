//523. Continuous Subarray Sum

import java.util.*;
//Approach - 1
//Find all subarrays
//Time : O(n^2) space : O(1)

//Approach - 2
//Using prefix sum
//Refer coding decoded

public class thirty {
    public boolean checkSubarraySum(int[] arr, int k) {
                
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        
        //To satisfy the test case
        hm.put(0,-1);
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            
                                        //                
            if(hm.containsKey(sum%k) && i-hm.get(sum%k)>1){
                return true;
            }
            else if(!hm.containsKey(sum%k))
                hm.put(sum%k,i);
        }
        return false;
    }  
}
