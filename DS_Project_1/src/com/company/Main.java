package com.company;

import com.company.Agency.LinkedList;
import com.company.Service.GList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GList gList = new GList();
        LinkedList linkedList = new LinkedList();

        mainWhile:
        while (true) {
            System.out.println("What do u wanna do? (ENTER THE NUMBER)");
            System.out.println("1.Add service");
            System.out.println("2.Add subService to a service");
            System.out.println("3.Add agency");
            System.out.println("4.Add offer a service to an agency");
            System.out.println("5.Delete a main service from an agency");
            System.out.println("6.List agencies");
            System.out.println("7.List services");
            System.out.println("8.List services from an specific service");
            System.out.println("9.Order by customer");
            System.out.println("10.List orders of an agency");
            System.out.println("00.EXIT");
            String command = scanner.next();
            switch (command) {
                case "1":
                    gList.addService();
                    while1:
                    while (true) {
                        System.out.println("1.Add service");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                gList.addService();
                                break;
                            case "2":
                                break while1;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "2":
                    System.out.println("Enter the name of parent service:");
                    gList.addSubService(scanner.next());
                    while2:
                    while (true) {
                        System.out.println("1.Add subService");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                System.out.println("Enter the name of parent service:");
                                gList.addSubService(scanner.next());
                                break;
                            case "2":
                                break while2;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "3":
                    linkedList.addAgency();
                    while3:
                    while (true) {
                        System.out.println("1.Add Agency");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                linkedList.addAgency();
                                break;
                            case "2":
                                break while3;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "4":
                    System.out.println("Enter service name:");
                    String serviceName1 = scanner.next();
                    System.out.println("Enter agency name:");
                    String agencyName1 = scanner.next();
                    linkedList.addOffer(serviceName1, agencyName1, gList.getFirst1());
                    while4:
                    while (true) {
                        System.out.println("1.Add offer a service to an agency");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                System.out.println("Enter service name:");
                                String serviceName = scanner.next();
                                System.out.println("Enter agency name:");
                                String agencyName = scanner.next();
                                linkedList.addOffer(serviceName, agencyName, gList.getFirst1());
                                break;
                            case "2":
                                break while4;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "5":
                    System.out.println("Enter service name:");
                    String serviceName2 = scanner.next();
                    System.out.println("Enter agency name:");
                    String agencyName2 = scanner.next();
                    linkedList.delete(serviceName2, agencyName2, linkedList.getFirstAgency(), gList.getFirst1());
                    while5:
                    while (true) {
                        System.out.println("1.Delete a main service from an agency");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                System.out.println("Enter service name:");
                                String serviceName = scanner.next();
                                System.out.println("Enter agency name:");
                                String agencyName = scanner.next();
                                linkedList.delete(serviceName, agencyName, linkedList.getFirstAgency(), gList.getFirst1());
                                break;
                            case "2":
                                break while5;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "6":
                    linkedList.listAgencies(linkedList.getFirstAgency());
                    while6:
                    while (true) {
                        System.out.println("1.List agencies");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                linkedList.listAgencies(linkedList.getFirstAgency());
                                break;
                            case "2":
                                break while6;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "7":
                    gList.servicesList(gList.getFirst1());
                    while7:
                    while (true) {
                        System.out.println("1.List services");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                gList.servicesList(gList.getFirst1());
                                break;
                            case "2":
                                break while7;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "8":
                    System.out.println("Enter service name:");
                    gList.servicesListFrom(scanner.next(), gList.getFirst1());
                    while8:
                    while (true) {
                        System.out.println("1.List services from an specific service");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                System.out.println("Enter service name:");
                                gList.servicesListFrom(scanner.next(), gList.getFirst1());
                                break;
                            case "2":
                                break while8;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "9":
                    System.out.println("Enter agency name:");
                    linkedList.customerOrder(scanner.next());
                    while9:
                    while (true) {
                        System.out.println("1.Order by customer");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                System.out.println("Enter agency name:");
                                linkedList.customerOrder(scanner.next());
                                break;
                            case "2":
                                break while9;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "10":
                    System.out.println("Enter agency name:");
                    linkedList.listOrder(scanner.next());
                    while10:
                    while (true) {
                        System.out.println("1.list Order");
                        System.out.println("2.back");
                        String temp = scanner.next();
                        switch (temp) {
                            case "1":
                                System.out.println("Enter agency name:");
                                linkedList.listOrder(scanner.next());
                                break;
                            case "2":
                                break while10;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }
                    break;
                case "00":
                    break mainWhile;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
