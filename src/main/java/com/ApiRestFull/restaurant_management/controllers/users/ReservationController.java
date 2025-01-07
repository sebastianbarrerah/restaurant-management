package com.ApiRestFull.restaurant_management.controllers.users;

import com.ApiRestFull.restaurant_management.model.Reservation;
import com.ApiRestFull.restaurant_management.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> listReservations() {
        return ResponseEntity.ok(service.listReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return service.findReservationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(service.addReservation(reservation));
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        service.deleteReservation(id);
        return ResponseEntity.ok("Reservation eliminada con éxito");
    }
}
