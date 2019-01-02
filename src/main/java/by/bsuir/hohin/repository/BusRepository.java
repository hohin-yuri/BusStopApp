package by.bsuir.hohin.repository;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.util.List;

public interface BusRepository {
    public void addBus(Bus bus);
    public List<Bus> getBusesByServiceName(ServiceName serviceName);
}
