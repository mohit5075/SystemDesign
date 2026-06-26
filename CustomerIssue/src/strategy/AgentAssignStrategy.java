package strategy;

import entities.Agent;
import entities.Issue;

import java.util.List;
import java.util.Optional;

public interface AgentAssignStrategy {
    Optional<Agent> assignAgent(Issue issue, List<Agent>agents);
}
