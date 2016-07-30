package timkiemdiadiemamthuc.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Commercial {
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Partnet partnet;
	@ManyToOne
	private Admin peopleConfirm;
	private int numberLimitAdvertisement;
	@OneToMany(mappedBy="commercials")
	private Set<Post> listAdvertisement;
	private double price;
	@ManyToOne
	private Contract contract;
	public Commercial(Partnet partnet, Admin peopleConfirm, int numberLimitAdvertisement, 
			double price, Contract contract) {
		super();
		this.partnet = partnet;
		this.peopleConfirm = peopleConfirm;
		this.numberLimitAdvertisement = numberLimitAdvertisement;
		this.price = price;
		this.contract = contract;
	}
	public Partnet getPartnet() {
		return partnet;
	}
	public void setPartnet(Partnet partnet) {
		this.partnet = partnet;
	}
	public Admin getPeopleConfirm() {
		return peopleConfirm;
	}
	public void setPeopleConfirm(Admin peopleConfirm) {
		this.peopleConfirm = peopleConfirm;
	}
	public int getNumberLimitAdvertisement() {
		return numberLimitAdvertisement;
	}
	public void setNumberLimitAdvertisement(int numberLimitAdvertisement) {
		this.numberLimitAdvertisement = numberLimitAdvertisement;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public long getId() {
		return id;
	}
	
}
