package Compulsory;

class Church extends Attraction implements Visitable {
    private String openingDays;
    private String openingHours;

    public Church(String name, String description, String openingDays, String openingHours) {
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
