package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
//import feeder and shooter subsystems!
//you also need to import something extra since it's a parallel command group

public class CmdFeedAndShoot extends ParallelCommandGroup{

        private FeederSubsystem feederSubsystem = FeederSubsystem.getInstance();
        private ShooterSubsystem shooterSubsystem = ShooterSubsystem.getInstance();
        private double power1;
        private double power2;
        public CmdFeedAndShoot(FeederSubsystem feederSubsystem, ShooterSubsystem shooterSubsystem, double power1, double power2){
            this.feederSubsystem = feederSubsystem;
            this.shooterSubsystem = shooterSubsystem;
            this.power1 = power1;
            this.power2 = power2;
            addCommands(
                new CmdFeeder(feederSubsystem, power1), 
                new CmdShooter(shooterSubsystem, power2)
            );
        }
    }

//no need for end because it contains commands which has end
  

    



