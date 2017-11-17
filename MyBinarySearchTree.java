package lab9_1;

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
}
