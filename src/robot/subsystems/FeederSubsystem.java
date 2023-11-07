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
import robotCore.PWMMotor;
import robotCore.SmartMotor.SmartMotorMode;
import robot.Constants.FeederConstants;
//import encoder, encoder type, and motor (PWMMotor) 
//import constants

public class FeederSubsystem extends SubsystemBase {
	//create motor and ecoder objects here
	private PWMMotor m_Motor;
	private Encoder m_Encoder;

    private static FeederSubsystem instance;

    public static synchronized FeederSubsystem getInstance() {
        if (instance == null) {
            instance = new FeederSubsystem();
        }
        return instance;
    }
	private FeederSubsystem() {
		m_Motor = new PWMMotor(FeederConstants.k_PWMPin, FeederConstants.k_DirPin);
		m_Encoder = new Encoder(null, FeederConstants.k_encPin1, FeederConstants.k_encPin2);
	}

	public void setPower(double power){
		m_Motor.set(power);
	}

	public double getSpeed(){
        return m_Encoder.getSpeed();
    }
	//set your motor power here

	//get encoder value here

	public Encoder getEncoder(){
        return m_Encoder;
    }
	
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
