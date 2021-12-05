package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Object purchase_transactions;
    private static Object Inventory_stock;

    public static void main(String[] args) {
        //Class import
        ArrayList<purchase_transactions> order = new ArrayList<purchase_transactions>();
        ArrayList<Inventory_stock> inventory = new ArrayList<Inventory_stock>();

        // Inventory for the system

        Inventory_stock merchandise = new Inventory_stock();
        merchandise.setStoreItem("Bison bumpersticker");
        merchandise.setItemPrice(4.99);
        inventory.add(merchandise);

        merchandise = new Inventory_stock();
        merchandise.setStoreItem("Bison tee");
        merchandise.setItemPrice(14.99);
        inventory.add(merchandise);

        merchandise = new Inventory_stock();
        merchandise.setStoreItem("Bison hoodie");
        merchandise.setItemPrice(23.99);
        inventory.add(merchandise);

        merchandise = new Inventory_stock();
        merchandise.setStoreItem("Bison sweater");
        merchandise.setItemPrice(55.99);
        inventory.add(merchandise);


        Scanner input = new Scanner(System.in);
        String items;
        double sum = 0.0;
        int index = -1;

        //Item gathering
        do {
            System.out.println("Which items are you purchasing? If none, enter none:  ");
            items = input.nextLine();
            purchase_transactions cart = new purchase_transactions();
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getStoreItem().equals(items)) {
                    index = i;
                    String customer_Item = inventory.get(index).getStoreItem();
                    double pricing = inventory.get(index).getItemPrice();
                    cart.setStore_Item(customer_Item);
                    cart.setSale_Price(pricing);
                    order.add(cart);
                }
            }
        }
        while (!items.equalsIgnoreCase("none"));

        //final loop for total
        for (int i = 0; i < order.size(); i++) {
            System.out.println("Items that I purchased: " + order.get(i).getStore_Item());
            double final_price= order.get(i).getSale_Price();
            sum += final_price;
        }

        System.out.println("Total: " + sum);

    }
}
