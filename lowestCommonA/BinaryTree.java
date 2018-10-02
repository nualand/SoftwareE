
import java.util.NoSuchElementException;

public class BinaryTree
{
	private Node root;             // root of BT

	/**
	 * Private node class.
	 */
	private class Node
	{
		private Node left, right;  // left and right subtrees
		private int value;         // value of the node

		public Node(int value)
		{
			this.value = value;
		}
	}


	//checks to see if node is in the BT
	public boolean containsNode(int value)
	{
			return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value)
	{
    if (current == null)
		{
        return false;
    }
    if (value == current.value)
		{
        return true;
    }

    return value < current.value
      ? containsNodeRecursive(current.left, value)
      : containsNodeRecursive(current.right, value);
	}


	// adds node to BT
	public void add(int value)
	{
    root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value)
	{
	    if (current == null) {
	        return new Node(value);
	    }

	    if (value < current.value) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }

	    return current;
	}

 public	Node lowestCommonAncestor(int node1, int node2)
	    {
	        return lowestCommonAncestor(root, node1, node2);
	    }

	// find lowest common ancestor of two nodes
	private Node lowestCommonAncestor(Node root, int node1, int node2)
	 {
			 // Base case
			 if (root == null)
					 return null;

			 // If either n1 or n2 matches with root's key, report
			 // the presence by returning root (Note that if a key is
			 // ancestor of other, then the ancestor key becomes LCA
			 if (root.value == node1 || root.value == node2)
					 return root;

			 // Look for keys in left and right subtrees
			 Node leftLCA = lowestCommonAncestor(root.left, node1, node2);
			 Node rightLCA = lowestCommonAncestor(root.right, node1, node2);

			 // If both of the above calls return Non-NULL, then one key
			 // is present in once subtree and other is present in other,
			 // So this node is the LCA
			 if (leftLCA!=null && rightLCA!=null)
					 return root;

			 // Otherwise check if left subtree or right subtree is LCA
			 return (leftLCA != null) ? leftLCA : rightLCA;
	 }

	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();
		theTree.add(5);
		theTree.add(7);
		theTree.add(9);
		theTree.add(2);
		theTree.add(10);
		theTree.add(4);
		theTree.add(3);
		theTree.add(8);

		System.out.print("does theTree contain 2? " + theTree.containsNode(2));
	}

}
