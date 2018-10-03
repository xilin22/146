import java.util.*;

public class Node implements Comparable{
	private ArrayList<Integer> keys = new ArrayList<Integer>();
	private ArrayList<Node> children = new ArrayList<Node>();
	private Node parent;
	private int midElt;
	private Node root;
	
	public Node(){}
	
	public Node(int x){
		keys.add(x);
	}
	
	public Node(int x, Node one, Node two){
		keys.add(x);
		orderKeys();
		children.add(one);
		children.add(two);
		orderChildren();
	}
	
		
	public Node getRoot()
	{
		return root;
	}
	
	public void addKey(int x)
	{
		keys.add(x);
		orderKeys();
	}
	
	private void orderKeys()
	{ 
		for( int i = 1; i < keys.size(); i++ )
		{
			int key = keys.get(i);
			int j = i - 1;
			
			while(j >= 0 && keys.get(j)> key )
			{
				keys.set(j+1, keys.get(j));
				j = j -1;
			}
			
			keys.set(j+1, key);
		}
	}

	public ArrayList getKeys()
	{
		return keys;
	}
	
	public ArrayList getChildren()
	{
		return children;
	}
	
	private void orderChildren()
	{

		children = new ArrayList(new TreeSet(children));
	}
	
	public int compareTo(Object that1)
	{
		Node that = (Node) that1;
		if(this.keys.get(keys.size()-1) > that.keys.get(0))  //this is greater than that
		{
			return 1;
		}
		if(this.keys.get(keys.size()-1) < that.keys.get(0))  //this is less than that
		{
			return -1;
		}
		return 0;
	}
	
	public void addChild(Node left)
	{
		children.add(left);
		
	}
	
	public void setParent(Node parent)
	{
		this.parent = parent;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public int getMiddleKey()
	{
//		keys.add(x);
//		orderKeys();
		int mid = keys.get((keys.size()/2));
		
		keys.remove((keys.size()/2));
		
		return mid;
	}
/*	
	public void moveUp(int x)  	//   <----- this is wrong
	{

		int mid = this.getMiddleKey(x);
		this.setParent(new Node(mid));
		
		if(parent==null) //if this node doesnt have a parent
		{
			//this.setParent(new Node(mid));
			return;
		}
		
		if(parent.keys.size() < 2)
		{
			//for(int i = 0; i < keys.size(); i++)
			while (keys.size()!= 0)
			{
				//parent.addKey(mid);
				parent.addChild(new Node(keys.get(0)));
				this.keys.remove(0);
			}
		}

		if(parent.keys.size() >= 2)
		{
			mid = this.getMiddleKey(mid);
			moveUp(mid);
		}

	}
*/	
	public void split()
	{ 
//		if(this == root)
//		{
//			Node node1 = new Node(this.getMiddleKey());
//			root = node1;
//			node1.children.add(new Node(this.keys.get(0)));
//			node1.children.add(new Node(this.keys.get(1)));
//		}
		if(this.parent !=  null)  // if there is a root
		{
			parent.addKey(this.getMiddleKey());
			
			Node node2 = new Node(this.keys.get(1));
			this.keys.remove(1);
			
			parent.children.add(node2);
			node2.setParent(parent);
			
			this.setParent(parent);
		
			
		}
		else
		{
			Node newRoot = new Node(this.getMiddleKey());
			this.setParent(newRoot);
			root = newRoot;
			
			Node node2 = new Node(this.keys.get(1));
			this.keys.remove(1);
			parent.children.add(node2);
			node2.setParent(newRoot);
			
			this.setParent(newRoot);

		}
		
		if(parent.keys.size() > 2)
		{
			parent.split();
		}
				
	}

	public void split(Node fullNode)
	{ 

		if(this.parent !=  null)  // if there is a root
		{
			parent.addKey(this.getMiddleKey());
			
			Node node2 = new Node(this.keys.get(1));
			this.keys.remove(1);
			
			parent.children.add(node2);
			node2.setParent(parent);
			
			this.setParent(parent);
		
			
		}
		else
		{
			Node newRoot = new Node(this.getMiddleKey());
			this.setParent(newRoot);
			root = newRoot;
			
			Node node2 = new Node(this.keys.get(1));
			this.keys.remove(1);
			parent.children.add(node2);
			node2.setParent(newRoot);
			
			this.setParent(newRoot);

		}
		
		if(parent.keys.size() > 2)
		{
			parent.split();
		}
				
	}

	public Node toLeaf(int x)
	{
		for( int i = 0; i < keys.size(); i++)
		{
			if(this.keys.get(i) == x)
			{
				return this;
			}
		}
		
		if(this.children.size()==0)
		{
			return this;
		}
		
		int i = 0;
		int index = 0;
		while(i != keys.size())  // use to find correct index
		{
			if( x < keys.get(i))
			{
				index = i;     
			}	
			if( x > keys.get(i))
			{
				index = i + 1;
			}					
//			if((i+1 < keys.size() || i+1 == keys.size()) && x >  keys.get(i) && x < keys.get(i+1))
			if((i+1 < keys.size()) && x >  keys.get(i) && x < keys.get(i+1))
			{
				//return children.get(i+1).toLeaf(x);
				index = i + 1;
			}
			i++;
		} 
		
		return children.get(index).toLeaf(x);
	}
	

	public boolean isDuplicate(int x)
	{			
		Node node = toLeaf(x);
		for(int i = 0; i < node.keys.size(); i++)
		{
			if(node.keys.get(i) == x)
				return true;
		}
		
		return false;
	}

//	public boolean insert(int x)
//	{
//		if(this.keys.size() == 0)
//		{
//			this.addKey(x);
//			root = this;
//			
//			return true;
//		}
//		if(this.isDuplicate(x) == false)
//		{
//			Node node = this.toLeaf(x);
//
//			node.addKey(x);
//			if(node.getKeys().size() > 2)
//			{
//				node.split();
//				root = node.getParent();
//				return true;
//			}
//			
//			if(node.getKeys().size() <= 2)
//			{
//				return true;
//			}
//		}
//		return false;
//	}
//	
	public String search(int x)
	{  
		// compare to the node and then take it on from there
		Node resultNode = toLeaf(x);
		String keys = "";
		
		for(int i = 0; i < resultNode.getKeys().size(); i ++)
		{
			if(resultNode.getKeys().size() == 1)
			{
				keys= ""+ resultNode.getKeys().get(0);
			} 
			else if(i+1 == resultNode.getKeys().size())
			{
				keys= keys + resultNode.getKeys().get(i);
			}
			else
			{
				keys =   keys + resultNode.getKeys().get(i)+ " " ;
			}		
		} 
		
//		return root.toLeaf(x).getKeys().toString();
		
		return  keys;
	}
	
//	public void splitThreeKeys(Node fullNode)
//	{
//		Node nodeLeft = new Node(fullNode.keys.get(0));
//		Node nodeCenter = new Node(fullNode.keys.get(1));
//		Node nodeRight = new Node(fullNode.keys.get(2));
//		
//		nodeCenter.addChild(nodeLeft);
//		nodeCenter.addChild(nodeRight);
//		
//		nodeLeft.addChild(fullNode.children.get(0));
//		nodeLeft.addChild(fullNode.children.get(1));
//		nodeRight.addChild(fullNode.children.get(2));
//		nodeRight.addChild(fullNode.children.get(3));
//	}
//	

	
}
