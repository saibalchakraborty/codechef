package january.longchallenge;

import java.util.Scanner;

public class PointOfImpact {

	//TLE
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			long t = sc.nextLong();
			for (long i = 0; i < t; i++) {
				long n = sc.nextLong();
				long k = sc.nextLong();
				long x = sc.nextLong();
				long y = sc.nextLong();
				Point prev = new Point(x, y);
				Point current = new Point(x + 1, y + 1);
				current.prev = prev;
				Point cornerEdge;
				Point[] edgeVertices = new Point[4];
				boolean resultPrinted = false;
				for (int z = 0; z < 4; z++) {
					cornerEdge = getEdgeVertex(current, n);
					if (!validateCornerEdge(cornerEdge, n)) {
						System.out.println(cornerEdge.x + " " + cornerEdge.y);
						resultPrinted = true;
						break;
					}
					edgeVertices[z] = cornerEdge;
					current = prepareCurrentPoint(cornerEdge, n);
				}
				if(!resultPrinted) {
					int counter = 0;
					while(k > 0) {
						if(counter == 4) {
							counter = 0;
						}
						k--;
						counter ++;
					}
					System.out.println(edgeVertices[counter - 1].x + " " + edgeVertices[counter - 1].y);
				}
			}
		} catch (

		Exception e) {
			return;
		} finally {
			sc.close();
		}
	}

	private static boolean validateCornerEdge(Point cornerEdge, long n) {
		if ((cornerEdge.x == 0 && cornerEdge.y == 0) || (cornerEdge.x == n && cornerEdge.y == n)
				|| (cornerEdge.x == 0 && cornerEdge.y == n) || (cornerEdge.x == n && cornerEdge.y == 0)) {
			return false;
		}
		return true;
	}

	private static Point prepareCurrentPoint(Point cornerEdge, long n) {
		Point newPoint = new Point();
		if (cornerEdge.x == 0 || cornerEdge.x == n) {
			newPoint.prev = cornerEdge;
			newPoint.x = cornerEdge.prev.x;
			newPoint.y = ((cornerEdge.y > cornerEdge.prev.y) ? (cornerEdge.y + 1) : (cornerEdge.y - 1));
		}
		if (cornerEdge.y == 0 || cornerEdge.y == n) {
			newPoint.prev = cornerEdge;
			newPoint.y = cornerEdge.prev.y;
			newPoint.x = ((cornerEdge.x > cornerEdge.prev.x) ? (cornerEdge.x + 1) : (cornerEdge.x - 1));
		}
		return newPoint;
	}

	private static Point getEdgeVertex(Point current, long n) {
		if (current.x == 0 || current.x == n || current.y == 0 || current.y == n) {
			return current;
		}
		Point p = new Point(current.x, current.y);
		p.prev = current.prev;
		while (true) {
			Point newPoint = new Point();
			newPoint.prev = p;
			newPoint.x = p.x + (p.x - p.prev.x);
			newPoint.y = p.y + (p.y - p.prev.y);
			p = new Point(newPoint.x, newPoint.y);
			p.prev = newPoint.prev;
			newPoint = null;
			if (p.x == 0 || p.x == n || p.y == 0 || p.y == n) {
				break;
			}
		}
		return p;
	}

}

class Point {
	long x;
	long y;
	Point prev;

	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}