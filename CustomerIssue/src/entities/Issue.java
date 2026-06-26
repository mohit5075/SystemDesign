package entities;

import enums.IssueType;

import java.util.UUID;

public class Issue {
    private String id;
    private String transactionId;
    private IssueType issueType;
    private String description;
    private String email;
    private String subject;

    public Issue(String transactionId, IssueType issueType, String description, String email, String subject) {
        this.id = UUID.randomUUID().toString();
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.description = description;
        this.email = email;
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
