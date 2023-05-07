package hw4;

import api.Crossable;
import api.Path;
import api.Point;
import api.PositionVector;

/**
 * 
 * @author ramganesh
 *
 */
public class CouplingLink extends AbstractLink {

	/*
	 * instance variable that stores first endpoint
	 */
	private Point pointA;
	/*
	 * instance variable that stores second endpoint
	 */
	private Point pointB;

	public CouplingLink(Point point1, Point point2) {

		pointA = point1; // set my instance for first endpoint to point1
		pointB = point2; // set my instance for second endpoint to point2
		numPaths(2); // call my protected method to find numpaths and set equal to 2 because the
						// number of points in constructor is 2
		getPoints(point1, point2); // need point 1, and point2 for my shiftpoint logic so I call the getPoints
									// method I made to
									// get endpoint1 and endpoint 2

	}

	@Override
	public Point getConnectedPoint(Point point) {

		// get connected point logic is unique for every class and follows rules from
		// javadoc
		if (pointA == point) {

			return pointB;

		} else if (pointB == point) {

			return pointA;

		}

		return null;
	}
}