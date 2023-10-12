package fullStackdeveloper;
import java.util.Scanner;
// program to demonstrate Endowment plan – Inheritance
class Endowment {
    protected String endowmentId;
    protected String holderName;
    protected String endowmentType;
    protected String registrationDate;

    public Endowment(String endowmentId, String holderName, String endowmentType, String registrationDate) {
        this.endowmentId = endowmentId;
        this.holderName = holderName;
        this.endowmentType = endowmentType;
        this.registrationDate = registrationDate;
    }

    public String getEndowmentId() {
        return endowmentId;
    }

    public void setEndowmentId(String endowmentId) {
        this.endowmentId = endowmentId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getEndowmentType() {
        return endowmentType;
    }

    public void setEndowmentType(String endowmentType) {
        this.endowmentType = endowmentType;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double calculateEndowment() {
        return 0.0; // Default implementation for the base class
    }
}

class EducationalEndowment extends Endowment {
    private String educationalInstitution;
    private String educationalDivision;

    public EducationalEndowment(String endowmentId, String holderName, String endowmentType,
                                 String registrationDate, String educationalInstitution, String educationalDivision) {
        super(endowmentId, holderName, endowmentType, registrationDate);
        this.educationalInstitution = educationalInstitution;
        this.educationalDivision = educationalDivision;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public String getEducationalDivision() {
        return educationalDivision;
    }

    public void setEducationalDivision(String educationalDivision) {
        this.educationalDivision = educationalDivision;
    }

    @Override
    public double calculateEndowment() {
        switch (educationalDivision.toLowerCase()) {
            case "school":
                return 30000.0;
            case "undergraduate":
                return 60000.0;
            case "postgraduate":
                return 90000.0;
            default:
                return 0.0; // Invalid division, return 0.0
        }
    }
}

class HealthEndowment extends Endowment {
    private String healthCareCenter;
    private int holderAge;

    public HealthEndowment(String endowmentId, String holderName, String endowmentType,
                           String registrationDate, String healthCareCenter, int holderAge) {
        super(endowmentId, holderName, endowmentType, registrationDate);
        this.healthCareCenter = healthCareCenter;
        this.holderAge = holderAge;
    }

    public String getHealthCareCenter() {
        return healthCareCenter;
    }

    public void setHealthCareCenter(String healthCareCenter) {
        this.healthCareCenter = healthCareCenter;
    }

    public int getHolderAge() {
        return holderAge;
    }

    public void setHolderAge(int holderAge) {
        this.holderAge = holderAge;
    }

    @Override
    public double calculateEndowment() {
        if (holderAge <= 30) {
            return 120000.0;
        } else if (holderAge < 60) {
            return 200000.0;
        } else {
            return 500000.0;
        }
    }
}

public class Endowmentplan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Endowment Id");
        String endowmentId = scanner.nextLine();

        System.out.println("Enter Holder Name");
        String holderName = scanner.nextLine();

        System.out.println("Enter Endowment Type");
        String endowmentType = scanner.nextLine();

        if (endowmentType.equalsIgnoreCase("educational") || endowmentType.equalsIgnoreCase("health")) {
            System.out.println("Enter Registration Date");
            String registrationDate = scanner.nextLine();

            if (endowmentType.equalsIgnoreCase("educational")) {
                System.out.println("Enter Educational Institution");
                String educationalInstitution = scanner.nextLine();

                System.out.println("Enter Educational Division");
                String educationalDivision = scanner.nextLine();

                EducationalEndowment educationalEndowment = new EducationalEndowment(endowmentId, holderName,
                        endowmentType, registrationDate, educationalInstitution, educationalDivision);

                double endowmentAmount = educationalEndowment.calculateEndowment();
                System.out.printf("Endowment Amount %.2f%n", endowmentAmount);
            } else if (endowmentType.equalsIgnoreCase("health")) {
                System.out.println("Enter Health Care Center");
                String healthCareCenter = scanner.nextLine();

                System.out.println("Enter Holder Age");
                int holderAge = scanner.nextInt();

                HealthEndowment healthEndowment = new HealthEndowment(endowmentId, holderName,
                        endowmentType, registrationDate, healthCareCenter, holderAge);

                double endowmentAmount = healthEndowment.calculateEndowment();
                System.out.printf("Endowment Amount %.2f%n", endowmentAmount);
            }
        } else {
            System.out.println(endowmentType + " is an invalid endowment type");
        }
    }
}