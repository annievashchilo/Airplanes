package planes;

public class AN225 extends Plane {
	
	public AN225(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public float getCapacity() {
		float capacity = 640000;
		return capacity;
	}

	public float getVolume() {
		float volume = 1300;
		return volume;
	}
	
	public float getRange() {
		float range = 15400f;
		return range;
	}

}
