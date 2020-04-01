package items;

/**
 * @author hechuan
 */
public class CountNumberOfTeams_1395 {

    /**
     * Simple solution with triple traversal.
     *
     * Time Complexity: O(n3)
     * Space Complexity: O(1)
     *
     * @param rating input array
     * @return the number of target teams
     */
    public int numTeams1(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length-2; i++) {
            for (int j = i+1; j < rating.length-1; j++) {
                for (int k = j+1; k < rating.length; k++) {
                    if (rating[i] > rating[j] && rating[j] > rating[k]) { res++; }
                    if (rating[i] < rating[j] && rating[j] < rating[k]) { res++; }
                }
            }
        }

        return res;
    }

    /**
     * Optimised solution with double traversal.
     *
     * For each element, count how many elements on the left and right have less and greater ratings.
     * This element can form less[left] * greater[right] + greater[left] * less[right] teams.
     *
     * We need to count triplets {arr[i] < arr[j] < arr[k]} and {arr[i] > arr[j] > arr[k]} where i<j<k.
     * So, let's find for every j count of all i and k, so that it will follow either of above 2 conditions and
     * summarize the counts:
     *
     * For example: [13, 3, 4, 10, 7, 8]
     *
     * elements 13:
     * for {arr[i] < arr[j] < arr[k]} triplets, Nothing smaller from left side.
     * for {arr[i] > arr[j] > arr[k]} triplets, Nothing larger from left side.
     *
     * elements 3:
     * for {arr[i] < arr[j] < arr[k]} triplets, Nothing smaller from left side.
     * for {arr[i] > arr[j] > arr[k]} triplets, Nothing smaller from right side.
     *
     * elements 4:
     * for {arr[i] < arr[j] < arr[k]} triplets, 1 number is smaller and 3 are larger, total = 1*3 = 3 triplets =>
     *                                                                                {3, 4, 10}, {3, 4, 7}, {3, 4, 8}
     * for {arr[i] > arr[j] > arr[k]} triplets, Nothing smaller from right side.
     *
     * elements 10:
     * for {arr[i] < arr[j] < arr[k]} triplets,Nothing larger from right side.
     * for {arr[i] > arr[j] > arr[k]} triplets, 1 number is bigger and 2 numbers are smaller, total = 1*2 = 2 triplets
     *                                                                             => {13, 10, 7}, {13, 10, 8}
     *
     * elements 7:
     * for {arr[i] < arr[j] < arr[k]} triplets, 2 numbers are smaller and 1 is larger, total = 2*1 = 2
     *                                                                             => {3, 7, 8}, {4, 7, 8}
     * for {arr[i] > arr[j] > arr[k]} triplets, Nothing smaller from right side.
     *
     * elements 8:
     * for {arr[i] < arr[j] < arr[k]} triplets, Nothing larger from right side.
     * for {arr[i] > arr[j] > arr[k]} triplets, Nothing smaller from right side.
     *
     * Total = 3 + 2 + 2 = 7 triplets.
     *
     * Time Complexity: O(n3)
     * Space Complexity: O(1)
     *
     * @param rating input array
     * @return the number of target teams
     */
    public int numTeams2(int[] rating) {
        int res = 0;
        int leftSmaller, rightLarger;
        int leftLarger, rightSmaller;
        for (int i = 1; i < rating.length-1; i++) {
            leftSmaller = 0;;rightLarger = 0; leftLarger = 0; rightSmaller = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] > rating[i]) {
                    leftLarger++;
                }
                else {
                    leftSmaller++;
                }
            }

            for (int j = i+1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    rightLarger++;
                }
                else {
                    rightSmaller++;
                }
            }

            res += leftSmaller*rightLarger + leftLarger*rightSmaller;
        }
        return res;
    }
    
}
