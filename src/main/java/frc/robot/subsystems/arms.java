/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class arms extends Subsystem {
     // Put methods for controlling this subsystem
     // here. Call these from Commands.
     // private DoubleSolenoid piston = new DoubleSolenoid(0, 1);
     private VictorSP spinneyLeft = new VictorSP(6);
     private VictorSP spinneyRight = new VictorSP(7);
     private VictorSP armChainMotor = new VictorSP(8);

     // private DoubleSolenoid airDoubleSolenoid = new DoubleSolenoid(0, 1);

     private boolean rotateIn = true;
     private boolean rotateOn = true;
     private boolean armChainUp = true;
     private double speed = -.28125;
     private double armChainSpeed = 0.2;
     private boolean pistonIn = true;
     private boolean armChainGoingUp = true;
     // private SpeedControllerGroup spinneyGroup = new
     // SpeedControllerGroup(spinneyLeft, spinneyRight);
     // private DifferentialDrive spinney = new DifferentialDrive(spinneyLeft,
     // spinneyRight);

     public arms() {
          super();
          spinneyLeft.setInverted(false);
          spinneyRight.setInverted(false);
          armChainMotor.setInverted(false);
          armChainMotor.setSafetyEnabled(false);
          // spinney.setSafetyEnabled(false);
          // spinney.setExpiration(1.0);
     }

     @Override
     public void initDefaultCommand() {
          // Set the default command for a subsystem here.
          // setDefaultCommand(new MySpecialCommand());
     }

     public void spinBall() {
          // double speed = Robot.m_oi.thrustmaster.getRawAxis(3);
          // String numberAsString = String.format("%f", speed);
          // new Double(speed).toString()
          SmartDashboard.putNumber("spinney speed", speed);

          if (rotateOn) {
               rotateOn = false;
               if (rotateIn) {
                    rotateIn = false;
                    spinneyLeft.setSpeed(-1);
                    spinneyRight.setSpeed(+1);
               } else {
                    rotateIn = true;
                    spinneyLeft.setSpeed(+speed);
                    spinneyRight.setSpeed(-speed);
               }
          } else {
               rotateOn = true;
               spinneyLeft.setSpeed(0);
               spinneyRight.setSpeed(0);
          }
     }

     public void armChainRotate() {
          // SmartDashboard.putNumber("armChainMotor", armChainSpeed);
          // test if off

          if (armChainGoingUp) {
               armChainGoingUp = false;
               if (armChainUp) {
                    armChainUp = false;
                    armChainMotor.setSpeed(armChainSpeed);
               } else {
                    armChainUp = true;
                    armChainMotor.setSpeed(-armChainSpeed);
               }
          } else {
               armChainGoingUp = true;
               armChainMotor.setSpeed(0.0);
          }
          /*
           * if (armChainGoingUp) { if (armChainUp) { // armChainUp = false;
           * armChainGoingUp = false; armChainMotor.setSpeed(armChainSpeed); } else {
           * armChainUp = true; armChainGoingUp = false; armChainMotor.setSpeed(0.0); } }
           * else { if (armChainUp) { armChainMotor.setSpeed(armChainSpeed / 3);
           * armChainUp = false; } // armChainGoingUp = true; else {
           * armChainMotor.setSpeed(0.0); } }
           */
     }

     public void Solly() {
          if (pistonIn) {
               // airDoubleSolenoid.set(Value.kForward);
               pistonIn = false;
          } else {
               // airDoubleSolenoid.set(Value.kReverse);
               pistonIn = true;
          }
     }

     public void deploy() {
          if (pistonIn) {
               // airDoubleSolenoid.set(Value.kForward);
               // pistonfired = false;
          } else {
               // airDoubleSolenoid.set(Value.kReverse);
               // pistonfired = true;
          }

     }
}
