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
public class MultiFixedLink extends AbstractLink {

	/*
	 * instance variable to store the pointpair array
	 */
	private PointPair[] array;

	public MultiFixedLink(PointPair[] connections) {

		numPaths(connections.length); // my number of paths is the array length, so I call my method to store numpaths
										// and my parameter inside is my constructor which is my array length
		array = connections; // I set my instance variable to store my array equal to connections
		getArray(array); // my protected method to get the array so I can use that for my get connected
							// points in my abstract class for multi switch and fix
	}

}
