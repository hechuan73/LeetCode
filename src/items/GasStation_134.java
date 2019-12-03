package items;

/**
 * @author hechuan
 */
public class GasStation_134 {

    /**
     *
     * 1. If car starts at A and can not reach B. Any station between A and B can not reach B.(B is the first station
     *    that A can not reach.)
     * 2. If the total number of gas is bigger than the total number of cost. There must be a solution.
     * 3. Every time a fail happens, accumulate the amount of gas that is needed to overcome the fail. After looping
     *    through the stations, if the gas left is more than gas needed, then we have a solution, otherwise not.
     *
     * @param gas gas array
     * @param cost cost array
     * @return index of station if can complete the circuit, if not re turn -1.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, origination = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += (gas[i]-cost[i]);
            if (tank < 0) {
                // origination moving backwards with 1.
                origination = i + 1;
                // calculate all the sum of gas supply and cost.
                totalGas += tank;
                // reset the tank
                tank = 0;
            }
        }

        return totalGas + tank > 0 ? origination : -1;
    }
}
