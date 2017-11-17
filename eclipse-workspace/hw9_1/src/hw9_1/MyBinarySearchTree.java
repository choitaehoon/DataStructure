package hw9_1;

class MyBinarySearchTree {
	// 트리의 루트 노드를 가리킬 인스턴스 변수 root 선언하고 null로 초기화
	Node root = null;

	// 트리의 노드를 표현하는 클래스 - 필드(int형 key, leftChild, rightChild), 생성자(key값을 매개변수하여 초기화)
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

	// (1) 전체조회를 위한 toString() 오버라이드
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p를 루트로 하는 트리를 중위 순회하며 키값을 문자열로 리턴하는 메소드(재귀 알고리즘)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) 재귀 삽입
	public void insert(int key) {
		root = insertKey(root, key);
	}

	// p를 루트로 하는 트리에 key를 삽입하는 메소드 (재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if(p == null) {
			Node newNode = new Node(key);
			return newNode;
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// 루트 불변
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// 루트 불변
		}
		else {  // key = p.key 인 경우 삽입 실패
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// 루트 불변
		}
	}

	// (3) 후위 순회
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p를 루트로 하는 트리를 후위 순회하며 키값을 출력하는 메소드
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
	//탐색하는 메소드
	public boolean contains(int key)
	{
		return contains(key, root);
	}
	//정보은닉 ->외부에게 공개 x
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
	
	//최대값 출력하는 메소드
	public int max()
	{
		 return max(root);
	}
	//정보 은닉
	private int max(Node temp) throws NullPointerException
	{
		if(temp == null)
		{
			throw new NullPointerException("공백 이진탐색 트리 입니다");
		}
		else
		{
			int data = 0;
			if(temp != null)
			data = max(temp.rightChild);
			return temp.key > data ? temp.key : data;	
		}
	}
	
	//삽입 하기
	public boolean add(int key)
	{
		return add(key, root);
	}
	//반복알고리즘 사용하기 (다시 생각해보기)
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
