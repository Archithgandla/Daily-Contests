//1047. Remove All Adjacent Duplicates In String

class Solution {
    public String removeDuplicates(String s) {
        StringBuffer str = new StringBuffer();
        //str.append(s.charAt(0));        
        

        for(int i=0;i<s.length();i++){
            
            if(str.length()>0 && s.charAt(i) == str.charAt(str.length()-1)){
                str.delete(str.length()-1,str.length());
            }
            else
                str.append(s.charAt(i));
        }
        return str.toString();
    }
}
