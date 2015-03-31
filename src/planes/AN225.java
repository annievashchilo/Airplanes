package planes;

public class AN225 extends Plane {

    private final float capacity = 64000f;        // грузоподъемность
    private final float volume = 1300f;           // объём
    private final float range = 15400f;           // дальность полёта
    private final float speed = 900;              // скорость

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

    public float getSpeed() { return speed; }
}
