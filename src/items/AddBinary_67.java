package items;

public class AddBinary_67 {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0'; // a.charAt(i--) return the value of ASCII, so need to subtract the
            if (j >= 0) sum += b.charAt(j--) - '0'; // character 'a'.
            result.append(sum % 2);
            carry = sum / 2;
        }

        return carry == 0 ? result.reverse().toString() : result.append(carry).reverse().toString();
    }
}
