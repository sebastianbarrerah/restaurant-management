package com.ApiRestFull.restaurant_management.services;

import com.ApiRestFull.restaurant_management.model.Reservation;
import com.ApiRestFull.restaurant_management.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> listReservations() {
        return reservationRepository.findAll();
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
