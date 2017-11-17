package hw9_1;

import java.util.Scanner;

public class MyBinarySearchTreeTest {
	public static void main(String[] args) {
		System.out.println("hw9_1 : 최태훈");

		// 공백 이진탐색트리 tree를 생성
		MyBinarySearchTree tree = new MyBinarySearchTree();

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;

		// 종료를 선택할 때까지 반복하여 메뉴를 제공하고 그에 맞는 트리 연산을 수행
		do {
			System.out.print("1:전체조회 2:재귀삽입 3:후위순회 4.검색 수행 5.최대값 출력 6.삽입수행(반복알고리즘) 9:종료 --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("전체조회를 수행합니다.");
				System.out.println(tree.toString());		// (1)
				break;
			case 2:
				System.out.println("재귀 알고리즘을 이용한 삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");		// (2)
				item = scan.nextInt();
				tree.insert(item);
				break;
			case 3:
				System.out.println("후위순회를 수행합니다.");
				tree.printPostorder();		 		// (3)
				break;
			case 4:
				System.out.println("검색을 수행합니다.");
				System.out.print("검색할 정수 입력:");
				item = scan.nextInt();
				if(tree.contains(item))				// (4)
					System.out.println("검색 성공");
				else
					System.out.println("검색 실패");
				break;
			case 5:
				System.out.println("최대값 조회를 수행합니다.");
				System.out.println(tree.max());			// (5)
				break;
			case 6:
				System.out.println("반복 알고리즘을 이용한 삽입을 수행합니다.");
				System.out.print("삽입할 정수 입력:");
				item = scan.nextInt();
				if(tree.add(item))				// (6)
					System.out.println("삽입 성공");
				else
					System.out.println("삽입 실패");
				break;
//			case 7:
//				System.out.println("삭제를 수행합니다.");
//				System.out.print("삭제할 정수 입력:");
//				item = scan.nextInt();
//				if(tree.remove(item))				// (7)
//					System.out.println("삭제 성공");
//				else
//					System.out.println("삭제 실패");
//
//				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while(menu != 9);
	}
}