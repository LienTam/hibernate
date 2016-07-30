package timkiemdiadiemamthuc.model;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="DISC",length=20)
public class Admin extends Account {
	@OneToMany(mappedBy="ownCreateGuide")
	private Set<Guide> listGuide;
	@OneToMany(mappedBy="peopleConfirm")
	private Set<Post> listPostConfirm;
	@OneToMany(mappedBy="peopleConfirm")
	private Set<Commercial> listConfirm;
	public Admin(String userName, String pass, String email, String fullName, boolean sex, String address) {
		super(userName, pass, email, fullName, sex, address);
	}

}
