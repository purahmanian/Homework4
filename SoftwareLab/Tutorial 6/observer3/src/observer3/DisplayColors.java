package observer3;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

public class DisplayColors {

    public static void main(String[] args) {
	SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }

    protected OriginalColorPanel originalColorPanel;
    protected ComplementaryColorPanel complementaryColorPanel;

    protected JSlider hueSlider;
    protected JSlider saturationSlider;
    protected JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;

    protected JPanel colorsPanel() {
	    JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		originalColorPanel = (OriginalColorPanel) createOriginalColorPanel(Color.getHSBColor(0,(float).5,(float).5));
		p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
		complementaryColorPanel = (ComplementaryColorPanel) createComplementaryColorPanel(Color.getHSBColor((float).5, (float).5, (float).5));
		p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));
		
		return p;
	}

    protected JPanel mainPanel() {
	JPanel p = new JPanel();
	p.setLayout(new GridLayout(2,1));
	JPanel colorsPanel = colorsPanel();
	JPanel subP = new JPanel();
	subP.setLayout(new GridLayout(3,1));
	hueSlider = slider("hue");
	subP.add(sliderBox("H", hueSlider, hueValueLabel));
	saturationSlider = slider("sat");
	saturationSlider.setValue(50);
	subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
	brightnessSlider = slider("bright");
	brightnessSlider.setValue(50);
	subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
	p.add(subP);
	p.add(colorsPanel);
	return p;
    }

    private JSlider slider(String name){
		JSlider slider = new JSlider();
		// WHAT GOES HERE?
		// You need to make it possible for the app to get the slider values out.
		

		slider.setName(name);
		slider.addChangeListener(originalColorPanel);
		return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel){
	if(valueLabel == null){
	    valueLabel = new JLabel();
	    valueLabel.setFont(SwingFacade.getStandardFont());
	    valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	    valueLabel.setForeground(java.awt.Color.black);
	}
	Box b = Box. createHorizontalBox();
	JLabel label = new JLabel(sliderLabel);
	label.setFont(SwingFacade.getStandardFont());
	label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	label.setForeground(java.awt.Color.black);
	b.add(label);
	b.add(valueLabel);
	b.add(slider);
	b.setPreferredSize(new Dimension(600, 50));
	return b;
    }
/*
    protected ColorPanel createColorPanel(Color initialColor){
	ColorPanel colorPanel = new ColorPanel(initialColor);
	colorPanel.setPreferredSize(new Dimension(300, 200));
	return colorPanel;
    }

*/
    
    protected OriginalColorPanel createOriginalColorPanel(Color initialColor){
    	ColorPanel colorPanel = new OriginalColorPanel(initialColor);
    	colorPanel.setPreferredSize(new Dimension(300, 200));
    	return (OriginalColorPanel) colorPanel;
    }
    
    protected ComplementaryColorPanel createComplementaryColorPanel(Color initialColor){
    	ColorPanel colorPanel = new ComplementaryColorPanel(initialColor, originalColorPanel);
    	colorPanel.setPreferredSize(new Dimension(300, 200));
    	return (ComplementaryColorPanel) colorPanel;
    }
   
}
    
