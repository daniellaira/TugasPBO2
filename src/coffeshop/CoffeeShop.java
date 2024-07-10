/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeshop;

/**
 *
 * @author HP PAVILION
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

    private static List<MenuItem> menu = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi menu
        menu.add(new MenuItem("Espresso", 3000));
        menu.add(new MenuItem("Americano", 2500));
        menu.add(new MenuItem("Cappuccino", 4000));
        menu.add(new MenuItem("Latte", 3500));
        menu.add(new MenuItem("Mocha", 4500));

        // Tampilkan menu
        tampilkanMenu();

        // Ambil pesanan
        ambilPesanan(scanner);

        // Cetak struk
        cetakStruk();

        // Hapus objek yang tidak terpakai (garbage collection)
        System.gc();
    }

    private static void tampilkanMenu() {
        System.out.println("Menu Coffee Shop:");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - Rp" + item.getPrice());
        }
    }

    private static void ambilPesanan(Scanner scanner) {
        System.out.print("Masukkan nomor pesanan: ");
        int nomorPesanan = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        MenuItem item = menu.get(nomorPesanan - 1);
        Order order = new Order(item, jumlah);
        orders.add(order);
    }

    private static void cetakStruk() {
        System.out.println("\nStruk Pembayaran:");
        for (Order order : orders) {
            System.out.println(order.getItem().getName() + " x " + order.getQuantity() + " - Rp" + order.getTotalPrice());
        }

        int total = 0;
        for (Order order : orders) {
            total += order.getTotalPrice();
        }

        System.out.println("Total: Rp" + total);
    }
}
