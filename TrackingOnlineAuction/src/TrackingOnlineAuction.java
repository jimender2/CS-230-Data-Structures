/**
 * @author Jonathan Meredith
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TrackingOnlineAuction {

	public static void main(String[] args) throws FileNotFoundException {

		File fileIn = new File("bids.txt");
		Scanner file = new Scanner(fileIn);

		ABStack person = new ABStack<String>();
		ABStack bid = new ABStack<Integer>();

		int tempBid,
			maxBid,
			highBidder;

		String tempPerson,
				out;

		System.out.println("New Bid      Result      High      Bidder      High Bid      Maximum Bid");
		System.out.println("-------------------------------------------------------------------------------");
		while(file.hasNext()) {
			tempBid = file.nextInt();
			tempPerson = file.nextLine();
			
		}
		
		while (!bid.isEmpty()) {
			System.out.println(person.pop() + " " + bid.pop());
		}

		file.close();
	}

}
