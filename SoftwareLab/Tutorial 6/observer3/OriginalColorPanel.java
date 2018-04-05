package observer3;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;

@SuppressWarnings("serial")
public class OriginalColorPanel extends ColorPanel implements ChangeListener{

	public OriginalColorPanel(Color initialColor) {
		super(initialColor);
		
	}
	
	

	public void stateChanged(ChangeEvent e){
		JSlider slider = (JSlider) e.getSource();
		String name = slider.getName();
		if(name.equals("hue")) {
			this.Hue = (float) slider.getValue()/100;

		}else if(name.equals("sat")) {
			this.Saturation = (float) slider.getValue()/100;
		}else {
			this.Brightness = (float) slider.getValue()/100;
		}
		this.color = Color.getHSBColor(this.Hue, this.Saturation, this.Brightness);
		this.setColor(this.color);
	}

}