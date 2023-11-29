// File: jobportal/JobListing.java
package jobportal;

public class JobListing implements Job {
    private String title;
    private String company;

    public JobListing(String title, String company) {
        this.title = title;
        this.company = company;
    }

    @Override
    public void displayDetails() {
        System.out.println("Job Title: " + title);
        System.out.println("Company: " + company);
    }
}
