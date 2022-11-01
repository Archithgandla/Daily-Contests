//1578. Minimum Time to Make Rope Colorful

//Time : O(N)
//Space : O(1)
//Two consective ballons should not be of same color
//so n consecutive balloons are of same color then
//we have to eliminate n-1 of them
//We have to retain the balloon which have max removal time
//Two pointer
//Refer coding decoded


class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total_time = 0,start = 0,end = 0;
        
        
        while(end<colors.length()){
            
            start = end;
            int max = Integer.MIN_VALUE;
            
            while(end <colors.length() && colors.charAt(start) == colors.charAt(end)){
                max = Math.max(max,neededTime[end]);
                total_time+=neededTime[end];
                end+=1;
            }
            total_time-=max;
            
        }
        return total_time;
    }
}