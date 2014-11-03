/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifce.Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 */
public class Conexao {
    private final String driver="org.gjt.mm.mysql.Driver";
    private final String url="mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/jbossews";
    private final String usuario="adminkxWRtET";
    private final String senha="Gywj7MdIDA5B";
    private Connection Con;
    
    public Conexao(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        if (Con == null) {
            try {
                Con = DriverManager.getConnection(url, usuario, senha);
                Con.setAutoCommit(false); 
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return Con;
    }
    
    public void desconecta(){
        try {
            Con.close();
            Con = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
}
