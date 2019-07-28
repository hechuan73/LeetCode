package Items;

public class SumOfEvenNumbersAfterQueries_985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];

        int sum = 0;
        for (int x : A) {
            if (x % 2 == 0) sum += x;
        }

        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0], index = queries[i][1];
            if (A[index] % 2 == 0) sum -= A[index]; // remove the old even value, and add the new value is even later.
            A[index] += value;

            if (A[index] % 2 == 0) sum += A[index];
            ans[i] = sum;
        }

        return ans;
    }

    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            A[queries[i][1]] += A[queries[i][0]];

            int sum = 0;
            for (int x : A) {
                if (x % 2 == 0) sum += x;
                ans[i] = sum;
            }
        }

        return ans;
    }
}
