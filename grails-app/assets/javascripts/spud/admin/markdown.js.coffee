#= require spud/admin/editor.js
#= require spud/core/codemirror/lib/codemirror
#= require spud/core/codemirror/mode/xml/xml
#= require spud/core/codemirror/mode/javascript/javascript
#= require spud/core/codemirror/mode/css/css
#= require spud/core/codemirror/mode/markdown/markdown

class @MarkdownEditor
	editor: null
	refreshTimeout: null
	defaultOptions:
		lineNumbers: true
		lineWrapping: false
		theme: 'default'
		mode:
			name: 'markdown'

	constructor: (@element, options) ->
		if !@element.attr('id')
			@assignId()

		@loadWhenVisible()

	loadWhenVisible: () =>
		if @element.is(':visible')
			@refreshTimeout = null
			@editor = CodeMirror.fromTextArea(@element[0], @defaultOptions)
		else
			@refreshTimeout = setTimeout($.proxy(->
				@loadWhenVisible()
			,this),100)

	assignId: () =>
		baseId = "spud-codemirror-"
		counter = 1
		counter += 1 while $("##{baseId}#{counter}").length
		@element.attr 'id', "#{baseId}#{counter}"

	unload: ->
		if @refreshTimeout
			clearTimeout @refreshTimeout
		else
			@editor.toTextArea()

@spud.admin.editor.registerEditor 'markdown', @MarkdownEditor
