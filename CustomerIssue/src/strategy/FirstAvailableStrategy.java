package strategy;

import entities.Agent;
import entities.Issue;
import enums.AgentStatus;

import java.util.List;
import java.util.Optional;

public class FirstAvailableStrategy implements AgentAssignStrategy{
    @Override
    public Optional<Agent> assignAgent(Issue issue, List<Agent>agents) {
        Agent ans = null;
        for(Agent agent : agents){
            if(agent.getAgentStatus().equals(AgentStatus.AVAILABLE) && agent.getIssueTypes().contains(issue.getIssueType())){
                ans = agent;
            }
        }
        return Optional.ofNullable(ans);
    }
}
