package lab10_1;

public class MatrixGraph 
{
	private int[][] matrix;
	private int vertex;
	
	public MatrixGraph(int vertex)
	{
		matrix = new int[vertex][vertex];
		this.vertex = vertex;
	}
	//삽입 메소드 (정점과 간선)
	public void addEdge(int vertex1, int vertex2)
	{
		if(vertex1<0|| vertex1>=vertex || vertex2<0 || vertex2>=vertex)
			System.out.println("간선 삽입오류 -잘못된 정점입니다");
		else
		{
			if(matrix[vertex1][vertex2] == 1 )
				System.out.println("간선 삽입오류 -이미 존재하는 간선입니다");
			else
			{
				matrix[vertex1][vertex2] = 1;
				matrix[vertex2][vertex1] = 1;	
			}
		}
	}
	//한 정점을 출력하면 인접한 메소드들을 출력
	public void printAdjacentVertices(int vertex)
	{
		if(vertex<0 || vertex>=this.vertex)
			System.out.println("잘못된 정점 번호입니다");
		else
		{
			for(int i=0; i<this.vertex; ++i) 
			{
				if(matrix[vertex][i] == 1)
				{
					System.out.print(i+" ");
				}
			}
			
		}
	}
}
