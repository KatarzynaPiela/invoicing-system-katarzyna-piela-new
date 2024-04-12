package pl.futurecollars.invoicing.db.file

import pl.futurecollars.invoicing.db.AbstractDatabaseTest
import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.helpers.TestHelpers
import pl.futurecollars.invoicing.utils.FilesService
import pl.futurecollars.invoicing.utils.JsonService

import java.nio.file.Files

class FileBasedDatabaseTest extends AbstractDatabaseTest {

    def dbPath

    @Override
    Database getDatabaseInstance() {
        def filesService = new FilesService()

        def idPath = File.createTempFile("ids", ".txt").toPath()
        def idService = new IdService(idPath, filesService)

        dbPath = File.createTempFile("invoices", ".txt").toPath()
        return FileBasedDatabase(dbPath, idService, filesService, new JsonService());
    }

    def "file based database writes invoices to correct file"() {
        given:
        def db = getDatabaseInstance()

        when:
        db.save ( TestHelpers.invoice(5))

        then :
        1 == Files.readAllLines(databasePath).size()

        when:
        db.save ( TestHelpers.invoice(6))

        then :
        2 == Files.readAllLines(databasePath).size()
    }
}
