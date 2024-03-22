package claims.controllers.Advisor;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import claims.models.Model;
import claims.models.Drivers.CustomerDatabaseDriver;
import claims.models.Customer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdvisorHomeController implements Initializable {
    
    @FXML
    private Label acc_dob;

    @FXML
    private Label acc_email;

    @FXML
    private Label acc_gender;

    @FXML
    private Label acc_name;

    @FXML
    private Label acc_phonenumber;

    @FXML
    private Label acc_signupdate;

    @FXML
    private Label acc_type;

    @FXML
    private Button btn_edit;

    @FXML
    private ListView<?> clm_listview;

    @FXML
    private TableColumn<Customer, StringProperty> email_col;

    @FXML
    private Label hi_lbl;

    @FXML
    private TableColumn<Customer, IntegerProperty> id_col;

    @FXML
    private TableColumn<Customer, StringProperty> name_col;

    @FXML
    private Label today_lbl;

    @FXML
    private TableView<Customer> clients_tableview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        id_col.setCellValueFactory(new PropertyValueFactory<Customer,IntegerProperty>("userID"));
        name_col.setCellValueFactory(new PropertyValueFactory<Customer, StringProperty>("firstName"));
        email_col.setCellValueFactory(new PropertyValueFactory<Customer, StringProperty>("email"));
        
        clients_tableview.setItems(customers);
    }

    CustomerDatabaseDriver db = new CustomerDatabaseDriver();
    ResultSet resultSet = db.searchCustomerByAdvisorID(1);
    ObservableList<Customer> customers = Model.getInstance().getCustomers(resultSet);
}
