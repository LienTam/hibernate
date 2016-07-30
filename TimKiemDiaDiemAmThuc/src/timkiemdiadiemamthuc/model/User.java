package timkiemdiadiemamthuc.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Account {
	public User(String userName, String pass, String email, String fullName, boolean sex, String address) {
		super(userName, pass, email, fullName, sex, address);
	}

}
