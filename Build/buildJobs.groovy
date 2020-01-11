def branchName = "master"
pipelineJob("addressbook_build"){
    definition{
        parameters{
            stringParam('Branch',defaultValue = branchName)
        }
        cpsScm{
            scm{
                git{
                    remote{
                        url("https://github.com/KishorePosa/infrastructure.git")
                    }

                }

            }
            scriptPath("Jobs/Jenkinsfile_build.groovy")

        }
        publishers{
            logRotator{
                numToKeep(15)
                artifactNumToKeep(1)
            }

        }



    }

}
