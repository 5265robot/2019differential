/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class networkTableVision extends Subsystem {
     // Put methods for controlling this subsystem
     // here. Call these from Commands.

     //
     NetworkTableInstance myNT;
     NetworkTable mytable;
     NetworkTableEntry myX;
     NetworkTableEntry myY;

     public networkTableVision() {
          super();

          // Connect NetworkTables, and get access to the default table
          myNT = NetworkTableInstance.getDefault();
          // get (does it also create??) a table by name
          mytable = myNT.getTable("datatable");
          // get (does it also create??) a table entry by name
          myX = mytable.getEntry("X");
          myY = mytable.getEntry("Y");
     }

     @Override
     public void initDefaultCommand() {
          // Set the default command for a subsystem here.
          // setDefaultCommand(new MySpecialCommand());
     }

     public void start() {
          // set a couple of table entries
          myX.setDouble(2.11);
          myY.setBoolean(true);
     }
}
