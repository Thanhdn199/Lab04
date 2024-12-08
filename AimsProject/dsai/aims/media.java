package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Thêm một Media vào giỏ hàng
    public void addMedia(Media item) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(item);
            System.out.println("Added: " + item.getTitle());
        } else {
            System.out.println("Cannot add more items, the cart is full!");
        }
    }

    // Xóa một Media khỏi giỏ hàng
    public void removeMedia(Media item) {
        if (itemsOrdered.remove(item)) {
            System.out.println("Removed: " + item.getTitle());
        } else {
            System.out.println("Item not found: " + item.getTitle());
        }
    }

    // Xóa Media theo title
    public boolean removeMediaByTitle(String title) {
        Iterator<Media> iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) {
            Media media = iterator.next();
            if (media.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Removed item: " + title);
                return true;
            }
        }
        System.out.println("No item found with title: " + title);
        return false;
    }

    // Tính tổng chi phí
    public float totalCost() {
        float total = 0;
        for (Media item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    // In chi tiết giỏ hàng
    public void printCartDetails() {
        System.out.println("*************** CART DETAILS ***************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.toString());
            index++;
        }
        System.out.println("Total Cost: " + totalCost() + " $");
        System.out.println("********************************************");
    }

    // Tìm kiếm Media theo title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found item: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with title: " + title);
        }
    }

    // Tìm kiếm Media theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found item: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID: " + id);
        }
    }

    // Sắp xếp giỏ hàng theo title và cost
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost.");
    }

    // Lấy Media theo title
    public Media getMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        System.out.println("No media found with title: " + title);
        return null;
    }

    // Xóa toàn bộ giỏ hàng
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart cleared successfully!");
    }

    // Lấy danh sách Media trong giỏ hàng
    public List<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }
}
