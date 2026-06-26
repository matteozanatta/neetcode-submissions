class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        dfs(0, nums, 0, target, res, subset);

        return res;
    }

    private void dfs(int i, int[] nums, int sum, int target, List<List<Integer>> res, List<Integer> subset){
        if(sum == target){
            res.add(new ArrayList(subset));
            return;
        } else if(sum > target || i >= nums.length){
            return;
        }

        subset.add(nums[i]);
        dfs(i, nums, sum + nums[i], target, res, subset);

        subset.remove(subset.size() - 1);
        dfs(i+1, nums, sum, target, res, subset);
    }
}
