import org.yaml.snakeyaml.Yaml
import parser.PlaybookParser
import java.io.File
import java.nio.file.attribute.FileTime

fun main(args: Array<String>) {
    val yamlFile = File(args[0])
    PlaybookParser.parse(yamlFile.readText()).execute(dryRun = true)
}
