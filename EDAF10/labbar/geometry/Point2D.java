/**
 * 
 */
package geometry;

/**
 * @author dat13jkl
 * 
 */
public class Point2D implements Point{

	private double x, y;

	public Point2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point other) {
		double tempx = Math.abs(this.x - ((Point2D)other).x);
		double tempy = Math.abs(this.y - ((Point2D)other).y);
		tempx = Math.pow(tempx, 2);
		tempy = Math.pow(tempy, 2);
		tempx = Math.sqrt(tempx + tempy);
		return tempx;

	}

}
