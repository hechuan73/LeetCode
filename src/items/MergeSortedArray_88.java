package items;

public class MergeSortedArray_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) System.arraycopy(nums2, 0, nums1, 0, nums2.length);

        int[] tmp = new int[m+n];
        int index1 = 0, index2=0;
        if (n != 0) {
            for (int i = 0; i < m + n; i++) {
                if (index1 == m) {
                    tmp[i] = nums2[index2++];
                }
                else if (index2 == n) {
                    tmp[i] = nums1[index1++];
                }
                else {
                    if (nums1[index1] <= nums2[index2])
                        tmp[i] = nums1[index1++];
                    else
                        tmp[i] = nums2[index2++];
                }
            }
            System.arraycopy(tmp, 0, nums1, 0, tmp.length);
        }
    }

    // solution without arranging new array space.
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (nums2[i] >= nums1[j] && nums2[i] <nums1[j+1]) {
                        System.arraycopy(nums1, j+1, nums1, j + 2, m - j - 1);
                        nums1[j+1] = nums2[i];
                        m += 1;
                        break;
                    }
                    if (nums2[i] >= nums1[j] && j == m-1) {
                        nums1[m] = nums2[i];
                        m += 1;
                        break;
                    }
                    if (nums2[i] < nums1[j]) {
                        System.arraycopy(nums1, j, nums1, j + 1, m - j);
                        nums1[j] = nums2[i];
                        m += 1;
                        break;
                    }
                }

            }
        }
    }
}
