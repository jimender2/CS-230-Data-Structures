import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class ProcessingFootnotes {

	public static void main(String[] args) throws IOException {

		char ch;
		String line;
		String footnote;
		int index, footnoteIndex = 0;
		final char END_FOOTNOTE = '}';
		final char BEGIN_FOOTNOTE = '{';
		Scanner infile = new Scanner( new File( "document.txt"));
		LinkedQueue<String> footnotes = new LinkedQueue<String>();
		
		while( infile.hasNextLine()) {
			line = infile.nextLine();
			for( index = 0 ; index < line.length() ; index++) {
				
				
			}
			System.out.println();
		}
		
		System.out.println( "\n\n\n");
		

		infile.close();
		return;
	}
}
