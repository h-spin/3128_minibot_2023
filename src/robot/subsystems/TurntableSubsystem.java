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

import robotCore.Encoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robotCore.Device;
//import encoder, encoder type, and motor (PWMMotor)
//import constantspackage robot.subsystems;
import robotCore.Encoder.EncoderType;
import robotCore.SmartMotor.SmartMotorMode;
import robotCore.PWMMotor;

import robot.Constants.TurnTableConstants;

public class TurntableSubsystem extends SubsystemBase {
	//create encoder and motor objects here
	private PWMMotor m_motor;
	private Encoder m_Encoder;
    private static TurntableSubsystem instance;

    public static synchronized TurntableSubsystem getInstance() {
        if (instance == null) {
            instance = new TurntableSubsystem();
        }
        return instance;
    }

	private TurntableSubsystem() {
		m_motor = new PWMMotor(TurnTableConstants.k_PWMPin, TurnTableConstants.k_DirPin);
		m_Encoder = new Encoder(null, TurnTableConstants.k_encoderIntPin, TurnTableConstants.k_encoderDirPin);
	}

	public void initDefaultCommand() {

	}

	public void setPower(double power){
		m_motor.set(power);
	}

    public double getSpeed(){
        return m_Encoder.getSpeed();
    }

	public Encoder getEncoder(){
        return m_Encoder;
    }

	//set power here

	//get encoder here

	@Override
	public void periodic() {
		
	}
}
