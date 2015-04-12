package main.pinch;
import java.awt.Point;

import main.image.ImageComponent;





public class PinchEventHandler {

	private final ImageComponent mImageComponent;

	private double mInitialPinchDistance = 0;

	private Point mPinchCenter = new Point(0, 0);

	private double mInitialZoom = 0;
	private double mInitialXPan = 0;
	private double mInitialYPan = 0;

	private double mPinchDistanceX = 0;
	private double mPinchDistanceY = 0;

	public PinchEventHandler(final ImageComponent pComponent){

		mImageComponent = pComponent;
	}

	public void handlePinchEvent(PinchEvent pEvent){

		if (pEvent.getPinchLifeStage() == PinchEventLifeStage.PINCH_START){
			double pinchDistanceX = pEvent.getPinchCenter().getX() - (mImageComponent.getPanelWidth() / 2);
			double pinchDistanceY = pEvent.getPinchCenter().getY() - (mImageComponent.getPanelHeight() / 2);
			System.out.println("Pixels from center X: " + pinchDistanceX);
			System.out.println("Pixels from center Y: " + pinchDistanceY);

			System.out.println("X distance percent " + pinchDistanceX / mImageComponent.getPanelWidth());
			mPinchDistanceX = pinchDistanceX / mImageComponent.getPanelWidth();
			System.out.println("Y distance percent " + pinchDistanceY / mImageComponent.getPanelHeight());
			mPinchDistanceY = pinchDistanceY / mImageComponent.getPanelHeight();

			mInitialPinchDistance = pEvent.getPinchDistance();
			mPinchCenter = pEvent.getPinchCenter();

			mInitialZoom = mImageComponent.getZoomFactor();
			mInitialXPan = mImageComponent.getXPanPercent();
			mInitialYPan = mImageComponent.getYPanPercent();

		}else if (pEvent.getPinchLifeStage() == PinchEventLifeStage.PINCH_CONTINUE){

			double pinchOffset = pEvent.getPinchDistance() - mInitialPinchDistance;
			double newZoom = mInitialZoom + pinchOffset * .01;
			System.out.println("The new zoom is going to be " + newZoom);
			double zoomRatio = (newZoom - mInitialZoom) / newZoom;
			System.out.println("The zoom ratio is " + zoomRatio);

			double newXPan = mInitialXPan + mPinchDistanceX * zoomRatio;
			double newYPan = mInitialYPan + mPinchDistanceY * zoomRatio;
			mImageComponent.setXPanPercent(newXPan);
			mImageComponent.setYPanPercent(newYPan);

			mImageComponent.setZoomFactor(newZoom);

		}else if (pEvent.getPinchLifeStage() == PinchEventLifeStage.PINCH_END){

			mInitialPinchDistance = 0;
			mPinchCenter = new Point(0, 0);

			mInitialZoom = 0;
			mInitialXPan = 0;
			mInitialYPan = 0;

			mPinchDistanceX = 0;
			mPinchDistanceY = 0;
		}
	}

}
