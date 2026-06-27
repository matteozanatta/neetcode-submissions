class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        // 1 2 2 4 5 6 9
        // [1] [0]
        //

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, target, res, new ArrayList<>());

        return res;
    }

    private void dfs(int index, int[] candidates, int target, List<List<Integer>> res, List<Integer> sub){
        if(target < 0) return;
        
        if(target == 0){
            res.add(new ArrayList<>(sub));
            return;
        }

        if(index >= candidates.length) return;

        sub.add(candidates[index]);
        dfs(index + 1, candidates, target - candidates[index], res, sub);

        sub.remove(sub.size() - 1);
        while(index < candidates.length - 1 && candidates[index] == candidates[index + 1]){
            index++;
        }
        dfs(index + 1, candidates, target, res, sub);
    }
}
