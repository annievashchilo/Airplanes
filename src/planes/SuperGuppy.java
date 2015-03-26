package planes;

public class SuperGuppy extends Plane {
	
	private final float capacity = 2000f;
	private final float volume = 42420f;
	private final float range = 14500f;
	
	public SuperGuppy(String name) {
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
