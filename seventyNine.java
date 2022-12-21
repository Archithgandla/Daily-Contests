//2500. Delete Greatest Value in Each Row


class Solution {
    public int deleteGreatestValue(int[][] grid) {
        //boolean[][] flag = new boolean[grid.length][grid[0].length];
        int ans = 0;
        
        for(int i=0;i<grid[0].length;i++){
            int max = Integer.MIN_VALUE;
            
            for(int j=0;j<grid.length;j++){
                int loc_max = Integer.MIN_VALUE;
                int index = -1;
                for(int k=0;k<grid[0].length;k++){
                    if(grid[j][k]>loc_max){
                        index = k;
                        loc_max = grid[j][k];
                    }
                }
                grid[j][index] = Integer.MIN_VALUE;
                max = Math.max(loc_max,max);
            }
            ans+=max;
        }
        return ans;
    }
}
