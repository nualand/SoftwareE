import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest
{

	@Test
	public void testLCA()
	{
		DAG<Integer, Integer> tree = new DAG<Integer, Integer>();
		//test on null tree
		assertEquals( "Testing LCA on empty tree",null, tree.lowestCommonAncestor(1, 2));

		//testing on  1 node
		tree.insert(1,1);
		assertEquals( "Testing one node tree given non-present keys",null, tree.lowestCommonAncestor(2,1));
		assertEquals("Testing one node tree given non-present keys", null, tree.lowestCommonAncestor(2,3));

		DAGt<Integer, Integer> bst = new DAG<Integer, Integer>();

		bst.insert(7, 7);   //        _7_
		bst.insert(8, 8);   //      /     \
		bst.insert(3, 3);   //    _3_      8
		bst.insert(1, 1);   //  /     \
		bst.insert(2, 2);   // 1       6
		bst.insert(6, 6);   //  \     /
		bst.insert(4, 4);   //   2   4
		bst.insert(5, 5);   //        \
	        				//         5

		assertEquals("Testing one node tree given root key", 7, (int)bst.lowestCommonAncestor(7,2));

	    assertEquals("Testing multi-node tree", 7, (int)bst.lowestCommonAncestor(3,8));
	    assertEquals("Testing multi-node tree", 7, (int)bst.lowestCommonAncestor(5,8));
	    assertEquals("Testing multi-node tree", 3, (int)bst.lowestCommonAncestor(3,6));
	    assertEquals("Testing multi-node tree", 3, (int)bst.lowestCommonAncestor(2,5));
	}

}
