class Solution {
    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int count = 0, p1 = 0, p2 = 0, min = 0, max = 0;
        
        while (p1 < nums1.length || p2 < nums2.length) {
            count++;
            if (count == n / 2) {
                min = p1 == nums1.length ? nums2[p2++] : p2 == nums2.length ? nums1[p1++] : nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
            } else if (count == n / 2 + 1) {
                max = p1 == nums1.length ? nums2[p2++] : p2 == nums2.length ? nums1[p1++] : nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
                break;
            } else {
                if (p1 == nums1.length) {
                    p2++;
                } else if (p2 == nums2.length) {
                    p1++;
                } else {
                    if (nums1[p1] <= nums2[p2]) {
                        p1++;
                    } else {
                        p2++;
                    }
                }
            }
        }

        if (n % 2 == 0) {
            return (double)(min + max) / 2;
        } else {
            return (double)max;
        }
    }
}
