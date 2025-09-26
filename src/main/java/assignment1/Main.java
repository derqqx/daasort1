package assignment1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        Random rnd = new Random();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(10000);

        try (PrintWriter pw = new PrintWriter(new FileWriter("metrics.csv"))) {
            pw.println("algorithm,n,timeMillis,depth");

            // MergeSort
            int[] a1 = arr.clone();
            long t1 = System.currentTimeMillis();
            int depthMS = MergeSort.sort(a1);
            long t2 = System.currentTimeMillis();
            pw.println("mergesort," + n + "," + (t2 - t1) + "," + depthMS);

            // QuickSort
            int[] a2 = arr.clone();
            long t3 = System.currentTimeMillis();
            int depthQS = QuickSort.sort(a2);
            long t4 = System.currentTimeMillis();
            pw.println("quicksort," + n + "," + (t4 - t3) + "," + depthQS);

            // Deterministic Select
            int k = n / 2;
            int[] a3 = arr.clone();
            long t5 = System.currentTimeMillis();
            int sel = DeterministicSelect.select(a3, k);
            long t6 = System.currentTimeMillis();
            pw.println("select," + n + "," + (t6 - t5) + ",-");

            System.out.println("Metrics saved to metrics.csv");
        }
    }
}
