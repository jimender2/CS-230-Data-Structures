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
			currentBid,
			maxBid;

		String tempPerson,
				highBidder,
				out;

		System.out.println("New Bid      Result      High Bidder           High Bid             Maximum Bid");
		System.out.println("-------------------------------------------------------------------------------");
		while(file.hasNext()) {
			tempBid = file.nextInt();
			tempPerson = file.nextLine();
			if (bid.isEmpty()) {
				bid.push(1);
				person.push(tempPerson);
				highBidder = tempPerson;
				currentBid = 1;
				maxBid = tempBid;
				System.out.println(tempBid + " " + tempPerson + "   New High Bidder  " + highBidder + "    " + currentBid + " " + maxBid);
			} else if ( tempBid < (int) bid.peek() ) {
				//Do nothing
			} else if ( tempBid == (int) bid.peek()) {
				currentBid = tempBid;
				//Need to fix this part
				//System.out.println(tempBid + " " + tempPerson + "   New High Bidder  " + highBidder + "    " + currentBid + " " + maxBid);
			} else {
				//Increase bid
			}
		}
		
		while (!bid.isEmpty()) {
			System.out.println(person.pop() + " " + bid.pop());
		}

		file.close();
	}

}
