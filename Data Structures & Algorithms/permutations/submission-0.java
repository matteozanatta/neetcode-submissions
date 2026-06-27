class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(nums, res, new ArrayList<>());
        
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> sub){
        if(sub.size() >= nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(sub.contains(nums[i])){
                continue;
            }

            sub.add(nums[i]);

            dfs(nums, res, sub);

            sub.remove(sub.size() - 1);
        }

        // 1 2 3
        // [1]
        // [1,2] [1,3]
        // [1,2,3] [1,3,2]

        // 2
        // [2,1] [2,3]
        // [2,1,3] [2,3,1]

        // 3 
        // 1 2
        // 2 1


    }
}
