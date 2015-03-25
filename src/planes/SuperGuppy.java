package planes;

public class SuperGuppy extends Plane {
	
	public SuperGuppy(String name) {
		super(name);
	}

	public float getCapacity() {
		float capacity = 2000f;
		return capacity;
	}

	public float getVolume() {
		float volume = 42420f;
		return volume;
	}
	
	public float getRange() {
		float range = 14500f;
		return range;
	}
}
