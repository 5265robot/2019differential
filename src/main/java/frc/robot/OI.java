/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.cameraActivate;
import frc.robot.commands.cameraExposureFlip;
import frc.robot.commands.leftGo;
import frc.robot.commands.networkTableStart;
import frc.robot.commands.printCurrentAngle;
import frc.robot.commands.rightGo;
import frc.robot.commands.ringLight;
import frc.robot.commands.rotateToSomeAngle;
import frc.robot.commands.zeroResetNavX;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

     public Joystick thrustmaster;

     private JoystickButton lightSwitch;
     private JoystickButton cameraSwitch;
     private JoystickButton testNetworkTable;
     private JoystickButton exposureSwitch;
     private JoystickButton rotateTo90;
     private JoystickButton rotateTo00;
     private JoystickButton zeroGyro;
     private JoystickButton printGyro;
     private JoystickButton leftShift;
     private JoystickButton rightShift;

     private POVButton turn0;
     private POVButton turn90;
     private POVButton turn180;
     private POVButton turnNeg90;
     private POVButton turn29;
     private POVButton turn151;
     private POVButton turnNeg29;
     private POVButton turnNeg151;

     public OI() {
          thrustmaster = new Joystick(0);

          lightSwitch = new JoystickButton(thrustmaster, 6);
          testNetworkTable = new JoystickButton(thrustmaster, 8);
          cameraSwitch = new JoystickButton(thrustmaster, 07);
          exposureSwitch = new JoystickButton(thrustmaster, 05);
          rotateTo90 = new JoystickButton(thrustmaster, 9);
          rotateTo00 = new JoystickButton(thrustmaster, 10);
          zeroGyro = new JoystickButton(thrustmaster, 11);
          printGyro = new JoystickButton(thrustmaster, 12);
          leftShift = new JoystickButton(thrustmaster, 2);
          rightShift = new JoystickButton(thrustmaster, 4);

          turn0 = new POVButton(thrustmaster, 0);
          turn90 = new POVButton(thrustmaster, 90);
          turn180 = new POVButton(thrustmaster, 180);
          turnNeg90 = new POVButton(thrustmaster, 270);
          turn151 = new POVButton(thrustmaster, 45);
          turn29 = new POVButton(thrustmaster, 135);
          turnNeg29 = new POVButton(thrustmaster, 315);
          turnNeg151 = new POVButton(thrustmaster, 225);

          lightSwitch.whenPressed(new ringLight());
          testNetworkTable.whenPressed(new networkTableStart());
          cameraSwitch.whenPressed(new cameraActivate());
          exposureSwitch.whenPressed(new cameraExposureFlip());

          turn0.whenPressed(new rotateToSomeAngle(0.0));
          turn90.whenPressed(new rotateToSomeAngle(90.0));
          turnNeg90.whenPressed(new rotateToSomeAngle(-90.0));
          turnNeg29.whenPressed(new rotateToSomeAngle(-29.0));
          turnNeg151.whenPressed(new rotateToSomeAngle(-151.0));
          turn29.whenPressed(new rotateToSomeAngle(29.0));
          turn180.whenPressed(new rotateToSomeAngle(179.5));
          turn151.whenPressed(new rotateToSomeAngle(151.0));

          zeroGyro.whenPressed(new zeroResetNavX());
          printGyro.whenPressed(new printCurrentAngle());
          leftShift.whenPressed(new leftGo());
          rightShift.whenPressed(new rightGo());
     }

     public Joystick getThrustmaster() {
          return thrustmaster;
     }

}
