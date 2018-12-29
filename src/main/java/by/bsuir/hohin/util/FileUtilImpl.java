package by.bsuir.hohin.util;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;
import by.bsuir.hohin.parser.BusParser;
import by.bsuir.hohin.service.BusService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtilImpl implements FileUtil {

    @Override
    public List<Bus> parseFromFile(String path) throws IOException {
        BusParser busParser = new BusParser();
        try(Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.map(busParser::parse).collect(Collectors.toList());
        }
    }

    @Override
    public void writeToFile(BusService busService, String path) throws IOException {

        List<String> grottyBuses = busService.getBusesByServiceName(ServiceName.GROTTY)
                .parallelStream().map(Bus::toString).collect(Collectors.toList());
        List<String> poshBuses = busService.getBusesByServiceName(ServiceName.POSH)
                .parallelStream().map(Bus::toString).collect(Collectors.toList());

        Files.write(Paths.get(path), grottyBuses, StandardOpenOption.WRITE);
        Files.write(Paths.get(path), " ".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), poshBuses, StandardOpenOption.APPEND);
    }

}
