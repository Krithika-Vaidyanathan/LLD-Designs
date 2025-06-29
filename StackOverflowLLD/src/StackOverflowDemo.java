import enumTypes.ContentType;
import enumTypes.VoteType;
import model.*;
import service.SearchService;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class StackOverflowDemo {
    public static void main(String[] args) {
        // Step 1: Create Users
        User alice = new User("U1", "Alice", "alice@example.com");
        User bob = new User("U2", "Bob", "bob@example.com");

        // Step 2: Create Tags
        Tag javaTag = new Tag("T1", "Java");
        Tag springTag = new Tag("T2", "Spring");

        // Step 3: Alice posts a question
        Question q1 = new Question("Q1", "What is Java?", "I want to learn Java basics.", alice);
        q1.addTag(javaTag);
        alice.postQuestion(q1);

        // Step 4: Bob posts a question
        Question q2 = new Question("Q2", "What is Spring Boot?", "How do I start with Spring Boot?", bob);
        q2.addTag(springTag);
        bob.postQuestion(q2);

        // Step 5: Bob answers Alice's question
        Answer a1 = new Answer("A1", "Java is a high-level programming language.", bob, q1);
        q1.addAnswer(a1);
        bob.postAnswer(a1);

        // Step 6: Alice upvotes Bob's answer
        a1.handleVote(alice, VoteType.UPVOTE);
        ReputationEvent voteRep = new ReputationEvent(10, "Received upvote", ContentType.ANSWER);
        bob.addReputationEvent(voteRep);

        // Step 7: Alice accepts the answer
        q1.acceptAnswer(alice, a1);

        // Step 8: Alice adds a comment to Bob's answer
        Comment comment1 = new Comment("C1", "Thanks, this helped!", alice);
        a1.addComment(comment1);
        alice.postComment(comment1);

        // Step 9: Create a list of all questions (simulating the DB)
        List<Question> allQuestions = new ArrayList<>();
        allQuestions.addAll(alice.getQuestionsPosted());
        allQuestions.addAll(bob.getQuestionsPosted());

        // Step 10: Run SearchService examples
        System.out.println("\n🔍 Search by keyword 'Java':");
        List<Question> keywordResults = SearchService.searchByKeyword(allQuestions, "Java");
        for (Question q : keywordResults) {
            System.out.println("- " + q.getTitle());
        }

        System.out.println("\n🔍 Search by tag 'Spring':");
        List<Question> tagResults = SearchService.searchByTag(allQuestions, "Spring");
        for (Question q : tagResults) {
            System.out.println("- " + q.getTitle());
        }

        System.out.println("\n🔍 Search by user 'Alice':");
        List<Question> userResults = SearchService.searchByUser(allQuestions, "Alice");
        for (Question q : userResults) {
            System.out.println("- " + q.getTitle());
        }

        // Step 11: Display answer upvotes and reputation
        System.out.println("\n📊 Bob's Answer Upvotes: " + a1.getUpVoteCount());
        System.out.println("⭐ Bob's Reputation: " + bob.getTotalReputation());

        System.out.println("\n📚 Comments on the Answer:");
        for (Comment c : a1.getComments()) {
            System.out.println("- " + c.getCreatedBy().getName() + ": " + c.getContent());
        }
    }
}
