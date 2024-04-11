package pl.futurecollars.invoicing.utils

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Path;

public class FilesServiceTest extends Specification {

    private Path path = Files.createTempFile('lines', '.txt')

    def "appendLineToFileShouldAddLineToFile"() {
        given:
        def fileService = new FilesService()
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




