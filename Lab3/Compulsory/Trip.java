package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String city;
    private String period;
    private List<Attraction> attractions;

    public Trip(String city, String period) {
        this.city = city;
        this.period = period;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }
}

