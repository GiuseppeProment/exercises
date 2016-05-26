package exercises.mockito;

public class Cooker {

	private Pan pan;
	
	public Cooker(Pan pan) {
		super();
		this.pan = pan;
	}

	public void turnOn() {
		pan.increaseHeat(1);
	}

}
