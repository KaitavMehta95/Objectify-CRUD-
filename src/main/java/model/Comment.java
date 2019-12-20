package model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

@Entity
public class Comment {

    @Id
    private Long id;

    private String author;
    private String text;
    private String postID;
    @Index
    private Date date;


    public Comment(){};

    public Comment(String author, String text, String postID){
        this.author = author;
        this.text = text;
        this.postID = postID;

        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getPostID() {
        return postID;
    }

    public Date getDate() {
        return date;
    }
}
