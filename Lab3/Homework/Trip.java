package Homework;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String city;
    private String period;
    private List<Homework.Attraction> attractions;

    public Trip(String city, String period) {
        this.city = city;
        this.period = period;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Homework.Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Homework.Attraction> getAttractions() {
        return attractions;
    }
}
