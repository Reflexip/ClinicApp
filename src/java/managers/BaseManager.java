package managers;

import data.Person;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BaseManager {
//FIELDS************************************************************************
    private SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

    private ArrayList<Person> persons = new ArrayList<Person>();
    
//METHODS***********************************************************************
    //Method add example persons to database
    public void addPersons(){
        persons.add(new Person("George", "Cloney","Main Street 8",          "91031402437", "660043236", 84, 171,    new Date(88, 3, 21),    new Date(91, 3, 14)));
        persons.add(new Person("Jessica", "Ramsey","Southy 18",             "91052802487", "665897436", 94, 180,    new Date(100, 8, 7),    new Date(91, 5, 28)));
        persons.add(new Person("Jorah", "Mormont", "Thrones 12",            "88081802795", "512443236", 68, 175,    new Date(98, 11, 14),   new Date(88, 8, 18)));
        persons.add(new Person("Jimmy", "Clarkson", "Opportunities 55",     "92080202795", "512427836", 68, 175,    new Date(100, 11, 2),   new Date(92, 8, 2)));
        persons.add(new Person("Caroline", "Ramsey","Truth 8",              "75051502727", "660043758", 80, 175,    new Date(81, 8, 10),    new Date(75, 5, 15)));
        persons.add(new Person("George", "Oman","Low Street 8",             "71060657849", "512025558", 89, 182,    new Date(80, 2, 6),     new Date(71, 6, 6)));
        persons.add(new Person("Barney", "Clarkson","Amazing Street 13",    "94042602488", "875693236", 72, 170,    new Date(100, 1, 16),   new Date(94, 4, 26)));
        persons.add(new Person("Jimmy", "Scott","Dark Street 13",           "91040402448", "875648896", 94, 170,    new Date(100, 1, 16),   new Date(91, 4, 4)));
        persons.add(new Person("Lenny", "Mormont","Dummy Street 8",         "80020307748", "689954785", 80, 165,    new Date(92, 5, 12),    new Date(80, 2, 3)));
        persons.add(new Person("Daenerys", "Targaryen","Dragons 78",        "95081888897", "587458963", 62, 175,    new Date(101, 8, 9),    new Date(95, 8, 18)));
        persons.add(new Person("Tyrion", "Lannister", "Dwarf 13",           "77042602488", "875693236", 72, 135,    new Date(100, 1, 16),   new Date(77, 4, 26)));
    }
    //Method add person to database
    public void addPerson(Person person){
        Person newPerson = new Person();
        newPerson.setName      (person.getName());
        newPerson.setSurname   (person.getSurname());
        newPerson.setAddress   (person.getAddress());
        newPerson.setHeight    (person.getHeight());
        newPerson.setWeight    (person.getWeight());
        newPerson.setPesel     (person.getPesel());
        newPerson.setPhone     (person.getPhone());
        newPerson.setRegDate   (new Date());
        newPerson.setBirthDay  (person.getBirthDay());
        
        newPerson.setRegDateToShow(dataFormat.format(new Date()));                //formating date to string with format dd/MM/yyyy
        newPerson.setBirthDayToShow(dataFormat.format(person.getBirthDay()));    //formating date to string with format dd/MM/yyyy
        
        persons.add(newPerson);
    }
    
//GETTERS AND SETTERS***********************************************************
    
    public List<Person> getPersons(){
        return persons;
    }
}
