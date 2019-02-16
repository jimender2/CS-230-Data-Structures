import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Jonathan Meredith
 *
 */

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

		System.out.printf("%10s %20s %20s %20s %20s", "New Bid", "Result", "High Bidder", "High Bid", "Maximum Bid");
		System.out.println("");
//		System.out.println("New Bid      Result      High Bidder           High Bid             Maximum Bid");
		System.out.println("---------------------------------------------------------------------------------------------------------");
		while(file.hasNext()) {
			tempBid = file.nextInt();
			tempPerson = file.nextLine();
			if (bid.isEmpty()) {
				bid.push(1);
				person.push(tempPerson);
				highBidder = tempPerson;
				currentBid = 1;
				maxBid = tempBid;
				System.out.printf("%10s %20s %20s %20s %20s", tempBid + " " + tempPerson, "New High Bidder", person.peek(), currentBid, maxBid);
				System.out.println("");
//				System.out.println(tempBid + " " + tempPerson + "   New High Bidder  " + highBidder + "    " + currentBid + " " + maxBid);
			} else if ( tempBid < currentBid ) {
				//Do nothing
				//works
			} else if (tempBid >= currentBid) {

				if (tempBid < maxBid) {
					currentBid = tempBid;
					if (tempBid == (int) bid.peek()) {
						System.out.printf("%10s %20s %20s %20s %20s", tempBid + " " + tempPerson, "No Change", person.peek(), currentBid, maxBid);
						System.out.println("");
//						System.out.println(tempBid + " " + tempPerson + "   No change  " + person.peek() + "    " + currentBid + " " + maxBid);
					} else {
						bid.push(currentBid);
						person.push(person.peek());
						System.out.printf("%10s %20s %20s %20s %20s", tempBid + " " + tempPerson, "High Bid Increased", person.peek(), currentBid, maxBid);
						System.out.println("");

//						System.out.println(tempBid + " " + tempPerson + "   High bid increased  " + person.peek() + "    " + currentBid + " " + maxBid);
					}

				} else if (tempBid > maxBid) {
					currentBid = maxBid + 1;
					maxBid = tempBid;
					bid.push(currentBid);
					person.push(tempPerson);
					System.out.printf("%10s %20s %20s %20s %20s", tempBid + " " + tempPerson, "New High Bidder", person.peek(), currentBid, maxBid);
					System.out.println("");
//					System.out.println(tempBid + " " + tempPerson + "   New high bidder  " + person.peek() + "    " + currentBid + " " + maxBid);

				}

			}
		}

		file.close();
		System.out.println("");

		System.out.println("The bid history for this auction is:");
		while (!bid.isEmpty()) {
			System.out.printf("%20s %s", person.pop(), bid.pop());
			System.out.println("");
		}

	}

}
