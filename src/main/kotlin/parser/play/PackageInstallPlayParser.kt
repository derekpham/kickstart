package parser.play

import parser.exception.InvalidSyntaxException
import plays.PackageInstallPlay

object PackageInstallPlayParser {
    private const val KEY = "packages"

    @Suppress("UNCHECKED_CAST")
    fun parse(rawProperties: Map<*, *>): PackageInstallPlay {
        if (!rawProperties.containsKey(KEY)) {
            throw InvalidSyntaxException("Must specify packages to install.")
        }

        val packages: Iterable<String> = rawProperties[KEY] as Iterable<String>
        return PackageInstallPlay(packageNames = packages)
    }
}