package ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutation {

    /**
     *  Given two strings, write a method to decide if one is a permutation of the
     * other
     */

    //O(N log N)
    public static boolean checkPermutation(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        Arrays.sort(aChar);
        Arrays.sort(bChar);

        String aString = String.valueOf(aChar);
        String bString = String.valueOf(bChar);

        return aString.equals(bString);
    }

    //O(A+B)
    public static boolean checkPermutationAnotherWay(String a, String b) {
        int[] aArray = new int[265];
        int[] bArray = new int[265];

        for (int i = 0; i < a.length(); i++) {
            aArray[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            bArray[b.charAt(i)]++;
        }
        if (Arrays.equals(aArray,bArray)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String textA = "abcde";
        String textB = "eabcd";

        System.out.println(checkPermutation(textA, textB));
        System.out.println(checkPermutationAnotherWay(textA, textB));

    }
}
