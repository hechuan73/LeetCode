package items;

public class DistributeCandies_575 {

    public int distributeCandies(int[] candies) {
        // use boolean array is faster than int array.
        boolean[] counter = new boolean[200001];
        int types = 0;
        for (int candy : candies) {
            if (!counter[candy + 100000]) {
                types++;
                counter[candy+100000] = true;
            }
            // use bit operation to be faster.
            if (types == (candies.length>>1)) {return types;}
        }

        return types;
    }
}
