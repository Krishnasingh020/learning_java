import java.util.*;
class Leetcode2785 {
    public String sortVowels(String s) {
        List<Integer> vowelPositions = new ArrayList<>();
        List<Character> vowelChars = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)) {
                vowelPositions.add(i);
                vowelChars.add(c);
            }
        }       

        Collections.sort(vowelChars);

        char []result =s.toCharArray();
        int vowelIndex = 0;

        for(int pos: vowelPositions){
            result[pos]= vowelChars.get(vowelIndex);
            vowelIndex++;
        }   
        return new String(result);
    }
    private boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}