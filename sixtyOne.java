//279. Perfect Squares

class Solution {
    
    //Memoization
    int Util(int n,int[] dp){
        
        if(n <= 0)
            return 0;
        
        else if(n<=3)
            return n;
        
        else if(dp[n] != 0){
            //System.out.println("Hi");
            return dp[n];
        }
            
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min = Math.min(min,1+Util(n-(i*i),dp));   
        }    
        return dp[n] = min; 
    }
    
    
    public int numSquares(int n) {
        
        //Tabulation
        if(n<=3)
            return n;        
        int[] dp = new int[n+1];
        
        for(int i=0;i<=3;i++)
            dp[i] = i;
        
        for(int j=4;j<=n;j++){
            int min = Integer.MAX_VALUE;
            for(int i=1;i*i<=j;i++)
                min = Math.min(min,1+dp[j-(i*i)]);   
            dp[j] = min;
                
        }
    
        return dp[n];
    }
}
