class Solution {
    /**
	* 滑动窗口
	* 时间复杂度 O(n)
	* 空间复杂度 O(min(n,m))，HashMap 的大小取决于字符串 n 的大小以及字符集/字母 m 的大小。
	* @param s
	* @return
    */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            maxLen = Math.max(maxLen, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
