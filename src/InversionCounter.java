
//Using Merge sort

import java.util.ArrayList;
import java.util.Scanner;

public class InversionCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an Array:");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter Elements of Array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The number of inversions are:" + mergeSort(arr, 0, size - 1));
    }

    private static int mergeInversionCounter(int[] arr, int l, int mid, int r) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = l;
        int right = mid + 1;
        int inversionCount = 0;

        //storing elements in the temporary array
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                inversionCount += (mid - left + 1);
                right++;
            }
        }

        // if elements on the left half are still left

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left
        while (right <= r) {
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temporary to arr
        for (int i = l; i <= r; i++) {
            arr[i] = temp.get(i - l);
        }
        return inversionCount;
    }

    public static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right){
            int mid = (left + right) / 2 ;
            count += mergeSort(arr, left, mid);  // left half
            count += mergeSort(arr, mid + 1, right); // right half
            count += mergeInversionCounter(arr, left, mid, right);  // merging sorted halves
        }
        return count;
    }
}
