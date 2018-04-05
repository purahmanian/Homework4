package observer3;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@SuppressWarnings("serial")
public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener{

	public ComplementaryColorPanel(Color initialColor, OriginalColorPanel o) {
		super(initialColor);
		o.addPropertyChangeListener(this);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		ColorPanel orig = (ColorPanel) evt.getSource();
	    this.Hue = orig.Hue - (float)0.5;
	    if(this.Hue < 0){
	    		this.Hue = this.Hue + 1;
	    }
	    this.setColor(Color.getHSBColor(this.Hue, orig.Saturation, orig.Brightness));
		
	}
	
	
}