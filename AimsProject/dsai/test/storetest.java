package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo các đối tượng DigitalVideoDisc
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Jungle Book", "Animation", "Jon Favreau", 118, 15.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella", "Fairy Tale", "Kenneth Branagh", 105, 12.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", "Jon Favreau", 118, 14.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin", "Fairy Tale", "Guy Ritchie", 128, 13.99f);

        // Tạo cửa hàng
        Store store = new Store();

        // Thêm DVD vào cửa hàng
        System.out.println("Adding DVDs to the store:");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);

        // Hiển thị danh sách sản phẩm trong cửa hàng
        System.out.println("\nDisplaying store items:");
        store.displayStoreItems();

        // Xóa một DVD khỏi cửa hàng
        System.out.println("\nRemoving DVD: " + dvd2.getTitle());
        store.removeMedia(dvd2);

        // Hiển thị lại danh sách sản phẩm
        System.out.println("\nDisplaying store items after removal:");
        store.displayStoreItems();

        // Thử xóa một DVD không tồn tại trong cửa hàng
        DigitalVideoDisc dvdNotInStore = new DigitalVideoDisc("Mulan", "Fairy Tale", "Tony Bancroft", 88, 11.99f);
        System.out.println("\nTrying to remove a DVD that does not exist in the store: " + dvdNotInStore.getTitle());
        store.removeMedia(dvdNotInStore);
    }
}
