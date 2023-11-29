// File: jobportal/JobPortalApp.java
package jobportal;

public class JobPortalApp {
    public static void main(String[] args) {
        // Create a job listing
        Job jobListing = new JobListing("Software Engineer", "Tech Company");

        // Create a job applicant
        JobSeeker jobApplicant = new JobApplicant("John Doe");

        // Job applicant applies for the job
        jobApplicant.applyForJob(jobListing);
    }
}
