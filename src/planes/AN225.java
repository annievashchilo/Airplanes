package planes;

public class AN225 extends Plane {
	
	private final float capacity = 64000f;
	private final float volume = 1300f;
	private final float range = 15400f;
	
	public AN225(String name) {
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
