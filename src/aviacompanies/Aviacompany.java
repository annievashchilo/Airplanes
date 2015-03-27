package aviacompanies;

import java.util.ArrayList;
import java.util.List;

import planes.Plane;

public class Aviacompany {
	
	private String m_companyName;
	private List<Plane> planes = new ArrayList<Plane>();
	
	public Aviacompany(String companyName) {
		m_companyName = companyName;
	}
	
	/**
	 * add Plane p to the aviacompany
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
	 * @param p
	 */
	public void addPlanesToPark(List<Plane> p ) {
		planes.addAll(p);
		System.out.println("Following planes are in park ("+ getName()+"):");
	}

	/**
	 * get all planes in aviacompany
	 * @return List of planes
	 */
	public List<Plane> getAviapark() {
		return planes;
	}


	
	/**
	 * Method searches through each parameter of plane
	 * @param minCapacity
	 * @param maxCapacity
	 * @param minVolume
	 * @param maxVolume
	 * @param minRange
	 * @param maxRange
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
			||  (p.getVolume() >= minVolume && p.getVolume() <= maxVolume)
			||  (p.getRange() >= minRange && p.getRange() <= maxRange)) {
				result.add(p);
			}
		}
		
		return result;
	}
}