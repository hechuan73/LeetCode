package items;

/**
 * Approach:
 * If x+1 rabbits have same color, then we get x+1 rabbits who all answer x.
 *
 * Now n rabbits answer x. (X+1 means another x rabbits and itself.)
 * 1. If n % (x + 1) == 0, we need n / (x + 1) groups of x + 1 rabbits.
 * 2. If n % (x + 1) != 0, we need n / (x + 1) + 1 groups of x + 1 rabbits.
 *
 * Tip: the number of groups is math.ceil(n / (x + 1)) and it equals to (n + x) / (x + 1) , which is more elegant.
 *
 */
public class RabbitsInForest_781 {

    public int numRabbits(int[] answers) {
        int[] counter = new int[answers.length];

        for (int answer : answers) { counter[answer]++; }

        int res = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                res += (counter[i] % (i + 1) == 0 ?
                        counter[i]/(i+1)*(i+1) : (counter[i]/(i+1)+1)*(i+1));
            }
        }

        return res;
    }
}
