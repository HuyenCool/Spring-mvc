package com.laptrinhjavaweb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "comment")
public class CommentEntity extends BaseEntity{
	
	@Column(name= "content", columnDefinition = "TEXT")
	private String content;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity user;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dish_id")
    private DishEntity dish;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public DishEntity getDish() {
		return dish;
	}
	public void setDish(DishEntity dish) {
		this.dish = dish;
	}

	
}
