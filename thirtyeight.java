//2131. Longest Palindrome by Concatenating Two Letter Words
import java.util.*;

class Solution {
    
    String reverse(String a){
        StringBuilder str = new StringBuilder();
        
        for(int i=a.length()-1;i>=0;i--)
            str.append(a.charAt(i));
        return str.toString();
    }
    
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> hm = new HashMap<>();
        int len = 0;
        
        //To check wheter a single palindromic element is user
        boolean flag = true;
        
        for(int i=0;i<words.length;i++)
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        
        
        for(int i=0;i<words.length;i++){
            if(hm.containsKey(reverse(words[i]))){
            
                                                               //flag must help or it should be greater than 2 soo that it can be attached twice at the ends
                if(words[i].charAt(0) == words[i].charAt(1) && (hm.get(words[i])>=2 || flag == true)){
                    int count = hm.get(words[i]);
                    
                    if(count-2>0)
                       hm.put(words[i],count-2); 
                    else
                        hm.remove(words[i]);
                
                    System.out.println(count);
                    len+= count>=2?4:2;
                    
                    //Single palindromic is used hence flip flag
                    if(count<2)
                        flag = false;
                    
                }
                else if(words[i].charAt(0) != words[i].charAt(1)){
                    int count1 = hm.get(words[i]);
                    int count2 = hm.get(reverse(words[i]));
                    
                    if(count1-1>0 && count2-1>0){
                        hm.put(words[i],count1-1);
                        hm.put(reverse(words[i]),count2-1);
                    }else{
                        hm.remove(words[i]);
                        hm.remove(reverse(words[i]));
                    }
                    
                    len+=4;
                }
                
                
            }            
        }
        return len;
    }
}


//Optimized solution
// class Solution {
//     public int longestPalindrome(String[] words) {
//         int result = 0;
//         int[][] letterArr= new int[26][26];
//         for (int i=0; i<words.length; i++) {
//             int index1 = words[i].charAt(0) - 'a';
//             int index2 = words[i].charAt(1) - 'a';
            
//             //Checking if reverse exits,if else removing it so that it cannot paired upon again
//             if (letterArr[index2][index1] > 0) {
//                 --letterArr[index2][index1];  result += 4;
//             } else ++letterArr[index1][index2];
//         }
        
//         //For that one palindromic element of once that has occured only once
//         for(int i=0; i<26; i++){
//            if(letterArr[i][i]>0) return result + 2;
//         }
//         return result;
//     }
// }