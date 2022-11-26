//1926. Nearest Exit from Entrance in Maze
import java.util.*;


//DFS USING DP

//1 TEST CASE FAILED
// class Solution {
    
//     int Util(char[][] maze,int row,int col,boolean[][] flag,int[][] dp){
//         if((row == maze.length-1 || col == maze[0].length-1 || row==0 || col == 0) && maze[row][col] != '+')
//             return 0;
        
//         if(dp[row][col] != -1)
//             return dp[row][col];
        
//         flag[row][col] = true;
//         int min = 11000;
        
//         //Right
//         if(col+1<maze[0].length && maze[row][col+1] == '.' && flag[row][col+1] == false)
//             min = Math.min(min,1+Util(maze,row,col+1,flag,dp));
            
//         //Left
//         if(col-1>=0 && maze[row][col-1] == '.' && flag[row][col-1] == false)
//             min = Math.min(min,1+Util(maze,row,col-1,flag,dp));
            
            
//         //Top
//         if(row-1>=0 && maze[row-1][col] == '.' && flag[row-1][col] == false)
//             min = Math.min(min,1+Util(maze,row-1,col,flag,dp));
            
//         //Down
//         if(row+1<maze.length && maze[row+1][col] == '.' && flag[row+1][col] == false)
//             min = Math.min(min,1+Util(maze,row+1,col,flag,dp));
        
//         flag[row][col] = false;
        
//         System.out.println("row : "+row+" col : "+col+" "+min);
//         return dp[row][col] = min;
        
//     }
    
    

//     public int nearestExit(char[][] maze, int[] entrance) {
//         boolean[][] flag = new boolean[maze.length][maze[0].length];
//         maze[entrance[0]][entrance[1]] = '+';
//         int[][] dp = new int[maze.length][maze[0].length];
        
//         for(int i=0;i<dp.length;i++){
//             for(int j=0;j<dp[0].length;j++)
//                 dp[i][j] = -1;
//         }
        
        
        
//         int ans = Util(maze,entrance[0],entrance[1],flag,dp);
//         if(ans != 11000)
//             return ans; 
        
//         return -1;
//     }
// }



//USING BFS
//https://www.youtube.com/watch?v=T9nIsYFK8Sg
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    if (maze[x][y] == '+') continue;

                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return steps;

                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}


