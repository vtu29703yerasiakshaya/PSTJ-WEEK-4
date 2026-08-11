class Solution {
    public void moveZeroes(int[] nums) {
        // Pointer to place the next non-zero element
        int lastNonZeroFoundAt = 0;
        
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If current element is non-zero, swap it with the element at lastNonZeroFoundAt
            if (nums[i] != 0) {
                // Only swap if the pointers are at different positions to minimize writes
                if (i != lastNonZeroFoundAt) {
                    int temp = nums[i];
                    nums[i] = nums[lastNonZeroFoundAt];
                    nums[lastNonZeroFoundAt] = temp;
                }
                lastNonZeroFoundAt++;
            }
        }
    }
}
