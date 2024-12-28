package com.vatsaladhiya.vatsal.routeq.routeq.strategies.impl;

import com.vatsaladhiya.vatsal.routeq.routeq.entities.RideRequest;
import com.vatsaladhiya.vatsal.routeq.routeq.services.DistanceService;
import com.vatsaladhiya.vatsal.routeq.routeq.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareCalculationDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        Double distance = distanceService.CalculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOffLocation());
        // TODO: Call the 3rd party API
        return distance * RIDE_FARE_MULTIPLIER;
    }
}
