package com.codeup.springblog.models;

public class Post {
    private String title;
    private String body;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post(String title, String body, long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    // Constructor
    public Post() {
    }

    // Now we can grab these two information.
    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }

    //------ getters and Setters
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
