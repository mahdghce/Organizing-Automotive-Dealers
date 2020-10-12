package com.company.Service;

public class GList {
    private GNode first1;

    /**
     * in GList constructor we initialize first node of generalized linkedList with empty GNode for simplicity of work on first node.
     * it will become printed in the both serviceList and serviceListFrom method's as a sample of a service node information.
     * GList constructor bigO(1)
     */
    public GList() {
        first1 = new GNode();
        first1.setServiceName("Service name");
        first1.setAgencyDescription("Agency description");
        first1.setCompanyFees("Company fees");
        first1.setCostumerDescription("Costumer description");
        first1.setVehicleModel("Vehicle model");
    }

    /**
     * addService method add a service at the end of the first line of generalized linkedList.
     * it checks the whole generalized list if there was a similar service with that name it wont add that service.
     * we used a recursive search method in this and an input method.
     * addService method bigO =  [search method bigO(n)] + [while bigO(n)] + [input method bigO(1)] = bigO(n)
     */
    public void addService() {
        GNode temp = first1;
        GNode n = new GNode();
        n.input();
        GNode temp1 = search(n.getServiceName(), getFirst1());
        if (temp1 == null) {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(n);
        } else System.out.println("there is a service or sub service with that name!");
    }

    /**
     * addSubService method will add a service as a sub service to an specific service which we took its name as an input of the method.
     * DLink for each service node will point to its first sub service.
     * it also checks if there was a sub service with a similar name in the whole generalized list it wont add it.
     * it also check if there was not any parent service which it took from input it wont add it anywhere and print a massage.
     * we used a recursive search method in this and an input method.
     * addSubService method bigO =  [search method bigO()] + [while bigO(n)] + [input method bigO(1)] = bigO(n)
     *
     * @param serviceName its the name of the service we want to add a sub service to it.
     */
    public void addSubService(String serviceName) {
        GNode n = new GNode();
        n.input();
        GNode temp1 = search(n.getServiceName(), first1);
        if (temp1 == null) {
            GNode temp2 = search(serviceName, first1);
            if (temp2 != null) {
                if (temp2.getDLink() != null) {
                    GNode temp3 = temp2.getDLink();
                    while (temp3.getNext() != null) {
                        temp3 = temp3.getNext();
                    }
                    temp3.setNext(n);
                } else temp2.setDLink(n);
                return;
            } else {
                System.out.println("parent service not found!");
                return;
            }
        }
        System.out.println("We have a sub_service with that name!");
    }

    /**
     * service list method will print all services in the generalized linkedList recursively.
     * it first print the main service and its sub services then print next main service...
     * if statement check if current service node is null wont print it.
     * serviceList method bigO(n)
     *
     * @param f the node we want to start print from the generalized linked list.
     */
    public void servicesList(GNode f) {
        if (f == null) return;
        else
            System.out.println("{ " + f.getServiceName() + " , " + f.getAgencyDescription() + " , " + f.getCompanyFees() + " , " + f.getCostumerDescription() + " , " + f.getVehicleModel() + " }");
        servicesList(f.getDLink());
        servicesList(f.getNext());
    }

    /**
     * serviceListFrom method will print all sub services of a chosen service in the generalized linkedList recursively.
     * we call serviceList method for sub service of the service which token its name as input serviceName.
     * it checks if there was not any service in Generalized linkedList it print a massage and wont print any service.
     * we used recursive serviceList and search methods in this
     * serviceListFrom method bigO = [serviceList method bigO(n)] + [search method bigO(n)] = big(n)
     *
     * @param serviceName it the name of a service in the generalized linkedList that we want to print its subLists.
     * @param first       the first node of the generalized linked list.
     */
    public void servicesListFrom(String serviceName, GNode first) {
        GNode temp = search(serviceName, first);
        if (temp == null) {
            System.out.println("we don't have a service with that name!");
            return;
        }
        servicesList(temp.getDLink());
    }

    /**
     * deleteServiceFromGList method will get the first node of generalized linkedList and find the service which it took its name as input of method and delete it.
     * deleteServiceFromGLIst bigO(n)
     *
     * @param first       its the first node of generalized linkedList.
     * @param serviceName its the name of the service we want to delete it and its subLists.
     */
    public void deleteServiceFromGList(GNode first, String serviceName) {
        if (first.getNext() != null) {
            if (first.getNext().getServiceName().equals(serviceName)) {
                first.setNext(first.getNext().getNext());
            } else deleteServiceFromGList(first.getNext(), serviceName);
        } else System.out.println("there is no service with that name!");
    }

    /**
     * search method will search the whole generalized linkedList to find a service recursively.
     * search method bigO(n)
     *
     * @param name its the name we want to find in GList.
     * @param p    first node of GList.
     * @return will return the service which have been found if there was not any service with that name it will return null.
     */
    private GNode search(String name, GNode p) {
        if (p == null) {
            return null;
        } else if (name.equals(p.getServiceName())) {
            return p;
        }
        GNode q = search(name, p.getNext());
        if (q != null) {
            return q;
        }
        q = search(name, p.getDLink());
        if (q != null) {
            return q;
        }
        return null;
    }

    public GNode getFirst1() {
        return first1;
    }


}
