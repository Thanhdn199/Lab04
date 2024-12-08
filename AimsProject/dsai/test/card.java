package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo các đối tượng DigitalVideoDisc (DVD)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Jungle Book", "Animation", "Jon Favreau", 118, 15.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella", "Fairy Tale", "Kenneth Branagh", 105, 12.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", "Jon Favreau", 118, 14.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin", "Fairy Tale", "Guy Ritchie", 128, 13.99f);

        // Tạo giỏ hàng mới
        Cart cart = new Cart();

        // Thêm DVD vào giỏ hàng
        System.out.println("Adding DVDs to the cart:");
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(dvd4);

        // In chi tiết giỏ hàng
        System.out.println("\nPrinting cart details:");
        cart.printCartDetails();

        // Tính tổng chi phí
        System.out.println("Total cost of the cart: " + cart.totalCost() + " $\n");

        // Xóa một DVD khỏi giỏ hàng
        System.out.println("Removing DVD: " + dvd2.getTitle());
        cart.removeMedia(dvd2);
        System.out.println("\nPrinting cart details after removal:");
        cart.printCartDetails();

        // Tìm kiếm DVD theo ID
        System.out.println("\nSearching by ID:");
        cart.searchById(1);   // Tìm ID của một DVD (giả định DVD có ID là 1)
        cart.searchById(10);  // Tìm ID không tồn tại

        // Tìm kiếm DVD theo Title
        System.out.println("\nSearching by Title:");
        cart.searchByTitle("The Jungle Book");  // DVD có trong giỏ
        cart.searchByTitle("The Matrix");       // DVD không có trong giỏ

        // Sắp xếp giỏ hàng
        System.out.println("\nSorting cart by Title:");
        cart.sortByTitle();
        cart.printCartDetails();

        System.out.println("\nSorting cart by Cost:");
        cart.sortByCost();
        cart.printCartDetails();

        // Xóa giỏ hàng
        System.out.println("\nClearing the cart:");
        cart.clearCart();
        cart.printCartDetails();
    }
}
