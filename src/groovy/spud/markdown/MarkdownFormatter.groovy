package spud.markdown

import spud.core.FormatterInterface
import org.pegdown.PegDownProcessor

class MarkdownFormatter implements FormatterInterface {
	String compile(String input) {
		if(!input) {
			return input
		}
		def processor = new PegDownProcessor()
		return processor.markdownToHtml(input)
	}
}
