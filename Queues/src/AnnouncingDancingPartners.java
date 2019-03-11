import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class AnnouncingDancingPartners {

	public static void main(String[] args) throws IOException {

		String dancer;
		CQueue<String> mqueue = new CQueue<String>();
		CQueue<String> fqueue = new CQueue<String>();
		Scanner infile = new Scanner( new File( "dancers.txt"));

		while( infile.hasNextLine()) {
			dancer = infile.nextLine();
			if( dancer.charAt(0) == 'F')
				fqueue.enqueue( dancer.substring( 2));
			else
				mqueue.enqueue( dancer.substring( 2));
		}
		
		System.out.println( "Announcing Dancers: " + fqueue);
		System.out.println( "Announcing Dancers: " + mqueue);

		
		
		infile.close();
		return;
	}
}
