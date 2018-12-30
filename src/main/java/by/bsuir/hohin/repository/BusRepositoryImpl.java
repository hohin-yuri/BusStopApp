package by.bsuir.hohin.repository;

import by.bsuir.hohin.checker.Checker;
import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BusRepositoryImpl implements BusRepository {

    private final Checker<Bus> checker;
    private final List<Bus> buses;

    public BusRepositoryImpl(Checker<Bus> checker) {
        this.checker = checker;
        this.buses = new ArrayList<>();
    }

    @Override
    public void addBus(Bus bus) {
        buses.add(bus);
    }

    private List<Bus> getCheckedBuses() {
        List<Bus> checkedBuses = new ArrayList<>();
        return buses.parallelStream()
                .filter(bus -> checker.canProvide(buses, bus))
                //.filter(bus -> { System.out.println(bus.toString()); System.out.println(checker.canProvide(buses, bus)); return checker.canProvide(buses, bus); })
                .collect(Collectors.toList());
    }

    @Override
    public List<Bus> getBusesByServiceName(ServiceName serviceName) {
        return  getCheckedBuses()
                .parallelStream()
                .filter(bus -> bus.getServiceName().equals(serviceName))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
