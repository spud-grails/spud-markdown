grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.fork = [
    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    inherits("global")
    log "warn"
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        compile 'org.pegdown:pegdown:1.4.2'
    }

    plugins {
        runtime ':spud-core:0.2.3'
        build(":release:3.0.1",
              ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}
