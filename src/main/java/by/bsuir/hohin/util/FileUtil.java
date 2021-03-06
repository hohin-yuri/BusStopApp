package by.bsuir.hohin.util;

import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.entity.ServiceName;
import by.bsuir.hohin.parser.BusParser;
import by.bsuir.hohin.parser.StringParser;
import by.bsuir.hohin.service.BusService;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface FileUtil {

    public static List<Bus> parseFromFile(StringParser<Bus> busParser, String path) throws IOException {
        try(Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.map(busParser::parse).collect(Collectors.toList());
        }
    }

    public static void writeToFile(BusService busService, String path) throws IOException {

        List<String> grottyBuses = busService.getBusesByServiceName(ServiceName.GROTTY)
                .parallelStream().map(Bus::toString).collect(Collectors.toList());

        List<String> poshBuses = busService.getBusesByServiceName(ServiceName.POSH)
                .parallelStream().map(Bus::toString).collect(Collectors.toList());

        Path outPath = Paths.get(path);

        if (!Files.exists(outPath, LinkOption.NOFOLLOW_LINKS))
            Files.createFile(outPath);

        Files.write(outPath, poshBuses);
        Files.write(outPath, "\n".getBytes(), StandardOpenOption.APPEND);
        Files.write(outPath, grottyBuses, StandardOpenOption.APPEND);
    }
}
