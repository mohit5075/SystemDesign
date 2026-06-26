package service;

import entities.Agent;
import entities.Issue;
import enums.IssueType;
import strategy.AgentAssignStrategy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerIssueService {
    Map<String, Issue> issueMap;
    Map<String, Agent> agentMap;
    public void createIssue(String transactionId, IssueType issueType,String subject,String description,String email){
        Issue issue = new Issue(transactionId, issueType, description, email, subject);
        issueMap.put(issue.getId(),issue);
    }
    public void addAgent(String email, String name, List<IssueType> issueTypeList){
        Agent agent = new Agent(name,email,issueTypeList);
        agentMap.put(agent.getEmail()+agent.getName(),agent);
    }
    public Optional<Agent> assignIssue(String issueId, AgentAssignStrategy agentAssignStrategy){
        Issue issue = issueMap.get(issueId);
        List<Agent> agents = agentMap.values().stream().toList();
        return agentAssignStrategy.assignAgent(issue,agents);
    }
    public List<Issue> getIssues(String filter){
        return List.of();
    }
    public void updateIssue(String id,String status,String resolution){

    }
    public void resolveIssue(String id){

    }
    public List<Issue> history(String agentId){

    }
}
