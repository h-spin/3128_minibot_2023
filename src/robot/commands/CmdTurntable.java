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

package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import shooter subsystem
//import encoder
import robot.subsystems.ShooterSubsystem;
import robot.subsystems.TurretSubsystem;
import robotCore.Encoder;

public class CmdTurntable extends CommandBase {
    //define stuff here, like power, subsystem, etc.
    private TurretSubsystem turntableSubsystem = TurretSubsystem.getInstance();
    private double power;

    public CmdTurntable(TurretSubsystem turntableSubsystem, double power) {
        //parameters include the subsystem and power
        this.power = power;
        this.turntableSubsystem = turntableSubsystem;
        addRequirements(turntableSubsystem);
    }

 
    @Override
    public void initialize() {
        //set power here
        turntableSubsystem.setPower(power);
    }

    @Override
    public void execute() {
        turntableSubsystem.getSpeed();
        //get speed of encoder here using the getEncoder() method from your subsystem
    }

    public boolean isFinished(){
        return false;
    }
    //put isFinished() here 

    @Override
    public void end(boolean interrupted) {

    }
}
