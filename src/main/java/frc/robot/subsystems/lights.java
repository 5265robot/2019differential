/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.hal.sim.mockdata.RelayDataJNI;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class lights extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final Relay spike00 = new Relay(0);


  public lights() {
     super();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void greenSwitch(){
     if (spike00.get() == Value.kOff) {
          spike00.set(Value.kOn);
     }
     else {
          spike00.set(Value.kOff);
     }
  }

}
