public class QuickSort {
    public int partition(int []arr, int l, int r){
        int pi;
        int i=l-1;
        int pivot=arr[r];
        for(int j=l; j<r; j++){
            if(arr[j] <= pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        arr[r]=arr[i+1];
        arr[i+1]=pivot;
        pi=i+1;
        return pi;
    }

    public void sort(int []arr, int l, int r){
        if(r > l){
            int pi=partition(arr, l, r);

            sort(arr, l, pi-1);
            sort(arr, pi+1, r);
        }
    }

    static void printArray(int []arr){
        int arraySize= arr.length;
     for(int i=0; i<arraySize; i++)
         System.out.print(arr[i]+",");
    }

    public  static  void main(String []arg){
        int []arr={ 12, 10, 50, 23, 34, 56, 21, 9, 8};
        int arr1[] = {10, 7, 8, 9, 1, 5};
        QuickSort quickSort= new QuickSort();
        quickSort.sort(arr1, 0, arr1.length-1);

        System.out.println("sorted array");
        printArray(arr1);

    }
}
