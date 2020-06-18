
public class BinarySearch {

    public static int[] arr = {1, 5, 10, 20, 25, 30, 37, 40, 56, 59};

    public static int find(int x, int l, int r) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            System.out.println("Number :" + arr[mid]);
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return find(x, l, mid - 1);
            }
            return find(x, mid + 1, r);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Binary Searching.....");
        int index = find(46, 0, arr.length - 1);
        int numberAt = findNumber(arr, 59);
        System.out.println("Index of the number: " + numberAt);
    }

    public static int findNumber(int[] arr, int num) {
        int l = 0, r = arr.length - 1;

        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}







































