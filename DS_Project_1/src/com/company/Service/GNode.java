package com.company.Service;

import java.util.Scanner;

public class GNode {
    private String ServiceName;
    private String vehicleModel;
    private String costumerDescription;
    private String agencyDescription;
    private String companyFees;
    private GNode next;
    private GNode DLink;
    private int link = 0;

    /**
     * input method ask user to enter information about the service wanna make.
     * time complexity O(1).
     */
    public void input() {
        System.out.println("Enter name of the service:");
        Scanner scanner = new Scanner(System.in);
        setServiceName(scanner.next());
        System.out.println("Enter model of the vehicle:");
        setVehicleModel(scanner.next());
        System.out.println("Enter description for costumer:");
        setCostumerDescription(scanner.next());
        System.out.println("Enter description for agency:");
        setAgencyDescription(scanner.next());
        System.out.println("Enter company fees:");
        setCompanyFees(scanner.next());
    }

    public String getServiceName() {
        return ServiceName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getCostumerDescription() {
        return costumerDescription;
    }

    public String getAgencyDescription() {
        return agencyDescription;
    }

    public String getCompanyFees() {
        return companyFees;
    }

    public GNode getNext() {
        return next;
    }

    public GNode getDLink() {
        return DLink;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public void setServiceName(String serviceName) {
        this.ServiceName = serviceName;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setCostumerDescription(String costumerDescription) {
        this.costumerDescription = costumerDescription;
    }

    public void setAgencyDescription(String agencyDescription) {
        this.agencyDescription = agencyDescription;
    }

    public void setCompanyFees(String companyFees) {
        this.companyFees = companyFees;
    }

    public void setNext(GNode next) {
        this.next = next;
    }

    public void setDLink(GNode DLink) {
        this.DLink = DLink;
    }
}
