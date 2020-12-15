package Lesson8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileHistoryService implements HistoryService {

    private static Lesson8.FileHistoryService instanse;
    private String path = "history.txt";

    private FileHistoryService() {

    }

    public static Lesson8.FileHistoryService getInstance() {
        return instanse == null ?
                new Lesson8.FileHistoryService() : instanse;
    }


    @Override
    public void save(List<String> chat) {
        try {
            Files.write(Paths.get(path), chat, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> load() {
        try {
            return Files.newBufferedReader(Paths.get(path))
                    .lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
    }
}
