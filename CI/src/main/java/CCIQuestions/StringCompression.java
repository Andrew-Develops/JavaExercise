package CCIQuestions;

public class StringCompression {

    /**
     * Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string "aabcccccaaa" would become a2b1c5a3. If the
     * "compressed" string would not become smaller than the original string, your method should return
     * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     */

    public static String stringCompression(String s) {
        //am folosit 2 pointer method
        int leftPointer = 0;
        int rightPointer = 1;
        int count = 1;
        StringBuilder compress = new StringBuilder();
        while (leftPointer < s.length() && rightPointer < s.length()) {
            //cand primul pointer este egal cu al doilea pointer incrementam count++ si rightPointer++
            if (s.charAt(leftPointer) == s.charAt(rightPointer)) {
                count++;
                rightPointer++;
                //daca leftPointer != rightPointer atunci trecem ultimul caracter + count si leftPointer = rightPointer
            } else if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                //trecem rezultatul intr-un string si il updatam de fiecare data cand leftPointer != rightPointer
                compress.append(s.charAt(leftPointer)).append(count);
                count = 1;
                leftPointer = rightPointer;
                rightPointer++;
            }
        }
        //deoarece leftPointer = rightPointer nu mai trecem prin else if si trebuie sa adaugam manual ultima bucata
        compress.append(s.charAt(leftPointer)).append(count);
        return compress.toString();
    }


    public static void main(String[] args) {

        String text = "aabcccccaaa";
        String text2 = "aaaaaaa";
        System.out.println(stringCompression(text));
        System.out.println(stringCompression(text2));

    }
}
