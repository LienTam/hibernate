package timkiemdiadiemamthuc.model;


import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Share {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idShare;
	private Calendar shareTime;
	@ManyToOne
	private Post sharePost;
	@ManyToOne
	private Post ownShare;

	public Share(Post post) {
		this.shareTime =Calendar.getInstance();
		this.sharePost = post;
	}

	public Calendar getShareTime() {
		return shareTime;
	}

	public void setShareTime(Calendar shareTime) {
		this.shareTime = shareTime;
	}

	public Post getPost() {
		return sharePost;
	}

	public void setPost(Post post) {
		this.sharePost = post;
	}

}
