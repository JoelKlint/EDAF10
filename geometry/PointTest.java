package geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		Point p1 = new Point2D(1, 0);
		Point p2 = new Point2D(1, 1);
		assertEquals("Not True", 1, p1.distanceTo(p2), 1);

		Segment s1 = new Segment(p1, p2);
		assertEquals("Not True", 1, s1.length(), 1);
	}

}
