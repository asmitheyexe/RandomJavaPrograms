package Trees;



//*******************************************************************
//
//   BinaryTreeNode.java		Authors:  Lewis/Chase
//
//   Represents a node in a binary tree with a left and right child
//*******************************************************************


public class BinaryTreeNode<T> {

   private T element;
   private BinaryTreeNode<T> left, right;

   //================================================================
   //  Creates a new tree node with the specified data.
   //================================================================
   BinaryTreeNode (T obj) 
   {
      element = obj;
      left = null;
      right = null;
   }  // constructor BinaryTreeNode

   //================================================================
   //  Returns the number of non-null children of this node.
   //  This method may be able to be written more efficiently.
   //================================================================
   public int numChildren() 
   {

      int children = 0;

      if (left != null)
         children = 1 + left.numChildren();

      if (right != null)
         children = children + 1 + right.numChildren();

      return children;

   }  // method numChildren
  /*--------------------------------------------------------*/ 
   public BinaryTreeNode<T> getLeft()
    {
       return left;
    }
    public BinaryTreeNode<T> getRight()
    {
       return right;
    }
     public void setLeft (BinaryTreeNode<T> node)
    {
       left = node;
    }
    public void setRight (BinaryTreeNode<T> node)
    {
       right = node;
    }
    public T getElement()
    {
       return element;
    }
 
    //---------------------------------------------------------
    //  Sets the element stored in this node.
    //---------------------------------------------------------
    public void setElement (T elem)
    {
       element = elem;
    }
   
}  // class BinaryTreeNode

