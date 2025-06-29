package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private List<Question> questionsPosted = new ArrayList<>();
    private List<Answer> answersPosted = new ArrayList<>();
    private List<Comment> commentsPosted = new ArrayList<>();
    private List<ReputationEvent> reputationHistory = new ArrayList<>();

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void postQuestion(Question question) {
        questionsPosted.add(question);
    }

    public void postAnswer(Answer answer) {
        answersPosted.add(answer);
    }

    public void postComment(Comment comment) {
        commentsPosted.add(comment);
    }

    public void addReputationEvent(ReputationEvent event) {
        reputationHistory.add(event);
    }

    public int getTotalReputation() {
        return reputationHistory.stream().mapToInt(ReputationEvent::getDelta).sum();
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestionsPosted() {
        return questionsPosted;
    }

    public List<Answer> getAnswersPosted() {
        return answersPosted;
    }

    public List<Comment> getCommentsPosted() {
        return commentsPosted;
    }

    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return this.id.equals(other.id);
    }

    public int hashCode() {
        return id.hashCode();
    }

}
