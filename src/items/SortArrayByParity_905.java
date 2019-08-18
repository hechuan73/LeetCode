package items;

public class SortArrayByParity_905 {

    public int[] sortArrayByParity(int[] A) {

        int left = 0, right = A.length-1;

        while (left < right) {
            if (A[left]%2 != 0) {
                while (right > left) {
                    if (A[right]%2 == 0){
                        int tmp = A[right];
                        A[right] = A[left];
                        A[left] = tmp;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }

        return A;
    }
}
