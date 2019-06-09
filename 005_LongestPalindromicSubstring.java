class Solution {
    /**
    * 时间复杂度 O(n^2), 由于围绕中心来扩展回文会耗去 O(n) 的时间，所以总的复杂度为 O(n^2)
    * 空间复杂度 O(1)
    */
    public String longestPalindrome(String s) {
        // 中心拓展法
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = maxLenArroundCenter(s, i, i);
            int len2 = maxLenArroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    // 以s.substring(start, end + 1)为中心的最长回文子串的长度
    private int maxLenArroundCenter(String s, int start, int end) {
        int left = start, right = end;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
