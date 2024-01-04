interface JobApplicable {
    void apply();

    default void performApplication(ApplicationAction applicationAction) {
        applicationAction.apply();
    }
}

interface ApplicationAction {
    void apply();
}

class Job implements JobApplicable {
    private String jobTitle;

    public Job(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public void apply() {
        System.out.println("Applied for the job of " + jobTitle + " on JobPortal");
    }
}

class Internship implements JobApplicable {
    private String internshipTitle;

    public Internship(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }

    @Override
    public void apply() {
        System.out.println("Applied for the internship of " + internshipTitle + " on JobPortal");
    }
}

class JobSeeker<T extends JobApplicable> {
    void applyForJob(T jobApplicable, ApplicationAction applicationAction) {
        System.out.println("JobSeeker is applying for a position on JobPortal");
        jobApplicable.performApplication(applicationAction);
    }
}

public class JobPortalApp7 {
    public static void main(String[] args) {
        JobSeeker<Job> jobSeeker = new JobSeeker<>();
        JobSeeker<Internship> internshipSeeker = new JobSeeker<>();

        Job softwareEngineerJob = new Job("Software Engineer");
        Internship marketingInternship = new Internship("Marketing Intern");

        // Using lambda expressions for application actions
        jobSeeker.applyForJob(softwareEngineerJob, () -> System.out.println("Application action for Software Engineer position"));
        internshipSeeker.applyForJob(marketingInternship, () -> System.out.println("Application action for Marketing Internship"));
    }
}
