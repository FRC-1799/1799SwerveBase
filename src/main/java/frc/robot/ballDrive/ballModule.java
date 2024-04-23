package frc.robot.ballDrive;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class ballModule {
    private CANSparkMax straifMotor;
    private CANSparkMax forwardMotor;
    public ballModule(int forwardMotorID, int straifMotorID){
        straifMotor=new CANSparkMax(straifMotorID,  MotorType.kBrushless);
        forwardMotor=new CANSparkMax(forwardMotorID,  MotorType.kBrushless);
    }

    public void drive(vector driveVector){
        forwardMotor.set(driveVector.getX());
        straifMotor.set(driveVector.getY());
    }
}
