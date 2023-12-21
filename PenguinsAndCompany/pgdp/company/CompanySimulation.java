package pgdp.company;

import java.util.Scanner;

public class CompanySimulation {
    public static void main(String[] args) {
        simulation("Novak","ATP");
    }

    private static void simulation(String ceoName, String companyName) {
        Employee ceo = new Employee(ceoName,null);
        ceo.setID(0);
        Company company = new Company(companyName,ceo);
        Scanner scanner = new Scanner(System.in);
        String numberOfQueries = scanner.nextLine();

        for (int k = 0; k < Integer.parseInt(numberOfQueries); k++) {
            String query = scanner.nextLine();
            if(query.startsWith("EmployeeWithID")){
                int ID = Integer.parseInt(query.substring(14));
                if(company.findByID(ID) == null)
                    System.out.println("Employee with ID " + ID + " does not exist.");
                else
                    System.out.println(company.findByID(ID));
            }
            else if(query.startsWith("Add")){
                String name = query.substring(4, query.indexOf(" "));
                int ID = Integer.parseInt(query.substring(4 + name.length() + 1));
                if(company.findByID(ID) == null)
                    System.out.println("No such boss exists");
                else{
                    Employee boss = company.findByID(ID);
                    Employee temp = new Employee(name, boss);
                    company.addEmployee(temp);
                    System.out.println("Completed!");
                }
            }
            else if(query.startsWith("Fire")){
                int id = Integer.parseInt(query.substring(5));
                if(company.findByID(id) == null)
                    System.out.println("employee dont exist fam styll dunno");
                else{
                    company.fireEmployee(id);
                }
            }
            else if(query.startsWith("FindCommonBoss")){
                int id1 = Integer.parseInt(query.substring(15, query.substring(16).indexOf(" ")));
                int id2 = Integer.parseInt(query.substring(query.substring(16).indexOf(" ")));
                if(company.findByID(id1) == null || company.findByID(id2) == null)
                    System.out.println("they dont exis cuh");
                else
                    System.out.println(company.findCommonBoss(company.findByID(id1), company.findByID(id2)));
            }
        }
        scanner.close();
    }
}
