package plays

import models.Play
import models.Validator

abstract class AbstractPlay(var validators: Iterable<Validator> = emptyList()): Play  {
    override fun validate() {
        if (validators.iterator().hasNext()) {
            println("There's no validation specified for this play")
        } else {
            validators.forEach { it.validate() }
        }
    }
}