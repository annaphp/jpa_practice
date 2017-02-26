package anna.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sandwich {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String bread;
	
	@Column
	private Meat meat;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> condiments= new ArrayList<>();

	public Sandwich(String bread, Meat meat) {
		this.bread = bread;
		this.meat = meat;
	
	}
	
	public Sandwich() {}

	public long getId() {
		return id;
	}

	public String getBread() {
		return bread;
	}

	public void setBread(String bread) {
		this.bread = bread;
	}

	public Meat getMeat() {
		return meat;
	}

	public void setMeat(Meat meat) {
		this.meat = meat;
	}

	public List<String> getCondiments() {
		return condiments;
	}

	public void setCondiments(List<String> condiments) {
		this.condiments = condiments;
	}

	

	@Override
	public String toString() {
		return "Sandwich [id=" + id + ", bread=" + bread + ", meat=" + meat + ", condiments=" + condiments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bread == null) ? 0 : bread.hashCode());
		result = prime * result + ((meat == null) ? 0 : meat.hashCode());
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
		Sandwich other = (Sandwich) obj;
		if (bread == null) {
			if (other.bread != null)
				return false;
		} else if (!bread.equals(other.bread))
			return false;
		if (meat == null) {
			if (other.meat != null)
				return false;
		} else if (!meat.equals(other.meat))
			return false;
		return true;
	}

	
	
	
	

}
