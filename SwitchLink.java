package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

/**
 * 
 * @author ramganesh
 *
 */
public class SwitchLink extends AbstractLink {

	/*
	 * instance variable for endpoint 1
	 */
	private Point pointA;
	/*
	 * instance variable for endpoint 2
	 */
	private Point pointB;
	/*
	 * instance variable for endpoint 3
	 */
	private Point pointC;
	/*
	 * instance variable to see if turn is set or not
	 */
	private boolean getTheTurn;

	public SwitchLink(Point point1, Point point2, Point point3) {

		pointA = point1; // instance variable for endpoint 1 set equal to point1
		pointB = point2; // instance variable for endpoint 2 set equal to point2
		pointC = point3; // instance variable for endpoint 3 set equal to point3
		numPaths(3); // I set my numpaths
		getPoints(point1, point2); // I get my endpoint 1 and endpoint 2 for my shiftpoints in abstract
	}

	public void setTurn(boolean turn) {

		getTheTurn = turn; // i set my boolean turn to parameter turn
	}

	@Override
	public Point getConnectedPoint(Point point) {

		// get connected point logic is unique for every class and follows rules from
				// javadoc
		if (getTheTurn && pointA == point) {

			return pointC;

		} else if (!getTheTurn && pointA == point) {

			return pointB;

		} else {
			return pointA;
		}

	}

}
