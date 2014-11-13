package net.anotheria.multipleWorkersTask;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Checks whether a matrix is a magic square.
 * @author ksolodovnik
 */
public class CheckSquare {
    /* magic square */
    int matrix[][];
    /* sum of columns, rows and diagonals */
    static final int SUM = 15;

    /**
     * Constructor
     * @param arr - two-dimensional array for checking
     */
    public CheckSquare(int[][] arr){
        this.matrix = arr;
    }

    /**
     * Checks the sum of all elements of rows and columns and diagonals of the array,
     * using ExecutorService for creating a pool of threads.
     * If sum = 15 it's a magic square.
     * @return res
     * @throws InterruptedException
     */
    protected boolean isMagic() throws InterruptedException {
        final boolean[] res = new boolean[1];
        int poolSize = 3;
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        for(int i = 0; i < 3; i++) {
            pool.submit(new Runnable() {
                public void run() {
                    if (rowAndColumn() == true && diagonalRight() == true && diagonalLeft() == true) {
                        res[0] = true;
                    } else {
                        res[0] = false;
                    }
                }
            });
        }
        pool.shutdown();
        return res[0];
    }

    /**
     * Checks sum of left diagonal elements
     * @return true if sum = 15
     */
    private boolean diagonalLeft(){
        int sum = 0;
        for(int d = 0; d < matrix[0].length; d++)
            sum = sum + matrix[d][(matrix.length-1) - d];
        return (sum == SUM);
    }

    /**
     * Checks sum of right diagonal elements
     * @return true if sum = 15
     */
    private boolean diagonalRight (){
        int sum = 0;
        for (int d = 0; d < matrix[0].length; d++)
            sum = sum + matrix[d][d];
        return (sum == SUM);
    }

    /**
     * Checks sum of rows and columns elements
     * @return true if sum = 15
     */
    private boolean rowAndColumn(){
        int rowsum = 0, colsum = 0;
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                rowsum = rowsum + matrix[i][j];
                colsum = colsum + matrix[j][i];
            }
            if(rowsum != SUM || colsum != SUM)
                return false; // if the sums doesn't match
            rowsum = 0; //reset row count
            colsum = 0; //reset col count
        }
        return true;
    }
}

