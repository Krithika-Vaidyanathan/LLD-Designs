package service;

import model.Question;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    public static List<Question> searchByKeyword(List<Question> questions, String keyword) {
        return questions.stream().filter(q -> q.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                q.getDescription().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }

    public static List<Question> searchByTag(List<Question> questions, String tagName) {
        return questions.stream().filter(q->q.getTags().stream().anyMatch(t->t.getName().equalsIgnoreCase(tagName))).collect(Collectors.toList());
    }

    public static List<Question> searchByUser(List<Question> questions, String userName) {
        return questions.stream().filter(q->q.getCreatedBy().getName().equalsIgnoreCase(userName)).collect(Collectors.toList());
    }
}
