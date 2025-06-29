package model;

import java.util.Date;

public class Comment {
    private String id;
    private String content;
    private User createdBy;
    private Date createdAt;
    public Comment(String id, String content, User createdBy) {
        this.id = id;
        this.content = content;
        this.createdBy = createdBy;
        this.createdAt = new Date();
    }
    public String getContent() {
        return content;
    }
    public User getCreatedBy() {
        return createdBy;
    }
}
