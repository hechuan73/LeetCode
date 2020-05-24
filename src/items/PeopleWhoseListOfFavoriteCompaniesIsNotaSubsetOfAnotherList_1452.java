package items;

import java.util.*;

/**
 * @author hechuan
 */
public class PeopleWhoseListOfFavoriteCompaniesIsNotaSubsetOfAnotherList_1452 {

    /**
     * Solution with union-find.
     *
     * @param favoriteCompanies input favorite companies of people
     * @return the indexes of people
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int len = favoriteCompanies.size();
        int[] unionFind = new int[len];
        for (int i = 0; i < len; i++) { unionFind[i] = i; }

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int a = find(unionFind, i);
                int b = find(unionFind, j);
                if (a != b) {
                    if (contains(favoriteCompanies.get(a), favoriteCompanies.get(b))) { unionFind[b] = unionFind[a]; }
                    if (contains(favoriteCompanies.get(b), favoriteCompanies.get(a))) { unionFind[a] = unionFind[b]; }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i : unionFind) { set.add(find(unionFind, i)); }
        List<Integer> res = new ArrayList<>(set);
        res.sort(Comparator.naturalOrder());
        return res;
    }

    private int find(int[] union, int i) {
        int origin = i;
        while (union[i] != i) {
            i = union[i];
        }

        return union[origin] = i;
    }

    private boolean contains(List<String> a, List<String> b) {
        if (a.size() <= b.size()) { return false; }
        return a.containsAll(b);
    }
}
