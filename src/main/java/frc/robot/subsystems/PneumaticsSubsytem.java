package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsytem extends SubsystemBase{
  
  PneumaticHub hub = new PneumaticHub();

  Compressor compressor = hub.makeCompressor();

  public PneumaticsSubsytem(){
    compressor.enableDigital();
  }

  public Compressor getCompressor(){
    return compressor;
  }

  public void toggleCompressor(){
    if(compressor.isEnabled()){
      compressor.disable();
      // display Compressor Data
      SmartDashboard.putData(compressor);

    }else{
      compressor.enableDigital();
      SmartDashboard.putData(compressor);
    }
  }

  public DoubleSolenoid makeDoubleSolenoid(int fwdPort,int revPort){
    return hub.makeDoubleSolenoid(fwdPort, revPort);
  }

  public Solenoid makeSolenoid(int port){
    return hub.makeSolenoid(port);
  }
}
