/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.posttest1;

import java.util.ArrayList;
import java.util.Scanner;
import service.cleaningservice;

/**
 *
 * @author Nova Nur Fauziah
 */
public class Posttest1 {

    
    static ArrayList<cleaningservice> servicesList = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            
           
            while (running) {
                System.out.println("\nSistem Layanan Kebersihan");
                System.out.println("1. Tambah Layanan");
                System.out.println("2. Lihat Layanan");
                System.out.println("3. Ubah Layanan");
                System.out.println("4. Hapus Layanan");
                System.out.println("5. Keluar");
                System.out.print("Pilih opsi: ");
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1 -> addService(scanner);
                    case 2 -> viewServices();
                    case 3 -> updateService(scanner);
                    case 4 -> deleteService(scanner);
                    case 5 -> {
                        running = false;
                        System.out.println("Keluar dari sistem.");
                    }
                    default -> System.out.println("Opsi tidak valid.");
                }
            }
        }
    }

    
    public static void addService(Scanner scanner) {
        scanner.nextLine();  // Konsumsi newline
        System.out.print("Masukkan nama layanan: ");
        String serviceName = scanner.nextLine();
        System.out.print("Masukkan deskripsi layanan: ");
        String description = scanner.nextLine();
        System.out.print("Masukkan harga layanan: ");
        double price = scanner.nextDouble();

       
        cleaningservice service = new cleaningservice(serviceName, description, price);
        servicesList.add(service); // Menambahkan layanan ke list

        System.out.println("Layanan berhasil ditambahkan.");
    }

    
    public static void viewServices() {
        if (servicesList.isEmpty()) {
            System.out.println("Belum ada layanan yang terdaftar.");
        } else {
            System.out.println("\nDaftar Layanan:");
            for (cleaningservice service : servicesList) {
                service.displayService();  // Memanggil method di CleaningService untuk menampilkan detail layanan
            }
        }
    }

    
    public static void updateService(Scanner scanner) {
        System.out.print("Masukkan ID layanan yang ingin diubah: ");
        int id = scanner.nextInt();
        cleaningservice foundService = null;

       
        for (cleaningservice service : servicesList) {
            if (service.getId() == id) {
                foundService = service;
                break;
            }
        }

       
        if (foundService != null) {
            scanner.nextLine();  // Konsumsi newline
            System.out.print("Masukkan nama layanan baru: ");
            String newName = scanner.nextLine();
            System.out.print("Masukkan deskripsi baru: ");
            String newDescription = scanner.nextLine();
            System.out.print("Masukkan harga baru: ");
            double newPrice = scanner.nextDouble();

           
            foundService.setServiceName(newName);
            foundService.setDescription(newDescription);
            foundService.setPrice(newPrice);

            System.out.println("Layanan berhasil diupdate.");
        } else {
            System.out.println("Layanan dengan ID tersebut tidak ditemukan.");
        }
    }

    
    public static void deleteService(Scanner scanner) {
        System.out.print("Masukkan ID layanan yang ingin dihapus: ");
        int id = scanner.nextInt();
        cleaningservice foundService = null;

       
        for (cleaningservice service : servicesList) {
            if (service.getId() == id) {
                foundService = service;
                break;
            }
        }

       
        if (foundService != null) {
            servicesList.remove(foundService);
            System.out.println("Layanan berhasil dihapus.");
        } else {
            System.out.println("Layanan dengan ID tersebut tidak ditemukan.");
        }
    }
}
