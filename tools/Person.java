package tools;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;


public class Person {
    public Integer age;
    public String name;
    public String lastName;
    public genderTypes gender;
    private String email;
    private String phoneNumber;


    public enum genderTypes {
        MALE, FEMALE, UNKNOWN
    }

    public Person(String name, String lastName, Integer age, genderTypes gender, String email, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        if (email != null)
        this.email = email;
        if (phoneNumber != null)
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        List<String> objStr = new ArrayList<>();
        objStr.add(name.substring(0, 1).toUpperCase() + name.substring(1));
        objStr.add(lastName.substring(0, 1).toUpperCase() + lastName.substring(1));
        objStr.add(String.format("[%s|%s]", age, gender));
        if (email != null) {
            objStr.add("email:" + email);
        }
        if (phoneNumber != null) {
            objStr.add("phoneNumber:" + phoneNumber);
        }
        return String.join(" ", objStr);

    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person) || (obj == null))
            return false;

        Person otherPerson = (Person) obj;

        if (otherPerson.getEmail() != null && otherPerson.email.equals(email))
            return true;
        if (otherPerson.getPhoneNumber() != null && otherPerson.phoneNumber.equals(phoneNumber))
            return true;
        if ((otherPerson.name.equals(name)
            && otherPerson.lastName.equals(lastName) 
            && (otherPerson.age != age)
            && otherPerson.gender.equals(gender))) 
            {
            return true;
            }
        return false;
    }

    public int hashCode() {
        if (email != null) {
            return Objects.hash(email);
        }
        if (phoneNumber != null) {
            return Objects.hash(phoneNumber);
        }
        return Objects.hash(name, lastName, age, gender, phoneNumber, email);
    }

    public Object merge(Object obj) {
        if (equals(obj)) {
            Person otherPerson = (Person) obj;
            if (otherPerson.name == null && name != null)
                otherPerson.name = name;
            if (otherPerson.lastName == null && lastName != null)
                otherPerson.lastName = lastName;
            if (otherPerson.age == null && age != null)
                otherPerson.age = age;
            if (otherPerson.gender == genderTypes.UNKNOWN && gender != genderTypes.UNKNOWN)
                otherPerson.gender = gender;
            if (otherPerson.email == null && email != null)
                otherPerson.email = email;
            if (otherPerson.phoneNumber == null && phoneNumber != null)
                otherPerson.phoneNumber = phoneNumber;
            return otherPerson;
        }
        return obj;

    }

    public void setphoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[- \\(\\)]", "");
        Pattern p = Pattern.compile("^(8|\\+7)[9]{1}[0-9]{9}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(phoneNumber);
        if (matcher.matches()) {
            phoneNumber = phoneNumber.replaceAll("^8", "+7");
            phoneNumber = String.format("+7 (%s) %s-%s-%s", phoneNumber.substring(2, 5), phoneNumber.substring(5, 8),
                    phoneNumber.substring(8, 10), phoneNumber.substring(10, 12));
            this.phoneNumber = phoneNumber;
        } else
            throw new IllegalArgumentException("Wrong phoneNumber phone");

    }
}
