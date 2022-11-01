//12. Integer to Roman

class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] notations = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}; 
        
        for(int i=0;i<notations.length && num>0;i++){
            //Approach-1
            // while(num>=values[i]){
            //     ans.append(notations[i]);
            //     num-=values[i];
            // }
            
            //approach-2
            int temp = num/values[i];
            String str = notations[i];
            
            if(temp == 3){
                ans.append(str).append(str).append(str);
                num-=3*values[i];
            }
            else if(temp == 2){
                ans.append(str).append(str);
                num-=2*values[i];
            }
            else if(temp == 1){
                ans.append(str);
                num-=1*values[i];
            }    
            
        }
        
        return ans.toString();
    }
}
