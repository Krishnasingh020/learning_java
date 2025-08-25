// leetcode question no.1493

class Solution5 {
    public int longestSubArray(int nums[]){
            int left = 0;
            int zeroCount = 0;
            int maxLength = 0;

            for(int right = 0; right <nums.length; right ++){
                if(nums[right] == 0){
                zeroCount++;
                }
                while(zeroCount > 1){
                    if(nums[left] == 0){
                        zeroCount--;
                    }
                    left++;
                    }
                    maxLength = Math.max(maxLength, right - left);

            }
            return maxLength;
    }

    public static void main (String args[]){
        int nums [] = {0,1,1,1,1,1,0,1,1,0};
        System.out.println(longestSubArray());

    }
}
