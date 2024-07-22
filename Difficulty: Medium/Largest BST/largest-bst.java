//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


class Solution {
    // Helper class to store information of subtree
    static class BSTInfo {
        boolean isBST;
        int size;
        int minVal;
        int maxVal;
        
        BSTInfo(boolean isBST, int size, int minVal, int maxVal) {
            this.isBST = isBST;
            this.size = size;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        if (root == null) return 0;
        BSTInfo result = largestBstHelper(root);
        return result.size;
    }
    
    // Helper function to find largest BST in subtree rooted at 'root'
    static BSTInfo largestBstHelper(Node root) {
        // Base case when root is null
        if (root == null) {
            return new BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        // Recursively traverse left and right subtrees
        BSTInfo leftInfo = largestBstHelper(root.left);
        BSTInfo rightInfo = largestBstHelper(root.right);
        
        // Initialize current subtree information
        BSTInfo current = new BSTInfo(false, 0, 0, 0);
        
        // Check if left and right subtrees are BST and root's key is greater than max of left and smaller than min of right
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.maxVal && root.data < rightInfo.minVal) {
            current.isBST = true;
            current.size = 1 + leftInfo.size + rightInfo.size;
            current.minVal = Math.min(root.data, leftInfo.minVal);
            current.maxVal = Math.max(root.data, rightInfo.maxVal);
        } else {
            current.size = Math.max(leftInfo.size, rightInfo.size);
        }
        
        return current;
    }
}

