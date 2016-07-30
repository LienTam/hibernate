package timkiemdiadiemamthuc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Guide {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String contentGuide;
	@ManyToOne
	private Admin ownCreateGuide;
	
	
	public Guide( String contentGuide, Admin ownCreateGuide) {
		this.contentGuide = contentGuide;
		this.ownCreateGuide = ownCreateGuide;
	}
	public String getContentGuide() {
		return contentGuide;
	}
	public void setContentGuide(String contentGuide) {
		this.contentGuide = contentGuide;
	}
	public Admin getOwnCreateGuide() {
		return ownCreateGuide;
	}
	public void setOwnCreateGuide(Admin ownCreateGuide) {
		this.ownCreateGuide = ownCreateGuide;
	}
	
}
