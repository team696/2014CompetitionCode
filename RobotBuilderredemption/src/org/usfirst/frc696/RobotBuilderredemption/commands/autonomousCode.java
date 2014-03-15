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
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc696.RobotBuilderredemption.Robot;
import org.usfirst.frc696.RobotBuilderredemption.UtilClasses.Util;

/**
 * S.A.S.H.A; Specific Autonomous Scripting Handiness Algorithm.
 */
public class autonomousCode extends CommandGroup {

    public static Timer timer = new Timer();
    String rawString = "";
    
    public autonomousCode() {
        // addSequential(new driveStraight(0.3,0.3));
        timer.start();
        addParallel(new flashLEDs());
        Robot.driveTrain.resetGyro();
        Robot.driveTrain.resetEncoders();
        //PARSING CODE STARTS
        do {
            rawString = SmartDashboard.getString("rawString", "String Not Found");
            System.out.println(rawString);
        } while (rawString.equals("String Not Found"));
        String parsedCode = Util.removeChar(rawString, " ");
        String[] commands = Util.split(parsedCode, "\n");
        try {
            for (int i = 0; i < commands.length; i++) {

                String[] splitCommand = Util.split(commands[i], ":");
                String command = splitCommand[0];
                double[] args = {0.0, 0.0, 0.0};
                if (splitCommand.length > 1) {
                    String[] argsString = Util.split(splitCommand[1], ",");
                    args = new double[argsString.length];
                    for (int j = 0; j < argsString.length; j++) {
                        args[j] = Double.parseDouble(argsString[j]);
                    }
                }

                if (command.equalsIgnoreCase("setTurnPID")) {
                    if (args.length == 3) {
                        Robot.driveTrain.turnController.setConstants(args[0], args[1], args[2]);
                    }
                } else if (command.equalsIgnoreCase("setMovePID")) {
                    if (args.length == 3) {
                        Robot.driveTrain.moveController.setConstants(args[0], args[1], args[2]);
                    }
                } else if (command.equalsIgnoreCase("driveStraight")) {
                    switch (args.length) {
                        case 0:
                            addSequential(new driveStraight());
                            break;
                        case 1:
                            addSequential(new driveStraight(args[0]));
                            break;
                        case 2:
                            addSequential(new driveStraight(args[0], args[1]));
                            break;

                    }
                } else if (command.equalsIgnoreCase("driveStraightP")) {
                    switch (args.length) {
                        case 0:
                            addParallel(new driveStraight());
                            break;
                        case 1:
                            addParallel(new driveStraight(args[0]));
                            break;
                        case 2:
                            addParallel(new driveStraight(args[0], args[1]));
                            break;

                    }
                }else if (command.equalsIgnoreCase("turn")) {
                    switch (args.length) {
                        case 0:
                            addSequential(new turn());
                            break;
                        case 1:
                            addSequential(new turn(args[0]));
                            break;
                    }
                } else if (command.equalsIgnoreCase("turnToHotGoal")) {
                    switch (args.length) {
                        case 0:
                            addSequential(new turnToHotGoal(30));
                            break;
                        case 1:
                            addSequential(new turnToHotGoal(args[0]));
                            break;
                    }
                } else if (command.equalsIgnoreCase("shoot")) {
                    System.out.println("starting shooting");
                    addSequential(new shoot());
                } else if (command.equalsIgnoreCase("pickupUp")) {
                    addSequential(new pickupUp());
                } else if (command.equalsIgnoreCase("frontPickupUp")) {
                    addSequential(new frontPickupUp());
                }else if (command.equalsIgnoreCase("spinPickup")) {
                     switch (args.length) {
                        case 0:
                            addSequential(new spinPickUp());
                        case 1:
                            addSequential(new spinPickUp(args[0]));
                    }
                    
                } else if (command.equalsIgnoreCase("spinFrontPickup")) {
                     switch (args.length) {
                        case 0:
                            addSequential(new spinFrontPickup());
                        case 1:
                            addSequential(new spinFrontPickup(args[0]));
                    }
                    
                }else if (command.equalsIgnoreCase("pickUpDown")) {
                    addSequential(new pickUpDown());
                } else if (command.equalsIgnoreCase("frontPickupDown")) {
                    addSequential(new frontPickUpDown());
                } else if (command.equalsIgnoreCase("pickupShootPosition")) {
                    addSequential(new pickupShootPosition());
                }else if (command.equalsIgnoreCase("pickupStart")) {
                    addSequential(new startPickup());
                }else if (command.equalsIgnoreCase("frontPickupStart")) {
                    addSequential(new startFrontPickup());
                } else if (command.equalsIgnoreCase("pickupStop")) {
                    addSequential(new stopPickup());
                }else if (command.equalsIgnoreCase("frontPickupStop")) {
                    addSequential(new stopFrontPickup());
                }  else if (command.equalsIgnoreCase("wait")) {
                    switch (args.length) {
                        case 0:
                            addSequential(new wait());
                        case 1:
                            addSequential(new wait(args[0]));
                    }
                } else if (command.equalsIgnoreCase("getHotGoal")) {
                    addSequential(new getHotGoal());
                } else if (command.equalsIgnoreCase("fire")) {
                    addSequential(new fire());
                }
            }
        } catch (Exception ex) {
            System.out.println("Fix the Code Jack!");
        }

        //PARSING CODE ENDS
    }
}
