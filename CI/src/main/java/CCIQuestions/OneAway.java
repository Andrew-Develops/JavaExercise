package CCIQuestions;

public class OneAway {

    /**
     * One Away: There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, write a function to check if they are
     * one edit (or zero edits) away.
     */

    public static boolean isOneAway(String s1, String s2) {
        //mai intai verificam daca s1 este maxim cu 1 mai mare sau mai mic decat s2
        if (s1.length() < s2.length() - 1 || s1.length() > s2.length() + 1) {
            return false;
        }
        int index = 0;
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            //numaram de fiecare data cand gasim diferente intre caractere
            if (s1.charAt(index) != s2.charAt(i)) {
                count++;
                //daca s1.length este mai mare decat s2.length atunci decrementam pentru a nu mutam indexul
                if (s1.length() != s2.length()) {
                    i--;
                }
            }
            index++;
        }
        System.out.println(count);
        return count <= 1;
    }

    public static void main(String[] args) {
        String text1 = "pale";
        String text2 = "bake";
        System.out.println(isOneAway(text1, text2));

    }

}
