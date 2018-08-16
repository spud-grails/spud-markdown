package spud.markdown

import grails.plugins.*
import grails.util.Environment
import groovy.util.logging.Slf4j
import org.grails.config.NavigableMapPropertySource
import org.grails.config.PrefixedMapPropertySource
import org.springframework.core.env.MapPropertySource
import org.springframework.core.env.PropertySource

@Slf4j
class SpudMarkdownGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.3.7 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

//	def dependsOn = [spudCore: "3.0.0"]

    // TODO Fill in these fields
    def title = "Spud Markdown Plugin" // Headline display name of the plugin
    def author = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = '''\
Adds Markdown formatting support to the Spud Site Management platform.
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/spud-markdown"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]
	def organization    = [name: "Bertram Labs", url: "http://www.bertramlabs.com/"]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]
	def issueManagement = [system: "GITHUB", url: "https://github.com/spud-grails/spud-markdown/issues"]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]
	def scm             = [url: "https://github.com/spud-grails/spud-markdown"]

    Closure doWithSpring() { {->
            // TODO Implement runtime spring config (optional)
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
//		def customConfig = "[name: 'markdown', description: 'Markdown', formatterClass: spud.markdown.MarkdownFormatter]"
//		grailsApplication.config.spud.formatters << [name: 'markdown', description: 'Markdown', formatterClass: spud.markdown.MarkdownFormatter]
//		println "doWithApplicationContext customConfig: ${customConfig}"
		def customConfig = [:]
		customConfig.name = 'markdown'
		customConfig.description = 'Markdown'
		customConfig.formatterClass = 'spud.markdown.MarkdownFormatter'

		ArrayList formatters = grailsApplication.config.spud.formatters
		if(log.isDebugEnabled()) {
			log.debug "doWithApplicationContext formatters: ${formatters}"
		}
		formatters.add(customConfig)
		if(log.isDebugEnabled()) {
			formatters.each { formatter ->
				log.debug "formatter: ${formatter}"
			}
		}

		log.debug "doWithApplicationContext formatters.class.simpleName: ${formatters.class.simpleName}"
		if(log.isTraceEnabled()) {
			grailsApplication.config.toProperties().each { prop ->
				log.trace "prop: ${prop}"
			}
		}
		grailsApplication.configChanged()
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
		if (event.application) {
			log.info "onChange event: ${event?.application?.dump()}"
		} else {
			log.info "onChange event: ${event?.dump()}"
		}
	}

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
		log.info "onConfigChange event: ${event?.dump()}"
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
