import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BinaryTreeTest
{

	@Test
	public void testContains(){

		BinaryTree theTree = new BinaryTree() ;
		theTree.add(1);
		assertTrue("Check bt contains value", theTree.contains(1));
		assertFalse("Check bt for non-present value", theTree.contains(4));

		BinaryTree empty = new BinaryTree();
		assertFalse("Check empty bst", empty.contains(8));

	}

	@Test
	public void testLowestCommonA(){

		BinaryTree theTree = new BinaryTree() ;
		theTree.add(5);
		theTree.add(7);
		theTree.add(9);
		theTree.add(2);
		theTree.add(10);
		theTree.add(4);
		theTree.add(3);
		theTree.add(8);
/*
		Node actual = new Node(theTree.lowestCommonAncestor(8,10));
		Node expected = new Node(7);
		assertEquals("Check that the lca for 8 and 10 = 7", actual.int, expected.value);
		assertFalse("Check bt for non-present value", theTree.contains(4));

		BinaryTree empty = new BinaryTree();
		assertFalse("Check empty bst", empty.contains(8));

*/
}
}
