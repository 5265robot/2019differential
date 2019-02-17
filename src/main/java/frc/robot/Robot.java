/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.air;
import frc.robot.subsystems.chassis;
import frc.robot.subsystems.lights;
//import frc.robot.subsystems.vision;
import frc.robot.subsystems.networkTableVision;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
     public static chassis m_chassis = new chassis();
     public static lights m_lights = new lights();
     // public static air m_air = new air();
     public static networkTableVision m_networkTableVision = new networkTableVision();
     // public static vision m_vision = new vision();
     public static OI m_oi;

     Command m_autonomousCommand;
     SendableChooser<Command> m_chooser = new SendableChooser<>();

     /**
      * This function is run when the robot is first started up and should be used
      * for any initialization code.
      */
     @Override
     public void robotInit() {
          m_oi = new OI();
          // CameraServer.getInstance().startAutomaticCapture();
          // should we get rid of ALL autonomous commands?
          // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
          // chooser.addOption("My Auto", new MyAutoCommand());
          SmartDashboard.putData("Auto mode", m_chooser);
     }

     /**
      * This function is called every robot packet, no matter the mode. Use this for
      * items like diagnostics that you want ran during disabled, autonomous,
      * teleoperated and test.
      *
      * <p>
      * This runs after the mode specific periodic functions, but before LiveWindow
      * and SmartDashboard integrated updating.
      */
     @Override
     public void robotPeriodic() {
     }

     /**
      * This function is called once each time the robot enters Disabled mode. You
      * can use it to reset any subsystem information you want to clear when the
      * robot is disabled.
      */
     @Override
     public void disabledInit() {
     }

     @Override
     public void disabledPeriodic() {
          Scheduler.getInstance().run();
          // System.out.print("doing vision stuffs");
          // System.out.println(m_vision.getPacketRxRate_PPS());
     }

     /**
      * This autonomous (along with the chooser code above) shows how to select
      * between different autonomous modes using the dashboard. The sendable chooser
      * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
      * remove all of the chooser code and uncomment the getString code to get the
      * auto name from the text box below the Gyro
      *
      * <p>
      * You can add additional auto modes by adding additional commands to the
      * chooser code above (like the commented example) or additional comparisons to
      * the switch structure below with additional strings & commands.
      */
     @Override
     public void autonomousInit() {
          m_autonomousCommand = m_chooser.getSelected();

          /*
           * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
           * switch(autoSelected) { case "My Auto": autonomousCommand = new
           * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
           * ExampleCommand(); break; }
           */

          // schedule the autonomous command (example)
          if (m_autonomousCommand != null) {
               m_autonomousCommand.start();
          }
     }

     /**
      * This function is called periodically during autonomous.
      */
     @Override
     public void autonomousPeriodic() {
          Scheduler.getInstance().run();
     }

     @Override
     public void teleopInit() {
          // This makes sure that the autonomous stops running when
          // teleop starts running. If you want the autonomous to
          // continue until interrupted by another command, remove
          // this line or comment it out.
          if (m_autonomousCommand != null) {
               m_autonomousCommand.cancel();
          }
     }

     /**
      * This function is called periodically during operator control.
      */
     @Override
     public void teleopPeriodic() {
          Scheduler.getInstance().run();
     }

     /**
      * This function is called periodically during test mode.
      */
     @Override
     public void testPeriodic() {
          /*
           * System.out.println("==============+++==============");
           * System.out.print("Vision Online: ");
           * System.out.println(m_vision.isVisionOnline());
           * System.out.print("Target Visible: ");
           * System.out.println(m_vision.isTgtVisible());
           * System.out.print("Target Angle: ");
           * System.out.println(m_vision.getTgtAngle_Deg());
           * System.out.print("Target Range:");
           * System.out.println(m_vision.getTgtRange_in());
           * System.out.print("Serial Packet RX Rate: ");
           * System.out.println(m_vision.getPacketRxRate_PPS());
           * System.out.print("JeVois Framerate: ");
           * System.out.println(m_vision.getJeVoisFramerate_FPS());
           * System.out.print("JeVois CPU Load: ");
           * System.out.println(m_vision.getJeVoisCpuLoad_pct());
           * System.out.println("===============================\n\n\n");
           */

     }
}
