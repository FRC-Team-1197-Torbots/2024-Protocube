package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterProto;
public class RunShooter extends Command{
    private final ShooterProto m_subsystem;
    public RunShooter(ShooterProto subsystem){
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }
    @Override
    public void initialize(){
      m_subsystem.runMotors(0.6);
    }
    @Override
    public void execute(){
        //m_subsystem.runMotors(0.9);
    }   
    @Override
    public void end(boolean interrupted) {
      m_subsystem.stopMotors();
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}
