// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class intakeSubsystem extends SubsystemBase 
{
  Victor rightIntake = new Victor(Constants.rightIntake), leftIntake = new Victor(Constants.leftIntake);

private int ddirectionDecider;
  public void intakeIn(int directionDecider)
  {
    ddirectionDecider = directionDecider;
    
    rightIntake.set(ddirectionDecider * Constants.intakeSpeed);
    leftIntake.set(ddirectionDecider * -Constants.intakeSpeed);
  }

  public void Stop()
  {
    rightIntake.set(0);
    leftIntake.set(0);
  }

 

  /** Creates a new intakeSubsystem. */
  public intakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
