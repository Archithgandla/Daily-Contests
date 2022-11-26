//907. Sum of Subarray Minimums
import java.util.*;

public class sixtyThree {
//O(N) Approach
    public int sumSubarrayMins(int[] arr) {
        Stack<Pair> st = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            while(st.size()>0 && st.peek().ele>=arr[i])
                st.pop();
            
            if(st.size() == 0)
                left[i] = i+1;
            
            else
                left[i] = i-st.peek().index;
            
            st.push(new Pair(arr[i],i));
        }
        
        st.clear();
        
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && st.peek().ele>arr[i])
                st.pop();
            
            if(st.size() == 0)
                right[i] = arr.length-i;
            else 
                right[i] = st.peek().index-i;
            st.push(new Pair(arr[i],i));
        }
           
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans=ans+(arr[i]*left[i]*right[i])%(int)(1e9+7);
            ans%=(int)(1e9+7);
        }
        return ans;
    }


//O(n^2) approach
//     public int sumSubarrayMins(int[] arr) {
        
//         int ans = 0;
        
//         for(int i=0;i<arr.length;i++){
//             int min = Integer.MAX_VALUE;
//             int sum = 0;
            
//             for(int j=i;j<arr.length;j++){
//                 min = Math.min(min,arr[j]);
//                 ans = (ans+min)%(int)(1e9+7);
//             }
//         }
//         return ans;
//     }  
}
