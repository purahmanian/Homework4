package observer3;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public abstract class ColorPanel extends JPanel{
    Color color;
    float Hue = (float) .5;
    float Saturation = (float) 0.5;
    float Brightness = (float) .5;
    
    public ColorPanel(Color initialColor){
    	this.color = initialColor;
    }

    public void setColor(Color newColor){
	this.color = newColor;
	repaint();
    }

    protected void paintComponent(Graphics g){
	this.setBackground(color);
	super.paintComponent(g);
    }
}