// CS108 HW1 -- String static methods

import java.util.HashSet;

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {

        int n = str.length();
        if (n == 0) {
            return 0;
        }
        int maxCount = 1;
        int currentCount = 0;
        char currentChar = str.charAt(0);
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == currentChar) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
                currentChar = str.charAt(i);
            }
        }

        return maxCount;

    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {

                if (i < str.length() - 1) {

                    int num = (ch - '0');
                    char next = str.charAt(i + 1);

                    for (int j = 0; j < num; j++) {
                        result.append(next);
                    }

                }

            } else {
                result.append(ch);
            }
        }

        return result.toString();

    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {

        HashSet<String> subA = new HashSet<>();
        HashSet<String> subB = new HashSet<>();
        for (int i = 0; i < a.length() - len + 1; i++) {
            subA.add(a.substring(i, i + len - 1));
        }
        for (int i = 0; i < b.length() - len + 1; i++) {
            subB.add(b.substring(i, i + len - 1));
        }
        for(String s: subA) {
            if(subB.contains(s)) {
                return true;
            }
        }

        return false;

    }
}
