package br.com.paraconsistente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ENTERPRISE")
public class Enterprise implements Serializable{

	private static final long serialVersionUID = 4955913464536571920L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;

	@Column(name="SIREN", nullable=false)
	private Integer siren;

	@Column(name="CAPITAL", nullable=false)
	private double capital;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSiren() {
		return siren;
	}

	public void setSiren(Integer siren) {
		this.siren = siren;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Enterprise enterprise = (Enterprise) o;

		if (Double.compare(enterprise.capital, capital) != 0) return false;
		if (id != null ? !id.equals(enterprise.id) : enterprise.id != null) return false;
		if (name != null ? !name.equals(enterprise.name) : enterprise.name != null) return false;
		return siren != null ? siren.equals(enterprise.siren) : enterprise.siren == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (siren != null ? siren.hashCode() : 0);
		temp = Double.doubleToLongBits(capital);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Enterprise [id=" + id + ", name=" + name + ", siren=" + siren
				+ ", capital=" + capital + "]";
	}


}