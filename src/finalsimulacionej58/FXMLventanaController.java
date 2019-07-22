/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsimulacionej58;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tpf.clases.Cliente;
import tpf.clases.GestorSimulacion;
import tpf.clases.TiempoAtencion;
import tpf.clases.VectorEstado;

/**
 * FXML Controller class
 *
 * @author xtoma
 */
public class FXMLventanaController implements Initializable {

    @FXML
    private TableView<VectorEstado> tableVectorEstado;
    @FXML
    private TableColumn<VectorEstado, Double> relojColumn;
    @FXML
    private TableColumn<VectorEstado, Double> tiempoLlegadaColumn;
    @FXML
    private TableColumn<VectorEstado, Double> proximaLlegadaColumn;
    @FXML
    private TextField txtHorasSimulacion;
    @FXML
    private Button btnSimular;
    @FXML
    private TextField txtHoraDesde;
    @FXML
    private TextField txtHoraHasta;
    @FXML
    private TableColumn<VectorEstado, Double> rndGasolinaColumn;
    @FXML
    private TableColumn<VectorEstado, Boolean> gasolinaColumn;
    @FXML
    private TableColumn<VectorEstado, Double> rndOtroServicioColumn;
    @FXML
    private TableColumn<VectorEstado, String> otroServicioColumn;
    @FXML
    private TableColumn<VectorEstado, Double> rndDemoraColumn;
    @FXML
    private TableColumn<VectorEstado, Double> tiempoAtencionColumn;
    @FXML
    private TableColumn<VectorEstado, Double> finAtencionColumn;
    @FXML
    private TableColumn<VectorEstado, String> servicioColumn;
    @FXML
    private TableColumn<VectorEstado, Double> colaSurColumn;
    @FXML
    private TableColumn<VectorEstado, Double> inicioSur1Column;
    @FXML
    private TableColumn<VectorEstado, Double> finSur1Column;
    @FXML
    private TableColumn<VectorEstado, Double> inicioSur2Column;
    @FXML
    private TableColumn<VectorEstado, Double>  finSur2Column;
    @FXML
    private TableColumn<VectorEstado, Double>  inicioSur3Column;
    @FXML
    private TableColumn<VectorEstado, Double>  finSur3Column;
    @FXML
    private TableColumn<VectorEstado, Double>  colaGomColumn;
    @FXML
    private TableColumn<VectorEstado, Double>  inicioGom1Column;
    @FXML
    private TableColumn<VectorEstado, Double>  finGom1Column;
    @FXML
    private TableColumn<VectorEstado, Double>  inicioGom2Column;
    @FXML
    private TableColumn<VectorEstado, Double>  finGom2Column;
    @FXML
    private TableColumn<VectorEstado, Double>  colaAccColumn;
    @FXML
    private TableColumn<VectorEstado, Double>  inicioAccColumn;
    @FXML
    private TableColumn<VectorEstado, Double> finAccColumn;
    @FXML
    private TableColumn<VectorEstado, Double>  maxColaSurColumn;
    @FXML
    private TableColumn<VectorEstado, Double>  maxColaGomColumn;
    @FXML
    private TableColumn<VectorEstado, Double>  maxColaAccColumn;
    @FXML
    private TableColumn<VectorEstado, Double>  compraClientesColumn;
    @FXML
    private TableColumn<VectorEstado, Double> totalClientesAtendidosColumn;
    @FXML
    private TableColumn<VectorEstado, Double> maxTiempoSistemaColumn;
    @FXML
    private Button btnClientes;
    @FXML
    private TableColumn<VectorEstado, Double>  rndLlegada1Column;
    @FXML
    private TableColumn<VectorEstado, Double>  rndLlegada2Column;

    private ObservableList<VectorEstado> estados;
    private ObservableList<Cliente> clientes;
    
