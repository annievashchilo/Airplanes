package aviacompanies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import planes.Plane;
import utils.RangeComparator;

public class Aviacompany {
	
	private String m_companyName;
	private List<Plane> planes = new ArrayList<Plane>();
	
	public Aviacompany(String companyName) {
		m_companyName = companyName;
	}
	
	public void addPlaneToPark(Plane p) {
		planes.add(p);
	}
	
	public String getName() {
		return m_companyName;
	}
	

	public void addPlanesToPark(List<Plane> p ) {
		planes.addAll(p);
	}

	public List<Plane> getAviapark() {
		return planes;
	}

	public List<Plane> sortPlanesByRange() {
		List<Plane> sorted = new ArrayList<Plane>();
		sorted.addAll(planes);
		Collections.sort(sorted, new RangeComparator());
		return sorted;
	}
	
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