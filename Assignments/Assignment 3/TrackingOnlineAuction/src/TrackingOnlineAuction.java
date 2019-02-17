import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Jonathan Meredith
 * Assignment 3 for Data Structures
 * Auction tracker
 */

public class TrackingOnlineAuction {

	public static void main(String[] args) throws FileNotFoundException {

		//Variables
		File fileIn = new File("bids.txt");
		Scanner file = new Scanner(fileIn);

		ABStack<String> person = new ABStack<>();
		ABStack<Integer> bid = new ABStack<>();

		int tempBid = 0,
			currentBid = 0,
			maxBid = 0;

		String tempPerson;

		//Header
		System.out.printf("%10s %20s %15s %10s %15s", "New Bid", "Result", 
				"High Bidder", "High Bid", "Maximum Bid");
		System.out.println("");
		System.out.println("---------------------------------------------"
				+ "------------------------------");

		//Read file in and do operations
		while(file.hasNext()) {
			tempBid = file.nextInt();
			tempPerson = file.nextLine();

			//Do checking if valid bid
			if (bid.isEmpty()) {

				bid.push(1);
				person.push(tempPerson);
				currentBid = 1;
				maxBid = tempBid;
				System.out.printf("%10s %20s %15s %10s %15s", tempBid + 
						" " + tempPerson, "New High Bidder", 
						person.peek(), currentBid, maxBid);
				System.out.println("");

			} else if ( tempBid < currentBid ) {

				//Do nothing
				//Reject bid because it is too small

			} else if (tempBid >= currentBid) {

				if (tempBid < maxBid) {
					currentBid = tempBid;

					if (tempBid == (int) bid.peek()) {
						System.out.printf("%10s %20s %15s %10s %15s", 
								tempBid + " " + tempPerson, "No Change",
								person.peek(), currentBid, maxBid);
						System.out.println("");

					} else {
						bid.push(currentBid);
						person.push(person.peek());
						System.out.printf("%10s %20s %15s %10s %15s", 
								tempBid + " " + tempPerson, "High Bid "
								+ "Increased", person.peek(), currentBid,
								maxBid);
						System.out.println("");

					}

				} else if (tempBid > maxBid) {

					currentBid = maxBid + 1;
					maxBid = tempBid;
					bid.push(currentBid);
					person.push(tempPerson);
					System.out.printf("%10s %20s %15s %10s %15s", tempBid 
							+ " " + tempPerson, "New High Bidder", 
							person.peek(), currentBid, maxBid);
					System.out.println("");

				}
			}
		}

		//Close file
		file.close();
		System.out.println("");

		//Output results
		System.out.println("The bid history for this auction is:");
		while (!bid.isEmpty()) {
			System.out.printf("%s %10s", person.pop(), bid.pop());
			System.out.println("");
		}

	}

}
