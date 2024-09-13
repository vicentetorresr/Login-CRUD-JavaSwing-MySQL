package Vista;

import Controlador.Conexion;
import static Vista.mantenedorAtleta.obtenerIdEstado;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mantenedorEvento extends javax.swing.JInternalFrame {

    public mantenedorEvento() {
        try {
            initComponents();
            llenarComboUsuario();
            llenarComboCiudad();
            limpiar();
            llenarEstado();
            llenarComboRut();
            actualizarEvento("WHERE es.est_estado='activo'");
            txtID.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarEvento(String where) {
        try {
            Object[] cabeceras
                    = {
                        "ID", "Nombre", "Fecha Creacion", "Fecha Realizacion", "Descripcion", "Estado", "Ciudad", "Usuario a cargo"
                    };
            Object[][] cuerpo
                    = {};
            DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabeceras);
            String sql = "SELECT e.eve_id,e.eve_nombre,e.eve_fechaCreacion,e.eve_fechaRealizacion,e.eve_descripcion,es.est_estado,c.ciu_ciudad_origen,us.usu_nombre FROM vtjt_evento e INNER JOIN vtjt_estado es ON e.eve_estado = es.est_id INNER JOIN vtjt_ciudad c ON e.eve_ciudad_id = c.ciu_id INNER JOIN vtjt_usuario us ON e.eve_usuario_cargo = us.usu_rut " + where;
            Conexion conn = new Conexion();
            ResultSet resul = conn.consulta(sql);

            while (resul.next()) {
                Object[] elemento
                        = {
                            resul.getString("e.eve_id"), resul.getString("e.eve_nombre"), resul.getString("e.eve_fechaCreacion"), resul.getString("e.eve_fechaRealizacion"),
                            resul.getString("e.eve_descripcion"), resul.getString("es.est_estado"), resul.getString("c.ciu_ciudad_origen"), resul.getString("us.usu_nombre")
                        };
                modelo.addRow(elemento);
            }
            table.setModel(modelo);
            conn.close();
            resul.close();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void llenarComboRut() {
        cbRut.removeAllItems();
        String sql = "SELECT atl_rut FROM vtjt_atleta";
        Controlador.Conexion conn = new Controlador.Conexion();
        ResultSet resul = conn.consulta(sql);
        try {
            while (resul.next()) {
                cbRut.addItem(resul.getString("atl_rut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            resul.close();
        }
    }

    private void limpiar() {
        cbCiudad.setSelectedIndex(-1);
        cbUsuario.setSelectedIndex(-1);
        cbEstado.setSelectedIndex(-1);
        txtGuardar.setText("GUARDAR");
        txtDescripcion.setText("");
        txtNombre.setText("");
        tabla.clearSelection();
        table.clearSelection();
        try {
            Object[] cabeceras
                    = {
                        "Rut", "Nombre"
                    };
            Object[][] cuerpo
                    = {};
            DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabeceras);
            tabla.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtFecha.setCalendar(null);
        txtGuardar.setText("GUARDAR");
        txtCreacion.setText("Fecha creacion: ");
    }

    private void llenarComboUsuario() throws SQLException {
        cbUsuario.removeAllItems();
        String sql = "SELECT usu_nombre FROM vtjt_usuario";
        Controlador.Conexion conn = new Controlador.Conexion();
        ResultSet resul = conn.consulta(sql);
        try {
            while (resul.next()) {
                cbUsuario.addItem(resul.getString("usu_nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
            resul.close();
        }
    }

    public static String obtenerRutUsuario(String nombre) throws SQLException {
        String sql = "SELECT usu_rut FROM vtjt_usuario WHERE usu_nombre='" + nombre + "';";
        Controlador.Conexion c = new Controlador.Conexion();
        ResultSet r = c.consulta(sql);
        String rut = null;

        try {
            if (r.next()) {
                rut = r.getString("usu_rut");
            }
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            c.close();
            r.close();
        }

        return rut;  // Return the RUT, which might be null if not found
    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        MostrarEliminados = new javax.swing.JMenuItem();
        table = new javax.swing.JTable();
        pnGuardarEvento = new javax.swing.JPanel();
        txtGuardar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        cbCiudad = new javax.swing.JComboBox<String>();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        txtCreacion = new javax.swing.JLabel();
        cbRut = new javax.swing.JComboBox();

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
        setTitle("Gestion de Eventos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/img/evento.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(868, 380));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setComponentPopupMenu(jPopupMenu1);
        table.setFillsViewportHeight(true);
        table.setOpaque(false);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        pnGuardarEvento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnGuardarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnGuardarEventoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnGuardarEventoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnGuardarEventoMouseExited(evt);
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

        javax.swing.GroupLayout pnGuardarEventoLayout = new javax.swing.GroupLayout(pnGuardarEvento);
        pnGuardarEvento.setLayout(pnGuardarEventoLayout);
        pnGuardarEventoLayout.setHorizontalGroup(
            pnGuardarEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );
        pnGuardarEventoLayout.setVerticalGroup(
            pnGuardarEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel3.setText("Descripciòn");

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel4.setText("Fecha de realizaciòn");

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel5.setText("Usuario a cargo");

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel6.setText("Ciudad");

        txtID.setEnabled(false);
        txtID.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtID)
                        .addGap(77, 77, 77)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(cbUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCiudad, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtID))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setText("Rut Atleta a participar:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUT", "ATLETA"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton1.setBackground(new java.awt.Color(204, 255, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("+");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnRecargar.setBackground(new java.awt.Color(153, 153, 255));
        btnRecargar.setText("🔃");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado:");

        txtCreacion.setText("Fecha creacion: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRecargar)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCreacion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnGuardarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbRut, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                        .addComponent(table, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 19, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCreacion)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRecargar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnGuardarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseEntered
        pnGuardarEvento.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_txtGuardarMouseEntered

    private void txtGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseExited
        pnGuardarEvento.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_txtGuardarMouseExited

    private void pnGuardarEventoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarEventoMouseEntered
        pnGuardarEvento.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_pnGuardarEventoMouseEntered

    private void pnGuardarEventoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarEventoMouseExited
        pnGuardarEvento.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_pnGuardarEventoMouseExited

    private void pnGuardarEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnGuardarEventoMouseClicked
        try {
            logicaGuardado();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnGuardarEventoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String rut = (String) cbRut.getSelectedItem();
        try {
            buscarAtletas(rut);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No encontrado " + e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGuardarMouseClicked
        try {
            logicaGuardado();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtGuardarMouseClicked

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        try {
            llenarComboUsuario();
            llenarComboCiudad();
            llenarEstado();
            llenarComboRut();
            limpiar();
            actualizarEvento("WHERE es.est_estado='activo'");
            txtGuardar.setText("GUARDAR");
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void settearAtletas(int idEvento) {
        tabla.removeAll();
        String sql = "SELECT a.atl_rut, a.atl_nombre FROM vtjt_detalle_evento d INNER JOIN vtjt_atleta a ON d.dee_atleta_rut=a.atl_rut WHERE d.dee_evento_id=" + idEvento + "";
        Controlador.Conexion conn = new Controlador.Conexion();
        ResultSet resul = conn.consulta(sql);
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            while (resul.next()) {
                String id = resul.getString("atl_rut");
                String nombre = resul.getString("atl_nombre");
                Object[] newRow = {id, nombre};
                model.addRow(newRow);
            }
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Evento sin participantes");
            }
            conn.close();
            resul.close();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            Object[] cabeceras
                    = {
                        "Rut", "Nombre"
                    };
            Object[][] cuerpo
                    = {};
            DefaultTableModel modelo = new DefaultTableModel(cuerpo, cabeceras);
            tabla.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int fila = table.getSelectedRow();
        System.out.println(fila);
        try {
            if (fila != -1) {
                // "ID", "Nombre", "Fecha Creacion", "Fecha Realizacion", "Descripcion", "Estado", "Ciudad", "Usuario a cargo"
                String id = (String) table.getValueAt(fila, 0);
                String nombre = (String) table.getValueAt(fila, 1);
                String fechaCreacion = (String) table.getValueAt(fila, 2);
                String FechaRealizacion = (String) table.getValueAt(fila, 3);
                String Descripcion = (String) table.getValueAt(fila, 4);
                String estado = (String) table.getValueAt(fila, 5);
                String ciudad = (String) table.getValueAt(fila, 6);
                String usuario = (String) table.getValueAt(fila, 7);
                settearAtletas(Integer.parseInt(id));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha = sdf.parse(FechaRealizacion);

                txtID.setText(id);
                txtNombre.setText(nombre);
                cbUsuario.setSelectedItem(usuario);
                cbCiudad.setSelectedItem(ciudad);
                txtFecha.setDate(fecha);
                cbEstado.setSelectedItem(estado);
                txtDescripcion.setText(Descripcion);
                txtCreacion.setText("Fecha creacion: " + fechaCreacion);
                txtGuardar.setText("EDITAR");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tableMouseClicked

    private void MostrarEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarEliminadosActionPerformed
        actualizarEvento("");
    }//GEN-LAST:event_MostrarEliminadosActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila = table.getSelectedRow();
        try {
            if (fila != -1) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminarlo?");
                if (respuesta == 0) {
                    String idEvento = (String) table.getValueAt(fila, 0);
                    System.out.println(idEvento);
                    int idEstado = obtenerIdEstado("inactivo");
                    String sql = "UPDATE vtjt_evento SET eve_estado=" + idEstado + " WHERE eve_id='" + idEvento + "'";
                    Conexion c = new Conexion();
                    c.exec(sql);
                    limpiar();
                    actualizarEvento("WHERE es.est_estado='activo'");
                    c.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void buscarAtletas(String rut) {
        String sql = "SELECT atl_rut,atl_nombre FROM vtjt_atleta where atl_rut='" + rut + "'";
        Controlador.Conexion conn = new Controlador.Conexion();
        ResultSet resul = conn.consulta(sql);
        String id = "";
        String nombre = "";
        try {

            while (resul.next()) {
                id = resul.getString("atl_rut");
                nombre = resul.getString("atl_nombre");

            }
            if (!id.equals("") && !nombre.equals("")) {
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    String rowRut = (String) model.getValueAt(i, 0);
                    if (rowRut.equals(rut)) {
                        JOptionPane.showMessageDialog(null, "Ya existe un atleta con ese RUT.");
                        return;
                    }
                }
                Object[] newRow = {
                    id,
                    nombre
                };
                model.addRow(newRow);
            } else {
                JOptionPane.showMessageDialog(null, "No encontrado");
            }
            conn.close();
            resul.close();
        } catch (SQLException ex) {
            Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
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

    public static int obtenerIdEstado(String nombre) throws SQLException {
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
            c.close();
            r.close();
        }
        return 0;
    }

    private void logicaGuardado() throws SQLException {
        String nombre = txtNombre.getText();
        Calendar selectedCalendar = txtFecha.getCalendar();
        java.util.Date selectedDate = selectedCalendar.getTime();
        String accion = txtGuardar.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = dateFormat.format(selectedDate);
        String descripcion = txtDescripcion.getText();
        String ciudad = (String) cbCiudad.getSelectedItem();
        String usuario = (String) cbUsuario.getSelectedItem();
        if (!nombre.equals("") || !formattedDate.equals("") || !descripcion.equals("") || !ciudad.equals("") || !usuario.equals("")) {
            int idCiu = obtenerIdCiudad(ciudad);
            String sqlEvento = "";
            int estado = obtenerIdEstado((String) cbEstado.getSelectedItem());
            // Inserta el evento
            if (accion.equals("GUARDAR")) {
                sqlEvento = "INSERT INTO VTJT_EVENTO VALUES(null, ?, CURDATE(), ?, ?, ?, ?, ?)";
            } else if (accion.equals("EDITAR")) {
                sqlEvento = "UPDATE VTJT_EVENTO SET eve_nombre = ?, eve_fechaRealizacion = ?, eve_descripcion = ?, eve_estado = ?, eve_ciudad_id = ?, eve_usuario_cargo = ? WHERE eve_id = ?;";
                int fila = table.getSelectedRow();
                String id = (String) table.getValueAt(fila, 0);
                insertDetalle(Integer.parseInt(id));
            }
            try {
                Conexion conexion = new Conexion();
                Connection conn = conexion.getConn();
                PreparedStatement statement = conn.prepareStatement(sqlEvento, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, nombre);
                statement.setString(2, formattedDate);
                statement.setString(3, descripcion);
                statement.setInt(4, estado);
                statement.setInt(5, idCiu);
                statement.setString(6, obtenerRutUsuario(usuario));
                if (accion.equals("EDITAR")) {
                    statement.setInt(7, Integer.parseInt(txtID.getText()));
                }
                int filasAfectadas = statement.executeUpdate();
                if (!accion.equals("EDITAR")) {
                    JOptionPane.showMessageDialog(null, "Ingresado correctamente");
                    if (filasAfectadas > 0) {
                        ResultSet generatedKeys = statement.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            int idEvento = generatedKeys.getInt(1);
                            insertDetalle(idEvento);
                        }
                        generatedKeys.close();
                    }
                } else if (accion.equals("EDITAR")) {
                    JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                    actualizarEvento("WHERE es.est_estado='activo'");
                }
                statement.close();
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void insertDetalle(int idEvento) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            String Rut = (String) tabla.getValueAt(i, 0);
            String sql = String.format("INSERT INTO VTJT_DETALLE_EVENTO (dee_evento_id, dee_atleta_rut) VALUES (%d, '%s')", idEvento, Rut);
            Conexion c = new Conexion();
            try {
                c.exec(sql);
            } catch (Exception e) {
                Logger.getLogger(mantenedorEvento.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                c.close();
            }
        }
        actualizarEvento("WHERE es.est_estado='activo'");
        limpiar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenuItem MostrarEliminados;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox<String> cbCiudad;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbRut;
    private javax.swing.JComboBox<String> cbUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnGuardarEvento;
    private javax.swing.JTable tabla;
    private javax.swing.JTable table;
    private javax.swing.JLabel txtCreacion;
    private javax.swing.JTextField txtDescripcion;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JLabel txtGuardar;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
