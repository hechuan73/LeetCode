import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        ProductOfNumbers numbers = new ProductOfNumbers();
//        numbers.add(3);
//        numbers.add(0);
//        numbers.add(2);
//        numbers.add(5);
//        numbers.add(4);
//        int[] array = null;
//        System.out.println(array.length);
//        int[] data = {1, 1, 1, 2, 2, 2, 2, 2, 1, 1};
//        int[] data2 = {70,50,30};
        //System.out.println(cards(data));
//    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //int[][] data = {{4,1}, {9,3}, {5,5}, {2,1}, {2,4}};
//        int t = scanner.nextInt();
//        int[][] data;
//        while (t-- > 0) {
//            int n = scanner.nextInt();
//            data = new int[n][2];
//            for (int i = 0; i < n; i++) {
//                data[i][0] = scanner.nextInt();
//            }
//            for (int i = 0; i < n; i++) {
//                data[i][1] = scanner.nextInt();
//            }
//            System.out.println(cal(data));
//        }
//
//        scanner.close();
//        System.out.println(findGoodStrings(8, "leetcode", "leetgoes", "leet"));
//        int[] data = new int[] {2,2,3,5};
//        int[][] arrays = {{30,50},{12,2},{3,4},{12,15}};
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(3);
//        set.add(10);
//        set.add(3);
//        set.add(5);
//        set.add(5);
//        set.add(3);
//        for (int string : set) {
//            System.out.println(string);
//        }
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(Arrays.asList("nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"));
        favoriteCompanies.add(Arrays.asList("nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"));
        favoriteCompanies.add(Arrays.asList("ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"));
