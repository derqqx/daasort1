package assignment1;

import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();
    private static int maxDepth;

    public static int sort(int[] a) {
        maxDepth = 0;
        sortRec(a, 0, a.length - 1, 1);
        return maxDepth;
    }

    private static void sortRec(int[] a, int l, int r, int depth) {
        if (depth > maxDepth) maxDepth = depth;
        while (l < r) {
            int p = l + rand.nextInt(r - l + 1);
            swap(a, p, r);
            int pivot = partition(a, l, r);
            if (pivot - l < r - pivot) {
                sortRec(a, l, pivot - 1, depth + 1);
                l = pivot + 1;
            } else {
                sortRec(a, pivot + 1, r, depth + 1);
                r = pivot - 1;
            }
        }
    }

    private static int partition(int[] a, int l, int r) {
        int x = a[r], i = l;
        for (int j = l; j < r; j++) if (a[j] <= x) swap(a, i++, j);
        swap(a, i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
