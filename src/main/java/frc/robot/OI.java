/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.armChainTwist;
import frc.robot.commands.ballIntake;
import frc.robot.commands.cameraActivate;
import frc.robot.commands.cameraExposureFlip;
//import frc.robot.commands.cameraActivate;
//import frc.robot.commands.cameraExposureFlip;
import frc.robot.commands.hatchReleaseBackup;
import frc.robot.commands.liftup;
import frc.robot.commands.networkTableStart;
import frc.robot.commands.pistonfire;
import frc.robot.commands.ringLight;
import frc.robot.commands.SoLlY;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
     //// CREATING BUTTONS
     // One type of button is a joystick button which is any button on a
     //// joystick.
     // You create one by telling it which joystick it's on and which button
     // number it is.
     // Joystick stick = new Joystick(port);
     // Button button = new JoystickButton(stick, buttonNumber);

     // There are a few additional built in buttons you can use. Additionally,
     // by subclassing Button you can create custom triggers and bind those to
     // commands the same as any other Button.

     //// TRIGGERING COMMANDS WITH BUTTONS
     // Once you have a button, it's trivial to bind it to a button in one of
     // three ways:

     // Start the command when the button is pressed and let it run the command
     // until it is finished as determined by it's isFinished method.
     // button.whenPressed(new ExampleCommand());

     // Run the command while the button is being held down and interrupt it once
     // the button is released.
     // button.whileHeld(new ExampleCommand());

     // Start the command when the button is released and let it run the command
     // until it is finished as determined by it's isFinished method.
     // button.whenReleased(new ExampleCommand());

     // THRUSTMASTER button number converted to driver station input number
     private static final int bt_01 = 6;
     private static final int bt_02 = 5;
     private static final int bt_03 = 12;
     private static final int bt_04 = 11;
     private static final int bt_05 = 1;
     private static final int bt_06 = 2;
     private static final int bt_07 = 3;
     private static final int bt_08 = 4;
     private static final int bt_09 = 8;
     private static final int bt_10 = 7;
     private static final int bt_11 = 9;
     private static final int bt_12 = 10;
     private static final int bt_13 = 13;
     // private static final int bt_14 = 5;

     public Joystick thrustmaster;
     // private JoystickButton leftDrive;
     // private JoystickButton rightDrive;
     // private JoystickButton humanCamera;
     private JoystickButton lightSwitch;
     private JoystickButton cameraSwitch;
     private JoystickButton testNetworkTable;
     private JoystickButton exposureSwitch;
     private JoystickButton hatch;
     private JoystickButton slider;
     private JoystickButton armChainButton;
     private JoystickButton Solenoid;
     private JoystickButton liftButton;
     private JoystickButton BEGONETHOT;

     public OI() {
          thrustmaster = new Joystick(0);

          lightSwitch = new JoystickButton(thrustmaster, 10);
          testNetworkTable = new JoystickButton(thrustmaster, 8);
          cameraSwitch = new JoystickButton(thrustmaster, 07);
          exposureSwitch = new JoystickButton(thrustmaster, 05);
          hatch = new JoystickButton(thrustmaster, 06);
          slider = new JoystickButton(thrustmaster, 01);
          armChainButton = new JoystickButton(thrustmaster, 2);
          Solenoid = new JoystickButton(thrustmaster, 11);
          BEGONETHOT = new JoystickButton(thrustmaster, 3);

          // lightSwitch.whenPressed(new ringLight());
          // testNetworkTable.whenPressed(new networkTableStart());
          // cameraSwitch.whenPressed(new cameraActivate());// cameraActivate());
          // exposureSwitch.whenPressed(new cameraExposureFlip());//
          // cameraExposureFlip());
          hatch.whenPressed(new hatchReleaseBackup());
          slider.whenPressed(new ballIntake());
          armChainButton.whenPressed(new armChainTwist());
          Solenoid.whenPressed(new SoLlY());
          BEGONETHOT.whenReleased(new pistonfire());
     }

     public Joystick getThrustmaster() {
          return thrustmaster;
     }

}
