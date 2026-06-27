class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int num: nums){
            int occ = count.getOrDefault(num, 0);

            if(occ > 0) return true;

            count.put(num, occ + 1);
        }

        return false;
    }
}