package binary_search;

// Given an infinite sorted array (or an array with unknown size), find if a given number ‘key’ is present in the array.
// Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
// Since it is not possible to define an array with infinite (unknown) size,
// you will be provided with an interface ArrayReader to read elements of the array. ArrayReader.get(index) will return the number at index; if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.
public class ESearchInfiniteSortedArray {

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length) {
                return Integer.MAX_VALUE;
            }
            return arr[index];
        }
    }

    // Approach : Keep increasing the length of the array until you reach the end or you reach a
    // number greater than key/target. Then you have your bound and now you can use this to apply binary search.
    public static int search(ArrayReader arr, int target) {
        int start = 0, end = 1;
        while (arr.get(end) < target) {
            int newStart = end + 1;
            end = (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, start, end, target);
    }

    private static int binarySearch(ArrayReader arr, int start, int end, int target) {
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr.get(middle) == target) {
                return middle;
            }
            if(arr.get(middle) > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + ESearchInfiniteSortedArray.search(new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}), 16));
        System.out.println("Response : " + ESearchInfiniteSortedArray.search(new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}), 11));
        System.out.println("Response : " + ESearchInfiniteSortedArray.search(new ArrayReader(new int[]{1, 3, 8, 10, 15}), 15));
        System.out.println("Response : " + ESearchInfiniteSortedArray.search(new ArrayReader(new int[]{1, 3, 8, 10, 15}), 200));
    }


}
