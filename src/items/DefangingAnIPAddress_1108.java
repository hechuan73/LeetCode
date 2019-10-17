package items;

/**
 * @author hechuan
 */
public class DefangingAnIPAddress_1108 {

    public String defangIPaddr(String address) {
        // the regulation expression is too slow.
        // return address.replaceAll("\\.", "[.]");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') { builder.append("[.]"); }
            else { builder.append(address.charAt(i)); }
        }

        return builder.toString();
    }
}
