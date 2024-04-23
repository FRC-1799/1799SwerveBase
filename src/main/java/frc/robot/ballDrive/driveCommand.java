package frc.robot.ballDrive;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class driveCommand extends RunCommand{
    public driveCommand(ballDrive druve, Supplier<Rotation2d> rotation, DoubleSupplier speed){
        super()
    }
}
