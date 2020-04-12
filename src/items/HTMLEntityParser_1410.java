package items;

/**
 * @author hechuan
 */
public class HTMLEntityParser_1410 {

    /**
     * Tricky solution with API.
     *
     * Optimised solution with AcAutoMachine.
     *
     * @param text input text
     * @return the parsed text
     */
    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&amp;", "&")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/");
    }
}
