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
public class TurnLink extends AbstractLink {

	/*
	 * instance variable to get endpoint 1
	 */
	private Point pointA;
	/*
	 * instance variable to get endpoint 2
	 */
	private Point pointB;
	/*
	 * instance variable to get endpoint 3
	 */
	private Point pointC;

	public TurnLink(Point point1, Point point2, Point point3) {

		pointA = point1; // instance variable for endpoint 1 set equal to point1
		pointB = point2; // instance variable for endpoint 2 set equal to point2
		pointC = point3; // instance variable for endpoint 3 set equal to point3

		numPaths(3); // i set my numpaths to 3 since there are 3 points in constructor
		getPoints(point1, point2); // i get my endpoint 1 and endpoint 2 for my shiftpoints in my abstract class
	}

	@Override
	public Point getConnectedPoint(Point point) {

		// get connected point logic is unique for every class and follows rules from
				// javadoc
		if (pointA == point) {

			return pointC;

		} else if (pointB == point) {

			return pointA;

		} else if (pointC == point) {

			return pointA;
		}

		return null;

	}

}
