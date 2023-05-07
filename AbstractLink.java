package hw4;

import api.Crossable;
import api.Point;
import api.PointPair;
import api.PositionVector;

/**
 * 
 * @author ramganesh
 *
 */
public abstract class AbstractLink implements Crossable {

	/*
	 * instance variable for first endpoint
	 */
	private Point pointA;
	/*
	 * instance variable for second endpoint
	 */
	private Point pointB;
	/*
	 * instance variable to check if train entered or exited crossing
	 */
	private boolean trainCrossing;
	/*
	 * instance variable to keep track of num paths for each class
	 */
	private int numberPaths;
	/*
	 * instance variable that stores the pointpair array thats set equal to the
	 * parameter
	 */
	private PointPair[] array;

	public AbstractLink() {

		// all instance variables set to null in constructor, so it resets every time

		pointA = null;
		pointB = null;
		trainCrossing = false;
		array = null;
	}

	public void shiftPoints(PositionVector positionVector) {

		// shift points logic is the same for every class so I implemented this in my
		// abstract class

		trainEnteredCrossing();

		if (trainCrossing) {

			pointA = getConnectedPoint(positionVector.getPointB());

			if (pointA == pointA.getPath().getLowpoint()) {

				pointB = pointA.getPath().getPointByIndex(1);

			} else if (pointA == pointA.getPath().getHighpoint()) {

				pointB = pointA.getPath().getPointByIndex(pointA.getPath().getNumPoints() - 2);
			}

			positionVector.setPointA(pointA);
			positionVector.setPointB(pointB);

		}

		trainExitedCrossing();

	}

	public Point getConnectedPoint(Point point) {

		// get connected point logic for multi switch and multi fix, and overriden in
		// every class since its unique for every class other than multi fix and switch
		for (int i = 0; i < array.length; i++) {

			if (array[i].getPointA() == point) {

				return array[i].getPointB();
			} else if (array[i].getPointB() == point) {

				return array[i].getPointA();
			}
		}

		return null;
	}

	public void trainEnteredCrossing() {

		trainCrossing = true; // boolean to check train entered is set to true

	}

	public void trainExitedCrossing() {

		trainCrossing = false; // boolean to check if train exited is set to false
	}

	public int getNumPaths() {

		return numberPaths; // returns instance int variable I created from my protected method to get the
							// numpaths
	}

	protected void numPaths(int paths) {

		numberPaths = paths; // created my own protected method to keep track of the numpaths for every
								// class. I call this method in the constructor of every sub class and enter the
								// number of paths inside the parameter. Then my instance variable numberpaths
								// is equal to the paths (which is the number inside my numpaths() method. I
								// return number paths in get num paths.

	}

	protected void getPoints(Point point1, Point point2) {

		// my own protected method I created to store the first and second endpoint, so
		// I can use
		// this for my shiftpoints logic in my abstract class
		pointA = point1;
		pointB = point2;

	}

	protected void getArray(PointPair[] pointPair) {

		// my own protected method I created to store the the pointpair array from multi
		// fix and switch link, i created this because I needed the array to implement
		// the logic for get connected points for my multi fix and mutli shift
		array = pointPair;

	}

	protected boolean trainCrossing() {
		// I created protected method to get getter for train crossing to call in multi
		// switch link, to implement my logic for switch connection
		return trainCrossing;
	}

}