//        favoriteCompanies.add(Arrays.asList("google"));
//        favoriteCompanies.add(Arrays.asList("amazon"));

    }










    public static int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.compareTo(s2) > 0) { return 0; }
        else if (s1.compareTo(s2) == 0) {
            return s1.contains(evil) ? 0 : 1;
        }
        else {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            backTracking(n, c1, c2, evil, new StringBuilder(), 0);
            return (int) (res % 1000000007);
        }
    }

    static private long res = 0;
    private static void backTracking(int n, char[] c1, char[] c2, String evil, StringBuilder sb, int index) {
        if (sb.length() == n) {
            String str = sb.toString();
            if (!str.contains(evil)) { res++; }
            return;
        }
        char start, end;
        if (sb.length() == 0) {
            start = c1[index];
            end = c2[index];
        }
        else {
            if (sb.charAt(0) == c1[0]) {
                start = c1[index];
                end = index == 0 ? c2[index] : 'z';
            }
            else {
                start = 'a';
                end = sb.charAt(0) == c2[0] ? c2[index] : 'z';
            }
        }

        for (char i = start; i <= end; i++) {
            sb.append(i);
            if (sb.toString().compareTo(new String(c2, 0, index+1)) > 0) { break; }

            if (!sb.toString().contains(evil)) {
                backTracking(n, c1, c2, evil, sb, index+1);
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }





    private static int cal(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] < b[0]) { return -1; }
            else if (a[0] > b[0]) { return 1; }
            else { return a[1] - b[1]; }
        });
        boolean[] visited = new boolean[arr.length];
        int res = 0;
        int len, weight;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                len = arr[i][0];
                weight = arr[i][1];
                res++;
                for (int j = 0; j < arr.length; j++) {
                    if (!visited[j] && arr[j][0] >= len && arr[j][1] >= weight) {
                        len = arr[j][0];
                        weight = arr[j][1];
                        visited[j] = true;
                    }
                }
            }
        }

        return res;
    }











    public static int ascii(int n, String[] strings) {
        Arrays.sort(strings, (a, b) -> {
            if (a.charAt(0) < b.charAt(0)) { return 1; }
            else if (a.charAt(0) > b.charAt(0)) { return -1;}
            // 首字母相同，长度大的放前面
            else {return Integer.compare(b.length(), a.length()); }
        });

        //PriorityQueue<String>
        return 0;
    }

    private static int result = Integer.MAX_VALUE;
    public static int cards(int[] cards) {
        int remainCards = 0;
        for (int card : cards) {
            remainCards += card;
        }
        backTracking(cards.length, cards, remainCards, 0);
        return result;
    }

    private static void backTracking(int n, int[] cards, int remainCards, int tmpResult) {
        if (remainCards <= 0) {
            result = Math.min(result, tmpResult);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canSixCards(cards, i)) {
                cards[i] -= 2; cards[i+1] -= 2; cards[i+2] -= 2;
                backTracking(n, cards, remainCards-6, tmpResult+1);
                cards[i] += 2; cards[i+1] += 2; cards[i+2] += 2;
            }

            if (canFiveCards(cards, i)) {
                cards[i] -= 1; cards[i+1] -= 1; cards[i+2] -= 1; cards[i+3] -= 1; cards[i+4] -= 1;
                backTracking(n, cards, remainCards-5, tmpResult+1);
                cards[i] += 1; cards[i+1] += 1; cards[i+2] += 1; cards[i+3] += 1; cards[i+4] += 1;
            }

            if (canTwoCards(cards, i)) {
                cards[i] -= 2;
                backTracking(n, cards, remainCards-2, tmpResult+1);
                cards[i] += 2;
            }

            if (cards[i] >= 1) {
                cards[i] -= 1;
                backTracking(n, cards, remainCards-1, tmpResult+1);
                cards[i] += 1;
            }
        }
    }


    private static boolean canSixCards(int[] cards, int start) {
        return start + 2 < cards.length && cards[start] >= 2
                && cards[start+1] >= 2 && cards[start+2] >= 2;
    }

    private static boolean canFiveCards(int[] cards, int start) {
        return start + 4 < cards.length && cards[start] >= 1 && cards[start+1] >= 1
                && cards[start+2] >= 1 && cards[start+3] >= 1 && cards[start+4] >= 1;
    }

    private static boolean canTwoCards(int[] cards, int start) {
        return start < cards.length && cards[start] >= 2;
    }



    public static int cal(int n, int[] arr) {
        int res = 0;
        int subSequenceLen = 0;
        int lastSequenceLen = 0;
        int last = Integer.MIN_VALUE;
        boolean delete = false;
        LinkedList<Integer> deque = new LinkedList<>();
        deque.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > deque.peek()) {
                deque.add(arr[i]);
            }
            else {

            }
        }

        return res;
    }




    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] counter = new int[n];
        for (int node : leftChild) {
            if (node >= 0) { counter[node]++; }
        }

        if (counter[0] != 0) { return false; }

        for (int node : rightChild) {
            if (node >=0 && counter[node] >= 1) { return false; }
        }

        return true;
    }

    public static String largestMultipleOfThree(int[] digits) {
        int[] counter = new int[10];
        int sum = 0;
        for (int digit : digits) {
            counter[digit]++;
            sum += digit;
        }

        if (sum == 0) { return "0"; }
        int remainder = sum % 3;
        if (remainder != 0) {
            while (remainder < counter.length) {
                if (counter[remainder] > 0) {
                    counter[remainder]--;
                    break;
                }
                else { remainder += 3; }

                if (remainder > 9) {
                    if (counter[3] > 0) { counter[3]--; }
                    else if (counter[6] > 0) { counter[6]--; }
                    else { counter[9]--; }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sum = 0;
        for (int i = counter.length - 1; i >= 0; i--) {
            sum += (counter[i] * i);
            while (counter[i]-- > 0) {
                sb.append(i);
            }
        }
        return sum % 3 == 0 ? sb.toString() : "";
    }








//        Strategy strategy = Strategy.valueOf("FAST");
//        strategy = null;
//        //strategy.run();
//        ;
//        System.out.println(Optional.ofNullable(strategy)
//                .map(Enum::toString)
//                .orElse("NULL"));
//        System.out.println(((2^2^2)^1));
//        List<String> myList = Arrays.asList("a", "b", "c", "d", "e");
//        myList.stream()
//                .filter(s -> s.startsWith("a"))
//                .map(String::toUpperCase)
//                .sorted()
//                .forEach(System.out::println);

    //int result = Stream.of(1, 2, 3).reduce(20, Integer::sum);

//        String s0 = "hechuan";
//        String s1 = new String("hechuan");
//        System.out.println(s0 == s1.intern());


//    public static List<Integer> grayCode(int n) {
//        List<Integer> result = new ArrayList<>();
//        int length = (int) Math.pow(2, n);
//        for (int i = 0; i < length; i++) {
//            if (i % 4 == 3) {
//                result.add(result.get(i-1));
//                result.set(i-1, i);
//            }
//            else result.add(i);
//        }
//
//        return result;
//    }

}