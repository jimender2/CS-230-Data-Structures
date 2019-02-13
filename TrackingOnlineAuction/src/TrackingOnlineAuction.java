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

		ABStack<String> person = new ABStack<>();
		ABStack<Integer> bid = new ABStack<>();

		int tempBid = 0,
			currentBid = 0,
			maxBid = 0;

		String tempPerson,
				highBidder,
				out;

		System.out.println("New Bid      Result      High Bidder           High Bid             Maximum Bid");
		System.out.println("-------------------------------------------------------------------------------");
		while(file.hasNext()) {
			tempBid = file.nextInt();
			tempPerson = file.nextLine();
			System.out.println(tempBid);
			if (bid.isEmpty()) {
				bid.push(1);
				person.push(tempPerson);
				highBidder = tempPerson;
				currentBid = 1;
				maxBid = tempBid;
				System.out.println(tempBid + " " + tempPerson + "   New High Bidder  " + highBidder + "    " + currentBid + " " + maxBid);
			} else if ( tempBid < currentBid ) {
				//Do nothing
				//works
			} else if ( tempBid == currentBid ) {
				currentBid = tempBid;
				bid.push(currentBid);
				person.push(person.peek());
				highBidder = tempPerson;
				maxBid = tempBid;
				//Need to fix this part
				System.out.println(tempBid + " " + tempPerson + "   Increase bid  " + highBidder + "    " + currentBid + " " + maxBid);
			} else {
				currentBid = tempBid;
				highBidder = tempPerson;
				bid.push(currentBid);
				person.push(highBidder);
				maxBid = tempBid;
				//Need to fix this part
				System.out.println(tempBid + " " + tempPerson + "   Increase bid  " + highBidder + "    " + currentBid + " " + maxBid);

			}
		}
		
		while (!bid.isEmpty()) {
			System.out.println(person.pop() + " " + bid.pop());
		}

		file.close();
	}

}
