class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        // 1 1 2
        // [1] []
        // [1, 2] [1]

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, new ArrayList<>());

        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> sub){
        if(i >= nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        dfs(i+1, nums, res, sub);

        sub.remove(sub.size() - 1);
        while(i < nums.length - 1 && nums[i] == nums[i+1]){
            i+=1;
        }
        dfs(i+1, nums, res, sub);
    }
}
