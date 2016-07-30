package timkiemdiadiemamthuc.model;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String address;

	@OneToMany(mappedBy = "adres")
	private Set<Post> listPost;

	public Address(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public Set<Post> getListPost() {
//		return listPost;
//	}
//
//	public void setListPost(Set<Post> listPost) {
//		this.listPost = listPost;
//	}

}
