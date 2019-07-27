package plays

class NoopPlay: AbstractPlay(validators = emptyList()) {
    override fun execute() {
        println("noop")
    }

    override fun dryRun() {
        execute()
    }

}