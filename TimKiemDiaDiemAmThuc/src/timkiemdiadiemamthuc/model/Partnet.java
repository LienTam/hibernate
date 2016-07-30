package timkiemdiadiemamthuc.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Partnet extends Account {
	private String namePartnet;
	@OneToMany(mappedBy = "partnet")
	private Set<Commercial> listCommercialAdvertisement;
	public Partnet(String userName, String pass, String email, String fullName, boolean sex, String address,
			String partnet) {
		super(userName, pass, email, fullName, sex, address);
		this.namePartnet = partnet;
	}

	public String getNamePartnet() {
		return namePartnet;
	}

	public void setNamePartnet(String namePartnet) {
		this.namePartnet = namePartnet;
	}

}
