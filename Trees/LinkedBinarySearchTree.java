package Trees;



//*******************************************************************
//
// LinkedBinarySearchTree.java          Authors: Lewis/Chase
//
// Implements the BinarySearchTreeADT interface with links
//*******************************************************************

public class LinkedBinarySearchTree<T>  extends LinkedBinaryTree<T>
 {
 //==========================================================
   //  Creates an empty binary search tree.
   //================================================================
   public LinkedBinarySearchTree() 
   {
      super();
   }  // constructor BinarySearchTree

   //================================================================
   //  Creates a binary search with the specified element as its
   //  root.
   //================================================================
   public LinkedBinarySearchTree (T element) 
   {
      super (element);
   }  // constructor BinarySearchTree

   //================================================================
   //  Adds the specified object to the binary search tree in the
   //  appropriate position according to its key value. 
   //================================================================
   public void addElement (T element) 
   {

      BinaryTreeNode<T> temp = new BinaryTreeNode<T> (element);
      Comparable<T> comparableElement = (Comparable<T>)element;
      boolean duplicate = false;
      if (isEmpty())
         root = temp;
      else 
      {
         BinaryTreeNode<T> current = root;
         boolean added = false;
         
         while (!added) 
         {
            if (comparableElement.compareTo(current.getElement()) < 0)

               if (current.getLeft() == null) 
               {
                  current.setLeft(temp);
                  added = true;
               } 
               else
                  current = current.getLeft();
            else 
             if (comparableElement.compareTo(current.getElement()) > 0)
              {
               if (current.getRight() == null) 
               {
                  current.setRight(temp);
                  added = true;
               } 
               else
                  current = current.getRight();
               }
             else { added = true; duplicate = true;}// do nothig - duplicates;
             
         }//while
      }//else

      if (!duplicate) count++;

   }  // method addElement

 
}  // class BinarySearchTree

