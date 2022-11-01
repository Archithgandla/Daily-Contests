//Push Dominoes

class ten {
    public String pushDominoes(String dominoes) {
       
        int[] left = new int[dominoes.length()]; 
        int[] right = new int[dominoes.length()];
        
        if(dominoes.charAt(0) == 'R'){
            left[0] = 0;
        }else{
            left[0] = -1;
        }    
        
        if(dominoes.charAt(dominoes.length()-1) == 'L'){
            right[dominoes.length()-1] = dominoes.length()-1;
        }else{
            right[dominoes.length()-1] = -1;
        }
        
        
        for(int i=1;i<dominoes.length();i++){
            
            if(dominoes.charAt(i) == 'R')
                left[i] = i;
            else if(dominoes.charAt(i) == 'L')
                left[i] = -1;
            else
                left[i] = left[i-1]; 
        }
        
        for(int i=dominoes.length()-2;i>=0;i--){
            
            if(dominoes.charAt(i) == 'L')
                right[i] = i;
            else if(dominoes.charAt(i) == 'R')
                right[i] = -1;
            else
                right[i] = right[i+1]; 
        }
        
                
        
        StringBuffer ans = new StringBuffer("");
        
        for(int i=0;i<dominoes.length();i++){
            
            
            if(left[i] == -1 && right[i] == -1)
                ans.append('.');
                
            else if(left[i] == -1 && right[i] != -1)
                ans.append('L');
            
            else if(left[i] != -1 && right[i] == -1)
                ans.append('R');
            
            else if(left[i] != -1 && right[i] != -1){
                
                if(i-left[i]<right[i]-i)
                    ans.append('R');
                else if(i-left[i]>right[i]-i)
                    ans.append('L');
                else
                    ans.append('.');
                
            }
        }
        return ans.toString();
        
    }
}
