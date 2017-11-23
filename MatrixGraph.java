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
	//���� �޼ҵ� (������ ����)
	public void addEdge(int vertex1, int vertex2)
	{
		if(vertex1<0|| vertex1>=vertex || vertex2<0 || vertex2>=vertex)
			System.out.println("���� ���Կ��� -�߸��� �����Դϴ�");
		else
		{
			if(matrix[vertex1][vertex2] == 1 )
				System.out.println("���� ���Կ��� -�̹� �����ϴ� �����Դϴ�");
			else
			{
				matrix[vertex1][vertex2] = 1;
				matrix[vertex2][vertex1] = 1;	
			}
		}
	}
	//�� ������ ����ϸ� ������ �޼ҵ���� ���
	public void printAdjacentVertices(int vertex)
	{
		if(vertex<0 || vertex>=this.vertex)
			System.out.println("�߸��� ���� ��ȣ�Դϴ�");
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
