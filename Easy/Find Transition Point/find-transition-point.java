//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GfG obj = new GfG();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int transitionPoint(int arr[], int n) {
        //last occurenece of 0;
        // or first occurence of 1;
        
        int low = 0 ;
        int high = n-1;
        int res = -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
        
            if(arr[mid] == 1)
            {
                res = mid;
                high = mid -1;
            }
            
            else if(arr[mid] == 0)
            low = mid +1;
            
            else 
            high = mid -1;
            
        }
        
        return res;
    }
}