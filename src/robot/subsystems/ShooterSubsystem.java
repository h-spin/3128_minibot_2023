/*
 *	  Copyright (C) 2016  John H. Gaby
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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robotCore.Device;
import robotCore.Encoder;
import robotCore.Encoder.EncoderType;
import robotCore.SmartMotor.SmartMotorMode;
import robotCore.PWMMotor;
import robot.Constants.ShooterConstants;
//import constants

public class ShooterSubsystem extends SubsystemBase {
//create motor and encoder objects

    private PWMMotor m_motor;
    private Encoder m_Encoder;

    private static ShooterSubsystem instance;

    public static synchronized ShooterSubsystem getInstance() {
        if (instance == null) {
            instance = new ShooterSubsystem();
        }
        return instance;
    }

    private ShooterSubsystem() {
        m_motor = new PWMMotor(ShooterConstants.k_PWMPin, ShooterConstants.k_DirPin);
        m_Encoder = new Encoder(null, ShooterConstants.k_encoderPin1, ShooterConstants.k_encoderPin2);
    }

    public void setPower(double power){//idk
        m_motor.set(power);
        
    }

    public double getSpeed(){
        return m_Encoder.getSpeed();
    }

    public Encoder getEncoder(){
        return m_Encoder;
    }
    @Override
    public void periodic() {
        System.out.println();
        // This method will be called once per scheduler run
    }

    //set power here 

   
}
