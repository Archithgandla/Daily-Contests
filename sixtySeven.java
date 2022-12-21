//1704. Determine if String Halves Are Alike

class Solution {
    
    boolean isVowel(char a){
        if(a == 'a' ||a == 'e'||a == 'i'||a == 'o'||a == 'u')
            return true;
        else if(a == 'A' ||a == 'E'||a == 'I'||a == 'O'||a == 'U')
            return true;
        return false;
    }
    
    
    public boolean halvesAreAlike(String s) {
        
        int first_half = 0,second_half = 0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()/2 && isVowel(s.charAt(i)))
                first_half+=1;
            else if(isVowel(s.charAt(i)))
                second_half+=1;
        }
        
        return first_half == second_half?true:false;
    }
}