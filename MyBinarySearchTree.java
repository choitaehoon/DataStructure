package hw9_2;

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
		Node leftChild ;
		Node rightChild ;
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
	//정보 은닉 (확인하기)
	private int max(Node temp) throws NullPointerException
	{
		if(temp == null)
		{
			throw new NullPointerException("공백 이진탐색 트리 입니다");
		}
		else
		{
			int data = 0;
			if(temp.rightChild != null)
			data = max(temp.rightChild);
			return temp.key > data ? temp.key : data;	
		}
	}
	
	//삽입 하기
	public boolean add(int key)
	{
		return add(key, root);
	}
	
	//반복알고리즘 사용하기
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
	
	//삭제 메소드
	public boolean remove(int key)
	{
		return remove(key,root);
	}
	
	//정보 은닉 메소드 
	private boolean remove(int key, Node temp)
	{
		if(temp == null) //아예 원소가 없을때
			return false;
		
		else //원소가 있을 경우   삭제는 경우가 3가지 있는데 1.단말노드 2.자식노드가 하나인 경우 3.자식 노드가 두개인 경우
		{	
			cases(key);
			return true;
		}
		
	}
	
	// 삭제할때 경우의 세가지수 정의하기 1.단말노드 2.자식 노드가 하나인 경우 3.자식 노드가 두개 인경우(후계자를 선택해야 하는데 나는 왼쪽서브트리 후계자 선택할 예정)
	private void cases(int key)
	{
		Node temp = root; //삭제할 노드를 탐색하는 참조변수
		Node parent = null;
		
		if(temp.key == key && temp.leftChild == null && temp.rightChild== null) //루트이면서 단말 노드 인경우
		{
			root = null;
			return ;
		}
		
			while(temp != null)
			{
				
				if(temp.key < key) //탐색 할때 오른쪽으로 가는 곳
				{
					
					parent = temp;
					temp = temp.rightChild;
					if(temp.key == key && (temp.leftChild == null && temp.rightChild == null)) // 단말 노드 인경우
					{
						if(parent.leftChild == temp)
							parent.leftChild = null;
						else
							parent.rightChild = null;
						return ;
					}
					
					else if(temp.key == key && (temp.leftChild == null || temp.rightChild == null)) //자식 노드가 하나 인경우 (오른쪽)
					{
						if(parent.leftChild == temp)
							parent.leftChild = temp.rightChild;
						else
							parent.rightChild = temp.rightChild;
					}
						
					else if(temp.key == key && (temp.leftChild != null && temp.rightChild != null))// 자식 노드가 두개 인 경우
					{
						int data = 0;
						if(temp.leftChild != null)
							data = max(temp.leftChild);
						temp.key = data;
						//마지막으로 temp.leftChild = remove(temp.leftChild, temp.key);하면 되는데 고민해봐야함
						return ;
					}
						
						
				}
				else //탐색할때 왼쪽으로 가는 곳
				{
					
					parent = temp;
					temp = temp.leftChild;
					if(temp.key == key && (temp.leftChild == null && temp.rightChild == null))// 단말 노드 인경우
					{
						if(parent.leftChild == temp)
							parent.leftChild = null;
						else
							parent.rightChild = null;
						return ;
					}
					else if(temp.key == key && (temp.leftChild == null || temp.rightChild != null)) //자식 노드가 하나 인경우 (왼쪽)
					{
						if(parent.leftChild == temp)
							parent.leftChild = temp.leftChild;
						else
							parent.rightChild = temp.leftChild;
					}
					else if(temp.key == key && (temp.leftChild != null && temp.rightChild != null))// 자식 노드가 두개 인 경우
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
