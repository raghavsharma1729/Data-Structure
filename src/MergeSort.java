public class MergeSort {
    void merge(int arr[], int l, int m, int r) {
        int lSize = m - l + 1;
        int rSize = r - m;

        int[] lArray = new int[lSize];
        int[] rArray = new int[rSize];

        for (int i = 0; i < lSize; i++) {
            lArray[i] = arr[l + i];
        }
        for (int j = 0; j < rSize; j++) {
            rArray[j] = arr[m + 1 + j];
        }

        int k = l;
        int i = 0, j = 0;
        while (i < lSize && j < rSize) {
            if (lArray[i] < rArray[j]) {
                arr[k] = lArray[i];
                i++;

            } else {
                arr[k] = rArray[j];
                j++;
            }
            k++;
        }

        while (i < lSize) {
            arr[k] = lArray[i];
            i++;
            k++;
        }
        while (j < rSize) {
            arr[k] = rArray[j];
            k++;
            j++;
        }

    }

    void sort(int[] arr, int l, int r) {
        if (r > l) {
            int m = (r + l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12, 17, 1, 23, 50, 67, 43};
        MergeSort mergeSort = new MergeSort();
        System.out.println("Array");
        printArray(arr);
        mergeSort.sort(arr, 0, arr.length - 1);
        System.out.println("Merge Sorted Array");
        printArray(arr);
        int arr1[]= arr;
        arr1[0]=10;
        System.out.println(arr[0]);
    }
}
