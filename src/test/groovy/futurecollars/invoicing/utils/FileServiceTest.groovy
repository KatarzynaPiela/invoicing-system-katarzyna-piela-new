package futurecollars.invoicing.utils;

import org.junit.Test
import pl.futurecollars.invoicing.utils.FileService;
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Path;

public class FileServiceTest extends Specification {

    private Path path = Files.createTempFile('lines', '.txt')

    def "appendLineToFileShouldAddLineToFile"() {
        given:
        def fileService = new FileService()
        def line = "Test"
        when:
        fileService.appendLineToFile(path, line)
        then:
        fileService.readAllLines(path) == [line]

        and:
        def additionalLine = "Another line"
        fileService.appendLineToFile(path, additionalLine)

        and:
        Files.readAllLines(path).size() == 2
        Files.readAllLines(path)[1] == additionalLine
    }


}




