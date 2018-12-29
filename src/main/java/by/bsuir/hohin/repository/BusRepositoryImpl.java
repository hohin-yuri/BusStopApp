package by.bsuir.hohin.repository;

import by.bsuir.hohin.checker.Checker;
import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.util.ArrayList;
import java.util.List;

public class BusRepositoryImpl implements BusRepository{

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
        return null;
    }

    @Override
    public List<Bus> getBusesByServiceName(ServiceName serviceName) {
        List<Bus> buses = new ArrayList<>();
        return null;
    }
}
