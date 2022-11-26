//36. Valid Sudoku
//Refer : https://leetcode.com/problems/valid-sudoku/discuss/2840656/Java-oror-Explained-in-Detailoror-Simple-and-Fast-Solutionoror-Intuitive-and-Hash-Table

import java.util.*;


public class sixtyTwo {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> hs = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] != '.'){
                    if(!hs.add(board[i][j]+" in row "+i) || !hs.add(board[i][j]+" in column "+j) || 
                        !hs.add(board[i][j] +" in block "+i/3+" "+j/3))
                            return false;
                }
                
            }        
        }
        
        return true;
    }  
}
