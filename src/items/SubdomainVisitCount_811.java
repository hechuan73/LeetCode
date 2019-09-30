package items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount_811 {

    /**
     * Using String.subString() is faster than String.split().
     *
     * @param cpdomains input string array.
     * @return count result list.
     */
    public List<String> subdomainVisits1(String[] cpdomains) {
        Map<String, Integer> domainCounter = new HashMap<>(3*cpdomains.length);
        List<String> res = new ArrayList<>();

        for (String cpdomain : cpdomains) {
            int index = cpdomain.indexOf(" ");
            int count = Integer.parseInt(cpdomain.substring(0, index));
            String domain = cpdomain.substring(index+1);
            domainCounter.put(domain, domainCounter.getOrDefault(domain, 0) + count);

            while ((index = domain.indexOf(".")) != -1) {
                domain = domain.substring(index+1);
                domainCounter.put(domain, domainCounter.getOrDefault(domain, 0) + count);
            }
        }

        domainCounter.forEach((key, value) -> res.add(value + " " + key));
        return res;
    }

    public List<String> subdomainVisits2(String[] cpdomains) {
        Map<String, Integer> domainCounter = new HashMap<>(3*cpdomains.length);
        List<String> res = new ArrayList<>();

        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];
            domainCounter.put(domain, domainCounter.getOrDefault(domain, 0) + count);
            while (domain.contains(".")) {
                String[] domains = domain.split("\\.", 2);
                domainCounter.put(domains[1], domainCounter.getOrDefault(domains[1], 0) + count);
                domain = domains[1];
            }
        }

        domainCounter.forEach((key, value) -> res.add(value + " " + key));
        return res;
    }
}
