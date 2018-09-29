package Items;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //0,3,0,1,1,-1,-5,-5,3,-3,-3,0
        //[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
//        Set<List<Integer>> test = new HashSet<>();
//        test.add(Arrays.asList(1,2,3));
//        test.add(Arrays.asList(1,2,3));
//        System.out.println(test);
//        String test = "0m";
//        System.out.println(test.split("m")[0]);
    }

    private static Set<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        List<List<Integer>> resultsFinal = new ArrayList<>();
        List<Integer> result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {

                int wanted = -(nums[i] + nums[j]);
                if (wanted < 0) {
                    break;
                }

                List<Integer> temp =  Arrays.stream(Arrays.copyOfRange(nums, j +1, nums.length -1)).boxed().collect(Collectors.toList());
                if (temp.contains(wanted)) {
                    result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(wanted);
                        results.add(result);
                }

//                for (int q = j + 1; q < nums.length; q++) {
//                    if (nums[i] + nums[j] + nums[q] > 0) {
//                        break;
//                    }
//
//                    if (0 == nums[i] + nums[j] + nums[q]) {
//                        result = new ArrayList<>();
//                        result.add(nums[i]);
//                        result.add(nums[j]);
//                        result.add(nums[q]);
//                        results.add(result);
//                    }
//                }
            }
        }

        System.out.println(results);
        return results;
    }
}
