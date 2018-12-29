package by.bsuir.hohin.parser;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BusParser implements StringParser<Bus>{

    private static final String TIME_FORMAT = "HH:mm";

    @Override
    public Bus parse(String info) {
        Bus bus = new Bus();
        String[] busFields = info.split(" ");

        ServiceName serviceName = ServiceName.fromString(busFields[0]);
        bus.setServiceName(serviceName);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);

        Calendar departureTime = Calendar.getInstance();
        Calendar arrivalTime = Calendar.getInstance();

        try {

            departureTime.setTime(simpleDateFormat.parse(busFields[1]));
            arrivalTime.setTime(simpleDateFormat.parse(busFields[2]));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        bus.setDepartureTime(departureTime);
        bus.setArrivalTime(arrivalTime);

        return bus;
    }
}
