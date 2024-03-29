package com.luluh.Lookify1.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="lookify")
public class Lookify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 20)
    private String song;
    @Size(min = 2, max = 20)
    private String artist;
    @Min(1)
    private Integer rating;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Lookify() {
    }
    public Lookify(String song, String artist, Integer rating) {
        this.song = song;
        this.artist = artist;
        this.rating = rating;
    }
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public Long getId() {
		return id;
	}
    
    public void setSong(String song) {
		this.song = song;
	}
    
    public String getSong() {
		return song;
	}
    
    public void setArtist(String artist) {
		this.artist = artist;
	}
    
    public String getArtist() {
		return artist;
	}
    
    public void setRating(Integer rating) {
		this.rating = rating;
	}
    
    public Integer getRating() {
		return rating;
	}
    
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void SetUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}