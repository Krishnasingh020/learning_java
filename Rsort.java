// rotation sorting array
public class Rsort {
    public static int search(int arr[], int tar, int si, int ei){
        if(si > ei){
            return -1;
        }


        int mid = si + (ei - si)/2;

        if(arr[mid] == tar){
            return mid;
        }

        if(arr[si] <= arr[mid]){
            //case a: left part
            if(arr[si] <= tar && tar <= arr[mid]){
                return search(arr, tar, si, mid);
            }
            else{
            //case b: right part
                return search(arr, tar, mid +1, ei);
            }
        }
        else{
            // case c left part
            if(arr[mid]<=tar && tar <= arr[ei]){
                return search(arr, tar, mid +1, ei);
            }else{
            //case d right part
                return search(arr, tar, si, mid -1);
            }
        }

    }
    
    public static void main(String args[]){
        int arr[] = {9,7,6,2,8,4,3,1,5};
        int target = 0;
        int tarIdx = search(arr, target, 0, arr.length -1);
        System.out.println(tarIdx);

    }
}