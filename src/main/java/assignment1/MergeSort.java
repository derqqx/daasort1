package assignment1;

public class MergeSort {
    private static int maxDepth;

    public static int sort(int[] a) {
        maxDepth = 0;
        int[] buf = new int[a.length];
        sortRec(a, buf, 0, a.length - 1, 1);
        return maxDepth;
    }

    private static void sortRec(int[] a, int[] buf, int l, int r, int depth) {
        if (depth > maxDepth) maxDepth = depth;
        if (r - l <= 16) { insertion(a, l, r); return; }
        int m = (l + r) / 2;
        sortRec(a, buf, l, m, depth + 1);
        sortRec(a, buf, m + 1, r, depth + 1);
        merge(a, buf, l, m, r);
    }

    private static void merge(int[] a, int[] buf, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) buf[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        while (i <= m) buf[k++] = a[i++];
        while (j <= r) buf[k++] = a[j++];
        for (i = l; i <= r; i++) a[i] = buf[i];
    }

    private static void insertion(int[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int x = a[i], j = i - 1;
            while (j >= l && a[j] > x) { a[j + 1] = a[j]; j--; }
            a[j + 1] = x;
        }
    }
}
