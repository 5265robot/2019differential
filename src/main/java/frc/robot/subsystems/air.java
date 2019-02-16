/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class air extends Subsystem {
     // Put methods for controlling this subsystem
     // here. Call these from Commands.
     private DoubleSolenoid piston = new DoubleSolenoid(0, 1);

     public air() {
          super();

     }

     @Override
     public void initDefaultCommand() {
          // Set the default command for a subsystem here.
          // setDefaultCommand(new MySpecialCommand());
     }

     public void hatchRelease() {
          // Fire Pnuematics
          // Moving Backwards through button command
          if (piston.get() == Value.kForward) {
               piston.set(Value.kReverse);
          } else {
               piston.set(Value.kForward);
          }
     }

}
