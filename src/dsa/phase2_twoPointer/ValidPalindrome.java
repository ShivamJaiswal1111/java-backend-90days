package dsa.phase2_twoPointer;

// LC-125 Valid Palindrome
// Pattern: Two Pointers from both ends
// Brute Force: clean string + reverse + compare — O(n) SC: O(n)
// Optimal: two pointers, skip non-alphanumeric in place — O(n) SC: O(1)

public class ValidPalindrome {

    public Boolean isPalindromeBrute(String s){
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public Boolean isPalindromeOptimised(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    public static void main (String args[]){
        ValidPalindrome valid= new ValidPalindrome();
        Boolean result= valid.isPalindromeBrute(new String("A man, a plan, a canal: Panama"));
        System.out.println(result);

        Boolean result1= valid.isPalindromeOptimised(new String("A man, a plan, a canal: Panama"));
        System.out.println(result1);
    }
}
