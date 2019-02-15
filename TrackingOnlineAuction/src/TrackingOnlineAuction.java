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
				highBidder = null;

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
			} else if ( tempBid < currentBid ) {
				//Do nothing
				//works
			} else if (tempBid >= currentBid) {

				if (tempBid < maxBid) {
					currentBid = tempBid;
					if (tempBid == (int) bid.peek()) {
						System.out.println(tempBid + " " + tempPerson + "   no change  " + person.peek() + "    " + currentBid + " " + maxBid);
					} else {
						bid.push(currentBid);
						person.push(person.peek());
						System.out.println(tempBid + " " + tempPerson + "   high bid increased  " + person.peek() + "    " + currentBid + " " + maxBid);
					}

				} else if (tempBid > maxBid) {
					currentBid = maxBid + 1;
					maxBid = tempBid;
					bid.push(currentBid);
					person.push(tempPerson);
					System.out.println(tempBid + " " + tempPerson + "   new high bidder  " + person.peek() + "    " + currentBid + " " + maxBid);

				}

			}
		}
		
		System.out.println("");
		while (!bid.isEmpty()) {
			System.out.println(person.pop() + " " + bid.pop());
		}

		file.close();
	}

}
