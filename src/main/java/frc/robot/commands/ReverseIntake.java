package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterProto;
import frc.robot.subsystems.ShooterProto.ToggleShoot;
public class ReverseIntake extends Command{
    private final ShooterProto m_subsystem;
    public ReverseIntake(ShooterProto subsystem){
        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }
    @Override
    public void initialize(){
    }
    @Override
    public void execute(){
      // System.out.println("Running Intake");
      m_subsystem.runIntake(-0.7);

    }   
    @Override
    public void end(boolean interrupted) {
      m_subsystem.stopIntake();
      m_subsystem.stopShooter();
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}
