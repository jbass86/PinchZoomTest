



public class PinchEventHandler {

	private final ImageComponent mImageComponent;
	
	public PinchEventHandler(final ImageComponent pComponent){
		
		mImageComponent = pComponent;
	}
	
	public void handlePinchEvent(PinchEvent pEvent){
		
		if (pEvent.getPinchLifeStage() == PinchEventLifeStage.PINCH_START){
			
		}
	}
	
}
