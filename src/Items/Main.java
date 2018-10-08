package Items;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //0,3,0,1,1,-1,-5,-5,3,-3,-3,0
        //[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        ThreeSum_15.threeSum(nums);
//        Set<List<Integer>> test = new HashSet<>();
//        test.add(Arrays.asList(1,2,3));
//        test.add(Arrays.asList(2,1,3));
//        System.out.println(test);
//        String test = "0m";
//        System.out.println(test.split("m")[0]);
    }


}
