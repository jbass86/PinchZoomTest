package main.pinch;
import java.awt.Point;


public class PinchEvent {

	private final Point mPinchCenter;
	
	private final double mPinchDistance;
	
	private final PinchEventLifeStage mPinchLifeStage;
	
	public PinchEvent(Point mPinchCenter, double mPinchDistance,
			PinchEventLifeStage mPinchLifeStage) {
		super();
		this.mPinchCenter = mPinchCenter;
		this.mPinchDistance = mPinchDistance;
		this.mPinchLifeStage = mPinchLifeStage;
	}

	public Point getPinchCenter() {
		return mPinchCenter;
	}

	public double getPinchDistance() {
		return mPinchDistance;
	}

	public PinchEventLifeStage getPinchLifeStage() {
		return mPinchLifeStage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mPinchCenter == null) ? 0 : mPinchCenter.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mPinchDistance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((mPinchLifeStage == null) ? 0 : mPinchLifeStage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PinchEvent other = (PinchEvent) obj;
		if (mPinchCenter == null) {
			if (other.mPinchCenter != null)
				return false;
		} else if (!mPinchCenter.equals(other.mPinchCenter))
			return false;
		if (Double.doubleToLongBits(mPinchDistance) != Double
				.doubleToLongBits(other.mPinchDistance))
			return false;
		if (mPinchLifeStage != other.mPinchLifeStage)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PinchEvent [mPinchCenter=" + mPinchCenter + ", mPinchDistance="
				+ mPinchDistance + ", mPinchLifeStage=" + mPinchLifeStage + "]";
	}
}
