class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> count = new HashMap<>();

        for(String str: strs){
            char[] sortedChar = str.toCharArray();
            Arrays.sort(sortedChar);
            String sortedString = new String(sortedChar);

            if(count.containsKey(sortedString)){
                count.get(sortedString).add(str);
            }else{
                List<String> arrS = new ArrayList<>();
                arrS.add(str);
                count.put(sortedString, arrS);
            }
        }

        return new ArrayList<>(count.values());
    }
}
