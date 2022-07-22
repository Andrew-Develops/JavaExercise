package Codesignal;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    //O(N^2)
    public static char firstNonRepeatingCharacter(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean repeatingChar = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && i != j) {
                    repeatingChar = true;
                    break;
                }
            }
            if (!repeatingChar) {
                return s.charAt(i);
            }
        }
        //daca nu am gasit nici un caracter care nu se repeta returnam  un spatiu gol
        return ' ';
    }

    //O(N+N) -> O(N)
    public static char firstNonRepeatingCharacterWithMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }


    public static void main(String[] args) {

        String text = "aaaabbcddeedcx";
        System.out.println(firstNonRepeatingCharacter(text));
        System.out.println(firstNonRepeatingCharacterWithMap(text));


    }
}
