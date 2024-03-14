package Compulsory;

public class Compulsory {
    public static void main(String[] args) {
        Trip trip = new Trip("Paris", "April 2024");

        trip.addAttraction(new Statue("Statue of Liberty", "A famous statue.", "Monday-Friday", "9:00-17:00"));
        trip.addAttraction(new Church("Notre Dame", "A historic church.", "Everyday", "8:00-18:00"));
        trip.addAttraction(new Concert("Rock Concert", "A live rock concert.", "Saturday", "20:00-23:00", 50.0));

        for (Attraction attraction : trip.getAttractions()) {
            System.out.println("Attraction: " + attraction.getName() + ", Description: " + attraction.getDescription());
            if (attraction instanceof Visitable) {
                System.out.println("Opening Days: " + ((Visitable) attraction).getOpeningDays() + ", Hours: " + ((Visitable) attraction).getOpeningHours());
            }
            if (attraction instanceof Payable) {
                System.out.println("Entry Fee: " + ((Payable) attraction).getEntryFee());
            }
            System.out.println();
        }
    }
}

