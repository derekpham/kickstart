package models

interface Play {
    fun execute()
    fun dryRun()
    fun validate()

    fun execute(dryRun: Boolean) {
        if (dryRun) {
            dryRun()
        } else {
            execute()
            validate()
        }
    }
}