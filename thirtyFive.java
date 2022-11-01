//766. Toeplitz Matrix


//Time : n^2
//space : 1
public class thirtyFive {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int ref = matrix[i][j];
                
                int tempi = i,tempj = j;
                while(tempi<matrix.length && tempj<matrix[0].length){
                    if(matrix[tempi][tempj] != ref)
                        return false;
                    tempi+=1;tempj+=1;
                }

            }    
        }
        return true;
    }

//Method-2
//Time : n^2
//space : 1
public boolean isToeplitzMatrix2(int[][] matrix) {
        
    for(int i=1;i<matrix.length;i++){
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[i][j] != matrix[i-1][j-1])
                return false;
        }
    }
    return true;
}


}
