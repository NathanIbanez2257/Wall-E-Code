// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveSubsystem;

public class driveCommand extends CommandBase {
  private final driveSubsystem sDrive;
  double rightSpeed, leftSpeed;
  /** Creates a new driveCommand. */
  public driveCommand(driveSubsystem drive, double leftSpeeds, double rightSpeeds) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    sDrive = drive;
    addRequirements(drive);
    leftSpeed = leftSpeeds;
    rightSpeed = rightSpeeds;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    sDrive.tankDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
