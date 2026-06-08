class Solution {
    public int[] plusOne(int[] digits) {
        // Start from the rightmost digit (least significant)
        for (int i = digits.length - 1; i >= 0; i--) {
            // If the digit is less than 9, just add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0 due to the carry
            digits[i] = 0;
        }
        
        // Edge case: If all digits were 9 (e.g., 999 -> 000)
        // We need an extra digit at the front (e.g., 1000)
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1; // The rest of the elements default to 0 in Java
        
        return newDigits;
    }
}