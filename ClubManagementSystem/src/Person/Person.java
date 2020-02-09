package Person;

public class Person {
    private String name;
    private int birthYr;
    private String Gender;

    private static int numberOfPerson = 0;

    public Person() {
        numberOfPerson ++;
    }

    public Person(String name) {
        this.name = name;
        numberOfPerson ++;
    }

    public Person(String name, int birthYr, String gender) {
        this.name = name;
        this.birthYr = birthYr;
        Gender = gender;
        numberOfPerson ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYr() {
        return birthYr;
    }

    public void setBirthYr(int birthYr) {
        this.birthYr = birthYr;
    }


    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public static int getNumberOfPerson() {
        return numberOfPerson;
    }

    public String personDetails() {
        return "Name of Player: " + name + "\n" +
                "Date of Birth: " + birthYr + "\n" +
                "Gender: " + Gender + "\n";
    }
}
