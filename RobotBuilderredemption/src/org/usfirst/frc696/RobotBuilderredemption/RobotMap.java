// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc696.RobotBuilderredemption;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainfrontLeftTalon;
    public static SpeedController driveTrainrearLeftTalon;
    public static SpeedController driveTrainfrontRightTalon;
    public static SpeedController driveTrainrearRightTalon;
    public static RobotDrive driveTrainRobotDrive;
    public static Gyro driveTrainGyro;
    public static Encoder driveTrainrightEncoder;
    public static Encoder driveTrainleftEncoder;
    public static Solenoid driveTrainshiftingSolenoid;
    public static Compressor driveTraincompressor;
    public static Solenoid pickUpthreeInSolenoid;
    public static SpeedController pickUpbackPickUpRight;
    public static Solenoid pickUptwoInSolenoid;
    public static SpeedController pickUpbackPickUpLeft;
    public static SpeedController frontPickupRight;
    public static SpeedController frontPickupLeft;
    public static Solenoid frontPickupdeploy;
    public static SpeedController shooterchoochooRight;
    public static SpeedController shooterchoochooLeft;
    public static DigitalInput shooterchoochooLimitSwitchLeft;
    public static Solenoid shooterejectSolenoid;
    public static DigitalInput shooterchoochooLimitSwitchRight;
    public static DigitalOutput lEDsred;
    public static DigitalOutput lEDsgreen;
    public static DigitalOutput lEDsblue;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainfrontLeftTalon = new Talon(1, 3);
	LiveWindow.addActuator("DriveTrain", "frontLeftTalon", (Talon) driveTrainfrontLeftTalon);
        
        driveTrainrearLeftTalon = new Talon(1, 5);
	LiveWindow.addActuator("DriveTrain", "rearLeftTalon", (Talon) driveTrainrearLeftTalon);
        
        driveTrainfrontRightTalon = new Talon(1, 6);
	LiveWindow.addActuator("DriveTrain", "frontRightTalon", (Talon) driveTrainfrontRightTalon);
        
        driveTrainrearRightTalon = new Talon(1, 8);
	LiveWindow.addActuator("DriveTrain", "rearRightTalon", (Talon) driveTrainrearRightTalon);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainfrontLeftTalon, driveTrainrearLeftTalon,
              driveTrainfrontRightTalon, driveTrainrearRightTalon);
	
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        driveTrainGyro = new Gyro(1, 1);
	LiveWindow.addSensor("DriveTrain", "Gyro", driveTrainGyro);
        driveTrainGyro.setSensitivity(0.007);
        driveTrainrightEncoder = new Encoder(1, 2, 1, 3, false, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "rightEncoder", driveTrainrightEncoder);
        driveTrainrightEncoder.setDistancePerPulse(1.0);
        driveTrainrightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainrightEncoder.start();
        driveTrainleftEncoder = new Encoder(1, 4, 1, 5, true, EncodingType.k4X);
	LiveWindow.addSensor("DriveTrain", "leftEncoder", driveTrainleftEncoder);
        driveTrainleftEncoder.setDistancePerPulse(1.0);
        driveTrainleftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainleftEncoder.start();
        driveTrainshiftingSolenoid = new Solenoid(1, 5);
	LiveWindow.addActuator("DriveTrain", "shiftingSolenoid", driveTrainshiftingSolenoid);
        
        driveTraincompressor = new Compressor(1, 1, 1, 1);
	
        
        pickUpthreeInSolenoid = new Solenoid(1, 2);
	LiveWindow.addActuator("pickUp", "threeInSolenoid", pickUpthreeInSolenoid);
        
        pickUpbackPickUpRight = new Talon(1, 10);
	LiveWindow.addActuator("pickUp", "backPickUpRight", (Talon) pickUpbackPickUpRight);
        
        pickUptwoInSolenoid = new Solenoid(1, 1);
	LiveWindow.addActuator("pickUp", "twoInSolenoid", pickUptwoInSolenoid);
        
        pickUpbackPickUpLeft = new Talon(1, 1);
	LiveWindow.addActuator("pickUp", "backPickUpLeft", (Talon) pickUpbackPickUpLeft);
        
        frontPickupRight = new Talon(1, 7);
	LiveWindow.addActuator("frontPickup", "Right", (Talon) frontPickupRight);
        
        frontPickupLeft = new Talon(1, 4);
	LiveWindow.addActuator("frontPickup", "Left", (Talon) frontPickupLeft);
        
        frontPickupdeploy = new Solenoid(1, 3);
	LiveWindow.addActuator("frontPickup", "deploy", frontPickupdeploy);
        
        shooterchoochooRight = new Talon(1, 9);
	LiveWindow.addActuator("shooter", "choochooRight", (Talon) shooterchoochooRight);
        
        shooterchoochooLeft = new Talon(1, 2);
	LiveWindow.addActuator("shooter", "choochooLeft", (Talon) shooterchoochooLeft);
        
        shooterchoochooLimitSwitchLeft = new DigitalInput(1, 9);
	LiveWindow.addSensor("shooter", "choochooLimitSwitchLeft", shooterchoochooLimitSwitchLeft);
        
        shooterejectSolenoid = new Solenoid(1, 4);
	LiveWindow.addActuator("shooter", "ejectSolenoid", shooterejectSolenoid);
        
        shooterchoochooLimitSwitchRight = new DigitalInput(1, 10);
	LiveWindow.addSensor("shooter", "choochooLimitSwitchRight", shooterchoochooLimitSwitchRight);
        
        lEDsred = new DigitalOutput(1, 7);
	
        
        lEDsgreen = new DigitalOutput(1, 8);
	
        
        lEDsblue = new DigitalOutput(1, 6);
	
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    public static class driveTrainRobotDrive {
        public driveTrainRobotDrive() {
        }
    }
}
