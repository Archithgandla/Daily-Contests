//224. Basic Calculator
//Refer Coding Decoded


import java.util.*;

public class fiftySix {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0,currAns = 0,sign = 1;
        
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='1' && s.charAt(i)<='9'){
                currAns = s.charAt(i)-'0';
                
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    currAns = (currAns*10)+(s.charAt(i+1)-'0');
                    i+=1;
                }
                ans+=(sign*currAns);
                currAns = 0;
                sign = 1;
            } 
            else if(s.charAt(i) == '-')
                sign = -1;
            else if(s.charAt(i) == '+')
                sign = 1;
            
            else if(s.charAt(i) == '('){
                st.push(ans);
                st.push(sign);
                ans = 0;
                sign = 1;
            }
            
            else if(s.charAt(i) == ')'){
                ans*=st.pop();
                int tempAns = st.pop();
                ans+=tempAns;
                sign = 1;
                
            }
        
        }
        return ans;
    }
}
