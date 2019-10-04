package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hechuan
 */
public class FindDuplicateFileInSystem_609 {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToPath = new HashMap<>(paths.length);

        for (String path : paths) {
            // can use loop to manual analyze the elements instead of using API to be faster.
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                // use substring to be faster
                int index = files[i].indexOf("(");
                String fileName = files[i].substring(0, index);
                String content = files[i].substring(index+1, files[i].length()-1);
                contentToPath.computeIfAbsent(content, k -> new ArrayList<>());
                contentToPath.get(content).add(files[0]+"/"+fileName);
            }
        }

        List<List<String>> res = new ArrayList<>();
        contentToPath.forEach((k, v) -> {
            if (v.size() > 1) {
                res.add(v);
            }
        });

        return res;
    }
}
