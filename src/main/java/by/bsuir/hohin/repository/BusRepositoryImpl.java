package by.bsuir.hohin.repository;

import by.bsuir.hohin.checker.Checker;
import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.util.ArrayList;
import java.util.List;

public class BusRepositoryImpl implements BusRepository{

    private final List<Checker> checkers;

    public BusRepositoryImpl(List<Checker> checkers) {
        this.checkers = checkers;
    }
    public List<Bus> getBusesByServiceName(ServiceName serviceName) {
        List<Bus> buses = new ArrayList<>();
        return null;
    }
}
