package Compulsory;

class Concert extends Attraction implements Visitable, Payable {
    private String openingDays;
    private String openingHours;
    private double entryFee;

    public Concert(String name, String description, String openingDays, String openingHours, double entryFee) {
        super(name, description);
        this.openingDays = openingDays;
        this.openingHours = openingHours;
        this.entryFee = entryFee;
    }

    @Override
    public String getOpeningDays() {
        return openingDays;
    }

    @Override
    public String getOpeningHours() {
        return openingHours;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }
}
