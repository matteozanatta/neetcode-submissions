class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int min = 0;
        int max = nums.length - 1;

        while(min < max){
            int mid = min + ((max - min) >>> 1);

            if(nums[mid] == target) return mid;

            if(nums[min] <= nums[mid]){
                if(target >= nums[min] && target < nums[mid]){
                    max = mid;
                }else{
                    min = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[max]){
                    min = mid + 1;
                }else{
                    max = mid;
                }
            }
        }

        return nums[min] == target ? min : -1;
    }
}
