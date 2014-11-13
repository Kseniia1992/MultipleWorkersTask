package net.anotheria.multipleWorkersTask;

/**
 * Initialized array and calls method for permutation of array elements
 * @author ksolodovnik
 */
public class Main {
    /* dimension of array */
    static final int N = 3;
    /* two-dimensional array */
    static int [][] square;
    /* one-dimensional array */
    static int arr[];

    /**
     * net.anotheria.magicSquareTask.Main method.
     * Initialized one-dimensional array
     * and calls prmt method for permutation of array elements
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        square = new int [N][N];
        arr = new int [N*N];
        int n = 1;
        for (int i = 0; i<N*N; i++){
            arr[i]=n;
            n++;
        }
        MagicSquare magicSquare = new MagicSquare(square);
        magicSquare.prmt(arr, 0);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("This program has performed for " + timeSpent + " milliseconds");
    }
}

