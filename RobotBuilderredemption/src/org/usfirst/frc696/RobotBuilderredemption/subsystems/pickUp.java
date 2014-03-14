// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc696.RobotBuilderredemption.subsystems;
import org.usfirst.frc696.RobotBuilderredemption.RobotMap;
import org.usfirst.frc696.RobotBuilderredemption.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class pickUp extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Solenoid threeInSolenoid = RobotMap.pickUpthreeInSolenoid;
    SpeedController backPickUpRight = RobotMap.pickUpbackPickUpRight;
    Solenoid twoInSolenoid = RobotMap.pickUptwoInSolenoid;
    SpeedController backPickUpLeft = RobotMap.pickUpbackPickUpLeft;
    SpeedController frontPickUpRight = RobotMap.pickUpfrontPickUpRight;
    SpeedController frontPickUpLeft = RobotMap.pickUpfrontPickUpLeft;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void set2InSolenoid(boolean val){
        twoInSolenoid.set(val);
    }
    public void set3InSolenoid(boolean val){
        threeInSolenoid.set(val);
    }
    public void setMotor(double setVal){
        backPickUpRight.set(setVal);
        backPickUpLeft.set(-setVal);
    }
}
