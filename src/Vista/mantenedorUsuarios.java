package Vista;

import Controlador.Conexion;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mantenedorUsuarios extends javax.swing.JInternalFrame {

    public mantenedorUsuarios() {
        initComponents();
        llenarComboBox();
        llenarTabla("WHERE e.est_estado='activo'");
        cbTipo.setSelectedIndex(-1);
        cbEstado.setSelectedIndex(-1);
        deshabililtaEstadoC();
    }

    private void llenarTabla(String where) {
        try {
            Object[] cabeceras
                    = {
                        "Rut", "Nombre", "Contraseña", "Tipo", "Estado"
                    };
            Object[][] cuerpo
                    = {};
            DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabeceras);
            String sql = "select u.usu_rut,u.usu_nombre,u.usu_contrasena,u.usu_tipo,e.est_estado from vtjt_usuario u INNER JOIN vtjt_estado e ON u.usu_estado=e.est_id " + where;

            Conexion conn = new Conexion();
            ResultSet resul = conn.consulta(sql);

            while (resul.next()) {
                Object[] elemento
                        = {
                            resul.getString("u.usu_rut"), resul.getString("u.usu_nombre"), resul.getString("u.usu_contrasena"), resul.getString("u.usu_tipo"), resul.getString("e.est_estado")
                        };
                modelo.addRow(elemento);
            }
            tabla.setModel(modelo);
            conn.close();
            resul.close();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Metodo limpiar para limpiar
    private void limpiar() {
        txtNombre.setText("");
        txtPassword.setText("");
        txtRut.setText("");
        cbTipo.setSelectedIndex(-1);
        cbEstado.setSelectedIndex(-1);
        txtGuardar.setText("GUARDAR");
        txtRut.setEnabled(true);
        deshabililtaEstadoC();
    }

    // Metodo para cargar tipo
    private void llenarComboBox() {
        cbEstado.removeAllItems();
        String sql = "SELECT est_estado FROM vtjt_estado";
        Controlador.Conexion conn = new Controlador.Conexion();
        ResultSet resul = conn.consulta(sql);
        try {
            while (resul.next()) {
                cbEstado.addItem(resul.getString("est_estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Metodo para obtener el id del estado segun el nombre
    public static int obtenerIdEstado(String nombre) {
        String sql = "SELECT est_id FROM vtjt_estado where est_estado='" + nombre + "';";
        Controlador.Conexion c = new Controlador.Conexion();
        ResultSet r = c.consulta(sql);
        try {
            while (r.next()) {
                return r.getInt("est_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                c.close();
                r.close();
            } catch (SQLException ex) {
                Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    private void logicaGuardado() {

        String sql = "";
        String accion = txtGuardar.getText();
        char clave[] = txtPassword.getPassword();
        String password = new String(clave);
        String rut = txtRut.getText();
        String nombre = txtNombre.getText();
        if (!password.equals("") || !rut.equals("") || !nombre.equals("")) {
            String tipo = (String) cbTipo.getSelectedItem();
            int id = obtenerIdEstado((String) cbEstado.getSelectedItem());
            if (accion.equals("GUARDAR")) {
                sql = "INSERT INTO vtjt_usuario VALUES ('" + rut + "','" + nombre + "','" + password + "','" + tipo + "'," + id + ")";
            } else if (accion.equals("EDITAR")) {
                sql = "UPDATE vtjt_usuario SET usu_nombre='" + nombre + "', usu_contrasena='" + password + "', usu_tipo='" + tipo + "', usu_estado=" + id + " WHERE usu_rut='" + rut + "'";
            }
            System.out.println(sql);
            try {
                Controlador.Conexion c = new Conexion();
                c.exec(sql);
                limpiar();
                llenarTabla("WHERE e.est_estado='activo'");
                c.close();
                if (accion.equals("GUARDAR")) {
                    JOptionPane.showMessageDialog(null, "Ingresado correctamente");
                } else if (accion.equals("EDITAR")) {
                    JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error al insertar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        MostrarEliminados = new javax.swing.JMenuItem();
        pnGuardarUsuario = new javax.swing.JPanel();
        txtGuardar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        btnAgregarEstado = new javax.swing.JButton();
        btnAgregarTipo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnRecargar = new javax.swing.JButton();

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        MostrarEliminados.setText("Mostrar Eliminados");
        MostrarEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarEliminadosActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MostrarEliminados);

        setClosable(true);
        setTitle("Gestion de Usuarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        setInheritsPopupMenu(true);

        pnGuardarUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnGuardarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnGuardarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnGuardarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnGuardarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnGuardarUsuarioMouseExited(evt);
            }
        });

        txtGuardar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        txtGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGuardar.setText("GUARDAR");
        txtGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnGuardarUsuarioLayout = new javax.swing.GroupLayout(pnGuardarUsuario);
        pnGuardarUsuario.setLayout(pnGuardarUsuarioLayout);
        pnGuardarUsuarioLayout.setHorizontalGroup(
            pnGuardarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        );
        pnGuardarUsuarioLayout.setVerticalGroup(
            pnGuardarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Rut");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel2.setText("Contraseña");

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel3.setText("Tipo");

        cbTipo.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "administrador", "usuario" }));

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel5.setText("Estado");

        cbEstado.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N

        btnAgregarEstado.setBackground(new java.awt.Color(153, 255, 153));
        btnAgregarEstado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarEstado.setText("+");
        btnAgregarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstadoActionPerformed(evt);
            }
        });

        btnAgregarTipo.setBackground(new java.awt.Color(153, 255, 153));
        btnAgregarTipo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarTipo.setText("+");
        btnAgregarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarEstado)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarTipo)))
                        .addGap(8, 8, 8))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAgregarTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarEstado))
                .addContainerGap())
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Contraseña", "Tipo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setComponentPopupMenu(jPopupMenu1);
        tabla.setFillsViewportHeight(true);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnRecargar.setBackground(new java.awt.Color(153, 153, 255));
        btnRecargar.setText("🔃");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRecargar)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnGuardarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecargar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseEntered
        pnGuardarUsuario.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_txtGuardarMouseEntered

    private void txtGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseExited
        pnGuardarUsuario.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_txtGuardarMouseExited

    private void pnGuardarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarUsuarioMouseEntered
        pnGuardarUsuario.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_pnGuardarUsuarioMouseEntered

    private void pnGuardarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarUsuarioMouseExited
        pnGuardarUsuario.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_pnGuardarUsuarioMouseExited

    private void pnGuardarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarUsuarioMouseClicked
        logicaGuardado();
    }//GEN-LAST:event_pnGuardarUsuarioMouseClicked

    private void txtGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseClicked
        logicaGuardado();
    }//GEN-LAST:event_txtGuardarMouseClicked

    private void btnAgregarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstadoActionPerformed
        String[] opciones = {"activo", "inactivo"};

        String nombreEstado = (String) JOptionPane.showInputDialog(null, "Ingrese el nombre del estado", "Agregar estado", JOptionPane.QUESTION_MESSAGE, null, opciones, null);

        if (nombreEstado == null) {
            JOptionPane.showMessageDialog(null, "Rellene el campo");
            return;
        }

        if (!nombreEstado.equalsIgnoreCase("activo") && !nombreEstado.equalsIgnoreCase("inactivo")) {
            JOptionPane.showMessageDialog(null, "El nombre del estado debe ser 'activo' o 'inactivo'");
            return;
        }

