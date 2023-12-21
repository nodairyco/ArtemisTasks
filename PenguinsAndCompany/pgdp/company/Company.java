package pgdp.company;
import pgdp.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Company {

    private final Employee CEO;
    private Tree<Integer> employeesTree;
    private Map<Integer,Employee> employees;
    private Queue<Integer> availableIDs;
    private static int availableID = 1;
    private String name;

    public Company(String name, Employee CEO) {
        this.name = name;
        this.CEO = CEO;
        employeesTree = new Tree<>(0);
        availableIDs = new PriorityQueue<>();
        employees = new HashMap<>();
        employees.put(0,CEO);
    }

    public void addEmployee(Employee newEmployee) {
        // TODO
        if(!employeesTree.containsKey(newEmployee.getBoss().getID()))
            return;
        newEmployee.setID(++availableID);
        employees.put(availableID,newEmployee);
        employeesTree.insert(availableID,newEmployee.getBoss().getID());
        availableIDs.add(availableID--);
    }

    public void fireEmployee(int ID) {
        // TODO
        if(!employeesTree.containsKey(ID))
            return;

        employeesTree.remove(ID);
        employees.remove(ID);
        availableIDs.remove(ID);
        availableID--;
    }

    public Employee findCommonBoss(Employee e1, Employee e2) {
        // TO-DO
        return employees.get(employeesTree.LCA(e1.getID(),e2.getID()));
    }

    public Employee findByID(int ID) {
       // TODO
        return employees.getOrDefault(ID,null);
    }
}
