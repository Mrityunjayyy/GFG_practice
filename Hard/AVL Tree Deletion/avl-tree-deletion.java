//{ Driver Code Starts
import java.io.*;
import java.util.*;

class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
public class GfG
{
    
    public static int setHeights(Node n)
    {
    	if(n==null) return 0;
    	n.height = 1 + Math.max( setHeights(n.left) , setHeights(n.right) );
    	return n.height;
    }
    
    static Node buildTree(String str)
    {
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        setHeights(root);
        return root;
    }
    
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[]) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine());
            
            while(t-->0)
                {
                    String s = br.readLine();
    	    	    Node root = buildTree(s);
    	    	    
                    
                    int n = Integer.parseInt(br.readLine());
                    int ip[] = new int[n];
                    
                    String[] in = br.readLine().trim().split("\\s+");
                    
                    for(int i = 0; i < n; i++)
                        ip[i] = Integer.parseInt(in[i]);
                    
                    Sol obj = new Sol();
                    
                    for(int i=0; i<n; i++)
            		{
            			root = obj.deleteNode(root, ip[i]);
            			
            			if(isBalancedBST(root)==false)
            				break;
            		}
        
            		if(root==null)
            			System.out.print("null");
            		else
            			printInorder(root);
            		System.out.println();    
                    
                    
                 
                    
                }
            
                
        }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
	int data, height;
	Node left, right;
	Node(int x)
	{
		data = x;
		height = 1;
		left = right = NULL;
	}
}
*/
class Sol
{
   
    // Function to calculate the height of a node
    static int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Function to update the height of a node
    static void updateHeight(Node node) {
        if (node != null)
            node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    // Function to perform left rotation
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Function to perform right rotation
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Function to balance the node if balance factor is violated
    static Node balance(Node node) {
        // Calculate balance factor
        int balanceFactor = height(node.left) - height(node.right);

        // Left heavy
        if (balanceFactor > 1) {
            // Left-Left case
            if (height(node.left.left) >= height(node.left.right))
                return rightRotate(node);

            // Left-Right case
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right heavy
        if (balanceFactor < -1) {
            // Right-Right case
            if (height(node.right.right) >= height(node.right.left))
                return leftRotate(node);

            // Right-Left case
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Node is balanced
        return node;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        // Perform standard BST delete
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp; // One child case

                temp = null;
            } else {
                // Node with two children, get the in-order successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the in-order successor's data to this node
                root.data = temp.data;

                // Delete the in-order successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null)
            return root;

        // Update height and balance the node
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return balance(root);
    }

    // Function to find the node with minimum value in a given node's subtree
    static Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }
}