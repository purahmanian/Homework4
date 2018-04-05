package observer2;

import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Graphics;

public abstract class ColorPanel extends JPanel implements ChangeListener{
    private Color color;
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