package Vista;

import Controlador.Conexion;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.DatatypeConverter;

public class mantenedorAtleta extends javax.swing.JInternalFrame {

    private String nombreUsuario;
    private String tipoUsuario;

    public mantenedorAtleta() {
        try {
            initComponents();
            llenarComboCiudad();
            rellenarComboEspecialidad();
            actualizarAtleta("WHERE est.est_estado='activo'");
            llenarEstado();
            deshabililtaEstadoC();
            limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarAtleta(String where) {
        try {
            Object[] cabeceras
                    = {
                        "Rut", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha", "Especialidad", "Ciudad", "Estado"
                    };
            Object[][] cuerpo
                    = {};
            DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabeceras);
            String sql = "select a.atl_rut,a.atl_nombre,a.atl_apellido1,a.atl_apellido2,a.atl_fechaNacimiento,esp.esp_especialidad_atleta,c.ciu_ciudad_origen,est.est_estado from vtjt_atleta a INNER JOIN vtjt_especialidad esp ON a.atl_especialidad=esp.esp_id INNER JOIN vtjt_ciudad c ON a.atl_ciudad_id=c.ciu_id INNER JOIN vtjt_estado est ON a.atl_estado=est.est_id " + where;

            Conexion conn = new Conexion();
            ResultSet resul = conn.consulta(sql);

            while (resul.next()) {
                Object[] elemento
                        = {
                            resul.getString("a.atl_rut"), resul.getString("a.atl_nombre"), resul.getString("a.atl_apellido1"), resul.getString("a.atl_apellido2"),
                            resul.getString("a.atl_fechaNacimiento"), resul.getString("esp.esp_especialidad_atleta"), resul.getString("c.ciu_ciudad_origen"), resul.getString("est.est_estado")
                        };
                modelo.addRow(elemento);
            }
            tabla.setModel(modelo);
            conn.close();
            resul.close();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Metodo para cargar ciudades
    private void llenarComboCiudad() throws SQLException {
        cbCiudad.removeAllItems();
        String sql = "SELECT ciu_ciudad_origen FROM vtjt_ciudad";
        Controlador.Conexion conn = new Controlador.Conexion();
        ResultSet resul = conn.consulta(sql);
        try {
            while (resul.next()) {
                cbCiudad.addItem(resul.getString("ciu_ciudad_origen"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            resul.close();
        }
    }

    // Metodo para cargar estado
    private void llenarEstado() throws SQLException {
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
            conn.close();
            resul.close();
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
        }
        return 0;
    }

    private void rellenarComboEspecialidad() throws SQLException {
        cbEspecialidad.removeAllItems();
        String sql = "SELECT esp_especialidad_atleta FROM vtjt_especialidad";
        Controlador.Conexion conn = new Controlador.Conexion();
        ResultSet resul = conn.consulta(sql);
        try {
            while (resul.next()) {
                cbEspecialidad.addItem(resul.getString("esp_especialidad_atleta"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            resul.close();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        MostrarEliminados = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbEspecialidad = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox<String>();
        btnEspecialidad = new javax.swing.JButton();
        btnCiudad = new javax.swing.JButton();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        btnRecargar = new javax.swing.JButton();
        pnGuardarAtleta = new javax.swing.JPanel();
        txtGuardar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cbEstado = new javax.swing.JComboBox<String>();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarEstado = new javax.swing.JButton();

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
        setTitle("Gestion de Atletas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atleta.png"))); // NOI18N
        setInheritsPopupMenu(true);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("RUT:");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel3.setText("Ciudad");

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel4.setText("Fecha de nacimiento");

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel5.setText("Especialidad");

        btnEspecialidad.setBackground(new java.awt.Color(153, 255, 153));
        btnEspecialidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEspecialidad.setText("➕");
        btnEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspecialidadActionPerformed(evt);
            }
        });

        btnCiudad.setBackground(new java.awt.Color(153, 255, 153));
        btnCiudad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCiudad.setText("➕");
        btnCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadActionPerformed(evt);
            }
        });

        jLabel6.setText("Apellido Paterno");

        jLabel7.setText("Apellido Materno");

        btnRecargar.setBackground(new java.awt.Color(153, 153, 255));
        btnRecargar.setText("🔃");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5))
                        .addGap(115, 115, 115)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCiudad)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEspecialidad))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel6))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtRut)
                            .addComponent(txtApellido1)
                            .addComponent(txtApellido2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecargar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnRecargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEspecialidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCiudad))
                .addContainerGap())
        );

        pnGuardarAtleta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnGuardarAtleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnGuardarAtleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnGuardarAtletaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnGuardarAtletaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnGuardarAtletaMouseExited(evt);
            }
        });

        txtGuardar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        txtGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGuardar.setText("GUARDAR");
        txtGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        javax.swing.GroupLayout pnGuardarAtletaLayout = new javax.swing.GroupLayout(pnGuardarAtleta);
        pnGuardarAtleta.setLayout(pnGuardarAtletaLayout);
        pnGuardarAtletaLayout.setHorizontalGroup(
            pnGuardarAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );
        pnGuardarAtletaLayout.setVerticalGroup(
            pnGuardarAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Apellido1", "Apellido2", "Fecha", "Especialidad", "Ciudad", "Estado"
            }
        ));
        tabla.setComponentPopupMenu(jPopupMenu1);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel8.setText("Estado");

        btnAgregarEstado.setBackground(new java.awt.Color(153, 255, 153));
        btnAgregarEstado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarEstado.setText("➕");
        btnAgregarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarEstado)
                        .addGap(16, 16, 16)
                        .addComponent(pnGuardarAtleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnGuardarAtleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(btnAgregarEstado)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseEntered
        pnGuardarAtleta.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_txtGuardarMouseEntered

    private void txtGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseExited
        pnGuardarAtleta.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_txtGuardarMouseExited

    private void pnGuardarAtletaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarAtletaMouseEntered
        pnGuardarAtleta.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_pnGuardarAtletaMouseEntered

    private void pnGuardarAtletaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarAtletaMouseExited
        pnGuardarAtleta.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_pnGuardarAtletaMouseExited

    private void pnGuardarAtletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarAtletaMouseClicked
        try {
            logicaGuardado();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnGuardarAtletaMouseClicked

    private void btnEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspecialidadActionPerformed
        String especliadad = JOptionPane.showInputDialog("Ingrese el nombre de la especialidad: ");

        if (especliadad.equals("")) {
            JOptionPane.showMessageDialog(null, "Rellene el campo");
        } else {
            try {
                String sql = "INSERT INTO VTJT_ESPECIALIDAD (esp_especialidad_atleta) SELECT '" + especliadad + "' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM VTJT_ESPECIALIDAD WHERE esp_especialidad_atleta = '" + especliadad + "')";
                Conexion c = new Conexion();
                c.exec(sql);
                rellenarComboEspecialidad();
                JOptionPane.showMessageDialog(null, "Especialidad ingresado correctamente");
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEspecialidadActionPerformed

    private void btnCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadActionPerformed
        String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad: ");

        if (ciudad.equals("")) {
            JOptionPane.showMessageDialog(null, "Rellene el campo");
        } else {
            try {
                String sql = "INSERT INTO VTJT_CIUDAD (ciu_ciudad_origen) SELECT '" + ciudad + "' FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM VTJT_CIUDAD WHERE ciu_ciudad_origen = '" + ciudad + "')";
                Conexion c = new Conexion();
                c.exec(sql);
                llenarComboCiudad();
                JOptionPane.showMessageDialog(null, "Especialidad ingresado correctamente");
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCiudadActionPerformed

    private void txtGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseClicked
        try {
            logicaGuardado();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtGuardarMouseClicked

    private void btnAgregarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstadoActionPerformed
        try {
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
            } finally {
                try {
                    c.close();
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            llenarEstado();
            actualizarAtleta("WHERE est.est_estado='activo'");
            JOptionPane.showMessageDialog(null, "Estado ingresado correctamente");
            c.close();
            deshabililtaEstadoC();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarEstadoActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        try {
            llenarComboCiudad();
            rellenarComboEspecialidad();
            actualizarAtleta("WHERE est.est_estado='activo'");
            llenarEstado();
            deshabililtaEstadoC();
            limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.getSelectedRow();
        try {
            if (fila != -1) {
                txtRut.setEnabled(false);
                String rut = (String) tabla.getValueAt(fila, 0);
                String nombre = (String) tabla.getValueAt(fila, 1);
                String apellido1 = (String) tabla.getValueAt(fila, 2);
                String apellido2 = (String) tabla.getValueAt(fila, 3);

                // Convert String value to Date object
                String fechaStr = (String) tabla.getValueAt(fila, 4);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = sdf.parse(fechaStr);

                String especialidad = (String) tabla.getValueAt(fila, 5);
                String ciudad = (String) tabla.getValueAt(fila, 6);
                String estado = (String) tabla.getValueAt(fila, 7);

                txtRut.setText(rut);
                txtNombre.setText(nombre);
                txtApellido1.setText(apellido1);
                txtApellido2.setText(apellido2);
                cbEspecialidad.setSelectedItem(especialidad);
                cbCiudad.setSelectedItem(ciudad);
                txtFecha.setDate(fecha);
                cbEstado.setSelectedItem(estado);
                txtGuardar.setText("EDITAR");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tablaMouseClicked

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = tabla.getSelectedRow();
        try {
            if (fila != -1) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminarlo?");
                if (respuesta == 0) {
                    String rut = (String) tabla.getValueAt(fila, 0);
                    int id = obtenerIdEstado("inactivo");
                    String sql = "UPDATE vtjt_atleta SET atl_estado=" + id + " WHERE atl_rut='" + rut + "'";
                    Conexion c = new Conexion();
                    c.exec(sql);
                    limpiar();
                    actualizarAtleta("WHERE est.est_estado='activo'");
                    c.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void MostrarEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarEliminadosActionPerformed
        actualizarAtleta("");
    }//GEN-LAST:event_MostrarEliminadosActionPerformed

    private void deshabililtaEstadoC() {
        int estados = cbEstado.getItemCount();

        if (estados == 2) {
            btnAgregarEstado.setEnabled(false);
        } else {
            btnAgregarEstado.setEnabled(true);
        }
    }

    private void limpiar() {
        txtRut.setText("");
        txtNombre.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtFecha.setCalendar(null);
        cbEspecialidad.setSelectedIndex(-1);
        cbCiudad.setSelectedIndex(-1);
        cbEstado.setSelectedIndex(-1);
        txtGuardar.setText("GUARDAR");
    }

    // Metodo para obtener el id del estado segun el nombre
    public static int obtenerIdCiudad(String nombre) throws SQLException {
        String sql = "SELECT ciu_id FROM vtjt_ciudad where ciu_ciudad_origen='" + nombre + "';";
        Controlador.Conexion c = new Controlador.Conexion();
        ResultSet r = c.consulta(sql);
        try {
            while (r.next()) {
                return r.getInt("ciu_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.close();
            r.close();
        }
        return 0;
    }

    // Metodo para obtener el id del estado segun el nombre
    public static int obtenerIdEspecialidad(String nombre) throws SQLException {
        String sql = "SELECT esp_id FROM vtjt_especialidad where esp_especialidad_atleta='" + nombre + "';";
        Controlador.Conexion c = new Controlador.Conexion();
        ResultSet r = c.consulta(sql);
        try {
            while (r.next()) {
                return r.getInt("esp_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.close();
            r.close();
        }
        return 0;
    }

    private void logicaGuardado() throws SQLException {
        String rut = txtRut.getText();
        String nombre = txtNombre.getText();
        String apellido1 = txtApellido1.getText();
        String apellido2 = txtApellido2.getText();
        Calendar selectedCalendar = txtFecha.getCalendar();

        if (selectedCalendar != null) {
            java.util.Date selectedDate = selectedCalendar.getTime();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String formattedDate = dateFormat.format(selectedDate);

            String ciudad = (String) cbCiudad.getSelectedItem();
            String especialidad = (String) cbEspecialidad.getSelectedItem();
            if (!formattedDate.equals("") || !rut.equals("") || !nombre.equals("") || !ciudad.equals("") || especialidad.equals("") || apellido1.equals("") || apellido2.equals("")) {
                String accion = txtGuardar.getText();
                String sql = "";
                int idc = obtenerIdCiudad(ciudad);
                int ide = obtenerIdEspecialidad(especialidad);
                int idest = obtenerIdEstado("activo");
                if (accion.equals("GUARDAR")) {
                    sql = "INSERT INTO vtjt_atleta VALUES ('" + rut + "','" + nombre + "','" + apellido1 + "','" + apellido2 + "','" + formattedDate + "'," + ide + "," + idc + ",1)";
                } else if (accion.equals("EDITAR")) {
                    sql = "UPDATE vtjt_atleta SET atl_nombre='" + nombre + "', atl_apellido1='" + apellido1 + "',atl_apellido2='" + apellido2 + "',atl_fechaNacimiento='" + formattedDate + "',atl_especialidad=" + ide + ",atl_ciudad_id=" + idc + ",atl_estado=" + idest + " WHERE atl_rut='" + rut + "'";
                }
                try {
                    System.out.println(sql);
                    Controlador.Conexion c = new Conexion();
                    c.exec(sql);
                    limpiar();
                    actualizarAtleta("WHERE est.est_estado='activo'");
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem MostrarEliminados;
    private javax.swing.JButton btnAgregarEstado;
    private javax.swing.JButton btnCiudad;
    private javax.swing.JButton btnEspecialidad;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox<String> cbCiudad;
    private javax.swing.JComboBox<String> cbEspecialidad;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnGuardarAtleta;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JLabel txtGuardar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
