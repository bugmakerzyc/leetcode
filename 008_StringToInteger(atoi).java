class Solution {
    public int myAtoi(String str) {
        if (str.equals("")) {
            return 0;
        }
        // i为第一个非空字符的下标
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        
        boolean symbol = true;
        // 判断第一个非空字符
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            symbol = str.charAt(i) == '+' ? true : false;
            i++;
        } else if (!Character.isDigit(str.charAt(i))) {
            return 0;
        }
        
        int tmp = 0;
        while (i < str.length()) {
            if (!Character.isDigit(str.charAt(i))) {
                return symbol ? tmp : -tmp;
            }
            int num = Integer.parseInt(str.charAt(i) + "");
            if (tmp > Integer.MAX_VALUE / 10 || (tmp == Integer.MAX_VALUE / 10 && num > 7)) {
                return symbol ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            tmp = 10 * tmp + num;
            i++;
        }
        
        return symbol ? tmp : -tmp;
    }
}
