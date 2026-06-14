class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> letters = new HashSet<Character>();

        int start = 0;
        int end = 0;
        int maxLength = 0;

        while(end < s.length()){
            if(letters.contains(s.charAt(end))){
                while(start < s.length() && letters.contains(s.charAt(end))){
                    letters.remove(s.charAt(start));
                    start++;
                }
                letters.add(s.charAt(end));
            }

            letters.add(s.charAt(end));
            end++;
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }
}
