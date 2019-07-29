package items;

public class PalindromeNumber_9 {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertNumber || x == revertNumber / 10;

//        if (x < 0) return false;
//
//        List<Integer> numbers = new ArrayList<>();
//        while (x > 0) {
//            numbers.add(x % 10);
//            x /= 10;
//        }
//
//        int length = numbers.size();
//        boolean result = true;
//        for (int i =0; i < length/2; i++) {
//            if (numbers.get(i) != numbers.get(length-1-i)) {
//                result = false;
//                break;
//            }
//        }
//
//        return result;
    }
}
