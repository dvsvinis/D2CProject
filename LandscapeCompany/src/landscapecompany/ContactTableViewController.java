package landscapecompany;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author Donna Svinis
 */
public class ContactTableViewController implements Initializable {
    
    //configure the table
    @FXML private TableView<Person> tableView;       // using Person object
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, String> phoneColumn;
    @FXML private TableColumn<Person, String> emailColumn;
	
    //These instance variables are used to create new Person objects
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField phoneTextField;
    @FXML private TextField emailTextField;
    
    
    /**Inititalize the controller class */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        //load dummy data from getPeople Method below
        tableView.setItems(getPeople());
    }    
    
    /**
     * This method will return an ObservableList of Person objects
     * This is just for testing.
     * @return people
     */
    public ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Frank", "Sinatra", "610-565-9999", "fSinatra@comcast.com"));
        people.add(new Person("Frank", "Zappa", "302-967-8765", "fzappa@mac.com"));
        people.add(new Person("John", "Lennon", "302-444-2314", "peacebaby@gmail.com"));
        people.add(new Person("Tony", "Bennett", "702-220-1234", "tonyB@aol.com"));
        people.add(new Person("Aretha", "Franklin", "202-330-4321", "FrankieA@mac.com"));
        people.add(new Person("Barbra", "Streisand", "500-555-5555", "BSsinger@comcast.com"));
        return people;
    }
    
     /**
     * When this method is called it will change the Scene back to the home page
     */  
        @FXML
    private void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent table_view_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene table_view_scene = new Scene(table_view_parent);
        Stage app_stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(table_view_scene);
        app_stage.show();
    }
    
    /** This method will create a new Person and add it to the table */
    public void newPersonButtonPushed(){
        //create new Person object
       Person newPerson = new Person (firstNameTextField.getText(),
                                      lastNameTextField.getText(),
                                      phoneTextField.getText(),
                                      emailTextField.getText());
       
       //Get all items from table as a list, then add the new person to the list
       tableView.getItems().add(newPerson);
       
    }
}
