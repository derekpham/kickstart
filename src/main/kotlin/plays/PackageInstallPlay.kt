package plays

import models.Validator

class PackageInstallPlay(private val packageNames: Iterable<String>,
                         validators: Iterable<Validator> = emptyList())
    : AbstractPlay(validators = validators) {

    override fun execute() {

    }

    override fun dryRun() {
        println("Would have executed command: ${getCommand()}")
    }

    private fun getCommand(): String {
        return "pacman -S " + packageNames.joinToString(" ")
    }
}