import java.util.*;
public class CircleOfApples {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        

        while(t-- > 0){
            int n = sc.nextInt();
            Set<Integer> uniqueBeauties = new HashSet<>();

            for(int i = 0; i<n; i++){
                uniqueBeauties.add(sc.nextInt());
            }
            System.out.println(uniqueBeauties.size());
        }
    }
}
