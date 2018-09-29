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
		theTree.adds(1);
		assertTrue("Check bt contains value", theTree.contains(1));
		assertFalse("Check bt for non-present value", theTree.contains(4));

		BinaryTree empty = new BinaryTree();
		assertFalse("Check empty bst", empty.contains(8));

	}


}
