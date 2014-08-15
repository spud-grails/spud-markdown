class SpudMarkdownGrailsPlugin {
    // the plugin version
    def version = "0.6.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title           = "Spud Markdown Plugin" // Headline display name of the plugin
    def author          = "David Estes"
    def authorEmail     = "destes@bcap.com"
    def description     = 'Adds Markdown formatting support to the Spud Site Management platform.'
    def documentation   = "https://github.com/spud-grails/spud-markdown"
    def license         = "APACHE"
    def organization    = [name: "Bertram Labs", url: "http://www.bertramlabs.com/"]
    def issueManagement = [system: "GITHUB", url: "https://github.com/spud-grails/spud-markdown/issues"]
    def scm             = [url: "https://github.com/spud-grails/spud-markdown"]

    def doWithApplicationContext = { ctx ->
        application.config.spud.formatters << [name: 'markdown', description: 'Markdown', formatterClass: spud.markdown.MarkdownFormatter]
    }

}
