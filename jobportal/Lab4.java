package jobportal;

interface JobPosition {
    void displayPosition();
}

class SoftwareDeveloper implements JobPosition {
    public void displayPosition() {
        System.out.println("Software Developer");
    }
}

class ITSpecialist implements JobPosition {
    public void displayPosition() {
        System.out.println("IT Specialist");
    }
}

class JobApplicant {
    void apply(JobPosition position) {
        System.out.println("Job Applicant");
        position.displayPosition();
    }
}

public class Lab4 {
    public static void main(String[] args) {
        JobApplicant applicant = new JobApplicant();
        JobPosition softwareDeveloper = new SoftwareDeveloper();
        JobPosition itSpecialist = new ITSpecialist();

        applicant.apply(softwareDeveloper);
    }
}
