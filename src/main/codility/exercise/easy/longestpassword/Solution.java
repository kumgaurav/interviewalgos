package exercise.easy.longestpassword;

/**
 * Given a string containing words, find the longest word that satisfies specific conditions.
 */
public class Solution {
    public int longestPassword(String s) {
        String[] words = s.split(" ");
        int maxLength = -1;

        for (String word : words) {
            if (isValid(word)) {
                 maxLength = Math.max(maxLength, word.length());
            }
        }

        return maxLength;
    }

    public boolean isValid(String word) {
        boolean isValid = false;
        long digitCount = word.chars().filter(Character::isDigit).count();
        long letterCount = word.chars().filter(Character::isLetter).count();
        isValid = (word.matches("^[a-zA-Z0-9]+$")) && (letterCount % 2 == 0) && ( digitCount % 2 != 0);
        return  isValid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPassword("test 5 a0A pass007 ?xy1"));
    }
}
