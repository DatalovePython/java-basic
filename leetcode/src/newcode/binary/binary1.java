package newcode.binary;

/**
 * @author luzc
 * @date 2020/10/19 14:49
 * @desc
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 */
public class binary1 {
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - 1) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumber(nums, 1, h);

            } else if (nums[m] < nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }

        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }

        }
        return nums[l];
    }
}
