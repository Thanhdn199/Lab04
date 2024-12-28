package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void main(String[] args) {
		
        Store store = new Store(); 
        Cart cart = new Cart();   
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();  
            scanner.nextLine();         
            
            switch (choice) {
                case 1: 
                	storeMenu();
                    System.out.println("Danh sách mặt hàng trong cửa hàng:");
                    store.printStore();     
                    break;
                case 2: 
                    break;
                case 3: 
                	cartMenu();
                    cart.totalCost();      
                    break;
                case 0: 
                    System.out.println("Chương trình kết thúc. Cảm ơn bạn đã sử dụng!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 0);

        scanner.close();
		
	}
	public static void showMenu() {
	    System.out.println("AIMS: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Xem cửa hàng");
	    System.out.println("2. Cập nhật cửa hàng");
	    System.out.println("3. Xem giỏ hàng hiện tại");
	    System.out.println("0. Thoát");
	    System.out.println("--------------------------------");
	    System.out.println("Vui lòng chọn một số: 0-1-2-3");
	}
	
	public static void storeMenu() {
	    System.out.println("Các tùy chọn: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Xem chi tiết một phương tiện");
	    System.out.println("2. Thêm phương tiện vào giỏ hàng");
	    System.out.println("3. Phát phương tiện");
	    System.out.println("4. Xem giỏ hàng hiện tại");
	    System.out.println("0. Quay lại");
	    System.out.println("--------------------------------");
	    System.out.println("Vui lòng chọn một số: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
	    System.out.println("Các tùy chọn: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Thêm vào giỏ hàng");
	    System.out.println("2. Phát");
	    System.out.println("0. Quay lại");
	    System.out.println("--------------------------------");
	    System.out.println("Vui lòng chọn một số: 0-1-2");
	}
	
	public static void cartMenu() {
	    System.out.println("Các tùy chọn: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Lọc các phương tiện trong giỏ hàng");
	    System.out.println("2. Sắp xếp các phương tiện trong giỏ hàng");
	    System.out.println("3. Xóa phương tiện khỏi giỏ hàng");
	    System.out.println("4. Phát phương tiện");
	    System.out.println("5. Đặt hàng");
	    System.out.println("0. Quay lại");
	    System.out.println("--------------------------------");
	    System.out.println("Vui lòng chọn một số: 0-1-2-3-4-5");
	}


}
