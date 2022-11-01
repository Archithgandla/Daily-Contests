//1239. Maximum Length of a Concatenated String with Unique Characters
//Finding all possible combinations
//Refer Fraz
import java.util.*;

public class twentyEight {
    boolean check(String s,int[] arr){
        
        int[] self_check = new int[26];
        
        for(int i=0;i<s.length();i++){
            if(self_check[s.charAt(i)-'a']==1)
                return false;
            self_check[s.charAt(i)-'a'] = 1;
        }
        
    
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a'] == 1)
                return false;
            
            //?? why is this step leading to error
            //arr[s.charAt(i)-'a'] = 1;
        }   
        System.out.println(s+" acccpeted");
        return true;
        
    }
    
    int Util(List<String> list,int index,int len,int[] arr,String ans){
        
        if(index == list.size()){
            //System.out.println(ans);
            return len;
        }
        
        if(check(list.get(index),arr) == false){
            return Util(list,index+1,len,arr,ans);
        }
        
        String s = list.get(index);
        
        //pick
        for(int i=0;i<s.length();i++)
            arr[s.charAt(i)-'a']=1;

        int taken = Util(list,index+1,len+s.length(),arr,ans+s);
        
        //Not pick
        for(int i=0;i<s.length();i++)
            arr[s.charAt(i)-'a']=0;
        
        int not_taken = Util(list,index+1,len,arr,ans);
        
        //System.out.println("Taken : "+taken+" not_taken : "+not_taken);
        return Math.max(taken,not_taken);
    }
    
    
    
    public int maxLength(List<String> arr) {
        return Util(arr,0,0,new int[26],"");        
    }
}
