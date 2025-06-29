package model;

import enumTypes.ContentType;
import enumTypes.VoteType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question implements Commentable {
    private String id;
    private String title;
    private String description;
    private User createdBy;
    private List<Answer> answers = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();
    private Map<User, VoteType> votes = new HashMap<>();
    private Answer acceptedAnswer;

    public Question(String id, String title, String description, User createdBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void handleVote(User user, VoteType type) {
        if(user.equals(createdBy)) return;
        votes.put(user, votes.get(user) == type ? null : type);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void acceptAnswer(User user, Answer answer) {
        if(!(createdBy.equals(user))) return;
        if(!(answers.contains(answer))) return;
        this.acceptedAnswer = answer;
        ReputationEvent event = new ReputationEvent(15, "Answer Accepted", ContentType.ANSWER);
        answer.getCreatedBy().addReputationEvent(event);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

}
