class Solution {

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n]; // single reusable buffer, O(n) space total
        mergeSort(nums, temp, 0, n - 1);
        return nums;
    }

    // Divide: recurse on [left, mid] and [mid+1, right]
    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return; // base case: 0 or 1 element
        }

        int mid = left + (right - left) / 2; // avoids overflow vs (left+right)/2

        mergeSort(arr, temp, left, mid);       // conquer left half
        mergeSort(arr, temp, mid + 1, right);  // conquer right half
        merge(arr, temp, left, mid, right);    // combine
    }

    // Combine: merge two sorted runs arr[left..mid] and arr[mid+1..right]
    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // copy the relevant slice into temp manually (no System.arraycopy)
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // pointer into left run (in temp)
        int j = mid + 1;   // pointer into right run (in temp)
        int k = left;      // pointer into arr, where we write the merged result

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // copy any remaining elements from the left run
        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        // copy any remaining elements from the right run
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
}