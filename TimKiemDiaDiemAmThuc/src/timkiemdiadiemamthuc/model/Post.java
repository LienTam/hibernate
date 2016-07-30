package timkiemdiadiemamthuc.model;

import java.util.Calendar;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "title", length = 65536)
	private String title;
	@Column(name = "contentPost", length = 65536)
	private String contentPost;
	private Calendar date;
	@ManyToOne
	private Account ownPost;
	@OneToMany(mappedBy = "isPost")
	protected Set<Image> images;
	@ManyToOne
	private Address adres;
	@OneToMany(mappedBy = "likePost")
	private Set<Likes> listLike;
	@OneToMany(mappedBy = "cmtPost")
	private Set<Comment> listComment;
	@OneToMany(mappedBy = "sharePost")
	private Set<Share> listShare;
	@ManyToOne
	private Admin peopleConfirm;
	@ManyToOne
	private Commercial commercials;

	public Post() {
	}
	public String getTitle() {
		return title;
	}

	public Post(String title, String contentPost, Account ownPost, Address adres, Admin peopleConfirm,
			Commercial commercial) {
		this.title = title;
		this.contentPost = contentPost;
		this.ownPost = ownPost;
		this.adres = adres;
		this.peopleConfirm = peopleConfirm;
		this.commercials = commercial;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public String getContentPost() {
		return contentPost;
	}

	public void setContentPost(String contentPost) {
		this.contentPost = contentPost;
	}

	public Account getOwnPost() {
		return ownPost;
	}

	public void setOwnPost(Account ownPost) {
		this.ownPost = ownPost;
	}

	public Address getAdres() {
		return adres;
	}

	public void setAdres(Address adres) {
		this.adres = adres;
	}
}
