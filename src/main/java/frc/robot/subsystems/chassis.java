/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.tankDrive;

/**
 * tank drive model of the chassis
 * four individual drive motors
 * in left and right pairs
 */
public class chassis extends Subsystem {
     // instantiate all our motors here

     private final VictorSP motor00 = new VictorSP(0);
     private final VictorSP motor01 = new VictorSP(1);
     private final VictorSP motor02 = new VictorSP(2);
     private final VictorSP motor03 = new VictorSP(3);
     private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(motor00, motor01);
     private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(motor02, motor03);
     private final DifferentialDrive drive00 = new DifferentialDrive(leftMotors, rightMotors);

     // Put methods for controlling this subsystem here

     public chassis() {
          super();
          
          addChild("motor00",motor00);
          addChild("motor01",motor01);
          addChild("motor02",motor02);
          addChild("motor03",motor03);
          addChild("rightMotors",rightMotors);
          addChild("leftMotors",leftMotors);
          addChild("drive00",drive00);
          
          motor00.setInverted(false);
          motor01.setInverted(false);
          motor02.setInverted(false);
          motor03.setInverted(false);
          
          drive00.setSafetyEnabled(false);
          drive00.setExpiration(1.0);
          drive00.setMaxOutput(1.0);
     }

     @Override
     public void initDefaultCommand() {
          // Set the default command for a subsystem here.
          setDefaultCommand(new tankDrive());
     }

     @Override
     public void periodic() {
          // Put code here to be run every loop
     }

     public void driveLeft(double ss){
          drive00.tankDrive(0.0,ss);
     }

     public void driveRight(double ss){
          drive00.tankDrive(ss,00);
     }

     public void driveBoth(double left, double right){
          drive00.tankDrive(left, right);
     }

     public void driveTank(Joystick stick){
          drive00.arcadeDrive(-stick.getY(), -stick.getX());;
     }
}
