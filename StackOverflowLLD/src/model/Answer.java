package model;

import enumTypes.VoteType;

import java.util.*;

public class Answer implements Commentable {
    private String id;
    private String content;
    private User createdBy;
    private Question question;
    private List<Comment> comments = new ArrayList<>();
    private Map<User, VoteType> votes = new HashMap<>();
    private Date createdAt = new Date();

    public Answer(String id, String content, User createdBy, Question question) {
        this.id = id;
        this.content = content;
        this.createdBy = createdBy;
        this.question = question;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void handleVote(User user, VoteType type) {
        if(user.equals(createdBy)) return;
        votes.put(user, votes.get(user) == type ? null : type);
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public int getUpVoteCount() {
        return (int) votes.values().stream().filter(v -> v == VoteType.UPVOTE).count();
    }

    public String getContent() {
        return content;
    }

}
