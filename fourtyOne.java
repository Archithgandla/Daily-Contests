//899. Orderly Queue

//Approach
//If the value of k is greater then value is sorted string
//If the value of k is 1 then keep shifting the first index i.e try all possible combinations and return the lexographically least possible string



//In java call by reference works for objects not for variables
//Objects are those that are created using new keyword
class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }           
        
        String ans = s;
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            Util(arr);
            
            //String.valueOf() can be used instead of toString()
            int diff = ans.compareTo(String.valueOf(arr));
            
            //diff is greater than 0 if exisitng ans is lexo greater than arr
            //so update the ans with arr
            if(diff>0)
                ans = String.valueOf(arr);
        }
        return ans;
    }
    
    void Util(char[] arr){
        char temp = arr[0];
        
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
    }
    
}