class Solution {
    /**
    * 时间复杂度 O(log(x)), 其中log(x)表示x的位数
    * 空间复杂度 O(1)
    */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int tmp = 0;
        while (x != 0) {
            int num = x % 10;
            tmp = 10 * tmp + num;
            x /= 10;
        }
        return origin == tmp;
    }
}
