/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
//import frc.robot.subsystems.networkTableVision;

/**
 * Add your docs here.
 */
public class networkTableStart extends InstantCommand {
     /**
      * Currently, just initializes some values in the network table for testing
      */
     public networkTableStart() {
          super();
          // Use requires() here to declare subsystem dependencies
          // eg. requires(chassis);
          requires(Robot.m_networkTableVision);
     }

     // Called once when the command executes
     @Override
     protected void initialize() {
          Robot.m_networkTableVision.start();
     }

}
