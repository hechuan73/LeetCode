package items;

public class ContainerWithMostWater_11 {
    public static int maxArea(int[] height) {

        int result = 0, left = 0, right = height.length - 1;

        while (left < right) {
            result = height[left] < height[right]
                    ? Math.max(result, (right - left) * height[left++])
                    : Math.max(result, (right - left) * height[right--]);
        }

        return result;
    }


//    public static int maxArea(int[] height) {
//
//        int result = 0;
//
//        for (int left = 0; left < height.length - 1; left++) {
//            for (int right = left + 1; right < height.length; right++) {
//                result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
//            }
//        }
//
//        return result;
//    }
}
