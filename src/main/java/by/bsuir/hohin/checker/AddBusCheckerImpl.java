package by.bsuir.hohin.checker;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.util.List;

public class AddBusCheckerImpl implements AddBusChecker {
    public Boolean canProvide(List<Bus> buses, Bus bus) {
        for (Bus b : buses) {
            if (bus.getServiceName().equals(ServiceName.GROTTY)
                    && b.getServiceName().equals(ServiceName.GROTTY)
                    && b.getDepartureTime().equals(bus.getDepartureTime())
                    && b.getArrivalTime().equals(bus.getArrivalTime())) {
                return false;
            }
            if (b.getDepartureTime().equals(bus.getDepartureTime())
                    && b.getArrivalTime().compareTo(bus.getArrivalTime()) < 0) {
                return false;
            }
            if (b.getDepartureTime().compareTo(bus.getDepartureTime()) > 0
                    && b.getArrivalTime().compareTo(bus.getArrivalTime()) <= 0) {
                return false;
            }
        }
        return true;
    }
}
