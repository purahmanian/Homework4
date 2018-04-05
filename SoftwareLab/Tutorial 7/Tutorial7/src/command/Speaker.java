package command;

// REFACTOR ME. I SHOULD BE A SINGLETON!

public class Speaker {
	static Speaker s = new Speaker();
    public Speaker() {
    }

    public void beep() {
	System.out.println("Speaker BEEP!");
    }
    
    public static Speaker getInstance() {
    	return s;
    }
}