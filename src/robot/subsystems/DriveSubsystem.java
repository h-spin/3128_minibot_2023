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


package robot.subsystems;
import static robot.Constants.DrivetrainConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robotCore.Device;
import robotCore.Encoder;
import robotcore.Encoder.EncoderType;
//import encoder, encoder type, and motor (PWMMotor) 
//import constants from constant folder

public class DriveSubsystem extends SubsystemBase {
  //create motor and encoder objects here
  private final PWMMotor m_leftMotor = new PWMMotor(DrivetrainConstants.k_leftMotorPWMPin, DrivetrainConstants.k_leftMotorDirPin);
  private final PWMMotor m_rightMotor = new PWMMotor(DrivetrainConstants.k_rightMototWPWMPin, DrivetrainConstants.k_rightMotorDirPin);
  private final Encoder m_leftEncoder = new Encoder(EncoderType.Quadrature, DrivetrainConstants.k_leftEncoderIntPin, DrivetrainConstants.k_leftEncoderDirPin);
  private final Encoder m_rightEncoder = new Encoder(EncoderType.Quadrature, DrivetrainConstants.k_rightEncoderIntPin, DrivetrainConstants.k_rightEncoderDirPin);
  
private static DriveSubsystem instance;
public static synchronized DriveSubsystem getInstance(){
  if (instance == null){
    instance = new DriveSubsystem();
  }
  return instance;
}

  public DriveSubsystem() {
    m_leftEncoder.setInverted(true);
    //be sure to set inverted!
  }

  @Override
  public void periodic() {
  // This method will be called once per scheduler run
}

  //set power here! for both motors
public void setPower(double leftPower, double rightPower) {
  m_leftMotor.set(leftPower);
  m_rightMotor.set(rightPower);
}

  //get your encoders here! for both motors
 public Encoder getLeftEncoder(){
  return (m_leftEncoder);
 }
 public Encoder getRightEncoder(){
  return (m_rightEncoder);
 } 
}