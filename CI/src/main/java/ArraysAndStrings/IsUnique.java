package ArraysAndStrings;

import java.util.HashSet;

public class IsUnique {

    /**
     * Implement an algorithm to determine if a string has all unique characters
     */

    //O(N)
    public static boolean allUniqueSet(String text) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            hashSet.add(text.charAt(i));
        }
        return hashSet.size() == text.length();
    }

    //O(N^2)
    public static boolean allUniqueNestedLoop(String text) {
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String text = "abcdeff";
        System.out.println(allUniqueSet(text));
        System.out.println(allUniqueNestedLoop(text));
    }
}
