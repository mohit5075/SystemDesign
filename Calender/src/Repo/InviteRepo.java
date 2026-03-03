package Repo;

import entity.Invite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InviteRepo {
    Map<String, List<Invite>> inviteMap = new ConcurrentHashMap<>();
    public void addInvite(Invite invite){
        inviteMap.computeIfAbsent(invite.getEventId(),k->new ArrayList<>()).add(invite);
    }
}
