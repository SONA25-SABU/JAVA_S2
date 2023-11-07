//Implement the concept of Class, Data members, Methods, Access Specifier,  Default Constructor, Method Overloading (minimum 3 methods), Constructor overloading (minimum of 2) in your selected domain.
//Class comments

import java.util.*;

class Job {                            // Create a class
    public String jobTitle;            // Data members
    private int salary = 0;
    String company;
    String location;

    Job() {                            // Default Constructor
        jobTitle = "Software Developer";
        salary = 80000;
        company = "Tech Corp";
        location = "New York";
    }

    Job(String title, int salary, String companyName, String jobLocation) {        //  Constructor with method overloading
        jobTitle = title;
        this.salary = salary;
        company = companyName;
        location = jobLocation;
    }

    public void displayJobDetails() {                         
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Company: " + company);
        System.out.println("Location: " + location);
        System.out.println("Salary: $" + salary);
    }
}

public class LAB_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the details of a job:");
        System.out.print("Job Title: ");
        String title = sc.nextLine();
        System.out.print("Salary: $");
        int salary = sc.nextInt();
        sc.nextLine();  // get the newline 
        System.out.print("Company: ");
        String company = sc.nextLine();
        System.out.print("Location: ");
        String location = sc.nextLine();

        Job job1 = new Job(title, salary, company, location);
        job1.displayJobDetails();

        Job job2 = new Job();
        job2.displayJobDetails();


    }
}
