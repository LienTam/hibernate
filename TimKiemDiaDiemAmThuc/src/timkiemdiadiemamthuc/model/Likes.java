package timkiemdiadiemamthuc.model;


import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Likes {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int idLike;
	private Calendar likeTime;
	@ManyToOne
	private Post likePost;
	@ManyToOne
	private Account ownLike;
	
	public Likes( Post post) {
		this.likeTime  =  Calendar.getInstance();
		this.likePost = post;
	}
	public Calendar getShareTime() {
		return likeTime;
	}
	public void setShareTime(Calendar likeTime) {
		this.likeTime = likeTime;
	}
	public Post getPost() {
		return likePost;
	}
	public void setPost(Post post) {
		this.likePost = post;
	}

}
