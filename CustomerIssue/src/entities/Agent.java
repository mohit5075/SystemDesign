package entities;

import enums.AgentStatus;
import enums.IssueType;

import java.util.List;

public class Agent {
    private String name;
    private String email;
    private List<IssueType> issueTypes;
    private AgentStatus agentStatus;

    public Agent(String name, String email, List<IssueType> issueTypes) {
        this.name = name;
        this.email = email;
        this.issueTypes = issueTypes;
        this.agentStatus = AgentStatus.AVAILABLE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IssueType> getIssueTypes() {
        return issueTypes;
    }

    public void setIssueTypes(List<IssueType> issueTypes) {
        this.issueTypes = issueTypes;
    }

    public AgentStatus getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(AgentStatus agentStatus) {
        this.agentStatus = agentStatus;
    }
}
