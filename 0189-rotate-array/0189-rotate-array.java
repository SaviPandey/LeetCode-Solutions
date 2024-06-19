class Solution {
    public void rotate(int[] nums, int k) {
    k %= nums.length; //Ensure k is within array bounds
    reverse(nums, 0, nums.length - 1); //Reverse entire array
    reverse(nums, 0, k - 1);  //Reverse first k elements
    reverse(nums, k, nums.length - 1); //Reverse remaining elements
}

public void reverse(int[] nums, int start, int end) {
    //While start index is less than end index
    while (start < end) {
        //Swap elements at start and end indices
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        //Increment start index and decrement end index
        start++;
        end--;
    }
}
}