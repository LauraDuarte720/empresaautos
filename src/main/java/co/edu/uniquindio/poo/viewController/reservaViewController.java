package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.reservaController;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class reservaViewController {

    App app;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Reserva, String> columnCliente;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Reserva> tabReserva; // Cambiar a Reserva para poder usar reservas

    @FXML
    private TableColumn<Reserva, Integer> columnDiasReserva;

    @FXML
    private Button btnCrearReserva;

    @FXML
    private ComboBox<Cliente> txtListaClientes;

    @FXML
    private TextField txtDiasReserva;

    @FXML
    private TextField txtCostoTotal;

    @FXML
    private ComboBox<Vehiculo> txtListaVehiculo;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Reserva, String> columnVehiculo;

    @FXML
    private TableColumn<Reserva, Double> columnCosto;

    @FXML
    private Button btnActualizar;

    private reservaController controller;
    private reservaController reservaController = new reservaController();

    public void setReservaController(reservaController controller) {
        this.controller = controller;
    }

    // Inicializa el controlador
    public reservaViewController() {
        this.controller = new reservaController();
    }

    @FXML
public void crearReservaAction(ActionEvent event) {
    try {
        int dias = Integer.parseInt(txtDiasReserva.getText());
        Vehiculo vehiculo = txtListaVehiculo.getValue();
        Cliente cliente = txtListaClientes.getValue();
    
        if (cliente != null && vehiculo != null && dias > 0) {
            if (reservaController.crearReserva(dias, cliente, vehiculo)) {
                // Mostrar el costo total calculado
                double costoTotal = reservaController.calcularCosto(vehiculo);
                txtCostoTotal.setText(String.valueOf(costoTotal));
                
                // Actualizar la tabla de reservas
                tabReserva.setItems(reservaController.getReservas());
                limpiarCampos(); // Limpia los campos después de crear la reserva
            } else {
                System.out.println("Error al crear la reserva.");
            }
        } else {
            System.out.println("Por favor, completa todos los campos.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Por favor, ingresa un número válido para los días.");
    }
}

    
    @FXML
    void eliminarAction(ActionEvent event) {
    // Obtener la reserva seleccionada de la tabla
    Reserva reservaSeleccionada = tabReserva.getSelectionModel().getSelectedItem();
    
    if (reservaSeleccionada != null) {
        // Llamar al controlador para eliminar la reserva
        reservaController.eliminarReserva(reservaSeleccionada);
        
        // Actualizar la vista de la tabla
        tabReserva.setItems(reservaController.getReservas());
        tabReserva.refresh(); // Refrescar la tabla para mostrar cambios
    } else {
        // Manejo de error si no se ha seleccionado ninguna reserva
        System.out.println("Por favor, selecciona una reserva para eliminar.");
    }
}

@FXML
void actualizarAction(ActionEvent event) {
    // Obtener la reserva seleccionada de la tabla
    Reserva reservaSeleccionada = tabReserva.getSelectionModel().getSelectedItem();

    // Verificar si hay una reserva seleccionada
    if (reservaSeleccionada != null) {
        try {
            // Obtener nuevos valores de los campos editables
            int dias = Integer.parseInt(txtDiasReserva.getText());
            Vehiculo vehiculo = txtListaVehiculo.getValue();
            Cliente cliente = txtListaClientes.getValue();

            // Actualizar la reserva a través del controlador
            controller.actualizarReserva(reservaSeleccionada, dias, cliente, vehiculo);

            // Actualizar la vista de la tabla
            actualizarTablaReservas();

            // Limpiar los campos después de la actualización
            limpiarCampos();

        } catch (NumberFormatException e) {
            // Mostrar un mensaje de error si el número de días no es válido
            mostrarMensajeError("Por favor, ingrese un número válido de días.");
        } catch (Exception e) {
            // Manejo de otros errores
            mostrarMensajeError("Ocurrió un error al actualizar la reserva: " + e.getMessage());
        }
    } else {
        // Mostrar un mensaje de error si no hay reserva seleccionada
        mostrarMensajeError("Por favor, selecciona una reserva para actualizar.");
    }
}

private void mostrarMensajeError(String mensaje) {
    // Puedes usar un Alert o un Label en tu interfaz para mostrar el mensaje
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}

    @FXML
    void limpiarAction(ActionEvent event) {
        limpiarCampos();
    }

    
    @FXML
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

        // Inicializa la tabla
        actualizarTablaReservas();
        cargarClientes();  // Método para cargar la lista de clientes, si aún no lo tienes implementado
        cargarVehiculos(); // Llamada al método que cargará los vehículos

        txtListaVehiculo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && controller != null) { // Asegurarse de que hay un vehículo seleccionado y controlador no es nulo
                double costo = controller.calcularCosto(newValue); // Calcula el costo usando la instancia pasada
                txtCostoTotal.setText(String.valueOf(costo)); // Muestra el costo en el campo de texto
            }
        });

        columnCliente.setCellValueFactory(new PropertyValueFactory<>("cliente")); // Atributo `clienteNombre` en la clase `Reserva`
        columnVehiculo.setCellValueFactory(new PropertyValueFactory<>("vehiculo")); // Atributo `vehiculoNombre`
        columnDiasReserva.setCellValueFactory(new PropertyValueFactory<>("dias"));
        columnCosto.setCellValueFactory(new PropertyValueFactory<>("costoTotal"));

        // Asigna la lista de reservas al TableView
        tabReserva.setItems(reservaController.getReservas());
        
        
    }


    private void cargarClientes() {
        // Cargar clientes desde el modelo (puedes tener una lista estática o de otro lugar)
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        // Suponiendo que tienes algunos clientes
        clientes.add(new Cliente("123456", "Juan Pérez",null));
        clientes.add(new Cliente("789101", "Ana Gómez",null));
        txtListaClientes.setItems(clientes);
    }
    
    private void cargarVehiculos() {
        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList();
        vehiculos.add(new Moto("ABC123", "Yamaha", "MT-07", 2020, 0, null, TipoCaja.AUTOMATICO));
        vehiculos.add(new Camioneta("XYZ789", "Toyota", "Hilux", 2021, 1000, null));
        txtListaVehiculo.setItems(vehiculos); // Esto debería cargar la lista de vehículos
    }
    


    private void limpiarCampos() {
        txtDiasReserva.clear();
        txtCostoTotal.clear();
        txtListaClientes.getSelectionModel().clearSelection();
        txtListaVehiculo.getSelectionModel().clearSelection();
        tabReserva.getSelectionModel().clearSelection();
    }

    private void actualizarTablaReservas() {
        ObservableList<Reserva> listaReservas = controller.getReservas();
        tabReserva.setItems(listaReservas);
    }

    public void setApp(App app){
        this.app=app;
    }
}
