public class Toh {
    public static void TowerOfHanoi(int n, String src, String dest, String helper){
        if (n == 1){
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        TowerOfHanoi(n-1, src, dest, helper);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        TowerOfHanoi(n-1, helper, dest, dest);
    }
    public static void main(String[] args){
        int n = 4;
        TowerOfHanoi(n, "A" ,"B", "C");
    }
}
