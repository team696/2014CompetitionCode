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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc696.RobotBuilderredemption.Robot;
import org.usfirst.frc696.RobotBuilderredemption.subsystems.shooter;
/**
 *
 */
public class  fire extends Command {
    Timer shootTimer = new Timer();
    public fire() {
        System.out.println("shooting");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooter);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.shooter.runChooChoo(0.7);
        shootTimer.start();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shooter.runChooChoo(0.7);
        System.out.println(Robot.shooter.getSwitch() +  "   " + Robot.shooter.getSwitch2());
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println((!Robot.shooter.getSwitch()&&(shootTimer.get()>0.4)) || shootTimer.get()>1.5);
        if((Robot.shooter.getSwitch()&&(shootTimer.get()>0.4)) || shootTimer.get()>1.5){
            Robot.shooter.stopChooChoo();
            System.out.println(Robot.shooter.getSwitch() + "  " + Robot.shooter.getSwitch2());
            return true;
        }
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.shooter.stopChooChoo();
    }
}
