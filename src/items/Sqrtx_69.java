package items;

public class Sqrtx_69 {
    public static int mySqrt(int x) {
        if (x == 1) return 1;
        long left = 0, right = x;
        while (left < right - 1) { // if right = left + 1, it will loop infinitely.
            if (((left + right)/2) * ((left + right)/2) == (long) x) return (int)(left + right)/2;
            else if (((left + right)/2) * ((left + right)/2) > (long) x) right = (left + right)/2;
            else left = (left + right)/2;
        }
        if (left * left > (long) x) return (int) left-1;
        return (int) left;
    }

//    public static int mySqrt(int x) {
//        for (long i = 0; i <= (long) x /2 + 1; i++) {
//            if (i*i == (long) x) return (int)i;
//            else if (i*i > (long) x) return (int)i-1;
//        }
//
//        return 1;
//    }
}
