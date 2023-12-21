import java.util.ArrayList;
import java.util.List;

// Define a generic class for job applications
class JobApplication<T extends JobListing> {
    private List<T> submittedApplications = new ArrayList<>();

    // Submit a job application
    public void submitApplication(T jobListing) {
        submittedApplications.add(jobListing);
        System.out.println("Application for " + jobListing.getPosition() + " submitted successfully!");
    }

    // Withdraw a submitted job application
    public void withdrawApplication(T jobListing) {
        submittedApplications.remove(jobListing);
        System.out.println("Application for " + jobListing.getPosition() + " withdrawn successfully!");
    }

    // Display the list of submitted job applications
    public void displaySubmittedApplications() {
        System.out.println("Submitted Job Applications:");
        for (T jobListing : submittedApplications) {
            System.out.println("- " + jobListing.getPosition());
        }
    }
}

// Define a generic interface for job listings
interface JobListing {
    String getPosition();
}

// Create a concrete class for IT job listings
class ITJobListing implements JobListing {
    private String position;

    public ITJobListing(String position) {
        this.position = position;
    }

    @Override
    public String getPosition() {
        return position;
    }
}

public class LAB_6  {
    public static void main(String[] args) {
        // Create a JobApplication for IT job listings
        JobApplication<ITJobListing> itJobApplication = new JobApplication<>();

        // Create some IT job listings
        ITJobListing job1 = new ITJobListing("Java Developer");
        ITJobListing job2 = new ITJobListing("Web Developer");

        // Submit and withdraw job applications
        itJobApplication.submitApplication(job1);
        itJobApplication.submitApplication(job2);
        itJobApplication.displaySubmittedApplications();

        itJobApplication.withdrawApplication(job1);
        itJobApplication.displaySubmittedApplications();
    }
}
