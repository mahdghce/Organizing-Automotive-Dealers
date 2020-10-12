package com.company.Agency;

import com.company.Order.PQueue;
import com.company.Service.GNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Node {
    private String agencyName;
    private Node next;
    private ArrayList<GNode> services = new ArrayList<>();
    private PQueue Queue = new PQueue();

    /**
     * input method ask user to enter information about the agency wanna make.
     * time complexity O(1).
     */
    public void input() {
        System.out.println("Enter name of the Agency:");
        Scanner scanner = new Scanner(System.in);
        setAgencyName( scanner.next());
    }

    public String getAgencyName() {
        return agencyName;
    }

    public Node getNext() {
        return next;
    }

    public ArrayList<GNode> getServices() {
        return services;
    }

    public PQueue getQueue() {
        return Queue;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
