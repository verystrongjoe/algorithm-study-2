import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/***
 *
 * 
 * 
 * 
 * 
	�ð� ����	�޸� ����
	1.0 ��	512 MB
	����
	2���� ��鿡 N���� ���� �־����� ��, �̵� �� �� ���� ���� ��� ���� �ٰ����� ����µ�, ������ ��� ���� ���ο� �����ϵ��� �� �� �ִ�. �̸� ���� ���� (CONVEX HULL) �̶� �Ѵ�.
	 N���� ���� �־��� �� ���ϲ����� �̷�� ���� ������ ���Ͽ���. ���� ���ϲ����� �̷�� �� ���п� 3�� �̻��� ���� ���Ե� ���, �� �������� ����.

		�Է�
		ù° �ٿ� ���� ���� N�� �־�����(3<=N<=100000). �� ��° �ٺ��� N���� �ٿ� ���� �� ���� x, y��ǥ�� �־�����. ��ǥ�� ������ �־����� ���밪�� 40000�� ���� �ʴ´�. �� ���� ��� �ٸ� ��ġ�� ������ ��� ���� �� �������� �ִ� ���� ����.

		���
		ù° �ٿ� ���ϲ����� �̷�� ���� ������ ����Ѵ�.

		��Ʈ
		�Է� ����

		8
		1 1
		1 2
		1 3
		2 1
		2 2
		2 3
		3 1
		3 2
		��� ����

		5
 * @throws IOException 
 * @throws NumberFormatException 
 */
public class source {
	public static double minX = Double.MAX_VALUE;
	public static double minY = Double.MAX_VALUE;
	public static int minXi =  Integer.MAX_VALUE;
	public static int N;
	public static List<Point>ps;
	public static Stack<Point> s = new Stack<Point>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ps = new ArrayList<Point>();

		for(int i = 0; i < N; i++) {
			String[] splits = br.readLine().split(" ");
			ps.add( new Point( Double.parseDouble(splits[0]), Double.parseDouble(splits[1]) ));
			double px =((Point)ps.get(i)).x;
			if(minX  > px)  { 
				minX = px;
				minXi= i;
			}
		}
		Point minX = ps.get(minXi);
		ps.remove(minXi);
		Collections.sort(ps, new PointComp(minX) );
		
		s.add(ps.get(ps.size()-1));
		s.add(minX);
		
		for(int i =0; i <N-1; i++) {
			while( PointComp.calExpr( s.elementAt(s.size() -2 ), s.lastElement(), ps.get(i) ) <= 0  )  {
				s.pop();
			}
			s.add(ps.get(i));
		}
		System.out.printf("%d", s.size()-1);
	}
}

class PointComp implements Comparator<Point> {
	
	Point minXi;
	
	public PointComp(Point p) {
		this.minXi = p;
	}

	public static  double calExpr(Point i, Point j, Point k) {
		double area1 = i.x*j.y + j.x*k.y + k.x* i.y;
		double area2 = i.y*j.x + j.y*k.x + k.y* i.x;
		return area1-area2;
	}
	
	@Override
	public int compare(Point p1, Point p2) {
		double  d = calExpr(p1, minXi,p2);
		if(d   > 0   ||  (  (d ==0) && getDistance(minXi, p1) > getDistance(minXi, p2) )  ) return 1;
		else return -1;
	}
	public double getDistance(Point i, Point j) {
		double dx = i.x-j.x;
		double dy = i.y-j.y;
		return dx*dx + dy*dy;
	}
}

class Point  {
	double x,y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}