package cl.cehd.ocr.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountInputReaderTestImp implements AccountInputReader {
    @Override
    public List<AccountNumberInput> readInputData() {

        List<AccountNumberInput> result = new ArrayList<>();

        String[] strings = fillValues();
        int fileLinesCount = strings.length + 1;
        for(int i=0;i<fileLinesCount/4;i++)
        {
            String line1=strings[i*4];
            String line2=strings[i*4+1];
            String line3=strings[i*4+2];
            AccountNumberInput accountNumberInput = new AccountNumberInput(line1, line2, line3);
            result.add(accountNumberInput);
        }
        return result;
    }

    private String[] fillValues() {
        String[] strings =null;
        try {
            return readData();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private String[] readData() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("input_data.txt")).toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data.split("\n");
    }
}
