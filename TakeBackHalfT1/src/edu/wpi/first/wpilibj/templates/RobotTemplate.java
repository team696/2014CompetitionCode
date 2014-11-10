/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
     double flyWheelSetSpeed = 0.0;
    Encoder flywheelEncoder = new Encoder(4, 5);
    Talon flywheelMotoTalon1 = new Talon(5);
    Talon flywheelMotorTalon2 = new Talon(2);
    Joystick j = new Joystick(1);
    Timer timer = new Timer();
    
    double targetRPM =0.0;
    double motorPower =0.0;
    double kMaxSpeed =9000.0;
    double tbh = 0.0;
    double lastError = 10.0;
    double gain = 1E-5;
    double error;
    
    double lastTime = 0;
    double time = 0;
    double lastDistance = 0;
    double distance = 0;
    double speed = 0;
    
    boolean lastButton1 = false;
    boolean lastButton2 = false;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
       flywheelEncoder.setDistancePerPulse(.01);
       flywheelEncoder.setReverseDirection(true);
       flywheelEncoder.setSamplesToAverage(ROBOT_TASK_PRIORITY);
       flywheelEncoder.start();
       timer.reset();
       timer.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        gain = SmartDashboard.getNumber("Gain", 1E-5);
        
        if(j.getRawButton(1) && !lastButton1){
            targetRPM += 1000;
            lastError =1;
            tbh = (2* targetRPM/kMaxSpeed)-1;
        }else if(j.getRawButton(2) && !lastButton2){
            targetRPM-=1000;
            lastError = -1;
            tbh = (2* targetRPM/kMaxSpeed)-1;
        }
        
        if(targetRPM <0){
            targetRPM= 0;
        }
        lastButton1 = j.getRawButton(1);
        lastButton2 = j.getRawButton(2);
        lastTime = time;
        time = timer.get();
        lastDistance = distance;
        distance = flywheelEncoder.getDistance();
        
        speed = (distance-lastDistance)/(time-lastTime) *60;
        lastError = error;
        error = targetRPM-speed;
        motorPower +=gain*error;
        motorPower = Util.constrain(motorPower, -1, 1);
        if(lastError>0 != error>0){
            motorPower = 0.5 *(motorPower+tbh);
            tbh = motorPower;
        }
        
        
        flywheelMotoTalon1.set(motorPower);
        flywheelMotorTalon2.set(motorPower);
        
        SmartDashboard.putNumber("Plot 0",speed);
        SmartDashboard.putNumber("Plot 1", targetRPM);
        SmartDashboard.putNumber("Plot 2", motorPower*9000);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
