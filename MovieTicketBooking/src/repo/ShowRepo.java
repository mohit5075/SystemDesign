package repo;

import entities.Show;

import java.util.Map;

public class ShowRepo {
    private Map<String, Show> showMap;

    public ShowRepo(Map<String, Show> showMap) {
        this.showMap = showMap;
    }
    public void addShow(Show show){
        showMap.putIfAbsent(show.getId(),show);
    }
    public Show getShow(String id){
        return showMap.get(id);
    }
}
