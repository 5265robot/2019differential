/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class lights extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final Talon spike00 = new Talon(9);

  /*public lights() {
     super();
  }
  */

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

     public void greenSwitch(){
          // testing code
          // System.out.println("NOW DOING green stuffs");
          spike00.setSafetyEnabled(false);
          if (spike00.get() == 1.0) {
               spike00.set(0);
          }
          else {
               spike00.set(1.0);
          }
     }

}
