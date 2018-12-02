import java.lang.StringBuilder;

public class DAG<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int num;

        public Node(Key key, Value value, int num) {
            this.key = key;
            this.value = value;
            this.num = num;
        }
    }

    public boolean isEmpty() { return size() == 0; }

    public int size() { return size(root); }

    private int size(Node x)
    {
        if (x == null) return 0;
        else return x.num;
    }

    public Value get(Key key)
    {
    	if(key == null)
    		return null;
    	else
    		return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        if (x == null)
        	return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
        	return get(x.left, key);
        else if(cmp > 0)
        	return get(x.right, key);
        else
        	return x.value;
    }

    public void insert(Key key, Value value)
    {
		if (key == null) { return; }
        if (value == null) { delete(key); return; }
        root = insert(root, key, value);
    }

    private Node insert(Node x, Key key, Value value)
    {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
        	x.left  = insert(x.left,  key, value);
        else if(cmp > 0)
        	x.right = insert(x.right, key, value);
        else
        	x.value = value;
        x.num = 1 + size(x.left) + size(x.right);
        return x;
    }

    public String printTree()
    {
      if (isEmpty()) return "()";

      StringBuilder output = new StringBuilder();
      output.append("(");
      printTree(root, output);

      String result = output.toString();
      return result;

    }

    private StringBuilder printTree(Node x, StringBuilder output){
    	if(x == null)
    	{
    		return (output.append(")"));
    	}
    	output.append("(");
    	printTree(x.left, output);
    	output.append(x.key);
    	output.append("(");
    	printTree(x.right, output);
    	output.append(")");
    	return output;

    }

    public void delete(Key key)
    {
    	if(key!=null) root = delete(root, key);
    }

    private Node delete(Node x, Key key)
    {
    	if(x == null) return null;
    	int cmp = key.compareTo(x.key);
    	if		(cmp < 0) x.left  = delete(x.left, key);
    	else if	(cmp > 0) x.right = delete(x.right, key);
    	else
    	{
    		if(x.right 	== null) return x.left;
    		if(x.left 	== null) return x.right;

    		Node t = x;
    		x = t.left;
    		while(x.right != null)
    		{
    			x = x.right;
    		}
    		x.left = deleteMax(t.left);
    		x.right = t.right;
    	}
    	x.num = size(x.left) + size(x.right) + 1;
    	return x;
    }

    private Node deleteMax(Node x)
    {
    	if(x.right == null) return x.left;
    	x.right = deleteMax(x.right);
    	x.num = 1 + size(x.left) + size(x.right);
    	return x;
    }

    public boolean contains(Key x)
    {
    	return(get(x)!= null);
    }



    public Key lowestCommonAncestor(Key a, Key b)
    {
    	if (root == null){
			return null;
		}
    	if(!contains(a) || !contains(b)){
    		return null;
    	}
    	return lowestCommonAncestor(root, a, b);
    }

	private Key lowestCommonAncestor(Node x, Key a, Key b) {

		int cmp = x.key.compareTo(a);
		int cmp2 = x.key.compareTo(b);

		if(cmp > 0 && cmp2 > 0){
			return lowestCommonAncestor(x.left, a, b);
		}
		else if(cmp < 0 && cmp2 < 0){
			return lowestCommonAncestor(x.right, a, b);
		}
		else{
			return x.key;
		}
	}
}
