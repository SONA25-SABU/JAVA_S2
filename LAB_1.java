public class LAB_1 {
    private String jobTitle;
    private double salary;
    private String company;
    private String location;

    LAB_1() {
        this.jobTitle = "Software Developer";
        this.salary = 80000;
        this.company = "Tech Corp";
        this.location = "New York";
    }

    LAB_1(String jobTitle, double salary, String company, String location) {
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.company = company;
        this.location = location;
    }

    LAB_1(String jobTitle, long salary, String company, String location) {
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.company = company;
        this.location = location;
    }

    public void displayJobDetails() {
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Company: " + company);
        System.out.println("Location: " + location);
        System.out.println("Salary: $" + salary);
    }

    public void displaySalary() {
        System.out.println("Salary: $" + salary);
    }

    public void displaySalary(String jobTitle) {
        if (!this.jobTitle.equalsIgnoreCase(jobTitle)) {
            System.out.println("Invalid job title");
        } else {
            System.out.println("Salary for " + jobTitle + " is $" + salary);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\nDefault constructor");
        LAB_1 job1 = new LAB_1();
        job1.displayJobDetails();

        System.out.println("\n\nConstructor overloading 1");
        LAB_1 job2 = new LAB_1("Senior Software Engineer", 120000.0, "Tech Solutions", "San Francisco");
        job2.displayJobDetails();

        System.out.println("\n\nConstructor overloading 2");
        LAB_1 job3 = new LAB_1("Data Analyst", 85000, "Analytics Co", "Chicago");
        job3.displayJobDetails();

        System.out.println("\n\nMethod overloading");
        job2.displaySalary();
        job2.displaySalary("Senior Software Engineer");
    }
}
