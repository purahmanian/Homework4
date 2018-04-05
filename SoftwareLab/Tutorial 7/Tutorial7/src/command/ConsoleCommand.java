package command;

public class ConsoleCommand implements Command {

	private Console c;
	private String s;

    public ConsoleCommand(Console c, String s){
	this.c = c;
	this.s = s;
    }

    public void execute(){
	c.print(this.s);
    }

}