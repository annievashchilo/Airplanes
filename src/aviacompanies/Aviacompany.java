package aviacompanies;

import planes.Plane;

import java.util.ArrayList;
import java.util.List;

public class Aviacompany {

    private String m_companyName;
    private List<Plane> planes = new ArrayList<Plane>();

    public Aviacompany(String companyName) {
        m_companyName = companyName;
    }

    /**
     * add Plane p to the aviacompany
     *
     * @param p - specified airplane
     */
    public void addPlaneToPark(Plane p) {
        planes.add(p);
    }

    /**
     * @return name of the aviacompany
     */
    public String getName() {
        return m_companyName;
    }

    /**
     * add List<Plane> p to the aviacompany
     *
     * @param p – list of planes
     */
    public void addPlanesToPark(List<Plane> p) {
        planes.addAll(p);
    }

    /**
     * get all planes in aviacompany
     *
     * @return List of planes
     */
    public List<Plane> getAviapark() {
        return planes;
    }


    /**
     * Method searches through each parameter of plane
     *
     * @param minCapacity min capacity of plane you are looking for
     * @param maxCapacity max capacity of plane you are looking for
     * @param minVolume min volume of plane you are looking for
     * @param maxVolume max volume of plane you are looking for
     * @param minRange min range of plane you are looking for
     * @param maxRange max range of plane you are looking for
     * @return a plane, that suits all specified parameters
     */
    public List<Plane> findPlane(
            float minCapacity,
            float maxCapacity,
            float minVolume,
            float maxVolume,
            float minRange,
            float maxRange
    ) {
        List<Plane> result = new ArrayList<Plane>();

        for (Plane p : planes) {
            if ((p.getCapacity() >= minCapacity && p.getCapacity() <= maxCapacity)
                    || (p.getVolume() >= minVolume && p.getVolume() <= maxVolume)
                    || (p.getRange() >= minRange && p.getRange() <= maxRange)) {
                result.add(p);
            }
        }

        return result;
    }

    /**
     * Method will show common capacity of planes in aviacompany
     * @return common capacity
     */
    public float getCommonCapacity() {
        float commonCapacity = 0;
        for (Plane p : planes) {
            commonCapacity += p.getCapacity();
        }
        return commonCapacity;
    }
}