package MALL;

import java.io.Serializable;

public class MallVO implements Serializable {
	private Integer commNo;
	private String commName;
	private Integer price;
	private Integer quantity;
	private byte[] img;
	private String intro;
	private String age;
	private String player;
	private Integer status;
	
	
	public MallVO() {
		
	}
	
	public MallVO(Integer commNo, String commName, Integer price, Integer quantity, byte[] img, String intro,
			String age, String player, Integer status) {
		super();
		this.commNo = commNo;
		this.commName = commName;
		this.price = price;
		this.quantity = quantity;
		this.img = img;
		this.intro = intro;
		this.age = age;
		this.player = player;
		this.status = status;
	}

	public Integer getCommNo() {
		return commNo;
	}
	
	public void setCommNo(Integer commNo) {
		this.commNo = commNo;
	}
	
	public String getCommName() {
		return commName;
	}
	
	public void setCommName(String commName) {
		this.commName = commName;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public byte[] getImg() {
		return img;
	}
	
	public void setImg(byte[] img) {
		this.img = img;
	}
	
	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getPlayer() {
		return player;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commName == null) ? 0 : commName.hashCode());
		result = prime * result + ((commNo == null) ? 0 : commNo.hashCode());
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
		MallVO other = (MallVO) obj;
		if (commName == null) {
			if (other.commName != null)
				return false;
		} else if (!commName.equals(other.commName))
			return false;
		if (commNo == null) {
			if (other.commNo != null)
				return false;
		} else if (!commNo.equals(other.commNo))
			return false;
		return true;
	}
	
	
	
	
	
}
