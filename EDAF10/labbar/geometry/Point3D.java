/**
 * 
 */
package geometry;

/**
 * @author dat13jkl
 * 
 */
public class Point3D implements Point {

	private double x, y, z;

	public Point3D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see geometry.Point#distanceTo(geometry.Point2D)
	 */
	@Override
	public double distanceTo(Point other) {
		double tempx = Math.abs(this.x - ((Point3D)other).x);
		double tempy = Math.abs(this.y - ((Point3D)other).y);
		double tempz = Math.abs(this.z - ((Point3D)other).z);
		tempx = Math.pow(tempx, 2);
		tempy = Math.pow(tempy, 2);
		tempz = Math.pow(tempz, 2);
		tempx = Math.sqrt(tempx + tempy + tempz);
		return tempx;

	}

}
