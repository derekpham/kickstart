package parser

import models.{Play, Playbook}

object Parser {
  def parse(yaml: Yaml): Playbook = {
    new Playbook(List[Play]())
  }
}
