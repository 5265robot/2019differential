/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.commands.driveByTime;

/**
 * Add your docs here.
 */
public class air extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final VictorSP motor00 = new VictorSP(0);
     private final VictorSP motor01 = new VictorSP(1);
     private final VictorSP motor02 = new VictorSP(2);
     private final VictorSP motor03 = new VictorSP(3);
     private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(motor00, motor01);
     private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(motor02, motor03);
     private final DifferentialDrive drive00 = new DifferentialDrive(leftMotors, rightMotors);


     public air() {
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
    // setDefaultCommand(new MySpecialCommand());
  }

  public void driveByTime() {
    // Fire Pnuematics
    // Moving Backwards through button command
    drive00.arcadeDrive(-0.1, -0.1);

  }
}
