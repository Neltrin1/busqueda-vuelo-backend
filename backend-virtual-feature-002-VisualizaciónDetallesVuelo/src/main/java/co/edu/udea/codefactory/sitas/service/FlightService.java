package co.edu.udea.codefactory.sitas.service;

import co.edu.udea.codefactory.sitas.model.Airport;
import co.edu.udea.codefactory.sitas.model.Flight;
import co.edu.udea.codefactory.sitas.model.FlightDetails;
import co.edu.udea.codefactory.sitas.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(Date departureDate, Airport departureAirport, Airport arrivalAirport) {
        return flightRepository.findByDepartureDateEqualsAndDepartureAirportEqualsAndArrivalAirportEquals(departureDate, departureAirport, arrivalAirport);
    }

    // Nuevo método para obtener los detalles de un vuelo específico
    public FlightDetails getFlightDetails(UUID flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        // Simulación de obtener el tipo de avión. Esto podría venir de otra entidad si tienes ese detalle.
        String aircraftType = "Boeing 737";

        return new FlightDetails(
                flight.getFlightNumber().toString(),
                flight.getDepartureAirport().getAirportName(),
                flight.getArrivalAirport().getAirportName(),
                flight.getDepartureDate().toString(),
                flight.getArrivalDate().toString(),
                aircraftType,
                flight.getPrice()
        );
    }


}
