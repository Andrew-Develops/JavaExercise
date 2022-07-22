package CCIQuestions;

public class StringRotation {

    /**
     * Assume you have a method isSubstring which checks if one word is a substring
     * of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
     * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
     */

    //ideea este ca daca aduni s1+s1 obtii orice combinatie posibila poate avea s2 si apoi folosesti metoda indexOf si
    // atata timp cat metoda nu este -1 esti ok
    public static boolean stringRotation(String s1, String s2) {
        return (s1.length() == s2.length()) && (s1 + s1).indexOf(s2) > 0;
        //return (s1.length() == s2.length()) && (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {

        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(stringRotation(s1, s2));

    }
}
