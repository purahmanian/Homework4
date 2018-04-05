package command;

public class MotorVibrateCommand implements Command{

	private VibrationMotor v;

    public MotorVibrateCommand(VibrationMotor v){
	this.v = v;
    }

    public void execute(){
	v.vibrate();
    }

}