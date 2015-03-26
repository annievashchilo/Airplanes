package planes;

public class AN12 extends Plane{
	
	private final float capacity = 1962.58f;
	private final float volume = 55420f;
	private final float range = 11000f;

	public AN12(String name) {
		super(name);
	}
	
	public float getCapacity() {
		return capacity;
	}

	public float getVolume() {
		return volume;
	}
	
	public float getRange() {
		return range;
	}

}
