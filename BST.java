/**
 * Binary Search Tree class.
 * Implements BST data structure
 * @author arnauvila
 */
public class BST<T extends Comparable<T>>{
	
	Node<T> root;
	
	public boolean find(T el){
		return find(root,el);
	}
	protected boolean find(Node<T> node,T el){
		if(node==null)
			return false;
		if(el.compareTo(node.value)==0)
			return true;
		else if(el.compareTo(node.value)<0)
			return find(node.left,el);
		else
			return find(node.right,el);
	}

	public void insert(T el){
		root=insert(root,el);
	}

	public Node<T> insert(Node<T> node,T el){
		if(node==null)
			return new Node<T>(el);
		if(el.compareTo(node.value)<0)
			node.left=insert(node.left,el);
		else
			node.right=insert(node.right,el);
		return node;
	}

	public void delete(T el){
		root=delete(root,el);
	}

	public Node<T> delete(Node<T> node, T el){
		if(node==null)
			return null;
		if(el.compareTo(node.value)>0){
			node.right=delete(node.right,el);
			return node;
		}
		else if(el.compareTo(node.value)<0){
			node.left=delete(node.left,el);
			return node;
		}
		else{	//el==Node.value
			if(node.left==null)
				return node.right;
			else if(node.right==null)
				return node.left;
			else{
				if(node.right.left==null){
					node.value=node.right.value;
					node.right=node.right.right;
				}
				else
					node.value=removeSmallest(node.right);
			}
			return node;
		}
	}

	public T removeSmallest(Node<T> node){
		if(node.left.left==null){
			T small=node.left.value;
			node.left=node.left.right;
			return small;
		}
		else
			return removeSmallest(node.left);
	}

	public void print(){
		inOrderTraversal(root);
	}
	
	public void inOrderTraversal(Node<T> node){
		if(node!=null){
			inOrderTraversal(node.left);
			System.out.print(node.value);
			inOrderTraversal(node.right);
		}
	}
	private class Node<T>{
		Node<T> left,right;
		T value;
		public Node(T item){
			value=item;
			left=null;
			right=null;
		}
	}

}
