
public class ImageComponent {

	private double mPanelWidth;
	
	private double mPanelHeight;
	
	private double mImageWidth;
	
	private double mImageHeight;
	
	private double mXPanPercent;
	
	private double mYPanPercent;
	
	private double mZoomFactor;
	
	public ImageComponent(){
		
		mPanelWidth = 1920;
		mPanelHeight = 1080;
		
		mImageWidth = 960;
		mImageHeight = 540;
		
		mXPanPercent = .5;
		mYPanPercent = .5;
		
		mZoomFactor = 1;
	}
	
	public double getPanelWidth() {
		return mPanelWidth;
	}

	public void setPanelWidth(double mPanelWidth) {
		this.mPanelWidth = mPanelWidth;
	}

	public double getPanelHeight() {
		return mPanelHeight;
	}

	public void setPanelHeight(double mPanelHeight) {
		this.mPanelHeight = mPanelHeight;
	}

	public double getImageWidth() {
		return mImageWidth;
	}

	public void setImageWidth(double mImageWidth) {
		this.mImageWidth = mImageWidth;
	}

	public double getImageHeight() {
		return mImageHeight;
	}

	public void setImageHeight(double mImageHeight) {
		this.mImageHeight = mImageHeight;
	}

	public double getXPanPercent() {
		return mXPanPercent;
	}

	public void setXPanPercent(double mXPanPercent) {
		this.mXPanPercent = mXPanPercent;
	}

	public double getYPanPercent() {
		return mYPanPercent;
	}

	public void setYPanPercent(double mYPanPercent) {
		this.mYPanPercent = mYPanPercent;
	}

	public double getZoomFactor() {
		return mZoomFactor;
	}

	public void setZoomFactor(double mZoomFactor) {
		this.mZoomFactor = mZoomFactor;
	}
	
	@Override
	public String toString() {
		return "ImageComponent [mPanelWidth=" + mPanelWidth + ", mPanelHeight="
				+ mPanelHeight + ", mImageWidth=" + mImageWidth
				+ ", mImageHeight=" + mImageHeight + ", mXPanPercent="
				+ mXPanPercent + ", mYPanPercent=" + mYPanPercent
				+ ", mZoomFactor=" + mZoomFactor + "]";
	}
}
