//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    { 
         if(low < high)
        {
            //here m is the pivot element
              int m = partition(arr , low , high);
              
              quickSort(arr , low ,  m -1 );
              quickSort(arr , m +1 , high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        //pivot as the first element in the array
       int pivot = arr[low];
       int i = low;
       
       //j  --- to take care of the element greater than pivot.
       //i --- to take care of the element greater than pivot.
       for(int j = low  +1 ; j <= high ; j++)
       { 
           if(arr[j] <= pivot)
           {  
               //increment i then we will swap
               i = i + 1;
               //swap value of arr[i] and arr[j]
               
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
       }
       
       
    //swap arr[low] and arr[i] to get the correct index of the pivot element
     
       int temp = arr[low];
       arr[low] = arr[i];
       arr[i] = temp;
       
       
       return i;
    } 
}
