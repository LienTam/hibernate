package timkiemdiadiemamthuc.model;

import java.util.Calendar;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public abstract class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAcount;
	@Version
	@Column(name = "version")
	private int version = 0;
	private String userName;
	private String pass;
	private String email;
	private String fullName;
	private boolean sex;
	private Calendar dateRegister;
	private String address;
	@OneToMany(mappedBy = "ownPost")
	private Set<Post> listPost;
	@OneToMany(mappedBy = "ownComment")
	private Set<Comment> listComment;
	@OneToMany(mappedBy = "ownLike")
	private Set<Likes> listLike;
	@OneToMany(mappedBy = "ownShare")
	private Set<Share> listShare;
	public int getIdAcount() {
		return idAcount;
	}

	public Account(String userName, String pass, String email, String fullName, boolean sex, String address) {
		super();
		this.userName = userName;
		this.pass = pass;
		this.email = email;
		this.fullName = fullName;
		this.sex = sex;
		this.dateRegister = Calendar.getInstance();
		this.address = address;
	}

	public void setIdAcount(int idAcount) {
		this.idAcount = idAcount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Calendar getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Calendar dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getAddress() {
		return address;
	}
	
	

	public void setAddress(String address) {
		this.address = address;
	}
// liên tam 95
}
