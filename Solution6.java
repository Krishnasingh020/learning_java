// program to find the length of the string using recursion

class Solution5 {
    public static int length(String str){
        if (str.length() == 0){
            return 0;
        }else{
            return length(str.substring(1) + 1);
        }

    }
    public static void main (String args []){
        String str = "krishna";
        System.out.println(length(str));
    }
}
