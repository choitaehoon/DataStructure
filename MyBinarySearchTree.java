package hw9_2;

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
		Node leftChild ;
		Node rightChild ;
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
	//���� ���� (Ȯ���ϱ�)
	private int max(Node temp) throws NullPointerException
	{
		if(temp == null)
		{
			throw new NullPointerException("���� ����Ž�� Ʈ�� �Դϴ�");
		}
		else
		{
			int data = 0;
			if(temp.rightChild != null)
			data = max(temp.rightChild);
			return temp.key > data ? temp.key : data;	
		}
	}
	
	//���� �ϱ�
	public boolean add(int key)
	{
		return add(key, root);
	}
	
	//�ݺ��˰��� ����ϱ�
	private boolean add(int key, Node temp)
	{
		Node newNode = new Node(key);
		if(temp == null)
		{
			root = newNode;
			return true;
		}
		else
		{
			while(temp != null)
			{
				if(temp.key == key)
					return false;	

				else if(temp.key < key)
				{
					if(temp.rightChild == null)
					{
						temp.rightChild = newNode;
						return true;
					}	
					else
						temp = temp.rightChild;	
				}
				
				else
				{
					if(temp.leftChild == null)
					{
						temp.leftChild = newNode;
						return true;
					}
					else
						temp = temp.leftChild;	
				}
			}
			return false;
		}
	}
	
	//���� �޼ҵ�
	public boolean remove(int key)
	{
		return remove(key,root);
	}
	
	//���� ���� �޼ҵ� 
	private boolean remove(int key, Node temp)
	{
		if(temp == null) //�ƿ� ���Ұ� ������
			return false;
		
		else //���Ұ� ���� ���   ������ ��찡 3���� �ִµ� 1.�ܸ���� 2.�ڽĳ�尡 �ϳ��� ��� 3.�ڽ� ��尡 �ΰ��� ���
		{	
			cases(key);
			return true;
		}
		
	}
	
	// �����Ҷ� ����� �������� �����ϱ� 1.�ܸ���� 2.�ڽ� ��尡 �ϳ��� ��� 3.�ڽ� ��尡 �ΰ� �ΰ��(�İ��ڸ� �����ؾ� �ϴµ� ���� ���ʼ���Ʈ�� �İ��� ������ ����)
	private void cases(int key)
	{
		Node temp = root; //������ ��带 Ž���ϴ� ��������
		Node parent = null;
		
		if(temp.key == key && temp.leftChild == null && temp.rightChild== null) //��Ʈ�̸鼭 �ܸ� ��� �ΰ��
		{
			root = null;
			return ;
		}
		
			while(temp != null)
			{
				
				if(temp.key < key) //Ž�� �Ҷ� ���������� ���� ��
				{
					
					parent = temp;
					temp = temp.rightChild;
					if(temp.key == key && (temp.leftChild == null && temp.rightChild == null)) // �ܸ� ��� �ΰ��
					{
						if(parent.leftChild == temp)
							parent.leftChild = null;
						else
							parent.rightChild = null;
						return ;
					}
					
					else if(temp.key == key && (temp.leftChild == null || temp.rightChild == null)) //�ڽ� ��尡 �ϳ� �ΰ�� (������)
					{
						if(parent.leftChild == temp)
							parent.leftChild = temp.rightChild;
						else
							parent.rightChild = temp.rightChild;
					}
						
					else if(temp.key == key && (temp.leftChild != null && temp.rightChild != null))// �ڽ� ��尡 �ΰ� �� ���
					{
						int data = 0;
						if(temp.leftChild != null)
							data = max(temp.leftChild);
						temp.key = data;
						//���������� temp.leftChild = remove(temp.leftChild, temp.key);�ϸ� �Ǵµ� ����غ�����
						return ;
					}
						
						
				}
				else //Ž���Ҷ� �������� ���� ��
				{
					
					parent = temp;
					temp = temp.leftChild;
					if(temp.key == key && (temp.leftChild == null && temp.rightChild == null))// �ܸ� ��� �ΰ��
					{
						if(parent.leftChild == temp)
							parent.leftChild = null;
						else
							parent.rightChild = null;
						return ;
					}
					else if(temp.key == key && (temp.leftChild == null || temp.rightChild != null)) //�ڽ� ��尡 �ϳ� �ΰ�� (����)
					{
						if(parent.leftChild == temp)
							parent.leftChild = temp.leftChild;
						else
							parent.rightChild = temp.leftChild;
					}
					else if(temp.key == key && (temp.leftChild != null && temp.rightChild != null))// �ڽ� ��尡 �ΰ� �� ���
					{
						int data = 0;
						if(temp.leftChild != null)
							data = max(temp.leftChild);
						temp.key = data;
						return ;
					}
					
				}
				
			}
		
		
	}
}
