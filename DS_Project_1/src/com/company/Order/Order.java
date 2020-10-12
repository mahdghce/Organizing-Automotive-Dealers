package com.company.Order;

import java.util.Scanner;

public class Order {
    private String serviceName;
    private String customerName;
    private int immediacyLevel;
    private int time;

    /**
     * input method ask user to enter information about the order wanna make.
     * time complexity O(1).
     */
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        setCustomerName(scanner.next());
        System.out.println("Enter name of the service you want:");
        setServiceName(scanner.next());
        System.out.println("Enter immediacy Level number from bellow:");
        System.out.println("1.Normal");
        System.out.println("2.Required");
        System.out.println("3.Necessary");
        setImmediacyLevel(scanner.nextInt());
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getImmediacyLevel() {
        return immediacyLevel;
    }

    public void setImmediacyLevel(int immediacyLevel) {
        this.immediacyLevel = immediacyLevel;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    private void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    private void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
