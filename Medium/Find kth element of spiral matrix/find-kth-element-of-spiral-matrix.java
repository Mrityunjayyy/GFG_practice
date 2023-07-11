//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	 
	 if(k > m*n)
	 return -1;
	 
	 int top = 0 ; 
	 int left = 0; 
	 int right = m -1;
	 int bottom = n -1;

	 
	 while(left <= right && top <= bottom)
	 { 
	     //moving left to right
	     for(int i = left ; i <= right ; i++)
	     {
	        // ans = A[top][i];
	         k = k -1;
	         
	         if(k == 0)
	         { 
	             return A[top][i];
	         }
	     }
	     
	     top++;
	     
	     
	     //moving top to bottom
	     for(int i = top ; i <= bottom ; i++)
	     { 
	        // ans = A[i][right];
	         k = k -1;
	         
	         if(k == 0)
	         { 
	             return A[i][right];
	         }
	     }
	     
	     right--;
	     
	     //moving right to left
	     if(top <= bottom)
	     { 
	         for(int i= right ; i >= left ; i--)
	         { 
	           //  ans = A[bottom][i];
	             k = k -1;
	             
	             
	         if(k == 0)
	         { 
	             return  A[bottom][i];
	         }
	         
	         }
	         
	         bottom--;
	     }
	     
	     
	     //moving bottom to top
	     if(left <= right)
	     { 
	         for(int i = bottom ; i >= top ; i--)
	         { 
	            // ans = A[i][left];
	             k = k -1;
	             
	              
	              if(k == 0)
	         { 
	             return  A[i][left];
	         }
	         
	         
	         }
	         
	         left = left + 1;
	     }
	         
	 }
	 
	 
	 return -1;
    }
}