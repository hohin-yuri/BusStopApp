package by.bsuir.hohin.entity;

import by.bsuir.hohin.util.ConfigurationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

/**
 * This class represents bus entity in project.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bus implements Comparable<Bus>{

    private final static String TIME_OUTPUT_FORMAT =
            ConfigurationUtil.getProperty("date.output.format", "%02d:%02d");

    private ServiceName serviceName;
    private Calendar departureTime;
    private Calendar arrivalTime;

    /**
     * 
     * @param otherBus
     * @return
     */
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

    /**
     * This method translates bus into string format.
     * @return the resulting representation of bus in string format.
     */
    @Override
    public String toString() {

        return String.format("%s %s %s", serviceName.toString(), String.format(TIME_OUTPUT_FORMAT,
                departureTime.get(Calendar.HOUR_OF_DAY),
                departureTime.get(Calendar.MINUTE)), String.format(TIME_OUTPUT_FORMAT,
                arrivalTime.get(Calendar.HOUR_OF_DAY),
                arrivalTime.get(Calendar.MINUTE)));
    }
}
