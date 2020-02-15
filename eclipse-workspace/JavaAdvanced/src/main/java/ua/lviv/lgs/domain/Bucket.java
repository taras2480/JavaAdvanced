package ua.lviv.lgs.domain;

import java.util.Date;

public class Bucket {
	
	private Integer id;
	private Integer user_id;
	private Integer product_id;
	private Date purchase_date;
	
	public Bucket(Integer user_id, Integer product_id, Date purchase_date) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.purchase_date = purchase_date;
	}

	public Bucket(Integer id, Integer user_id, Integer product_id, Date purchase_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.purchase_date = purchase_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((purchase_date == null) ? 0 : purchase_date.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		Bucket other = (Bucket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (purchase_date == null) {
			if (other.purchase_date != null)
				return false;
		} else if (!purchase_date.equals(other.purchase_date))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", purchase_date="
				+ purchase_date + "]";
	}
	
	
	

}
