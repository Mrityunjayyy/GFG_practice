//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{     
	int  select(int arr[], int i)
	{
	    int min_idx = i ;
	    
       for(int a = i ; i < arr.length ; i++)
       {
              min_idx = a;
           
           for(int b = a + 1 ; b < arr.length ; b++)
           { 
                 if(arr[b] < arr[min_idx])
                 { 
                     min_idx = b;
                 }
           } 
           if(min_idx != a)
           return arr[min_idx];
       }
       
       return min_idx;
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i = 0 ; i < n ;i++)
	    {
	        int minimumIndex = i ;
	        for(int j = i+1 ; j < n ; j++)
	        { 
	            if(arr[j] < arr[minimumIndex])
	            minimumIndex = j;
	        }
	        
	        if(minimumIndex != i)
	        { 
	            int temp = arr[i];
	            arr[i] = arr[minimumIndex];
	            arr[minimumIndex] = temp;
	        }
	    } 
	}
}