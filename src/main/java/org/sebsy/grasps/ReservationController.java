package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.services.ReservationService;

public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController() {
        this(new ReservationService());
    }

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public Reservation creerReservation(Params params) {
        return reservationService.createReservation(params);
    }
}
