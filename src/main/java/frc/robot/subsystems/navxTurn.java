/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class navxTurn extends PIDSubsystem {
     /**
      * Add your docs here.
      */

     public navxTurn() {
          // Intert a subsystem name and PID values here
          super("navxTurn", 2.3, 0.00, 0.00, 0.5);
          // Use these to get going:
          // setSetpoint() - Sets where the PID controller should move the system
          // to
          // enable() - Enables the PID controller.
          setAbsoluteTolerance(4.0);
          // getPIDController().setContinuous(true);
          setInputRange(-180.0, 180.0);
          setOutputRange(-1.0, 1.0);
          setSetpoint(0.0);
          // getPIDController().

     }

     @Override
     public void initDefaultCommand() {
          // Set the default command for a subsystem here.
          // setDefaultCommand(new MySpecialCommand());
     }

     @Override
     protected double returnPIDInput() {
          // Return your input value for the PID loop
          // e.g. a sensor, like a potentiometer:
          // yourPot.getAverageVoltage() / kYourMaxVoltage;
          return Robot.m_chassis.gyro.pidGet();
     }

     @Override
     protected void usePIDOutput(double output) {
          // Use output to drive your system, like a motor
          // e.g. yourMotor.set(output);
          System.out.println("gyro " + Robot.m_chassis.gyro.pidGet() + " out " + output + " repeat rate "
                    + getPIDController().kDefaultPeriod);
          Robot.m_chassis.driveBoth(output, -output);
     }
}
