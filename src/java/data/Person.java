package data;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Person {
//FIELDS************************************************************************
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private String      name;
    private String      surname;
    private String      address;
    private String      pesel;
    private String      phone;
    private int         weight;
    private int         height;
    private Date        regDate;
    private Date        birthDay;
    private String      regDateToShow;
    private String      birthDayToShow;
//CONSTRUCTORS******************************************************************   
    public Person(){
    }
    //Accessory constructor to make example persons
    public Person(String name, String surname, String address, String pesel, String phone, int weight, int height, Date regDate, Date birthDay) {
        this.name           = name;
        this.surname        = surname;
        this.address        = address;
        this.pesel          = pesel;
        this.phone          = phone;
        this.weight         = weight;
        this.height         = height;
        this.regDate        = regDate;
        this.birthDay       = birthDay;
        this.regDateToShow  = dateFormat.format(regDate); //Convert data to desired format
        this.birthDayToShow = dateFormat.format(birthDay);//Convert data to desired format
    }
//GETTERS AND SETTERS***********************************************************
    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public String getRegDateToShow() {
        return regDateToShow;
    }
    public void setRegDateToShow(String regDateToShow) {
        this.regDateToShow = regDateToShow;
    }
    public String getBirthDayToShow() {
        return birthDayToShow;
    }
    public void setBirthDayToShow(String birthDayToShow) {
        this.birthDayToShow = birthDayToShow;
    }
    
    
}
