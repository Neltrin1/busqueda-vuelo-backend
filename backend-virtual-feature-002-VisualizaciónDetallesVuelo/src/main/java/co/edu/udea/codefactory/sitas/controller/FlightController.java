package co.edu.udea.codefactory.sitas.controller;

import co.edu.udea.codefactory.sitas.model.Airport;
import co.edu.udea.codefactory.sitas.model.Flight;
import co.edu.udea.codefactory.sitas.model.FlightDetails;
import co.edu.udea.codefactory.sitas.service.FlightService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

    Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam("departureDate") String departureDate,
            @RequestParam("departure") UUID departure,
            @RequestParam("arrival") UUID arrival
            ) throws ParseException {
        Airport departureAirport = new Airport();
        Airport arrivalAirport = new Airport();
        departureAirport.setUuid(departure);
        arrivalAirport.setUuid(arrival);
        return flightService.findFlights(
                new SimpleDateFormat("yyyy-MM-dd").parse(departureDate),
                departureAirport,
                arrivalAirport);
    }

    // Método para obtener los detalles de un vuelo específico
    @GetMapping("/details/{flightId}")
    public ResponseEntity<FlightDetails> getFlightDetails(@PathVariable UUID flightId) {
        FlightDetails flightDetails = flightService.getFlightDetails(flightId);
        return ResponseEntity.ok(flightDetails);
    }


    @Setter
    @Getter
    public static class CustomBody{
        private String departureDate;

        private Airport arrivalAirport;

        private Airport departureAirport;
    }
}
