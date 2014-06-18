# Spud Markdown

The `spud-markdown` grails plugin provides Markdown syntax support for the spud site management formatted editor sections.
It allows, for example, a user to create CMS pages (with [spud-cms](http://github.com/spud-grails/spud-cms)) or Blog Posts (with [spud-blog](http://github.com/spud-grails/spud-blog)) in the markdown syntax.

For more information on how to use markdown syntax, please refer to the official [documentation](http://daringfireball.net/projects/markdown/syntax).

**NOTE**: Spud Markdown provides the github flavor of markdown syntax.

## Installation/Usage

This documentation assumes you are already running `spud-core` or `spud-cms` plugins. Add spud markdown to your BuildConfig.groovy:

```groovy
plugins {
	compile ":spud-markdown:0.5.0"
}
```

Now you can freely use markdown in any of the formatted editor sections of spud. Simply choose Markdown from the format dropdown box and a codemirror editor will show up.
