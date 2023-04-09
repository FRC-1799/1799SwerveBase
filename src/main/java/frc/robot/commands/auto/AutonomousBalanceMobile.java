// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Bucket;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class AutonomousBalanceMobile extends SequentialCommandGroup {
  /*
   * pseudoCode:
   * humans will position robot
   * milk crate will tip, releasing cube into lowest zone
   * robot drives forward, getting more auto points
   */

   // Subsystem to Dump Cargo then go forward over charge station
   // and then back up onto charge system to attempt balance

  public AutonomousBalanceMobile(DriveSubsystem drive, IntakeSubsystem intake, Bucket bucket, Gyro gyro) {
    super(
      new WaitCommand(2),
      //dump game piece
      new InstantCommand(
        ()->bucket.set(DoubleSolenoid.Value.kForward),
        bucket
      ),
      new WaitCommand(1),
      //pick up milk crate
      new InstantCommand(
        ()->bucket.set(DoubleSolenoid.Value.kReverse),
        bucket
      ),
      new WaitCommand(1),
      //go forward
      new DriveStraight(drive, 2.7,Constants.auto.fwdSpeed),
      new WaitCommand(1),
      //go back
      new DriveStraight(drive, 3,Constants.auto.revSpeed),
      // balance
      new Balance(drive, gyro)
    );
  }
}