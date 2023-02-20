package frc.robot.subsystems;
/**
 * @author: @bakedPotatoLord
 * this code was blatantly stolen from team 7243. no apologies.
 */

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.LimelightCommand;

public class LimelightSubsystem extends SubsystemBase {
    NetworkTable table =NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");

    public LimelightSubsystem(){
        //idk if this is cringe but i didn't feel like puting this in the RobotContainer
        setDefaultCommand(new LimelightCommand(this));
    }

    public double getX(){
        return tx.getDouble(0);
    }

    public double getY(){
        return ty.getDouble(0);
    }

    public double getA(){
        return ta.getDouble(0);
    }

}
