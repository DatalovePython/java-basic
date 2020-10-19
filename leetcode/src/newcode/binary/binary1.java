package newcode.binary;

/**
 * @author luzc
 * @date 2020/10/19 14:49
 * @desc
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
