public class Sudoku {

    public static boolean isSafe(int Sudoku[][], int row, int col, int digits){
        //vertical
        for(int i=0; i<=8; i++){
            if (Sudoku[i][col] == digits) {
                return false;
            }
        }

        //horizontal
        for(int j=0; j<=8; j++){
            if (Sudoku[row][j] == digits) {
                return false;
            }
        }

        //grid
        int sr = (row/3) * 3;     //Starting row
        int sc = (col/3) * 3;     //Starting column

        //3X3 grid
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if (Sudoku[i][j] == digits) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static boolean sudokuSolver(int Sudoku[][], int row, int col){
        //base case
        if (row == 9 ) {
            return true;
        }

        //recursion
        int newRow = row, newCol = col+1;
        if (col+1 == 9) {
            newRow = row+1;
            newCol = 0;
        }

        if (Sudoku[row][col] != 0) {
            return sudokuSolver(Sudoku, newRow, newCol);
        }

        for(int digits=1; digits<=9; digits++){
            if (isSafe(Sudoku, row, col, digits)) {
                Sudoku[row][col] = digits;
                if (sudokuSolver(Sudoku, newRow, newCol)) {
                    return true;
                }
                Sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoku(int Sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(Sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int Sudoku[][] = {{0,0,8,0,0,0,0,0,0},
                          {4,9,0,1,5,7,0,0,2},
                          {0,0,3,0,0,4,1,9,0},
                          {1,8,5,0,6,0,0,2,0},
                          {0,0,0,0,2,0,0,6,0},
                          {9,6,0,4,0,5,3,0,0},
                          {0,3,0,0,7,2,0,0,4},
                          {0,4,9,0,3,0,0,5,7},
                          {8,2,7,0,0,9,0,1,3}};


         if (sudokuSolver(Sudoku, 0, 0)) {
            printSudoku(Sudoku);
         }else{
            System.out.println("Something went wrong");
         }                 
    }
}
