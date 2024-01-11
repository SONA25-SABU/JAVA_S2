import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Job {
    private String jobId;
    private String title;

    public Job(String jobId, String title) {
        this.jobId = jobId;
        this.title = title;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Title: " + title;
    }
}

class Employer {
    private int employerId;
    private String companyName;

    public Employer(int employerId, String companyName) {
        this.employerId = employerId;
        this.companyName = companyName;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Employer ID: " + employerId + ", Company Name: " + companyName;
    }
}

class Candidate {
    private int candidateId;
    private String name;
    private int age;

    public Candidate(int candidateId, String name, int age) {
        this.candidateId = candidateId;
        this.name = name;
        this.age = age;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Candidate ID: " + candidateId + ", Name: " + name + ", Age: " + age;
    }
}

class Application {
    private int applicationId;
    private Job job;
    private Candidate candidate;

    public Application(int applicationId, Job job, Candidate candidate) {
        this.applicationId = applicationId;
        this.job = job;
        this.candidate = candidate;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Application ID: " + applicationId + ", " + job + ", " + candidate;
    }
}

public class LabExercise_8 {
    public static void main(String[] args) {
        // Creating a list to store Job objects
        ArrayList<Job> jobList = new ArrayList<>();

        // Adding Job objects to the list
        jobList.add(new Job("1", "Software Engineer"));
        jobList.add(new Job("2", "Data Scientist"));
        jobList.add(new Job("3", "Project Manager"));

        // Displaying the contents of the Job list
        System.out.println("Job List:");
        jobList.forEach(System.out::println);

        // For entering candidate details
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the candidate ID: ");
        int candidateId = sc.nextInt();
        System.out.println("Enter the name of the candidate:");
        String candidateName = sc.next();
        System.out.println("Enter the age: ");
        int candidateAge = sc.nextInt();

        Set<Candidate> candidateSet = new HashSet<>();

        Candidate candidate1 = new Candidate(candidateId, candidateName, candidateAge);
        candidateSet.add(candidate1);

        // Print all candidates in the set
        System.out.println("Candidate Set:");
        candidateSet.forEach(System.out::println);

        // Application
        List<Application> applicationList = new ArrayList<>();

        // Adding applications to the list
        applicationList.add(new Application(1, jobList.get(0), candidate1));

        // Displaying applications from the list
        System.out.println("Application Details:");
        applicationList.forEach(System.out::println);
    }
}
