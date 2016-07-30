package timkiemdiadiemamthuc.model;


import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComment;
	private String contentCmt;
	private Calendar commentTime;
	@ManyToOne
	private Post cmtPost;
	@ManyToOne
	private Account ownComment;
	
	public Comment(String contentCmt, Post post) {
		this.contentCmt = contentCmt;
		this.commentTime =  Calendar.getInstance();
		this.cmtPost = post;
	}
	public String getContentCmt() {
		return contentCmt;
	}
	public void setContentCmt(String contentCmt) {
		this.contentCmt = contentCmt;
	}
	public Calendar getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Calendar commentTime) {
		this.commentTime = commentTime;
	}
	public Post getPost() {
		return cmtPost;
	}
	public void setPost(Post post) {
		this.cmtPost = post;
	}

}
