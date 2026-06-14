class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int min = 0;
        int max = nums.length - 1;

        while(min < max){
            int mid = min + ((max - min) >>> 1);

            if(nums[mid] > nums[nums.length - 1]){
                min = mid + 1;
            }else{
                max = mid;
            }
        }

        return nums[min];
    }
}
