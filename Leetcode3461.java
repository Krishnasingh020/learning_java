class Leetcode3461 {
    public boolean hasSameDigits(String s) {
        // Convert string to integer array
        char[] chars = s.toCharArray();
        int[] digits = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digits[i] = chars[i] - '0';
        }
        
        // Repeatedly perform operations until only 2 digits remain
        while (digits.length > 2) {
            // Create new array for next iteration (length reduced by 1)
            int[] newDigits = new int[digits.length - 1];
            
            // Calculate new digits for each consecutive pair
            for (int i = 0; i < digits.length - 1; i++) {
                newDigits[i] = (digits[i] + digits[i + 1]) % 10;
            }
            
            // Replace current digits with new digits
            digits = newDigits;
        }
        
        // Check if the final two digits are the same
        return digits[0] == digits[1];
    }
}