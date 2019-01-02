package by.bsuir.hohin;

import by.bsuir.hohin.checker.ArrivalAndDepartureTimeChecker;
import by.bsuir.hohin.checker.Checker;
import by.bsuir.hohin.checker.CheckersChain;
import by.bsuir.hohin.checker.TravelTimeChecker;
import by.bsuir.hohin.entity.Bus;
import by.bsuir.hohin.parser.BusParser;
import by.bsuir.hohin.parser.StringParser;
import by.bsuir.hohin.repository.BusRepositoryImpl;
import by.bsuir.hohin.service.BusService;
import by.bsuir.hohin.service.BusServiceImpl;
import by.bsuir.hohin.util.FileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    private final static String OUTPUT_FILE = "output.txt";

    public static void main(String args[]) throws IOException {

        String inputPath = args[0];
        StringParser<Bus> parser = new BusParser();
        List<Bus> buses = FileUtil.parseFromFile(parser, inputPath);
        BusService busService = null;
        Checker<Bus> checker = new TravelTimeChecker();
        ((CheckersChain<Bus>) checker).linkWith(new ArrivalAndDepartureTimeChecker());
        busService = new BusServiceImpl(new BusRepositoryImpl(checker));
        buses.parallelStream().forEach(busService::addBus);

        FileUtil.writeToFile(busService, OUTPUT_FILE);
    }
}
