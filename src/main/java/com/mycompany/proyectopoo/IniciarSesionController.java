/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.ERROR;
import javafx.scene.control.TextField;
import modelo.Admin;
import modelo.Cobranza;
import modelo.Tecnico;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class IniciarSesionController {

    @FXML
    TextField txtUsuario;
    @FXML
    TextField txtClave;

    static ArrayList<Admin> listaAdmin = new ArrayList<Admin>();
    static ArrayList<Cobranza> listaCobranza = new ArrayList<Cobranza>();
    static ArrayList<Tecnico> listaTecnicos = new ArrayList<Tecnico>();

    public void initialize() {
        Usuario.cargarListaUsuarios(listaTecnicos, listaCobranza, listaAdmin);
    }

    @FXML
    private void iniciarSesion() throws IOException {
        String usuario = txtUsuario.getText();
        String clave = txtClave.getText();
        if (Usuario.verificarUsuario(usuario, clave, listaAdmin, listaTecnicos, listaCobranza)) {
            for (Admin admin : listaAdmin) {
                if (admin.getUsuario().equals(usuario)) {
                    App.setRoot("menuAdmin");
                }
            }
            for (Tecnico tecnico : listaTecnicos) {
                if (tecnico.getUsuario().equals(usuario)) {
                    App.setRoot("menuTecnico");
                }
            }
            for (Cobranza cobranza : listaCobranza) {
                if (cobranza.getUsuario().equals(usuario)) {
                    App.setRoot("menuCobranza");
                }
            }
        } else {
            Alert alerta = new Alert(ERROR);
            alerta.setTitle("Error");
            alerta.setContentText("Usuario o clave incorrectos");
            alerta.showAndWait();
        }
    }

    /**
     * Initializes the controller class.
     */
    //crear Archivos
}
