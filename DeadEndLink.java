package hw4;

import api.Crossable;
import api.Point;
import api.PositionVector;

/**
 * 
 * @author ramganesh
 *
 */
public class DeadEndLink extends AbstractLink {

	public DeadEndLink() {

		numPaths(1); // called my protected method to store numpaths, which in this case is just 1
						// for this class

	}

	@Override
	public void shiftPoints(PositionVector positionVector) {

		// does not do anything
	}

	@Override
	public Point getConnectedPoint(Point point) {

		// does not do anything
		return null;
	}

}
