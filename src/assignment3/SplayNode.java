package Assign2Package;

public class SplayTree {
	private SplayNode root;
	private int count = 0;
	
	public SplayTree(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(int num){
        SplayNode z = root;
        SplayNode p = null;

        while (z != null){
            p = z;
            if (num > p.number)
                z = z.right;
            else
                z = z.left;
        }
        z = new SplayNode();
        z.number = num;
        z.parent = p;

        if (p == null)
            root = z;
        else if (num > p.number)
            p.right = z;
        else
            p.left = z;

        Splay(z);
        count++;
	}
	
    public void makeLeftChildParent(SplayNode c, SplayNode p){

        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            System.out.println("WRONG");

        if (p.parent != null){
            if (p == p.parent.left)
                p.parent.left = c;
            else 
                p.parent.right = c;
        }

        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }
    
    public void makeRightChildParent(SplayNode c, SplayNode p){

        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            System.out.println("WRONG");

        if (p.parent != null){
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }

        if (c.left != null)
            c.left.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;

    }
    
    private void Splay(SplayNode x){
    	
        while (x.parent != null){
            SplayNode Parent = x.parent;
            SplayNode GrandParent = Parent.parent;

            if (GrandParent == null){
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);                 
            } 
            else{
                if (x == Parent.left){
                    if (Parent == GrandParent.left){
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    }
                    else {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                }
                else {
                    if (Parent == GrandParent.left){
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    } 
                    else {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        root = x;

    }
    
    public void remove(int num){
        SplayNode node = findNode(num);
        remove(node);
    }
    
    private void remove(SplayNode node){
    	
        if (node == null)
        	return;
        
        Splay(node);

        if( (node.left != null) && (node.right !=null)){
        	
            SplayNode min = node.left;

            while(min.right!=null){
                min = min.right;
            }

            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        }

        else if (node.right != null){
            node.right.parent = null;
            root = node.right;
        } 

        else if( node.left !=null){
            node.left.parent = null;
            root = node.left;
        }
        else{
            root = null;
        }
        
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        count--;
    }
    
    public boolean search(int value) {

        return findNode(value) != null;
    }

    private SplayNode findNode(int num){
    	
        SplayNode z = root;

        while (z != null){
        	
            if (num > z.number)
                z = z.right;

            else if (num < z.number)
                z = z.left;

            else
                return z;

        }
        return null;

    }
    
    public void print(){
    	System.out.println(root.number);
    	//System.out.println(root.left.number);
    	System.out.println(root.right.number);
    }
}
