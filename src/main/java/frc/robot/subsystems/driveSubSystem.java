import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SwerveConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain;

public class driveSubSystem extends SubsystemBase{
    public SwerveDrivetrain swerve = new SwerveDrivetrain(
        SwerveConstants.driveTrainStuff.swerveDriveTrainConstants, SwerveConstants.frontLeft.ModuleConstants,
        SwerveConstants.frontRight.ModuleConstants, SwerveConstants.backLeft.ModuleConstants, SwerveConstants.backRight.ModuleConstants);
    public driveSubSystem(){
        
    }
}