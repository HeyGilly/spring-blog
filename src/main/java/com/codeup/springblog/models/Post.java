package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "postTable")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    private long id;
    @Column(name="Blog_Title", length = 50)
    private String title;
    @Column(name = "Blog_Body", columnDefinition = "TEXT")
    private String body;

    // Constructor With and WIthout elements
    public Post() {
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
