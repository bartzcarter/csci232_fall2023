// Taken from Algorithms, 4th edition by Segewick and Wayne
//Modified by Carter Bartz (added comments)

public class ThreeSumDoubling {

     private static final int MAXIMUM_INTEGER=1000000;
     
     /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        //counts the number of triples that sum to 0
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 
    
    public static double timeTrial(int n) {
        //returns the time to count the number of triples that sum to 0
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        StopWatchCPU timer = new StopWatchCPU();
        count(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) { 
        //prints the time to count the number of triples that sum to 0
        double time = 0.0;
        for (int n = 250; n < 8001; n += n) {
            time = timeTrial(n);
            System.out.printf("%7d %f\n", n, time);
            
        }
        double running_time_with_n = (time/(8000.0 * 8000.0 * 8000.0));
        System.out.println("running time compared with N = " +
                                running_time_with_n + " x N cubed");
        
    } 
    
}
