package com.company.Agency;

import com.company.Order.Order;
import com.company.Service.GList;
import com.company.Service.GNode;

public class LinkedList {
    private Node firstAgency;

    /**
     * in LinkedList constructor we make an empty node for simplicity of work on first node.
     * it will become printed in the agencyList method as a sample of agency name.
     * LinkedList constructor bigO(1)
     */
    public LinkedList() {
        setFirstAgency(new Node());
        getFirstAgency().setAgencyName("Agency name");
    }

    /**
     * addAgency method add a Agency at the end of a linkedList.
     * it checks if there was a similar agency with that name it wont add that agency.
     * addAgency method bigO(n)
     */
    public void addAgency() {
        Node temp = getFirstAgency();
        Node n = new Node();
        n.input();
        while (temp.getNext() != null) {
            if (temp.getNext().getAgencyName().equals(n.getAgencyName())) {
                System.out.println("there is another agency with that name!");
                return;
            } else temp = temp.getNext();
        }
        temp.setNext(n);
    }

    /**
     * addOffer method will add a main service in generalized list to an agency's arrayList of services.
     * we have a recursiveSearchLinkedList method in this.
     * first it checks if there is agency in the linkedList with that name with recursiveSearchLinkedList method.
     * there is a boolean named found we set initialize it false at first and checks in a for if there is service in the arrayList already with that name make it true.
     * it checks if there was not any main service in the generalized linkedList with the name which token as an input of the method it will print a massage.
     * addOffer method bigO = [recursiveSearchLinkedList method bigO(n)] + [for bigO(n)] + [while bigO(n)] = bigO(n)
     *
     * @param serviceName its the name of the service we want to add to an agency.
     * @param agencyName  its the name of the agency we want to add a service to its arrayList of services.
     * @param first1      first node of the generalized List of services.
     */
    public void addOffer(String serviceName, String agencyName, GNode first1) {
        Node temp = recursiveSearchLinkedList(getFirstAgency(), agencyName);
        if (temp != null) {
            boolean found = false;
            for (int i = 0; i < temp.getServices().size(); i++) {
                if (temp.getServices().get(i).getServiceName().equals(serviceName)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                while (first1 != null) {
                    if (first1.getServiceName().equals(serviceName)) {
                        temp.getServices().add(first1);
                        first1.setLink(first1.getLink() + 1);
                        return;
                    }
                    first1 = first1.getNext();
                }
                System.out.println("there is no main service with that name!");
            } else System.out.println("We have a service with this name in the agencies offer!");
        } else System.out.println("there is no agency with that name!");
    }

    /**
     * customerOrder method will get a name of an agency and make an Order and gets it information with info method and add it to agency with addOrder method.
     * it checks if there was not any agency with that name or any service which customer wants to order it will print a massage.
     * we have a recursiveSearchLinkedList method and an input method and addOrder method in this.
     * costumerOrder method bigO(n).
     *
     * @param agencyName its a name of the agency which customer wants to order a service from it.
     */
    public void customerOrder(String agencyName) {
        Node temp = recursiveSearchLinkedList(getFirstAgency(), agencyName);
        if (temp != null) {
            Order order = new Order();
            order.input();
            boolean found = false;
            for (int i = 0; i < temp.getServices().size(); i++) {
                if (temp.getServices().get(i).getServiceName().equals(order.getServiceName())) {
                    found = true;
                    break;
                }
            }
            if (found) temp.getQueue().addOrder(order);
            else System.out.println("there is no main service with that name in this agency!");
        } else System.out.println("Agency not found!");
    }

    /**
     * listOrder method get an agency name and use printOrders method to print all orders in the agency and delete them.
     * if there was not any agency with that name it will print a massage.
     * listOrder method bigO(n*log(n))
     *
     * @param agencyName its the name the agency which we want to do its orders;
     */
    public void listOrder(String agencyName) {
        Node temp = recursiveSearchLinkedList(getFirstAgency(), agencyName);
        if (temp != null) {
            temp.getQueue().printOrders();
        } else System.out.println("Agency not found!");
    }


    /**
     * listAgencies method will print all agencies in linkedList recursively.
     * listAgencies method bigO(n)
     *
     * @param f first node of the linked list.
     */
    public void listAgencies(Node f) {
        if (f == null) return;
        else System.out.println("{" + f.getAgencyName() + "}");
        listAgencies(f.getNext());
    }

    /**
     * delete method will delete a service from an agency.
     * we have a recursiveSearchLinkedList and deleteServiceFromGList in this method.
     * it checks if there was not that agency in linkedList it print a massage.
     * it checks if there was not that service in generalized linkedList it print a massage.
     * if the service we want to delete was only pointed with this agency it will delete that service and its subLists completely and print a massage.
     * if the service was pointed from more than one agency it wont be delete and only decrease the number of links pointed to that service.
     * delete method bigO(n)
     *
     * @param serviceName its the name of the service which we want to delete it from generalized linkedList.
     * @param agencyName  its the name of the agency which we want to delete a service from it.
     * @param first1      its the first node of the agencies linkedList.
     * @param first2      its the first node of the services generalized linkedList.
     */
    public void delete(String serviceName, String agencyName, Node first1, GNode first2) {
        Node temp = recursiveSearchLinkedList(first1, agencyName);
        if (temp == null) System.out.println("Agency not found!");
        else {
            for (int i = 0; i < temp.getServices().size(); i++) {
                if (temp.getServices().get(i).getServiceName().equals(serviceName)) {
                    if (temp.getServices().get(i).getLink() < 2) {
                        temp.getServices().get(i).setLink(temp.getServices().get(i).getLink() - 1);
                        GList gList = new GList();
                        gList.deleteServiceFromGList(first2, serviceName);
                        temp.getServices().remove(i);
                        System.out.println("Service and subLists of this service deleted completely");
                    } else {
                        temp.getServices().get(i).setLink(temp.getServices().get(i).getLink() - 1);
                        temp.getServices().remove(i);
                    }
                    break;
                } else System.out.println("there is no service with that name!");
            }
        }

    }

    /**
     * recursiveSearchLinkedList method will find an agency in the linked list recursively.
     * recursiveSearchLinkedList method bigO(n)
     *
     * @param first      its the first node of the linkedList we want to search.
     * @param agencyName its the name of the agency we want to find in the linkedList.
     * @return its the agency we looking for if its not found it will return null.
     */
    private Node recursiveSearchLinkedList(Node first, String agencyName) {
        if (first == null) return null;
        if (first.getAgencyName().equals(agencyName)) return first;
        else return recursiveSearchLinkedList(first.getNext(), agencyName);
    }

    public Node getFirstAgency() {
        return firstAgency;
    }

    private void setFirstAgency(Node firstAgency) {
        this.firstAgency = firstAgency;
    }
}
