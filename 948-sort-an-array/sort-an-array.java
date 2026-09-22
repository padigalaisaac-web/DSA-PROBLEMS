class Solution {
    public void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int p1 = start,
            p2 = mid+1,
            p3 = 0;

        while(p1 <= mid && p2 <= end) {
            if(arr[p1] < arr[p2]) {
                temp[p3] = arr[p1];
                p1++;
            }
            else {
                temp[p3] = arr[p2];
                p2++;
            }
            p3++;
        }

        while(p1 <= mid) {
            temp[p3] = arr[p1];
            p1++;
            p3++;
        }

        while(p2 <= end) {
            temp[p3] = arr[p2];
            p2++;
            p3++;
        }

        int i=0;
        p1 = start;

        while(i < temp.length) {
            arr[p1] = temp[i];
            i++;
            p1++;
        }
    }
    public void mergeSort(int[] nums, int start, int end) {
        if(start >= end) return;

        int mid = start + (end - start)/2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);

        merge(nums, start, mid, end);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}