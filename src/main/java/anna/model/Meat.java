package anna.model;

import javax.persistence.Embeddable;

@Embeddable
public class Meat {
	
	private String meat;
	private int slices;
	
	
	public Meat(String meat, int slices) {
		this.meat = meat;
		this.slices = slices;
	}

	public Meat() {}
	
	public String getMeat() {
		return meat;
	}


	public void setMeat(String meat) {
		this.meat = meat;
	}


	public int getSlices() {
		return slices;
	}


	public void setSlices(int slices) {
		this.slices = slices;
	}


	@Override
	public String toString() {
		return "Meat [meat=" + meat + ", slices=" + slices + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meat == null) ? 0 : meat.hashCode());
		result = prime * result + slices;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meat other = (Meat) obj;
		if (meat == null) {
			if (other.meat != null)
				return false;
		} else if (!meat.equals(other.meat))
			return false;
		if (slices != other.slices)
			return false;
		return true;
	}
	
	
}
