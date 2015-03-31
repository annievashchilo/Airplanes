package planes;

public class AN12 extends Plane {

    private final float capacity = 1962.58f;        // грузоподъемность
    private final float volume = 55420f;            // объём
    private final float range = 11000f;             // дальность полёта
    private final float speed = 750;                // скорость

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

    public float getSpeed() { return speed; }

}
