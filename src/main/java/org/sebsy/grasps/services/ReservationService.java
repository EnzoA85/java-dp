package org.sebsy.grasps.services;

import org.sebsy.grasps.Params;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;
import org.sebsy.grasps.utils.DateParser;

import java.time.LocalDateTime;

public class ReservationService {

    private final ClientDao clientDao;
    private final TypeReservationDao typeReservationDao;
    private final DateParser dateParser;
    private final ReservationPricingService pricingService;

    public ReservationService() {
        this(new ClientDao(), new TypeReservationDao(), new DateParser(), new ReservationPricingService());
    }

    public ReservationService(ClientDao clientDao,
                              TypeReservationDao typeReservationDao,
                              DateParser dateParser,
                              ReservationPricingService pricingService) {
        this.clientDao = clientDao;
        this.typeReservationDao = typeReservationDao;
        this.dateParser = dateParser;
        this.pricingService = pricingService;
    }

    public Reservation createReservation(Params params) {
        Client client = clientDao.extraireClient(params.getIdentifiantClient());
        TypeReservation typeReservation = typeReservationDao.extraireTypeReservation(params.getTypeReservation());
        LocalDateTime reservationDate = dateParser.parseReservationDate(params.getDateReservation());

        Reservation reservation = new Reservation(reservationDate);
        reservation.setNbPlaces(params.getNbPlaces());
        reservation.setClient(client);
        client.getReservations().add(reservation);

        double total = pricingService.computeTotal(client, typeReservation, params.getNbPlaces());
        reservation.setTotal(total);

        return reservation;
    }
}
