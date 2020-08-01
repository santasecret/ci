pipelineJob('Rusty'){
  description('Relase Job for Rusty')
  definition {
    cps {
      script(readFileFromWorkspace('jenkins/pipelines/Rusty/Jenkinsfile'))
      sandbox()
    }
  }
}

