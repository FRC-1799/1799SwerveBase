package frc.robot.ballDrive;

import edu.wpi.first.math.geometry.Twist2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ballDrive extends SubsystemBase{
    ballModule[] modules;
    int moduleCount;
    public ballDrive(ballModule[] modules){
        this.modules=modules;
        this.moduleCount=modules.length;
    }


    public void drive(vector driveVector){
        for(ballModule module:modules){
            module.drive(driveVector);
        }
    }
}
