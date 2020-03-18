package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column
	private String name;
	
	@Column
	private Integer level;
	
	@Column
	private Integer qtyInstitutes;
	
	@Column
	private Integer qtyStudents;
	
	
	
	@Column
	private String adress;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getQtyStudents() {
		return qtyStudents;
	}

	public void setQtyStudents(Integer qtyStudents) {
		this.qtyStudents = qtyStudents;
	}

	public Integer getQtyInstitutes() {
		return qtyInstitutes;
	}

	public void setQtyInstitutes(Integer qtyInstitutes) {
		this.qtyInstitutes = qtyInstitutes;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "University [Id=" + Id + ", name=" + name + ", level=" + level + ", qtyStudents=" + qtyStudents
				+ ", qtyInstitutes=" + qtyInstitutes + ", adress=" + adress + "]";
	}
	
	

}
