package by.bsuir.hohin.util;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.service.BusService;

import java.util.List;

public interface FileUtil {
    public List<Bus> parseFromFile(final String path);
    public List<Bus> writeToFile(BusService busService, final String path);
}
