package CCIQuestions;

public class PalindromePermutation {

    /**
     * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     * Palindrome este un cuvant care se citeste la fel de la dreapta la stanga sau de la stanga la dreapta
     * Permutation este rearanjarea caracterelor intr-un string
     */

    //O(N+M)
    public static boolean palindromePermutation(String text) {
        int[] check = new int[128];
        for (int i = 0; i < text.length(); i++) {
            //introducem caracterele in check dupa ASCI table. Fiecarui index ii va corespunde un caracter din ASCI
            check[text.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < check.length; i++) {
            //daca este palindrom ar trebui sa avem o gramada de valori 2 in array ceea ce inseamna ca check[i] % 2 = 2 % 2 = 0
            //adaugam +1 numai cand in array se afla un singur caracter nu 2
            count += check[i] % 2;
        }
        return count <= 1;
    }

    //O(1)
    public static boolean checkPalindrome(String text) {
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.reverse();
        return String.valueOf(sb).equals(text);
    }

    public static void main(String[] args) {

        String text = "racecar";
        System.out.println(palindromePermutation(text));
        System.out.println(checkPalindrome(text));

    }
}
