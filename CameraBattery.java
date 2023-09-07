package hw1;

/**
 * 
 * Homework #1 COMS227 Professor Tancretti 2/10/2023
 * 
 * @author ramganesh
 *
 */

public class CameraBattery {

	/*
	 * Number of external charger settings. Settings are numbered between 0
	 * inclusive and 4 exclusive.
	 */
	public static final int NUM_CHARGER_SETTINGS = 4;

	/*
	 * A constant used in calculating the charge rate of the external charger.
	 * 
	 */
	public static final double CHARGE_RATE = 2.0;

	/*
	 * Default power consumption of the camera at the start of simulation.
	 */
	public static final double DEFAULT_CAMERA_POWER_CONSUMPTION = 1.0;

	/*
	 * instance variable to model if battery connected to external charger or camera
	 */
	private int connectedBattery;
	/*
	 * instance variable to keep track of battery starting charge
	 */

	/*
	 * instance variable to keep track of increase in charge for external charging
	 */
	private double externalChargeIncrease;

	/*
	 * instance variable to keep track of increase in charge for camera charging
	 */
	private double totalCharge;

	private double chargerSetting;

	private double totalDrain;

	private int externalChargeSetting;

	private double charge;

	private double consumption;

	private double cameraCharge;

	private double batteryCharge;

	private double batteryCapacity;

	private double drain;

	/**
	 * 
	 * Constructs a new camera battery simulation. The battery should start
	 * disconnected from both the camera and the external charger. The starting
	 * battery charge and maximum charge capacity are given. If the starting charge
	 * exceeds the batteries capacity, the batteries charge is set to its capacity.
	 * The external charger starts at setting 0.
	 * 
	 * @param batteryStartingCharge
	 * @param batteryCapacity
	 */
	public CameraBattery(double batteryStartingCharge, double batteryCapacity) {

		connectedBattery = 0;
		this.batteryCharge = batteryStartingCharge;
		this.batteryCapacity = batteryCapacity;
		cameraCharge = 0.0;
		totalDrain = 0.0;

	}

	/*
	 * Indicates the user has pressed the setting button one time on the external
	 * charger. The charge setting increments by one or if already at the maximum
	 * setting wraps around to setting 0.
	 */
	public void buttonPress() {

		chargerSetting = chargerSetting % NUM_CHARGER_SETTINGS;
		chargerSetting += 1;
		


	}

	/**
	 * Charges the battery connected to the camera (assuming it is connected) for a
	 * given number of minutes. The amount of charging in milliamp-hours (mAh) is
	 * the number minutes times the CHARGE_RATE constant. However, charging cannot
	 * exceed the capacity of the battery connected to the camera, or no charging if
	 * the battery is not connected. The method returns the actual amount the
	 * battery has been charged.
	 * 
	 * @param minutes
	 * @return totalCharge
	 */
	public double cameraCharge(double minutes) {

		totalCharge = minutes * CHARGE_RATE;

		charge = Math.max(totalCharge, this.batteryCapacity);

		return charge;

	}

	/**
	 * Drains the battery connected to the camera (assuming it is connected) for a
	 * given number of minutes. The amount of drain in milliamp-hours (mAh) is the
	 * number of minutes times the cameras power consumption. However, the amount
	 * cannot exceed the amount of charge contained in the battery assuming it is
	 * connected to the camera, or no amount drain if the battery is not connected.
	 * The method returns the actual amount drain from the battery.
	 * 
	 * @param minutes
	 * @return total battery drained from battery connected to camera
	 */
	public double drain(double minutes) {

		connectedBattery = 1;

		totalDrain = minutes * consumption;

		drain = Math.min(0, totalDrain);

		return drain;

	}

	/**
	 * Charges the battery connected to the external charger (assuming it is
	 * connected) for a given number of minutes. The amount of charging in
	 * milliamp-hours (mAh) is the number minutes times the charger setting (a
	 * number between 0 inclusive and NUM_CHARGER_SETTINGS exclusive) the
	 * CHARGE_RATE constant. However, charging cannot exceed the capacity of the
	 * battery connected to the camera, or no charging if the battery is not
	 * connected. The method returns the actual amount the battery has been charged.
	 * 
	 * @param minutes
	 * @return amount required to charge battery by
	 */
	public double externalCharge(double minutes) {

		connectedBattery = 1;

		externalChargeIncrease = minutes * chargerSetting * CHARGE_RATE;

		return externalChargeIncrease;
	}

	/**
	 * Reset the battery monitoring system by setting the total battery drain count
	 * back to 0.
	 */
	public void resetBatteryMonitor() {

		totalDrain = 0;
	}

	/**
	 * Get the battery's capacity.
	 * 
	 * @return battery capacity
	 */
	public double getBatteryCapacity() {

		return this.batteryCapacity;
	}

	/**
	 * Get the battery's current charge.
	 * 
	 * @return battery current charge
	 */
	public double getBatteryCharge() {

		return this.batteryCharge;
	}

	/**
	 * Get the current charge of the camera's battery.
	 * 
	 * @return camera current charge of battery
	 */
	public double getCameraCharge() {

		return cameraCharge;
	}

	/**
	 * 
	 * Get the power consumption of the camera.
	 * 
	 * @return power consumption of camera
	 */
	public double getCameraPowerConsumption() {

		return consumption;
	}

	/**
	 * Get the external charger setting.
	 * 
	 * @return external charger setting
	 */
	public int getChargerSetting() {

		return externalChargeSetting;
	}

	/**
	 * Move the battery to the camera. Updates any variables as needed to represent
	 * the move.
	 */
	public void moveBatteryCamera() {

		cameraCharge = batteryCharge;
		connectedBattery = 1;
	}

	/**
	 * Get the total amount of power drained from the battery since the last time
	 * the battery monitor was started or reset.
	 * 
	 * @return total amoun tof power drained from battery since last time the
	 *         monitor was started or reset
	 */
	public double getTotalDrain() {

		return totalDrain;

	}

	/**
	 * Move the battery to the external charger. Updates any variables as needed to
	 * represent the move.
	 */
	public void moveBatteryExternal() {

		connectedBattery = 1;
	}

	/*
	 * Remove the battery from either the camera or external charger. Updates any
	 * variables as needed to represent the removal.
	 */
	public void removeBattery() {

		connectedBattery = 0;
	}

	/**
	 * Set the power consumption of the camera.
	 * 
	 * @param cameraPowerConsumption
	 */
	public void setCameraPowerConsumption(double cameraPowerConsumption) {

		consumption = cameraPowerConsumption;

	}

}
