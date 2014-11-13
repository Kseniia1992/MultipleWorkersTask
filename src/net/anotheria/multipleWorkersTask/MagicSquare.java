package net.anotheria.multipleWorkersTask;

/**
 * Finds all permutations of one-dimensional array
 * and converts them into a 3 by 3 matrix.
 * @author ksolodovnik
 */
public class MagicSquare {
    /* dimension of array */
    static final int N = 3;
    /* two-dimensional array */
    static int [][] sq;
    /* temporary array */
    static int[][] temp ;

    /**
     * Constructor
     * @param sq - two-dimensional array
     */
    public MagicSquare(int[][] sq) {
        this.sq = sq;
    }

    /**
     * Permutation of one-dimensional array elements.
     * Calls methods for transformation of array and checking it
     * @param arr one-dimensional array
     * @param i index of array element
     * @throws InterruptedException
     */
    protected void prmt(int[] arr, int i) throws InterruptedException {
        //if end of array - transfer array to a two-dimensional array
        if (i == arr.length - 1) {
            temp = transfer(arr);
            CheckSquare checkSquare = new CheckSquare(temp);
            //if array is a Magic Square - print it
            if (checkSquare.isMagic()) {
                printArray(temp);
                System.out.println();
            }
        } else {
            // Permutation of array elements
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                prmt(arr, i + 1);
                swap(arr, i, j);
            }
        }
    }

    /**
     * Transfers one-dimensional array into two-dimensional array
     * @param arr - one-dimensional array
     * @return sq - two-dimensional array
     */
    private int[][] transfer(int arr[]){
        for(int i=0; i<N*N;i++){
            sq[i/N][i%N]=arr[i];
        }
        return sq;
    }

    /**
     * Moves one-dimensional array elements
     * @param ar - one-dimensional array
     * @param i - first element index
     * @param j - next element index
     */
    private void swap(int[] ar, int i, int j) {
        int k = ar[i];
        ar[i] = ar[j];
        ar[j] = k;
    }

    /**
     * Prints Magic Square
     * @param pr_arr - magic square
     */
    private void printArray(int [][] pr_arr) {
        for (int i = 0; i < pr_arr.length; i++) {
            for (int j = 0; j < pr_arr.length; j++) {
                System.out.print(pr_arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

