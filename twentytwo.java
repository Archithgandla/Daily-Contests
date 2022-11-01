//1335. Minimum Difficulty of a Job Schedule
//Refer Coding decoded and tech by nivedita

//Variation of matrix chain multiplication
import java.util.*;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length)
            return -1;
        
        int[][] dp = new int[d+1][jobDifficulty.length+1];
        
        for(int[] temp:dp)
            Arrays.fill(temp,-1);
        
        return Util(0,d,jobDifficulty,jobDifficulty.length,dp);
    }
    
    int Util(int index,int day,int[] jobDifficulty,int n,int[][] dp){
        
        if(day == 1){
            int max = Integer.MIN_VALUE;
            
            for(int i=index;i<n;i++)
                max = Math.max(max,jobDifficulty[i]);
            return max;
        }
        
        if(dp[day][index] != -1)
            return dp[day][index];
        
        
        int currDay = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        
        for(int i=index;i<n-day+1;i++){
            currDay = Math.max(currDay,jobDifficulty[i]);
            ans = Math.min(ans,currDay+Util(i+1,day-1,jobDifficulty,n,dp));
        }
        
        return dp[day][index] = ans;
    
    }
}
