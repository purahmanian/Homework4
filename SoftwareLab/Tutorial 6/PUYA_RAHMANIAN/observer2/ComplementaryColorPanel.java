package observer2;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import java.awt.Color;
import java.awt.Graphics;

public class ComplementaryColorPanel extends ColorPanel{

	public ComplementaryColorPanel(Color initialColor) {
		super(initialColor);
	}
	
	public void stateChanged(ChangeEvent e){
		JSlider slider = (JSlider) e.getSource();
		String name = slider.getName();
		if(name.equals("hue")) {
			this.Hue = (float) slider.getValue()/100;
			this.Hue = (float) (this.Hue - 0.5);
		    if(this.Hue < 0){
		    	this.Hue = this.Hue + 1;
		    }
		}else if(name.equals("sat")) {
			this.Saturation = (float) slider.getValue()/100;
		}else {
			this.Brightness = (float) slider.getValue()/100;
		}
		this.setColor(Color.getHSBColor(this.Hue, this.Saturation, this.Brightness));
	}
	
	
}