class Leetcode165 {
    public int compareVersion(String version1, String version2) {
        String[] rev1 = version1.split("\\.");
        String [] rev2 = version2.split("\\.");
        int maxLength = Math.max(rev1.length, rev2.length);

        for(int i = 0; i < maxLength; i++){
            int num1 = i < rev1.length ? Integer.parseInt(rev1[i]) : 0;
            int num2 = i < rev2.length ? Integer.parseInt(rev2[i]) : 0;
            
            if(num1 < num2 ){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
        }
        return 0;
    }
}