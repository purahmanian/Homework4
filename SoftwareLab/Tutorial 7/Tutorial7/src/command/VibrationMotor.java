package command;

// REFACTOR ME. I SHOULD BE A SINGLETON!

public class VibrationMotor {
	static VibrationMotor v = new VibrationMotor();
    public VibrationMotor() {
    }

    public void vibrate() {
	System.out.println("Motor VIBRATE");
    }
    
    public static VibrationMotor getInstance() {
    	return v;
    }
}