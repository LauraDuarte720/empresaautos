package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'reserva.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 import javafx.scene.control.ComboBox;
 import javafx.scene.control.TableColumn;
 import javafx.scene.control.TableView;
 import javafx.scene.control.TextField;
 
 public class reservaViewController {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="columnCliente"
     private TableColumn<?, ?> columnCliente; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnLimpiar"
     private Button btnLimpiar; // Value injected by FXMLLoader
 
     @FXML // fx:id="tabReserva"
     private TableView<?> tabReserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnDiasReserva"
     private TableColumn<?, ?> columnDiasReserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnCrearReserva"
     private Button btnCrearReserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtListaClientes"
     private ComboBox<?> txtListaClientes; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtDiasReserva"
     private TextField txtDiasReserva; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtCostoTotal"
     private TextField txtCostoTotal; // Value injected by FXMLLoader
 
     @FXML // fx:id="txtListaVehiculo"
     private ComboBox<?> txtListaVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnEliminar"
     private Button btnEliminar; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnVehiculo"
     private TableColumn<?, ?> columnVehiculo; // Value injected by FXMLLoader
 
     @FXML // fx:id="columnCosto"
     private TableColumn<?, ?> columnCosto; // Value injected by FXMLLoader
 
     @FXML // fx:id="btnActualizar"
     private Button btnActualizar; // Value injected by FXMLLoader
 
     @FXML
     void crearReservaAction(ActionEvent event) {
 
     }
 
     @FXML
     void eliminarAction(ActionEvent event) {
 
     }
 
     @FXML
     void actualizarAction(ActionEvent event) {
 
     }
 
     @FXML
     void limpiarAction(ActionEvent event) {
 
     }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert columnCliente != null : "fx:id=\"columnCliente\" was not injected: check your FXML file 'reserva.fxml'.";
         assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'reserva.fxml'.";
         assert tabReserva != null : "fx:id=\"tabReserva\" was not injected: check your FXML file 'reserva.fxml'.";
         assert columnDiasReserva != null : "fx:id=\"columnDiasReserva\" was not injected: check your FXML file 'reserva.fxml'.";
         assert btnCrearReserva != null : "fx:id=\"btnCrearReserva\" was not injected: check your FXML file 'reserva.fxml'.";
         assert txtListaClientes != null : "fx:id=\"txtListaClientes\" was not injected: check your FXML file 'reserva.fxml'.";
         assert txtDiasReserva != null : "fx:id=\"txtDiasReserva\" was not injected: check your FXML file 'reserva.fxml'.";
         assert txtCostoTotal != null : "fx:id=\"txtCostoTotal\" was not injected: check your FXML file 'reserva.fxml'.";
         assert txtListaVehiculo != null : "fx:id=\"txtListaVehiculo\" was not injected: check your FXML file 'reserva.fxml'.";
         assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'reserva.fxml'.";
         assert columnVehiculo != null : "fx:id=\"columnVehiculo\" was not injected: check your FXML file 'reserva.fxml'.";
         assert columnCosto != null : "fx:id=\"columnCosto\" was not injected: check your FXML file 'reserva.fxml'.";
         assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'reserva.fxml'.";
 
     }
 }
 