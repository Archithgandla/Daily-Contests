//Minimum windows substring
//Refer Coding decoded

//Sliding window approach
public class twentysix {
    class Solution {
        public String minWindow(String s, String t) {
            
            int[] freq = new int[128];
            String ans="";
            
            //Constructing the frequency array for pattern
            for(char c:t.toCharArray())
                freq[c]+=1;
            
            int i=0,j=0,counter = t.length(),min_length = Integer.MAX_VALUE;
            
            //Traversing through the text
            while(j<s.length()){
                
                char c = s.charAt(j);
                
                //Decreasing the counter if it is a part of pattern string
                //Because only elements in pattern can have freq greater than zero
                if(freq[c]>0){
                    counter-=1;
                }
                
                //Decreasing the frequency
                freq[c]-=1;
                
                //Moving i to minimize the window size
                while(counter == 0){
                    //System.out.println("ans : "+s.substring(i,j+1));
                    if(j-i+1<min_length){
                        min_length = j-i+1;
                        ans = s.substring(i,j+1);
                        //System.out.println("ans : "+ans);
                    }
                    //System.out.println("hi");
                    freq[s.charAt(i)]+=1;
                    
                    if(freq[s.charAt(i)]>0){
                        //System.out.println(s.charAt(i));
                        counter+=1;
                    }
                    i+=1;
                }
                //If counter became >0 then moving j again to make counter zero
                j+=1;
                
            }
            return min_length == Integer.MAX_VALUE?"":ans;
        }
    }
}
