package ua.edu.ucu;


class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname +
                ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Student)){
            return false;
        }
        if (this.hashCode() == obj.hashCode()) {
            return this.GPA == ((Student) obj).getGPA()
                    && this.year == ((Student) obj).getYear()
                    && this.name.equals(((Student) obj).getName())
                    && this.surname.equals(((Student) obj).getSurname());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) this.GPA + this.year + this.name.hashCode() + this.surname.hashCode();
    }
}
