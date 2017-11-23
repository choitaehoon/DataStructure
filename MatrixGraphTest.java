package lab10_1;

import java.util.Scanner;

public class MatrixGraphTest { 
	public static void main(String[] args) { 
		System.out.println("lab10_1 : 최태훈");

		// 정점 수 n 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("정점 수 입력: ");
		int n = scan.nextInt();

		// 정점 수가 n인 무방향 그래프를 생성
		MatrixGraph graph = new MatrixGraph(n);

		System.out.println("\n메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		int v1 = 0;
		int v2 = 0;

		// 종료를 선택할 때까지 반복하여 메뉴를 제공하고 그에 맞는 그래프 연산을 수행
		do {
			System.out.print("\n1:간선삽입 2:인접정점출력 3:DFS 4:BFS 5:종료 --->");
			menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.print("정점 v1 입력: ");
				v1 = scan.nextInt();		
				System.out.print("정점 v2 입력: ");
				v2 = scan.nextInt();
				graph.addEdge(v1, v2);
				break;
			case 2:
				System.out.print("정점 입력:");		 
				v1 = scan.nextInt();  
				graph.printAdjacentVertices(v1);
				break;				
//			case 3:
//				System.out.println("깊이우선탐색 순서대로 정점을 출력합니다.");
//				graph.depthFirstSearch();
//				break;
//			case 4:
//				System.out.println("너비우선탐색 순서대로 정점을 출력합니다.");
//				graph.breadthFirstSearch();
//				break;
			case 5:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류 - 메뉴를 다시 선택하세요.");
			}
		} while(menu != 5);
	}
}