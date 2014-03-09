// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc696.RobotBuilderredemption.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc696.RobotBuilderredemption.Robot;
/**
 *
 */
public class  flashLEDs extends Command {
    double period = 2;
    public flashLEDs() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lEDs);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double cycleTime = autonomousCode.timer.get()%period;
        if(cycleTime >0.1*period&&cycleTime<0.4*period){
            Robot.lEDs.setleds(1.0, 0, 0.5);
        }else if(cycleTime <0.1*period){
            Robot.lEDs.setleds(cycleTime*5, 0, cycleTime*2.5);
        }else if(cycleTime >0.4*period && cycleTime<0.5*period){
            Robot.lEDs.setleds(1-((cycleTime-0.8)*5), 0, 0.5-((cycleTime-0.8)*2.5));
        }else if(cycleTime>0.6*period && cycleTime<0.9*period){
            Robot.lEDs.setleds(0, 1, 0);
        }else if(cycleTime >0.5*period && cycleTime <0.6*period){
            Robot.lEDs.setleds(0, (cycleTime-1)*5, 0);
        }else if(cycleTime >0.9*period && cycleTime <period){
            Robot.lEDs.setleds(0, 1-((cycleTime-1.8)*5), 0);
        }else{
            Robot.lEDs.setleds(1.0, 0, 0.5);
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return autonomousCode.timer.get()>9.8;
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}