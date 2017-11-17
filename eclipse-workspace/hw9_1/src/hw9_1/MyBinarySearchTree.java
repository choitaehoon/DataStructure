package hw9_1;

class MyBinarySearchTree {
	// Ʈ���� ��Ʈ ��带 ����ų �ν��Ͻ� ���� root �����ϰ� null�� �ʱ�ȭ
	Node root = null;

	// Ʈ���� ��带 ǥ���ϴ� Ŭ���� - �ʵ�(int�� key, leftChild, rightChild), ������(key���� �Ű������Ͽ� �ʱ�ȭ)
	private class Node
	{
		public Node(int key)
		{
			this.key = key;
		}
		int key;
		Node leftChild;
		Node rightChild;
	}

	// (1) ��ü��ȸ�� ���� toString() �������̵�
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ���ڿ��� �����ϴ� �޼ҵ�(��� �˰���)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) ��� ����
	public void insert(int key) {
		root = insertKey(root, key);
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� key�� �����ϴ� �޼ҵ� (��� �˰���)
	private Node insertKey(Node p, int key) {
		if(p == null) {
			Node newNode = new Node(key);
			return newNode;
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// ��Ʈ �Һ�
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// ��Ʈ �Һ�
		}
		else {  // key = p.key �� ��� ���� ����
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// ��Ʈ �Һ�
		}
	}

	// (3) ���� ��ȸ
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ����ϴ� �޼ҵ�
	private void postorder(Node p) {
		if(p == null)
		{
			return ;
		}
		else
		{
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.print(p.key+" ");
		}
	}
	//Ž���ϴ� �޼ҵ�
	public boolean contains(int key)
	{
		return contains(key, root);
	}
	//�������� ->�ܺο��� ���� x
	private boolean contains(int key, Node temp)
	{
		if(temp == null)
			return false;
		else
		{
			if(key == temp.key) 
				return true;
			else if(key< temp.key)
				return contains(key, temp.leftChild);	
			else
				return contains(key, temp.rightChild);
		}
	}
	
	//�ִ밪 ����ϴ� �޼ҵ�
	public int max()
	{
		 return max(root);
	}
	//���� ����
	private int max(Node temp) throws NullPointerException
	{
		if(temp == null)
		{
			throw new NullPointerException("���� ����Ž�� Ʈ�� �Դϴ�");
		}
		else
		{
			int data = 0;
			if(temp != null)
			data = max(temp.rightChild);
			return temp.key > data ? temp.key : data;	
		}
	}
	
	//���� �ϱ�
	public boolean add(int key)
	{
		return add(key, root);
	}
	//�ݺ��˰��� ����ϱ� (�ٽ� �����غ���)
	private boolean add(int key, Node temp)
	{
		Node newNode = new Node(key);
		Node tmp = root;
		if(tmp == null)
		{
			root = newNode;
			return true;
		}
		else 
		{
				while(tmp != null)
				{
					if(key == tmp.key)
						return false;
					else if(tmp.key > key)
						tmp = tmp.rightChild;
					else
						tmp = tmp.leftChild;
				}
				tmp = newNode;
		}
		return false;
	}
}
