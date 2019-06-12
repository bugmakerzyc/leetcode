class Solution {
    /**
    * 时间复杂度 O(log(x)), log(x)表示x的位数
    * 空间复杂度 O(1)
    */
    public int reverse(int x) {
        int tmp = 0;
        while (x != 0) {
            int num = x % 10;   // 负数取模后仍为负数
            if (tmp > Integer.MAX_VALUE / 10 || tmp < Integer.MIN_VALUE / 10 || 
               (tmp == Integer.MAX_VALUE / 10 && num > 7) || (tmp == Integer.MIN_VALUE / 10 && num < -8)) {
                return 0;
            }
            x /= 10;
            tmp = 10 * tmp + num;
        }
        return tmp;
    }
}
