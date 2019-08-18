package items;

public class SortArrayByParityII_922 {

    public int[] sortArrayByParityII(int[] A) {
        int evenIndex = 0, oddIndex = A.length % 2 == 0 ? A.length-1 : A.length-2;

        while (evenIndex < A.length && oddIndex > 0) {
            if (A[evenIndex]%2 != 0) {
                while (oddIndex > 0 ) {
                    if (A[oddIndex]%2 == 0){
                        int tmp = A[oddIndex];
                        A[oddIndex] = A[evenIndex];
                        A[evenIndex] = tmp;
                        break;
                    }
                    oddIndex -= 2;
                }
            }
            evenIndex += 2;
        }

        return A;
    }
}
