class Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return null;
        } else if (s.length() == 0) {
            return "";
        } else if (numRows == 1) {
            return s;
        }
        
        int intervals = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        
        // 转换后的第一行
        for (int i = 0; i < s.length(); i += intervals) {
            sb.append(s.charAt(i) + "");
        }
        // 转换后的中间行，每行由两部分组成
        for (int i = 1; i < numRows - 1; i++) {
            int base1 = i;
            int base2 = intervals - i;
            while (base1 < s.length()) {
                sb.append(s.charAt(base1));
                base1 += intervals;
                if (base2 < s.length()) {
                    sb.append(s.charAt(base2));
                    base2 += intervals;
                }
            }
        }
        // 转换后的最后一行
        for (int i = numRows - 1; i < s.length(); i += intervals) {
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
