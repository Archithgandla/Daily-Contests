//150. Evaluate Reverse Polish Notation
import java.util.*;

class Solution {

    int eval(String n1,String n2,String operator){
        if(operator.equals("+"))
            return Integer.valueOf(n1)+Integer.valueOf(n2);
        else if(operator.equals("-"))
            return Integer.valueOf(n1)-Integer.valueOf(n2);
        else if(operator.equals("*"))
            return Integer.valueOf(n1)*Integer.valueOf(n2);
        else if(operator.equals("/"))
            return Integer.valueOf(n1)/Integer.valueOf(n2);
        return -1;
    }


    public int evalRPN(String[] token) {
        Stack<String> st = new Stack<>();

        for(int i=0;i<token.length;i++){
            if(token[i].equals("+") || token[i].equals("-") || token[i].equals("*") || token[i].equals("/")){
                String d1 = st.pop();
                String d2 = st.pop();

                st.push(String.valueOf(eval(d2,d1,token[i])));
            }
            else{
                st.push(token[i]);
                System.out.println(token[i]);
            }
        }
        System.out.println(st);
        return Integer.valueOf(st.pop());
    }
}