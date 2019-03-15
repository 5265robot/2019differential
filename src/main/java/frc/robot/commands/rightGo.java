/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class rightGo extends Command {

     private double zero = 0.0;
     private double time = 0.5;
     private double speed = 0.5;

     public rightGo() {
          // Use requires() here to declare subsystem dependencies
          // eg. requires(chassis);
          requires(Robot.m_chassis);
     }

     // Called just before this Command runs the first time
     @Override
     protected void initialize() {
          Robot.m_chassis.Lightright();
     }

     // Called repeatedly when this Command is scheduled to run
     @Override
     protected void execute() {
     }

     // Make this return true when this Command no longer needs to run execute()
     @Override
     protected boolean isFinished() {
          return isTimedOut();
     }

     // Called once after isFinished returns true
     @Override
     protected void end() {
     }

     // Called when another command which requires one or more of the same
     // subsystems is scheduled to run
     @Override
     protected void interrupted() {
     }
}