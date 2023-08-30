//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends


class solve
{
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
       ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> al = new ArrayList<Integer>();
       solve(ans , al , arr , 0);
       
       HashSet set = new HashSet(ans);
       ans.clear();
       ans.addAll(set);
       
       Collections.sort(ans , (a,b) -> {
           
           int min = Math.min(a.size() , b.size());
           
           for(int i = 0 ; i < min ; i++)
           {
               int cmp = a.get(i).compareTo(b.get(i));
               if(cmp != 0)
               return cmp;
           }
           
           return Integer.compare(a.size() , b.size());
       });
       
       ans.add(0 , new ArrayList<Integer>());
       return ans;
       
       
    }
    
    
    public static void solve(ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> al , int[] a , int i)
    {
        if(i == a.length)
        {
            if(al.size() > 0)
            ans.add(new ArrayList<>(al));
            
            
            return;
        }
        
        al.add(a[i]);
        solve(ans , al , a , i+1);
        al.remove(al.size()-1);
        
        solve(ans , al , a , i+1);
    }
     
    
}
