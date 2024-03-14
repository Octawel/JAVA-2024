package Compulsory;

class Statue extends Attraction implements Visitable {
    private String openingDays;
    private String openingHours;

    public Statue(String name, String description, String openingDays, String openingHours) {
        super(name, description);
        this.openingDays = openingDays;
        this.openingHours = openingHours;
    }

    @Override
    public String getOpeningDays() {
        return openingDays;
    }

    @Override
    public String getOpeningHours() {
        return openingHours;
    }
}
