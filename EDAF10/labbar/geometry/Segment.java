package geometry;

public class Segment {

	private Point p1, p2;

	public Segment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public double length() {
		return p1.distanceTo(p2);
	}

}
