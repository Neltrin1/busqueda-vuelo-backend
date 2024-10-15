package co.edu.udea.codefactory.sitas.model;

public class FlightDetails {

    private String flightNumber;
    private String departureAirportName;
    private String arrivalAirportName;
    private String departureDateTime;
    private String arrivalDateTime;
    private String aircraftType;
    private double price;

    // Constructor
    public FlightDetails(String flightNumber, String departureAirportName, String arrivalAirportName,
                         String departureDateTime, String arrivalDateTime, String aircraftType, double price) {
        this.flightNumber = flightNumber;
        this.departureAirportName = departureAirportName;
        this.arrivalAirportName = arrivalAirportName;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.aircraftType = aircraftType;
        this.price = price;
    }

}
