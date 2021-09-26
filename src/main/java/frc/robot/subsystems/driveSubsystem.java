// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveSubsystem extends SubsystemBase 
{

  Victor leftBack, leftFront, rightBack, rightFront;
  SpeedControllerGroup rightSide, leftSide;
  DifferentialDrive drive;


  /** Creates a new driveSubsystem. */
  public driveSubsystem() 
  {
    this.leftBack = new Victor(0);
    this.leftFront = new Victor(5);
    this.rightFront= new Victor(8);
    this.rightBack= new Victor(3);
    this.rightSide = new SpeedControllerGroup(rightBack, rightFront);
    this.leftSide = new SpeedControllerGroup(leftBack, leftFront);
    this.drive = new DifferentialDrive(leftSide, rightSide);



  }

  public void tankDrive(double leftJoystick, double rightJoystick)
  {
    double leftSpeed = leftJoystick, rightSpeed = rightJoystick;

    drive.tankDrive(leftSpeed, rightSpeed);
    
  }




  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
