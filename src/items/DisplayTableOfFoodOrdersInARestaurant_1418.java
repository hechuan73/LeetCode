package items;

import java.util.*;

/**
 * @author hechuan
 */
public class DisplayTableOfFoodOrdersInARestaurant_1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        if (orders.size() == 0) { return Collections.EMPTY_LIST; }

        Map<String, HashMap<String, Integer>> foodToTables = new HashMap<>();
        TreeSet<String> foods = new TreeSet<>();
        TreeSet<Integer> tableIds = new TreeSet<>();
        HashMap<String, Integer> tmp;
        for (List<String> order : orders) {
            foods.add(order.get(2));
            tableIds.add(Integer.parseInt(order.get(1)));
            foodToTables.putIfAbsent(order.get(2), new HashMap<>());
            tmp = foodToTables.get(order.get(2));
            tmp.put(order.get(1), tmp.getOrDefault(order.get(1), 0)+1);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        headers.add("Table");
        headers.addAll(foods);
        res.add(headers);

        int num = tableIds.size();
        List<String> table;
        Iterator<Integer> tables = tableIds.iterator();
        for (int i = 1; i <= num; i++) {
            table = new ArrayList<>();
            table.add(String.valueOf(tables.next()));
            res.add(table);
        }

        Iterator<String> iterator = foods.iterator();
        String food;
        while (iterator.hasNext()) {
            food = iterator.next();
            tmp = foodToTables.get(food);
            for (int i = 1; i < res.size(); i++) {
                table = res.get(i);
                table.add(tmp.getOrDefault(table.get(0), 0).toString());
            }
        }

        return res;
    }
}
