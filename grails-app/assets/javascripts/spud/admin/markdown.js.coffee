#= require spud/admin/codemirror
#= require codemirror/mode/markdown/markdown

class @MarkdownEditor extends @SpudCodeMirror
	defaultOptions:
		lineNumbers: false
		lineWrapping: true
		theme: 'default'
		mode:
			name: 'markdown'

@spud.admin.editor.registerEditor 'markdown', @MarkdownEditor
