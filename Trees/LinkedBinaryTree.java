package Trees;



//*******************************************************************
//
//      LinkedBinaryTree.java           Authors:  Lewis/Chase
//
//     Implements the BinaryTreeADT interface
//*******************************************************************


public class LinkedBinaryTree<T> 
{
   protected int count;
   protected BinaryTreeNode<T> root; 

   //================================================================
   //  Creates an empty binary tree.
   //================================================================
   public LinkedBinaryTree() 
   {
      count = 0;
      root = null;
   }  // constructor LinkedBinaryTree

   //================================================================
   //  Creates a binary tree with the specified element as its root.
   //================================================================
   public LinkedBinaryTree (T element) 
   {
      count = 1;
      root = new BinaryTreeNode<T> (element);
   }  // constructor LinkedBinaryTree

  
   
   //================================================================
   //  Deletes all nodes from the binary tree.
   //================================================================
   public void removeAllElements() 
   {
      count = 0;
      root = null;
   }  // method removeAllElements
   
   //================================================================
   //  Returns true if the binary tree is empty and false otherwise.
   //================================================================
   public boolean isEmpty() 
   {
      return (count == 0);
   }  // method isEmpty

   //================================================================
   //  Returns the number of nodes.
   //================================================================
   public int size() 
   {
      return count;
   }  // method size
   

 
   //================================================================
   //  Performs an inorder traversal on the binary tree by calling an
   //  overloaded, recursive inorder method that starts with
   //  the root.
   //================================================================
    public void displayInOrder() 
    {
      
      inorder(root);
      System.out.println("");
    }
     private void inorder(BinaryTreeNode<T> current)
     {
         if(current == null) return;
         inorder(current.getLeft());
         
         System.out.print(current.getElement().toString() + " ");
         inorder(current.getRight());
     }
    //================================================================
   //  Performs a postorder traversal on the binary tree by calling an
   //  overloaded, recursive inorder method that starts with
   //  the root.
   //================================================================
    public void displayPostOrder() 
    {
      
      postorder(root);
      System.out.println("");
    }
     private void postorder(BinaryTreeNode<T> current)
     {
         if(current == null) return;
         postorder(current.getLeft());
         postorder(current.getRight());
         System.out.print(current.getElement().toString() + " ");
         
         
     }  
     
  //================================================================
   //  Performs an preorder traversal on the binary tree by calling an
   //  overloaded, recursive inorder method that starts with
   //  the root.
   //================================================================
    public void printTreePre() 
    {
      preorder(root);
      System.out.println("");
     
    }
     private void preorder(BinaryTreeNode<T> current)
     {
         if(current == null) return;
         System.out.print(current.getElement().toString() + " ");
         preorder(current.getLeft());
         preorder(current.getRight());
        
     }
   //===========================================================  
   public int height() 
  {
      return heightNode(root);
    }
    
    private int heightNode(BinaryTreeNode<T> current)
    {
       if(current == null) return -1; 
       else
       {   int count=0;
           int leftHeight = heightNode(current.getLeft());
           int rightHeight = heightNode(current.getRight());
           if (leftHeight > rightHeight) count = leftHeight;
           else count = rightHeight;
           count++;
           return count;
        }
    }
    
	public int countLeaves() {
		int leafTotal =leafCounter(root);
		return leafTotal;
	}
	
	private int leafCounter(BinaryTreeNode<T> current) {
		if (current == null) return 0;
		else if(current.getLeft() == null && current.getRight() == null) return 1;
		else return leafCounter(current.getLeft()) + leafCounter(current.getRight());
	}
	public void swapTree() {
		swapTrees(root);
		System.out.println("Done Swapping");
	}
	private void swapTrees(BinaryTreeNode<T> current) {
		if (current == null);
		else{ 
			BinaryTreeNode<T> temp;
			swapTrees(current.getLeft());
			temp = current.getLeft();
			swapTrees(current.getRight());
			current.setLeft(current.getRight());
			current.setRight(temp);
		}
	}
}  // class BinaryTree

