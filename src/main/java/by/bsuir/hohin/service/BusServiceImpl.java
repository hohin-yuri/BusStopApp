package by.bsuir.hohin.service;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;
import by.bsuir.hohin.repository.BusRepository;

import java.util.List;

public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public void addBus(Bus bus) {
        busRepository.addBus(bus);
    }

    @Override
    public List<Bus> getBusesByServiceName(ServiceName serviceName) {
        return busRepository.getBusesByServiceName(serviceName);
    }
}
