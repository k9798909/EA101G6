package MALLOR;

import java.io.Serializable;


public class MallOrVO implements Serializable{

	private Integer mallOrNo;
	private Integer mbrNo;
	private java.sql.Date orDate;
	private String take;
	private String  address;
	private Integer status;
	private Integer payStatus;
	private Integer boxStatus;
	
	public MallOrVO() {
		
	}

	public MallOrVO(Integer mallOrNo, Integer mbrNo, java.sql.Date orDate, String take, String address, Integer status,
			Integer payStatus, Integer boxStatus) {
		super();
		this.mallOrNo = mallOrNo;
		this.mbrNo = mbrNo;
		this.orDate = orDate;
		this.take = take;
		this.address = address;
		this.status = status;
		this.payStatus = payStatus;
		this.boxStatus = boxStatus;
	}

	public Integer getMallOrNo() {
		return mallOrNo;
	}

	public void setMallOrNo(Integer mallOrNo) {
		this.mallOrNo = mallOrNo;
	}

	public Integer getMbrNo() {
		return mbrNo;
	}

	public void setMbrNo(Integer mbrNo) {
		this.mbrNo = mbrNo;
	}

	public java.sql.Date getOrDate() {
		return orDate;
	}

	public void setOrDate(java.sql.Date orDate) {
		this.orDate = orDate;
	}

	public String getTake() {
		return take;
	}

	public void setTake(String take) {
		this.take = take;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getBoxStatus() {
		return boxStatus;
	}

	public void setBoxStatus(Integer boxStatus) {
		this.boxStatus = boxStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mallOrNo == null) ? 0 : mallOrNo.hashCode());
		result = prime * result + ((mbrNo == null) ? 0 : mbrNo.hashCode());
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
		MallOrVO other = (MallOrVO) obj;
		if (mallOrNo == null) {
			if (other.mallOrNo != null)
				return false;
		} else if (!mallOrNo.equals(other.mallOrNo))
			return false;
		if (mbrNo == null) {
			if (other.mbrNo != null)
				return false;
		} else if (!mbrNo.equals(other.mbrNo))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
