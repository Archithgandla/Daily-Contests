//Break a palindrome

class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1)
            return "";
        
        StringBuilder ans = new StringBuilder("");
        int i=0,j=palindrome.length()-1;
        boolean flag = false;

        
        
        while(i<j){
            if(palindrome.charAt(i) != 'a'){
                break;
            }
            i+=1;j-=1;
        }
        
        //When the string contains only a's
        if(i>=j){
            for(int k=0;k<palindrome.length()-1;k++){
                ans.append(palindrome.charAt(k));
            }
            ans.append('b');
            return ans.toString();
        }
        
        //When non a's are also present in the string
        for(int k=0;k<palindrome.length();k++){
            if(k==i){
                ans.append('a');
                continue;
            }
            ans.append(palindrome.charAt(k));
        }
        return ans.toString();
        
        
        
    }
}
