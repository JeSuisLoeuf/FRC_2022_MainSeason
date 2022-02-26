package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drivetrain.commands.UseCompressor;

public class Pneumatics extends SubsystemBase {
    private PneumaticHub compressor;

    public Pneumatics(){
        compressor = new PneumaticHub(1);
        compressor.clearStickyFaults();
        compressor.enableCompressorDigital();

        initDefaultCommand();
    }

    private void initDefaultCommand(){
        setDefaultCommand(new UseCompressor(this));
    }

    public DoubleSolenoid getDoubleSolenoid(int port1, int port2) {
        return compressor.makeDoubleSolenoid(port1, port2);
    }

    public double getPressure() {
        return compressor.getPressure(1);
    }

    public boolean pressureSwitchTripped() {
        return compressor.getPressureSwitch();
    }

    public void compressorOff() {
        compressor.disableCompressor();
    }
    public void compressorOn(){
        compressor.enableCompressorDigital();
    }
}