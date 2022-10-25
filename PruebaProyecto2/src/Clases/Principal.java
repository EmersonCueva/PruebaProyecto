/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaz.InicioSesion;
import java.io.FileNotFoundException;

/**
 *
 * @author emers
 */
public class Principal {
    
    public static void main(String args[]) throws FileNotFoundException{
      
         InicioSesion acceso = new InicioSesion();
        acceso.setVisible(true);
    }
}
