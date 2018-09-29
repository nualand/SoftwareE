
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



	// find lowest common ancestor of two nodes
	public Node lowestCommonAncestor(Node root, Node node1, Node node2)
	{
		if(!containsNode(node1)||!containsNode(node2))
		{
			return null;
		}
		if(root == null)
		{
			return null;
		}

	}

}
