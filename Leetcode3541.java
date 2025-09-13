class Leetcode3541 {
    public int maxFreqSum(String s) {
        int freq [] = new int[26];
        //count the frewuency of all letters
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        //find ht emax vowel frequency 
        int maxVowel = 0;
        int vowelIndices [] = {0,4,8,14,20};

        for(int idx : vowelIndices){
            if(freq[idx] > maxVowel){
                maxVowel = freq[idx];
            }
        }

        //find max consonant frequency 

        int maxConsonant = 0;
        for(int i = 0; i<26; i++){
            boolean isVowel = false;
            for(int vowelIdx : vowelIndices){
                if(i == vowelIdx){
                    isVowel = true;
                    break;
                }
            }
            if(!isVowel && freq[i] > maxConsonant){
            maxConsonant = freq[i];
            }
        }
        return maxVowel + maxConsonant;
    }
}