    private GestorSimulacion simulador;
    @FXML
    private TableView<Cliente> tableClientes;
    @FXML
    private TableColumn<Cliente, Integer> numCliColumn;
    @FXML
    private TableColumn<Cliente, Double> inicioCliColumn;
    @FXML
    private TableColumn<Cliente, Double> finCliColumn;
    @FXML
    private TableColumn<Cliente, Double> tiempoPermanenciaColumn;
    @FXML
    private TableColumn<VectorEstado, String> cliSur1Column;
    @FXML
    private TableColumn<VectorEstado, String> cliSur2Column;
    @FXML
    private TableColumn<VectorEstado, String> cliSur3Column;
    @FXML
    private TableColumn<VectorEstado, String> cliGom1Column;
    @FXML
    private TableColumn<VectorEstado, String> cliGom2Column;
    @FXML
    private TableColumn<VectorEstado, String> cliAccColumn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.relojColumn.setCellValueFactory(new PropertyValueFactory("reloj"));
        
        this.rndLlegada1Column.setCellValueFactory(new PropertyValueFactory("rnd1Ll"));
        this.rndLlegada2Column.setCellValueFactory(new PropertyValueFactory("rnd2Ll"));
        this.tiempoLlegadaColumn.setCellValueFactory(new PropertyValueFactory("tiempoLl"));
        this.proximaLlegadaColumn.setCellValueFactory(new PropertyValueFactory("proxLl"));
        
        this.rndGasolinaColumn.setCellValueFactory(new PropertyValueFactory("rndSer"));
        this.gasolinaColumn.setCellValueFactory(new PropertyValueFactory("gasolina"));
        this.rndOtroServicioColumn.setCellValueFactory(new PropertyValueFactory("rndOtSer"));
        this.otroServicioColumn.setCellValueFactory(new PropertyValueFactory("otSer"));
        
        this.rndDemoraColumn.setCellValueFactory(new PropertyValueFactory("rndTiAt"));
        this.tiempoAtencionColumn.setCellValueFactory(new PropertyValueFactory("tiemAt"));
        this.finAtencionColumn.setCellValueFactory(new PropertyValueFactory("finAt"));
        this.servicioColumn.setCellValueFactory(new PropertyValueFactory("ser"));
        
        this.colaSurColumn.setCellValueFactory(new PropertyValueFactory("colaSur"));
        this.inicioSur1Column.setCellValueFactory(new PropertyValueFactory("inSur1"));
        this.finSur1Column.setCellValueFactory(new PropertyValueFactory("finSur1"));
        this.inicioSur2Column.setCellValueFactory(new PropertyValueFactory("inSur2"));
        this.finSur2Column.setCellValueFactory(new PropertyValueFactory("finSur2"));
        this.inicioSur3Column.setCellValueFactory(new PropertyValueFactory("inSur3"));
        this.finSur3Column.setCellValueFactory(new PropertyValueFactory("finSur3"));
        
        
        this.colaGomColumn.setCellValueFactory(new PropertyValueFactory("colaGom"));
        this.inicioGom1Column.setCellValueFactory(new PropertyValueFactory("inGom1"));
        this.finGom1Column.setCellValueFactory(new PropertyValueFactory("finGom1"));
        this.inicioGom2Column.setCellValueFactory(new PropertyValueFactory("inGom2"));
        this.finGom2Column.setCellValueFactory(new PropertyValueFactory("finGom2"));
        
        this.colaAccColumn.setCellValueFactory(new PropertyValueFactory("colaAcc"));
        this.inicioAccColumn.setCellValueFactory(new PropertyValueFactory("inAcc"));
        this.finAccColumn.setCellValueFactory(new PropertyValueFactory("finAcc"));
        
        this.maxColaSurColumn.setCellValueFactory(new PropertyValueFactory("maxSur"));
        this.maxColaGomColumn.setCellValueFactory(new PropertyValueFactory("maxGom"));
        this.maxColaAccColumn.setCellValueFactory(new PropertyValueFactory("maxAcc"));
        
