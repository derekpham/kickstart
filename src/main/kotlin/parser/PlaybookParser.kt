package parser

import models.Play
import models.PlayBook
import plays.PackageInstallPlay
import org.yaml.snakeyaml.Yaml
import parser.exception.InvalidSyntaxException
import parser.exception.UnrecognizedPlayNameException
import parser.play.PackageInstallPlayParser
import plays.NoopPlay

object PlaybookParser {
    fun parse(rawYamlPlayBook: String): PlayBook {
        val plays = extractRawPlays(rawYamlPlayBook).map { parsePlay(it) }
        return PlayBook(plays)
    }

    private fun extractRawPlays(rawYamlPlayBook: String): Iterable<*> {
        return Yaml().loadAll(rawYamlPlayBook).iterator().next()
                as? Iterable<*>
            ?: throw InvalidSyntaxException(
                "Playbook must be consisted of list of plays. " +
                        "Please see the docs for more information."
            )
    }

    private fun parsePlay(rawPlay: Any?): Play {
        if (rawPlay !is Map<*, *>) {
            throw InvalidSyntaxException("Play must be a mapping of name to properties.")
        }
        if (rawPlay.size != 1) {
            throw InvalidSyntaxException("There can only be one key (play name).")
        }

        val entry = rawPlay.iterator().next()
        val playProps: Map<*, *> = entry.value as Map<*, *>
        println(playProps)
        return when (entry.key) {
            "install" -> PackageInstallPlayParser.parse(playProps)
            "dotfiles" -> NoopPlay() // TODO fix this
            else -> throw UnrecognizedPlayNameException(entry.key as String)
        }
    }
}