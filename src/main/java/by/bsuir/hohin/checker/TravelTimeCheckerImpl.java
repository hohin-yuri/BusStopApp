package by.bsuir.hohin.checker;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TravelTimeCheckerImpl {
    private final static int TIME_LIMIT_IN_HOURS = 1;

    public Boolean canProvide(List<Bus> buses, Bus bus) {
        long departureTime = bus.getDepartureTime().getTimeInMillis();
        long arrivalTime = bus.getArrivalTime().getTimeInMillis();
        long period = arrivalTime - departureTime;
        return period <= TimeUnit.HOURS.toMillis(TIME_LIMIT_IN_HOURS);
    }
}