// Realiza una consulta a la base de datos para verificar si el estado ya existe
        String sql = "SELECT COUNT(*) AS total FROM VTJT_ESTADO WHERE est_estado = '" + nombreEstado.toLowerCase() + "'";
        Conexion c = new Conexion();
        ResultSet rs = c.consulta(sql);

        try {
            rs.next();
            if (rs.getInt("total") == 0) {
                sql = "INSERT INTO VTJT_ESTADO (est_estado) VALUES ('" + nombreEstado.toLowerCase() + "')";
                c.exec(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        llenarComboBox();
        llenarTabla("WHERE e.est_estado='activo'");
        JOptionPane.showMessageDialog(null, "Estado ingresado correctamente");
        c.close();

        int estados = cbEstado.getItemCount();

        if (estados == 2) {
            btnAgregarEstado.setEnabled(false);
        } else {
            btnAgregarEstado.setEnabled(true);
        }
    }//GEN-LAST:event_btnAgregarEstadoActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.getSelectedRow();
        try {
            if (fila != -1) {
                txtRut.setEnabled(false);
                String rut = (String) tabla.getValueAt(fila, 0);
                String nombre = (String) tabla.getValueAt(fila, 1);
                String pass = (String) tabla.getValueAt(fila, 2);
                String tipo = (String) tabla.getValueAt(fila, 3);
                String estado = (String) tabla.getValueAt(fila, 4);
                txtRut.setText(rut);
                txtPassword.setText(pass);
                txtNombre.setText(nombre);
                cbTipo.setSelectedItem(tipo);
                cbEstado.setSelectedItem(estado);
                txtGuardar.setText("EDITAR");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tablaMouseClicked

    private void btnAgregarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipoActionPerformed
        // Vacia el ComboBox
        cbTipo.removeAllItems();

        // Agrega los datos al ComboBox
        cbTipo.addItem("administrador");
        cbTipo.addItem("usuario");
    }//GEN-LAST:event_btnAgregarTipoActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        limpiar();
        llenarComboBox();
        llenarTabla("WHERE e.est_estado='activo'");
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void MostrarEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarEliminadosActionPerformed
        llenarTabla("");
    }//GEN-LAST:event_MostrarEliminadosActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = tabla.getSelectedRow();
        try {
            if (fila != -1) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminarlo?");
                if (respuesta == 0) {
                    String rut = (String) tabla.getValueAt(fila, 0);
                    int id = obtenerIdEstado("inactivo");
                    String sql = "UPDATE vtjt_usuario SET usu_estado=" + id + " WHERE usu_rut='" + rut + "'";
                    Conexion c = new Conexion();
                    c.exec(sql);
                    limpiar();
                    llenarTabla("WHERE e.est_estado='activo'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void deshabililtaEstadoC() {
        int estados = cbEstado.getItemCount();

        if (estados == 2) {
            btnAgregarEstado.setEnabled(false);
        } else {
            btnAgregarEstado.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem MostrarEliminados;
    private javax.swing.JButton btnAgregarEstado;
    private javax.swing.JButton btnAgregarTipo;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnGuardarUsuario;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel txtGuardar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
