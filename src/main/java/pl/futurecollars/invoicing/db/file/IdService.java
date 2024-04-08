package pl.futurecollars.invoicing.db.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import pl.futurecollars.invoicing.utils.FileService;

public class IdService {
  private final Path idFilePath;
  private final FileService fileService;

  private int nextId = 1;

  public IdService(FileService fileService, Path idFilePath) {
    this.idFilePath = idFilePath;
    this.fileService = fileService;

    List<String> lines = fileService.readAllLines(idFilePath);
    if (lines.isEmpty()) {
      fileService.writeToFile(idFilePath, "1");
    } else {
      nextId = Integer.parseInt(lines.get(0));
    }

  }

  public int getNextIdAndIncrement() {

    fileService.writeLinesToFile(idFilePath, Collections.singletonList(String.valueOf(nextId + 1)));
    return nextId++;

  }
}


