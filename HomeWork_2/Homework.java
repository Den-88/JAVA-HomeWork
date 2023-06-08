/**
 * 1. Реализовать метод isPalindrome
 * 2. Пересмотреть мой спич про работу с файловой системой. Подготовить вопросы.
 */

/**
 * Проверить, является ли строка палиндромом.
 * Палиндром - это строка, которая читается одинаково слева и справа
 * abcdedcba -> true
 * a -> true
 * abc -> false
 * abcd -> false
 * abba -> true
 */

public class Homework {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("abc")); 
        System.out.println(isPalindrome("abcd")); 
        System.out.println(isPalindrome("abba")); 
        System.out.println();
        System.out.println(isPalindromeTwo("a"));
        System.out.println(isPalindromeTwo("abc")); 
        System.out.println(isPalindromeTwo("abcd")); 
        System.out.println(isPalindromeTwo("abba")); 
    }

    static boolean isPalindrome(String source) {
        for (int i = 0; i < source.length() / 2; i++) {
            if (source.charAt(i) != source.charAt(source.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindromeTwo(String source) {
        String sourceRev = new StringBuilder(source).reverse().toString();
        if (source.equals(sourceRev)) {
            return true;
        } 
        return false;
    }
}
