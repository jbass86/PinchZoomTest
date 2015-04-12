package main.image;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class ImageComponent {

	private double mPanelWidth;

	private double mPanelHeight;

	private double mXPanPercent;

	private double mYPanPercent;

	private double mZoomFactor;

	private final Component mComponent;

	private BufferedImage mImage;
	
	private Point mZoomTestPoint;
	
	public ImageComponent(){

		mPanelWidth = 960;
		mPanelHeight = 720;


		mXPanPercent = .5;
		mYPanPercent = .5;

		mZoomFactor = 1;
		
		try {
			mImage = ImageIO.read(this.getClass().getResourceAsStream("CherryBlossom.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mComponent = new JComponent() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				
				Graphics2D g2d = (Graphics2D)g;
				
				double widthFit = getPanelWidth() / mImage.getWidth();
				double heightFit = getPanelHeight() / mImage.getHeight();
				double fitScale = Math.min(widthFit, heightFit);
				
				Dimension fitSize = new Dimension(
						(int)(mImage.getWidth() * fitScale),
						(int)(mImage.getHeight() * fitScale));
				Dimension zoomSize = new Dimension(
						(int)(fitSize.getWidth() * getZoomFactor()),
						(int)(fitSize.getHeight() * getZoomFactor()));
				
				double deltaX = getPanelWidth() - zoomSize.getWidth();
				double deltaY = getPanelHeight() - zoomSize.getHeight();
				Point2D centerTranslate = new Point2D.Double(deltaX / 2, deltaY / 2);
				
				double xPixelPan = (.5 - getXPanPercent()) * zoomSize.getWidth();
				double yPixelPan = (.5 - getYPanPercent()) * zoomSize.getWidth();
				Point2D panTranslate = new Point2D.Double(xPixelPan, yPixelPan);
				
				AffineTransform transform = new AffineTransform();
				
				transform.translate(centerTranslate.getX(), centerTranslate.getY());
				transform.translate(panTranslate.getX(), panTranslate.getY());
				transform.scale(getZoomFactor(), getZoomFactor());
				
				g2d.drawImage(mImage, transform, null);
				
				if (mZoomTestPoint != null){
					g2d.setColor(Color.RED);
					g2d.fillRect(mZoomTestPoint.x, mZoomTestPoint.y, 10, 10);
				}
			}
		};
		
		mComponent.setPreferredSize(new Dimension(960, 720));

	}
	
	public Component getComponent(){
		return mComponent;
	}
	
	public double getPanelWidth() {
		return mPanelWidth;
	}

	public double getPanelHeight() {
		return mPanelHeight;
	}


	public double getImageWidth() {
		return mImage.getWidth();
	}

	public double getImageHeight() {
		return mImage.getHeight();
	}

	public double getXPanPercent() {
		return mXPanPercent;
	}

	public void setXPanPercent(double mXPanPercent) {
		this.mXPanPercent = mXPanPercent;
		mComponent.repaint();
	}

	public double getYPanPercent() {
		return mYPanPercent;
	}

	public void setYPanPercent(double mYPanPercent) {
		this.mYPanPercent = mYPanPercent;
		mComponent.repaint();
	}

	public double getZoomFactor() {
		return mZoomFactor;
	}

	public void setZoomFactor(double mZoomFactor) {
		this.mZoomFactor = mZoomFactor;
		mComponent.repaint();
	}
	
	public void setZoomTestPoint(final Point pTestPoint){
		mZoomTestPoint = pTestPoint;
		mComponent.repaint();
	}

	@Override
	public String toString() {
		return "ImageComponent [mPanelWidth=" + mPanelWidth + ", mPanelHeight="
				+ mPanelHeight + ", mXPanPercent=" + mXPanPercent
				+ ", mYPanPercent=" + mYPanPercent + ", mZoomFactor="
				+ mZoomFactor + ", mComponent=" + mComponent + ", mImage="
				+ mImage + "]";
	}
}
