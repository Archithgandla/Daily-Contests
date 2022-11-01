//1706. Where Will the Ball Fall
//Time : #ofrows*#ofcols
//Explanation : for every col it goes down each row one by one i.e #noofrows


class Solution {
    
    int Util(int[][] grid,int col,int row){
        //base case
                        
        if(grid[row][col] == 1){
            
            //Ball is the last row or v shape is formed
            if(col+1 >= grid[0].length || grid[row][col+1] == -1)
                return -1;
            
            //ball reached the last row and not in last col
            else if(row == grid.length-1)
                return col+1;
            
            //middle row and not at corner and no v shape so it moves down
            return Util(grid,col+1,row+1);
            
        }
        
        else if(grid[row][col] == -1){
            //Ball is in the 0th row or v shape is formed
            if(col-1 < 0 || grid[row][col-1] == 1)
                return -1;
            
            //ball reached the last row and not in 0th col
            else if(row == grid.length-1)
                return col-1;
            
            //middle row and not at corner and no v shape so it moves down
            return Util(grid,col-1,row+1);
        }
        return 0;
        
    }
    
    public int[] findBall(int[][] grid) {
       
        
        int[] ans = new int[grid[0].length];
        
        for(int i=0;i<grid[0].length;i++){
            ans[i] = Util(grid,i,0);    
        } 
        
        return ans;
    }
}
