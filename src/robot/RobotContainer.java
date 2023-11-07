/*
 *	  Copyright (C) 2022  John H. Gaby
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, version 3 of the License.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Contact: robotics@gabysoft.com
 */


package robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.team3128.common.hardware.input.NAR_Joystick;
import robotCore.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import robot.subsystems.DriveSubsystem;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;
import robot.subsystems.TurntableSubsystem;
import robot.commands.CmdArcadeDrive;
import robot.commands.CmdFeedAndShoot;
import robot.commands.CmdFeeder;
import robot.commands.CmdShooter;
import robot.commands.CmdTurntable;

//also be sure to import joystick
//import literally everything (all subsystems and commands)

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //you know the drill, define subsystems and joystick
  private DriveSubsystem driveSubsystem = DriveSubsystem.getInstance();
  private FeederSubsystem feederSubsystem = FeederSubsystem.getInstance();
  private ShooterSubsystem shooterSubsystem = ShooterSubsystem.getInstance();
  private TurntableSubsystem turntableSubsystem = TurntableSubsystem.getInstance();
  private NAR_Joystick joystick;

  public RobotContainer() {
    //everything you include here is stuff that you want the minibot to do
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //configure your joystick buttons to each command here!
    
    driveSubsystem.setDefaultCommand(new CmdArcadeDrive(driveSubsystem, joystick));
    joystick.getButton(2).whileTrue(new CmdFeedAndShoot(feederSubsystem, shooterSubsystem, 0, 0));
    joystick.getButton(3).whileTrue(new CmdTurntable(turntableSubsystem, 0.7));
    joystick.getButton(4).whileTrue(new CmdTurntable(turntableSubsystem, -0.7));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
