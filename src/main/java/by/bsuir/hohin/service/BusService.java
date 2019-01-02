package by.bsuir.hohin.service;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;

import java.util.List;

public interface BusService {
    public void addBus(Bus bus);
    public List<Bus> getBusesByServiceName(ServiceName serviceName);
}
