package parser

import models.{Play, Playbook}
import org.yaml.snakeyaml.Yaml

object Parser {
  def parse(yaml: Yaml): Playbook = {
    new Playbook(List[Play]())
  }
}
