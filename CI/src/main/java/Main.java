public class Main {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return 1;
        }
        double aSum = 0;
        double bSum = 0;
        for (int i : nums1) {
            aSum += i;
        }
        for (int i : nums2) {
            bSum += i;
        }
        double result = ((aSum / nums1.length) + (bSum / nums2.length)) / 2;
        return result;

    }

    public static void main(String[] args) {

        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
