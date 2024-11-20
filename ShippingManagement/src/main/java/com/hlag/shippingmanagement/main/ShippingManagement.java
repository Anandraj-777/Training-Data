package com.hlag.shippingmanagement.main;

import java.util.List;
import java.util.Scanner;

import com.hlag.shippingmanagement.entity.Shipment;
import com.hlag.shippingmanagement.serviceImpl.ShipmentServiceImpl;

public class ShippingManagement {

    private static ShipmentServiceImpl shipmentService = ShipmentServiceImpl.getInstance();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ShippingManagement app = new ShippingManagement();

        while (true) {
            System.out.println("\nShipping Management System");
            System.out.println("1. Add Shipment");
            System.out.println("2. Update Shipment");
            System.out.println("3. Delete Shipment");
            System.out.println("4. View Shipments by Assigned Driver");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    app.addShipment();
                    break;
                case 2:
                    app.updateShipment();
                    break;
                case 3:
                    app.deleteShipment();
                    break;
                case 4:
                    app.viewShipmentsByAssignedDriver();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addShipment() {
        System.out.print("Enter Order: ");
        String order = scanner.nextLine();
        System.out.print("Enter Tracking Number: ");
        String trackingNumber = scanner.nextLine();
        System.out.print("Enter Assigned Driver: ");
        String assignedDriver = scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        int id = (int) (Math.random() * 10000); // Generate a random ID for simplicity
        Shipment shipment = new Shipment(id, order, trackingNumber, assignedDriver, status);
        shipmentService.add(shipment);
        System.out.println("Shipment added successfully.");
    }

    private void updateShipment() {
        System.out.print("Enter Shipment ID to update: ");
        int shipmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Shipment existingShipment = shipmentService.get(shipmentId);

        if (existingShipment != null) {
            System.out.println("Shipment found: " + existingShipment);
            System.out.println("1. Update Order");
            System.out.println("2. Update Tracking Number");
            System.out.println("3. Update Assigned Driver");
            System.out.println("4. Update Status");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter new Order: ");
                    String order = scanner.nextLine();
                    existingShipment.setOrder(order);
                    break;
                case 2:
                    System.out.print("Enter new Tracking Number: ");
                    String trackingNumber = scanner.nextLine();
                    existingShipment.setTrackingNumber(trackingNumber);
                    break;
                case 3:
                    System.out.print("Enter new Assigned Driver: ");
                    String assignedDriver = scanner.nextLine();
                    existingShipment.setAssignedDriver(assignedDriver);
                    break;
                case 4:
                    System.out.print("Enter new Status: ");
                    String status = scanner.nextLine();
                    existingShipment.setStatus(status);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
            shipmentService.update(shipmentId, existingShipment);
            System.out.println("Shipment updated successfully.");
        } else {
            System.out.println("Shipment not found.");
        }
    }

    private void deleteShipment() {
        System.out.print("Enter Shipment ID to delete: ");
        int shipmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (shipmentService.delete(shipmentId)) {
            System.out.println("Shipment deleted successfully.");
        } else {
            System.out.println("Shipment not found.");
        }
    }

    private void viewShipmentsByAssignedDriver() {
        System.out.print("Enter Assigned Driver to filter shipments: ");
        String assignedDriver = scanner.nextLine();
        List<Shipment> shipments = shipmentService.getShipmentsByAssignedDriver(assignedDriver);
        displayShipments(shipments);
    }

    private void displayShipments(List<Shipment> shipments) {
        System.out.println("\nShipment List:");
        if (shipments.isEmpty()) {
            System.out.println("No shipments available.");
        } else {
            for (Shipment shipment : shipments) {
                System.out.println(shipment);
            }
        }
    }
}
