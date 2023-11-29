// File: jobportal/JobApplicant.java
package jobportal;

public class JobApplicant implements JobSeeker {
    private String name;

    public JobApplicant(String name) {
        this.name = name;
    }

    @Override
    public void applyForJob(Job job) {
        System.out.println(name + " applied for the following job:");
        job.displayDetails();
    }
}
