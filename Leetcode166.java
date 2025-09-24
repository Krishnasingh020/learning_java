import java.util.HashMap;
import java.util.Map;

public class Leetcode166 {
    public String fractionToDecimal(int numerator, int denominator) {
        // Handle division by zero (though constraints say denominator != 0)
        if (denominator == 0) return "";
        
        // Handle the case when numerator is 0
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        // Determine the sign (positive or negative)
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Convert to long to avoid integer overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integer part
        result.append(num / den);
        long remainder = num % den;
        
        // If no fractional part, return the result
        if (remainder == 0) {
            return result.toString();
        }
        
        // Fractional part
        result.append(".");
        
        // HashMap to store remainder and its position
        Map<Long, Integer> remainderMap = new HashMap<>();
        
        while (remainder != 0) {
            // If we've seen this remainder before, we have a repeating decimal
            if (remainderMap.containsKey(remainder)) {
                int position = remainderMap.get(remainder);
                result.insert(position, "(");
                result.append(")");
                break;
            }
            
            // Store the current remainder and its position
            remainderMap.put(remainder, result.length());
            
            // Perform division
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        
        return result.toString();
    }
}