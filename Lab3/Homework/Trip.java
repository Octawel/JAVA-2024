package Homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.LocalTime;

class Trip {
    private String city;
    private String period;
    private List<Attraction> attractions = new ArrayList<>();

    public Trip(String city, String period) {
        this.city = city;
        this.period = period;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void displayVisitableNotPayable() {
        attractions.stream()
                .filter(attraction -> attraction instanceof Visitable && !(attraction instanceof Payable))
                .sorted(Comparator.comparing(attraction -> ((Visitable) attraction).getOpeningHours().entrySet().iterator().next().getValue().getLeft()))
                .forEach(attraction -> {
                    Pair<LocalTime, LocalTime> timeInterval = ((Visitable) attraction).getOpeningHours().entrySet().iterator().next().getValue();
                    System.out.println(attraction.getName() + " opens at " + timeInterval.getLeft() + " on " +
                            ((Visitable) attraction).getOpeningHours().entrySet().iterator().next().getKey());
                });
    }

    public String getCity() {
        return city;
    }

    public String getPeriod() {
        return period;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }
}
