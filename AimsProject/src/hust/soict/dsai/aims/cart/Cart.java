package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
    public Cart() {
        this.itemsOrdered = new ArrayList<Media>();
    }
    
	public void addMedia(Media media) {
	    if (!itemsOrdered.contains(media)) {
	        itemsOrdered.add(media);
	        System.out.println(media.getTitle() + " has been added to the cart.");
	    } else {
	        System.out.println(media.getTitle() + " is already in the cart.");
	    }
	}

	public void removeMedia(Media media) {
	    if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	        System.out.println(media.getTitle() + " has been removed from the cart.");
	    } else {
	        System.out.println(media.getTitle() + " is not in the cart.");
	    }
	}
	
	public float totalCost() {
	    float total = 0;
	    for (Media media : itemsOrdered) {
	        total += media.getCost();
	    }
	    return total;
	}
	
    public void sortMediaByTitleCost() {	//tieu de
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortMediaByCostTitle() {	//gia
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
}
