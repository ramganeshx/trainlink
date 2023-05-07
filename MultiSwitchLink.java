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
public class MultiSwitchLink extends MultiFixedLink {
	// It extends multifixed because multi switch link is the same logic
	// The two methods have identiical logic besides one logic for
	// switchlink which is switchconnection. so, it would extend multi fixed not
	// multi switch. key example of
	// inheritance

	/*
	 * instance variable for my array
	 */
	private PointPair[] array;

	public MultiSwitchLink(PointPair[] connections) {

		super(connections); // called super since my multi switch and multi fix are the same exact classes
							// and that stores my array
		// I am inheriting it for my mutliswitch link, so I call super
		array = connections; // set my array variable to pointpair array

	}

	public void switchConnection(PointPair pointPair, int index) {

		if (!trainCrossing()) { // I called my traincrossing method to see if train entered or exited crossing,
								// and if it exited crossing then switch connections perfroms

			array[index] = pointPair; // this performs the switch connection method because array at index is equal to
										// pointpair

		}
	}

}
