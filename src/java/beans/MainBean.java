package beans;

import data.Person;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import managers.BaseManager;

@SessionScoped
@ManagedBean(name = "mB")
public class MainBean implements Serializable{
//FIELDS************************************************************************
    private static final long serialVersionUID = 1L;
    
        //Injecting baseManager object
        @Inject
        private BaseManager baseManager;
        
        // List of persons to show
        private ListDataModel<Person> personsToShow = 
                new ListDataModel<Person>();
        //Accessory person to add to base
        private Person person = new Person();

//METHODS***********************************************************************
    
    //Method add example persons to database
    public String addDummyPersons(){
            baseManager.addPersons();
        return "homePage.xhtml";
    }
    //Method add Person to database
    public String addPerson(){
       baseManager.addPerson(getPerson());
       clearPerson();
       return "search.xhtml";
    }
    //Method clears accessory person to show
    public void clearPerson(){
        getPerson().setName("");
        getPerson().setSurname("");
        getPerson().setPesel("");
        getPerson().setBirthDay(null);
        getPerson().setAddress("");
        getPerson().setPhone(null);
        getPerson().setWeight(0);
        getPerson().setHeight(0);
    }
    //Method checks "CONTROL DIGIT (Pesel)"
    public void checkBirthAndPesel(ComponentSystemEvent event) {

        UIForm form = (UIForm) event.getComponent();
        UIInput pesel = (UIInput) form.findComponent("pesel");
        UIInput birthDay = (UIInput) form.findComponent("birthDay");

        if (pesel.getValue() != null && birthDay.getValue() 
            != null && pesel.getValue().toString().length() >= 2) {
            String twoOfPesel = pesel.getValue().toString().substring(0, 2);
            Calendar callendar = Calendar.getInstance();
            callendar.setTime(((Date) birthDay.getValue()));

            String twoOfBirth = 
                ((Integer) callendar.get(Calendar.YEAR)).toString().substring(2);

                if (!twoOfPesel.equals(twoOfBirth)){
                    FacesContext context = FacesContext.getCurrentInstance();
                    FacesMessage msg = 
                        new FacesMessage("Pesel don't match with date of birth.");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    context.addMessage(form.getClientId(), msg);
                    context.renderResponse();
                }
        }
    }
    //Method checks for pesel already exist in base
    public void uniquePesel(FacesContext context, UIComponent component, Object value) {
                String pesel = (String) value;
                for(int i = 0; i < pesel.length()-1; i++)                {
                    if((pesel.charAt(i)!='0')&&(pesel.charAt(i)!='1')&&
                       (pesel.charAt(i)!='2')&&(pesel.charAt(i)!='3')&&
                       (pesel.charAt(i)!='4')&&(pesel.charAt(i)!='5')&&
                       (pesel.charAt(i)!='6')&&(pesel.charAt(i)!='7')&&
                       (pesel.charAt(i)!='8')&&(pesel.charAt(i)!='9'))
                    {
                        FacesMessage message = 
                            new FacesMessage("Type values only from 0 to 9.");
                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        throw new ValidatorException(message);
                    }
                }
                if(pesel.length() != 11){
                    FacesMessage msgToShort = 
                        new FacesMessage("Pesel must have length of 11.");
                    msgToShort.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msgToShort);
                }

                for (Person person : baseManager.getPersons()){
                    if (person.getPesel().equalsIgnoreCase(pesel)) {
                        FacesMessage message = 
                            new FacesMessage("Person with that pesel already exist in base.");
                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        throw new ValidatorException(message);
                    }
                }
    }
    //Method check phone number(letters and length)
    public void validatePhone(FacesContext context, UIComponent component, Object value){
         String phone = (String) value;
         for(int i = 0; i < phone.length()-1; i++){
                    if((phone.charAt(i)!='0')&&(phone.charAt(i)!='1')&&
                       (phone.charAt(i)!='2')&&(phone.charAt(i)!='3')&&
                       (phone.charAt(i)!='4')&&(phone.charAt(i)!='5')&&
                       (phone.charAt(i)!='6')&&(phone.charAt(i)!='7')&&
                       (phone.charAt(i)!='8')&&(phone.charAt(i)!='9'))
                    {
                        FacesMessage message =
                            new FacesMessage("Type only numbers!(0 - 9)");
                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        throw new ValidatorException(message);
                    }
         }
         if(phone.length() != 9){
                    FacesMessage msgToShort = 
                        new FacesMessage("Phone number must have 9 digits.");
                    msgToShort.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msgToShort);
                }
    }
//GETTERS AND SETTERS***********************************************************
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public ListDataModel<Person> getPersonsToShow() {
        personsToShow.setWrappedData(baseManager.getPersons());
        return personsToShow;
    }
    
    public void setPersonsToShow(ListDataModel<Person> persons) {
        this.personsToShow = persons;
    }
    
    
}
