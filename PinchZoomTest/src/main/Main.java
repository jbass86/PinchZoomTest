package main;
import java.awt.Dimension;
import java.awt.Point;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import main.image.ImageComponent;
import main.pinch.PinchEvent;
import main.pinch.PinchEventHandler;
import main.pinch.PinchEventLifeStage;


public class Main {
	
	static double pinchDistance = 10;
	
	public static void main(String[] args) {
		
		ImageComponent component = new ImageComponent();	
		PinchEventHandler pincher = new PinchEventHandler(component);
		
		final JFrame frame = new JFrame();
		
		frame.setPreferredSize(new Dimension(960, 720));
		frame.add(component.getComponent());
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Start doing some pinch stuff...
		//Set this point to whatever you want and it should pinch zoom around it
		final Point zoomTestPoint = new Point(800, 200);
		
		//just set this so we can see the pinch point on the image panel
		component.setZoomTestPoint(zoomTestPoint);
		
		PinchEvent firstEvent = new PinchEvent(zoomTestPoint, pinchDistance, PinchEventLifeStage.PINCH_START);
		pincher.handlePinchEvent(firstEvent);
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(()->{
			
			pinchDistance += .1;
			PinchEvent event = new PinchEvent(zoomTestPoint, pinchDistance, PinchEventLifeStage.PINCH_CONTINUE);
			pincher.handlePinchEvent(event);
		}, 5000, 50, TimeUnit.MILLISECONDS);
		
	}
}
