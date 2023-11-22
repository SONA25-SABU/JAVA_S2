import java.util.Scanner;

abstract class Job {
    public String jobTitle;
    private double salary;

    public Job(String title, double salary) {
        jobTitle = title;
        this.salary = salary;
    }

    public void showTitle() {
        System.out.println("Job Title: " + jobTitle);
    }

    public double showSalary() {
        return salary;
    }

    public abstract String type(String jobType);
}

class JobPosting extends Job {
    String company;
    public JobPosting(String title, double salary, String company) {
        super(title, salary);
        this.company = company;
    }

    @Override
    public String type(String jobType) {
        return jobType;
    }

    public void showCompany() {
        System.out.println("Company: " + company);
    }

    public double calculateBonus(int yearsOfExperience) {
        return yearsOfExperience * 1000;
    }
}

final class Applicant extends JobPosting {
    int yearsOfExperience;

    public Applicant(String title, double salary, String company, int yearsOfExperience) {
        super(title, salary, company);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateBonus(int yearsOfExperience) {
        return super.calculateBonus(yearsOfExperience) + 500; // Additional bonus for applicants
    }
}

public class LAB_3 {
    public static void main(String args[]) {
        System.out.println("\n\n-----------------------------------Using the class that inherited the abstract class----------------------------\n");
        JobPosting jp1 = new JobPosting("Software Engineer", 80000, "ABC Tech");
        jp1.showTitle();
        System.out.println("Salary: " + jp1.showSalary());
        System.out.println("Job Type: " + jp1.type("Full-time"));
        jp1.showCompany();

        System.out.println("\n\n----------------------------------Using the final class-----------------------------------\n");
        Applicant applicant1 = new Applicant("Senior Developer", 100000, "XYZ Solutions", 5);
        applicant1.showTitle();
        System.out.println("Salary: " + applicant1.showSalary());
        System.out.println("Job Type: " + applicant1.type("Full-time"));
        applicant1.showCompany();
        System.out.println("Enter the no of years of experience: ");
        Scanner sc = new Scanner(System.in);
        int yearsOfExperience = sc.nextInt();
        System.out.println("The bonus for the applicant with " + yearsOfExperience + " years of experience is: " + applicant1.calculateBonus(yearsOfExperience));
    }
}
