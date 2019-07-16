/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsimulacionej58;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author xtoma
 */
public class FXMLventanaController implements Initializable {

    @FXML
    private TableView<?> tableVectorEstado;
    @FXML
    private TableColumn<?, ?> relojColumn;
    @FXML
    private TableColumn<?, ?> rndLlegadaColumn;
    @FXML
    private TableColumn<?, ?> tiempoLlegadaColumn;
    @FXML
    private TableColumn<?, ?> proximaLlegadaColumn;
    @FXML
    private TextField txtHorasSimulacion;
    @FXML
    private Button btnSimular;
    @FXML
    private TextField txtHoraDesde;
    @FXML
    private TextField txtHoraHasta;
    @FXML
    private TableColumn<?, ?> rndGasolinaColumn;
    @FXML
    private TableColumn<?, ?> gasolinaColumn;
    @FXML
    private TableColumn<?, ?> rndOtroServicioColumn;
    @FXML
    private TableColumn<?, ?> otroServicioColumn;
    @FXML
    private TableColumn<?, ?> rndDemoraColumn;
    @FXML
    private TableColumn<?, ?> tiempoAtencionColumn;
    @FXML
    private TableColumn<?, ?> finAtencionColumn;
    @FXML
    private TableColumn<?, ?> servicioColumn;
    @FXML
    private TableColumn<?, ?> colaSurColumn;
    @FXML
    private TableColumn<?, ?> inicioSur1Column;
    @FXML
    private TableColumn<?, ?> finSur1Column;
    @FXML
    private TableColumn<?, ?> inicioSur2Column;
    @FXML
    private TableColumn<?, ?> finSur2Column;
    @FXML
    private TableColumn<?, ?> inicioSur3Column;
    @FXML
    private TableColumn<?, ?> finSur3Column;
    @FXML
    private TableColumn<?, ?> colaGomColumn;
    @FXML
    private TableColumn<?, ?> inicioGom1Column;
    @FXML
    private TableColumn<?, ?> finGom1Column;
    @FXML
    private TableColumn<?, ?> inicioGom2Column;
    @FXML
    private TableColumn<?, ?> finGom2Column;
    @FXML
    private TableColumn<?, ?> colaAccColumn;
    @FXML
    private TableColumn<?, ?> inicioAccColumn;
    @FXML
    private TableColumn<?, ?> finAccColumn;
    @FXML
    private TableColumn<?, ?> maxColaSurColumn;
    @FXML
    private TableColumn<?, ?> maxColaGomColumn;
    @FXML
    private TableColumn<?, ?> maxColaAccColumn;
    @FXML
    private TableColumn<?, ?> compraClientesColumn;
    @FXML
    private TableColumn<?, ?> totalClientesAtendidosColumn;
    @FXML
    private TableColumn<?, ?> maxTiempoSistemaColumn;
    @FXML
    private Button btnClientes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBtnSimular(MouseEvent event) {
    }

    @FXML
    private void clickBtnClientes(ActionEvent event) {
    }
    
}