        this.compraClientesColumn.setCellValueFactory(new PropertyValueFactory("compraron"));
        this.totalClientesAtendidosColumn.setCellValueFactory(new PropertyValueFactory("totalCli"));
        this.maxTiempoSistemaColumn.setCellValueFactory(new PropertyValueFactory("maxPermanencia"));
        
        this.numCliColumn.setCellValueFactory(new PropertyValueFactory("numCliente"));
        this.inicioCliColumn.setCellValueFactory(new PropertyValueFactory("inicio"));
        this.finCliColumn.setCellValueFactory(new PropertyValueFactory("fin"));
        this.tiempoPermanenciaColumn.setCellValueFactory(new PropertyValueFactory("permanencia"));
        
        this.cliSur1Column.setCellValueFactory(new PropertyValueFactory("cliSur1"));
        this.cliSur2Column.setCellValueFactory(new PropertyValueFactory("cliSur2"));
        this.cliSur3Column.setCellValueFactory(new PropertyValueFactory("cliSur3"));
        this.cliGom1Column.setCellValueFactory(new PropertyValueFactory("cliGom1"));
        this.cliGom2Column.setCellValueFactory(new PropertyValueFactory("cliGom2"));
        this.cliAccColumn.setCellValueFactory(new PropertyValueFactory("cliAcc"));
        
    }    

    @FXML
    private void clickBtnSimular(MouseEvent event) {
        if (validarDatos()) {
            TiempoAtencion.getInstance().resetear();
            simulador = new GestorSimulacion(Double.parseDouble(txtHorasSimulacion.textProperty().get()),Double.parseDouble(txtHoraDesde.textProperty().get()), Double.parseDouble(txtHoraHasta.textProperty().get()));
            simulador.simular();
            estados = simulador.getEstados();
            clientes = simulador.getClientes();

            tableVectorEstado.setItems(estados);
            tableClientes.setItems(clientes);
               Alert dialog = new Alert(Alert.AlertType.INFORMATION);
               dialog.setTitle("Éxito");
               dialog.setHeaderText("Simulacion");
               dialog.showAndWait();
        }
    }

    @FXML
    private void clickBtnResultado(ActionEvent event) {
        String resumen = "Tiempo máximo de permanencia en el sistema de un cliente: " + simulador.getTiempoMaxCliente() + "\n";
        resumen = resumen + "Porcentaje de clientes que no compraron: " + simulador.getPorcentajeNoCompraron() + "%\n";
        resumen = resumen + "Cola máxima en gasolinera: " + simulador.getColaMaxGasolinera() + "\n";
        resumen = resumen + "Cola máxima en gomeria: " + simulador.getColaMaxGomeria()+ "\n";
        resumen = resumen + "Cola máxima en venta de accesorios: " + simulador.getColaMaxAccesorio()+ "\n";
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Medidas resumen ");
        dialog.setHeaderText(resumen);
        dialog.showAndWait();
    }
    
    private boolean validarDatos(){
        
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("ERROR");
        double horasSimulacion;
        double horaDesde ;
        double horaHasta;
        
        try{
            horasSimulacion = Double.parseDouble(txtHorasSimulacion.textProperty().get());
            horaDesde = Double.parseDouble(txtHoraDesde.textProperty().get());
            horaHasta = Double.parseDouble(txtHoraHasta.textProperty().get());
        }
        catch (NumberFormatException e){
            dialog.setHeaderText("Debe cargar números");
            dialog.showAndWait();
            return false;
        }
        
        if (horasSimulacion < 0 || horaDesde < 0 || horaHasta < 0) {
            dialog.setHeaderText("Los números deben ser superiores a 0");
            dialog.showAndWait();
            return false;
        }
        
        if (horaDesde >= horaHasta) {
            dialog.setHeaderText("Intervalo invalido");
            dialog.showAndWait();
            return false;
        }

        return true;
    }
}
