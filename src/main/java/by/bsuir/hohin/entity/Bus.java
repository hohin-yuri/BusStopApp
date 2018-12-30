package by.bsuir.hohin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bus implements Comparable<Bus>{

    private final static String TIME_FORMAT = "%02d:%02d";

    private ServiceName serviceName;
    private Calendar departureTime;
    private Calendar arrivalTime;

    @Override
    public int compareTo(Bus otherBus) {
        if (departureTime.compareTo(otherBus.getDepartureTime()) != 0) {
            return departureTime.compareTo(otherBus.getDepartureTime());
        }
        if (arrivalTime.compareTo(otherBus.getArrivalTime()) != 0) {
            return arrivalTime.compareTo(otherBus.getArrivalTime());
        }
        return 0;
    }

    @Override
    public String toString() {

        return String.format("%s %s %s", serviceName.toString(), String.format(TIME_FORMAT,
                departureTime.get(Calendar.HOUR_OF_DAY),
                departureTime.get(Calendar.MINUTE)), String.format(TIME_FORMAT,
                arrivalTime.get(Calendar.HOUR_OF_DAY),
                arrivalTime.get(Calendar.MINUTE)));
    }
}
