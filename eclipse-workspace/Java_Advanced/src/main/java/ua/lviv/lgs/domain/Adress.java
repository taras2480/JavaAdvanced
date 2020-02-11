package ua.lviv.lgs.domain;

public class Adress {

	private Integer id;
	private Integer index;
	private String country;
	private String region;
	private String district;
	private String sity;
	private String street;
	private Integer building;
	private Integer flat;

	public Adress(Integer index, String country, String region, String district, String sity, String street,
			Integer building, Integer flat) {
		super();
		this.index = index;
		this.country = country;
		this.region = region;
		this.district = district;
		this.sity = sity;
		this.street = street;
		this.building = building;
		this.flat = flat;
	}

	public Adress(Integer id, Integer index, String country, String region, String district, String sity, String street,
			Integer building, Integer flat) {
		super();
		this.id = id;
		this.index = index;
		this.country = country;
		this.region = region;
		this.district = district;
		this.sity = sity;
		this.street = street;
		this.building = building;
		this.flat = flat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSity() {
		return sity;
	}

	public void setSity(String sity) {
		this.sity = sity;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getBuilding() {
		return building;
	}

	public void setBuilding(Integer building) {
		this.building = building;
	}

	public Integer getFlat() {
		return flat;
	}

	public void setFlat(Integer flat) {
		this.flat = flat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((flat == null) ? 0 : flat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((sity == null) ? 0 : sity.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Adress other = (Adress) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (flat == null) {
			if (other.flat != null)
				return false;
		} else if (!flat.equals(other.flat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (sity == null) {
			if (other.sity != null)
				return false;
		} else if (!sity.equals(other.sity))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", index=" + index + ", country=" + country + ", region=" + region + ", district="
				+ district + ", sity=" + sity + ", street=" + street + ", building=" + building + ", flat=" + flat
				+ "]";
	}

}
