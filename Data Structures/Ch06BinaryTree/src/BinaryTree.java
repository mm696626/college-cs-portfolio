
public class BinaryTree<T> {
	private class Node<T>
	{
		private T data;
		private Node<T> left;
		private Node<T> right;
		
		
		public Node(T value)
		{
			data = value;
			left = null;
			right = null;
		}
		public Node(T value, Node<T> leftRef, Node<T> rightRef)
		{
			data = value;
			left = leftRef;
			right = rightRef;
		}
	}
		private Node<T> root;
		
		public BinaryTree()
		{
			root = null;
		}
		public BinaryTree(Node<T> rootnode)
		{
			root = rootnode;
		}
		public BinaryTree(T value, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
		{
			root = new Node<T>(value);
			if(leftTree != null)
				root.left = leftTree.root;
			else
				root.left = null;
			
			if(rightTree != null)
				root.right = rightTree.root;
			else
				root.right = null;
		}
		
		
		public BinaryTree<T> getLeftSubtree()
		{
			if(root != null && root.left != null)
				return new BinaryTree<T>(root.left);
			else
				return new BinaryTree<T>(null);
		}
		
		public BinaryTree<T> getRightSubtree()
		{
			if(root != null && root.right != null)
				return new BinaryTree<T>(root.right);
			else
				return new BinaryTree<T>(null);
		}
		
		public void showPreOrderTraversal(Node<T> givenroot, int level)
		{
			for(int i=1; i<level; i++)
			{
				System.out.print("       ");
			}
			if(givenroot == null)
				System.out.println("null");
			else
			{
				System.out.println(givenroot.data);
				showPreOrderTraversal(givenroot.left, level+1);
				showPreOrderTraversal(givenroot.right, level+1);
			}
		}
		
		public void preOrder()
		{
			showPreOrderTraversal(root, 1);
		}
		
		public void showInOrderTraversal(Node<T> givenroot, int level)
		{
			if(givenroot == null)
			{
				for(int i=1; i<level; i++)
				{
					System.out.print("       ");
				}
				System.out.println("null");
			}
				
			else
			{
				
				showInOrderTraversal(givenroot.left, level+1);
				for(int i=1; i<level; i++)
				{
					System.out.print("       ");
				}
				System.out.println(givenroot.data);
				showInOrderTraversal(givenroot.right, level+1);
			}
		}
		public void inOrder()
		{
			showInOrderTraversal(root, 1);
		}
		
		
		public void showPostOrderTraversal(Node<T> givenroot, int level)
		{
			if(givenroot == null)
			{
				for(int i=1; i<level; i++)
				{
					System.out.print("       ");
				}
				System.out.println("null");
			}
				
			else
			{
				
				showPostOrderTraversal(givenroot.left, level+1);
				showPostOrderTraversal(givenroot.right, level+1);
				for(int i=1; i<level; i++)
				{
					System.out.print("       ");
				}
				System.out.println(givenroot.data);
			}
		}
		public void postOrder()
		{
			showPostOrderTraversal(root, 1);
		}
		
}
