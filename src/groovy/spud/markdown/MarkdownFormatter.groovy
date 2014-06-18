package spud.markdown

import spud.core.FormatterInterface
/*import org.pegdown.**/
import org.markdown4j.Markdown4jProcessor;

class MarkdownFormatter implements FormatterInterface {
	String compile(String input) {
		if(!input) {
			return input
		}
		/*def processor = new PegDownProcessor(org.pegdown.Extensions.FENCED_CODE_BLOCKS | org.pegdown.Extensions.HARDWRAPS | org.pegdown.Extensions.AUTOLINKS | org.pegdown.Extensions.TABLES )*/
		/*return processor.markdownToHtml(input)*/
		/*RootNode astRoot = processor.parseMarkdown(input)*/
		/*String html = new MyCustomToHtmlSerializer().toHtml(astRoot);*/
		def markdownText = Markdown4jProcessor().process(input);

		// Lets fix our handlebars escaping
		return markdownText.replaceAll(/({{{?.*}}}?)/) { fullMatch, handlebarsPattern -> 
			return handlebarsPattern.decodeHTML()
		}
		
	}
}
