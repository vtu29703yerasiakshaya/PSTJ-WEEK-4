class Solution {
    public boolean halvesAreAlike(String s) {
        // Create a fast lookup array for ASCII characters
        boolean[] isVowel = new boolean[128];
        for (char c : "aeiouAEIOU".toCharArray()) {
            isVowel[c] = true;
        }
        
        int mid = s.length() / 2;
        int balance = 0;
        
        // Single loop to process both halves simultaneously
        for (int i = 0; i < mid; i++) {
            // First half increments the balance
            if (isVowel[s.charAt(i)]) {
                balance++;
            }
            // Second half decrements the balance
            if (isVowel[s.charAt(i + mid)]) {
                balance--;
            }
        }
        
        // Alike strings will cancel out to exactly 0
        return balance == 0;
    }
}
