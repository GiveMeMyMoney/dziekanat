package model;

/**
 * Created by Marcin on 2015-11-04.
 */
public class StudentSecond {

    int id, index, years;
    String speciality, address, city;

    public StudentSecond(int id, int index, int years, String speciality, String address, String city) {
        this.id = id;
        this.index = index;
        this.years = years;
        this.speciality = speciality;
        this.address = address;
        this.city = city;
    }

    public StudentSecond(int index, int years, String address, String speciality, String city) {
        this.index = index;
        this.years = years;
        this.address = address;
        this.speciality = speciality;
        this.city = city;
    }

    //GETTERs:
    public int getId() {
        return id;
    }
    public int getIndex() {
        return index;
    }
    public String getSpeciality() {
        return speciality;
    }
    public int getYears() {
        return years;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }

    //SETTERs:
    public void setId(int id) {
        this.id = id;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }

    //METODs:
    @Override
    public String toString() {
        return "StudentSecond{" +
                "id=" + id +
                ", index=" + index +
                ", years=" + years +
                ", speciality='" + speciality + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}
