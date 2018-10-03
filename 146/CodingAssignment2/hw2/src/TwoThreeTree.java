import java.util.ArrayList;

public class TwoThreeTree {

	private Node root;

	public TwoThreeTree()
	{
	}
	
	public boolean insert(int x)
	{
		if(root == null)
		{
			root = new Node(x);//assuming that the list is empty
			return true;
		}
		if(root.isDuplicate(x) == false)
		{
			Node node = root.toLeaf(x);

			node.addKey(x);
			if(node.getKeys().size() > 2)
			{
//				node.moveUp(x);
				node.split(node);
				root = node.getParent();
				return true;
			}
			
			if(node.getKeys().size() <= 2)
			{
				return true;
			}
		}
		return false;
	}
	
	public String search(int x)
	{  
		return root.search(x);
	}


}
