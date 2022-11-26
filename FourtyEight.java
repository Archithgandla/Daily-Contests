//151. Reverse Words in a String

public class FourtyEight {
//     public String reverseWords(String s) {
//         StringBuilder str = new StringBuilder();
//         String temp = "";
//         boolean flag = false;
        
//         for(int i=s.length()-1;i>=0;i--){
//             char c = s.charAt(i);
//             if(c != ' '){
//                 temp = c+temp;
//                 flag = true;
//             }else if(flag && i != 0 && i != s.length()-1){
//                 str.append(temp);
//                 temp = "";
//                 str.append(" ");
//                 flag = false;
//             }
            
//         }
//         str.append(temp);

//         return str.toString().trim();
//     }


//Better Solution

public String reverseWords(String s) {

    int n = s.length();
    StringBuilder ans = new StringBuilder("");
    StringBuilder temp = new StringBuilder("");

    for( int i=n-1; i>=0; i-- ) {
        char ch = s.charAt(i);

        if( ch!=' ' ) temp.append(ch);
        
        if( (ch==' ' || i==0 ) && temp.length()>0 ) {
            if( ans.length()>0 ) ans.append(" ");
            temp.reverse();
            ans.append(temp);
            temp.setLength(0);
        }
    }

    return ans.toString();
}
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }   
}
