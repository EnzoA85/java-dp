package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.TypeReservation;

public class ReservationPricingService {

    public double computeTotal(Client client, TypeReservation typeReservation, int nbPlaces) {
        double total = typeReservation.getMontant() * nbPlaces;
        if (client.isPremium()) {
            return total * (1 - typeReservation.getReductionPourcent() / 100.0);
        }
        return total;
    }
}
