package command;

// REFACTOR ME. I SHOULD BE A SINGLETON!

public class Console{
    static Console c = new Console();
    public Console(){
    }

    public void print(String toPrint){
	System.out.println(toPrint);
    }
    
    public static Console getInstance() {
    	return c;
    }
}