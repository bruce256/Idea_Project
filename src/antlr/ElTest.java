package antlr;

import antlr.gen.El2Lexer;
import antlr.gen.El2Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @author lvsheng
 * @date 2019-03-24
 **/
public class ElTest {
	
	public static void main(String[] args) {
		
		
		String input =
				"a = 3 * 5 + 10;"
						+ "b=40;"
						+ "a * b + 100;"
						+ "a > b;"
						+ "b = 10;"
						+ "a > b;"
						+ "3 < 4 && 7 >= 3;"
						+ "3 > 4 && 7 > 4;";
		ANTLRInputStream  inputStream = new ANTLRInputStream(input);
		El2Lexer          lexer       = new El2Lexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		El2Parser         parser      = new El2Parser(tokenStream);
		ParseTree         parseTree   = parser.program();
		ElVisitorImpl     visitor     = new ElVisitorImpl();
		Double            rtn         = visitor.visit(parseTree);
		System.out.println("#result# = " + rtn.toString());
		
	}
}
