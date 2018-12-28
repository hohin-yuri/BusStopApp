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
    private ServiceName serviceName;
    private Calendar departureTime;
    private Calendar arrivalTime;

    public int compareTo(Bus o) {
        return 0;
    }
}
