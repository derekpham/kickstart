## Initial measure of success:
    - Being able to have a script to automatically download git, java, scala to download
    the repo, build the application and run a tester script
    - Being able to download playbook file and run it
    
## Syntax Tree:
A _playbook_ is consisted of _plays_.
A _play_ must have a name, and a (possibly empty) list of _validator_s.
A _validator_ must have a name, and a list _validation steps_
One supported validation step current is the manual validation step.