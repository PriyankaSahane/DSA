package array;

//set matrix zero
public class LeetCode_73 {
    public int[][] setZero(int[][] matrix, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    for (int r = 0; r < row; r++) {
                        if (matrix[i][j] != 0) {
                            matrix[i][j] = -1;
                        }
                        for (int c = 0; c < column; c++) {
                            if (matrix[i][j] != 0) {
                                matrix[i][j] = -1;
                            }
                        }
                    }
                }
            }
        }


            //mark all -1 as 0
            for(int i=0; i<row; i++){
                for(int j=0; j<column; j++){
                    if(matrix[i][j] == -1){
                        matrix[i][j] =0;
                    }
                }
            }
            return matrix;
        }

        public static void main(String[] args){
            int input_matrix[][]={{1,0,1},{0,0,1}};
            int n=input_matrix.length;
            int m= input_matrix[0].length;

            LeetCode_73 obj= new LeetCode_73();

            int[][] ans= obj.setZero(input_matrix,n, m);
            for(int i=0; i< ans.length; i++){
                for(int col: ans[i]){
                    System.out.println(col+" ");
                }
                System.out.println();
            }
        }

    }
