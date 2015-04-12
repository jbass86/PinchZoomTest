package main;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import main.image.ImageComponent;
import main.pinch.PinchEventHandler;


public class Main {
	
	public static void main(String[] args) {
		
		ImageComponent component = new ImageComponent();	
		PinchEventHandler pincher = new PinchEventHandler(component);
		
		//Create some fake pinch events and send them through to the handler...
		
		final JFrame frame = new JFrame();
		
		frame.setPreferredSize(new Dimension(960, 720));
		frame.add(component.getComponent());
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}