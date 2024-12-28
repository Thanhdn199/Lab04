package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore;

    
    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        if (media != null) {
            itemsInStore.add(media);
            System.out.println("DVD đã được thêm vào Store: " + media.getTitle());
        } else {
            System.out.println("DVD không hợp lệ, không thể thêm!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("DVD đã được xóa khỏi Store: " + media.getTitle());
        } else {
            System.out.println("DVD không có trong Store, không thể xóa!");
        }
    }
    
    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("Store hiện không có phương tiện nào.");
        } else {
            System.out.println("Danh sách các phương tiện trong Store:");
            for (Media media : itemsInStore) {
                System.out.println(media.toString());
            }
        }
    }

}
