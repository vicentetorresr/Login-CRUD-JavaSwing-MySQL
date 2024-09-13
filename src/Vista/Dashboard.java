package Vista;

import Controlador.Conexion;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class Dashboard extends javax.swing.JFrame {

    private String nombreUsuario;
    private String tipoUsuario;

    mantenedorEvento eventpo = new mantenedorEvento();
    mantenedorAtleta atleta = new mantenedorAtleta();
    mantenedorUsuarios usuariosm = new mantenedorUsuarios();

    public Dashboard(String nombre, String tipo) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.nombreUsuario = nombre;
        lblUser.setText(nombre);
        this.tipoUsuario = tipo;
        nivelAccesoA();
    }

    private void nivelAccesoA() {
        if (tipoUsuario.equals("administrador")) {
            paActivado();
        } else if (tipoUsuario.equals("usuario")) {
            paGestionUsuarios.setEnabled(false);
            paGestionAtleta.setEnabled(false);
            paGestionEvento.setEnabled(true);
            lblGestionUsuarios.setEnabled(false);
            lblGestionAtetlal.setEnabled(false);
            lblGestionEvento.setEnabled(true);

            paGestionUsuarios.setVisible(false);
            paGestionAtleta.setVisible(false);
            lblGestionUsuarios.setVisible(false);
            lblGestionAtetlal.setVisible(false);
        } else {    // Este else es para acceder con el usuario Tester, presionando una vez la tecla ENTER en el campo de rut en el login
            paActivado();
        }
    }

    private void paActivado() {
        paGestionUsuarios.setEnabled(true);
        paGestionAtleta.setEnabled(true);
        paGestionEvento.setEnabled(true);
        lblGestionUsuarios.setEnabled(true);
        lblGestionAtetlal.setEnabled(true);
        lblGestionEvento.setEnabled(true);
    }

    private void cerrarSesion() {
        ImageIcon iconoPregunta = new ImageIcon("src/img/pregunta.png");
        Object[] opciones = {"Aceptar", "Rechazar"};
        int respuesta = JOptionPane.showOptionDialog(
                null,
                "¿Desea cerrar sesión?",
                "Cierre de Sesión",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                iconoPregunta,
                opciones,
                opciones[0]);

        if (respuesta == 0) {
            Login volver = new Login();
            volver.setVisible(true);
            volver.setLocationRelativeTo(null);
            this.dispose();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        paGeneralRF = new javax.swing.JPanel();
        paGestionUsuarios = new javax.swing.JPanel();
        lblGestionUsuarios = new javax.swing.JLabel();
        paGestionAtleta = new javax.swing.JPanel();
        lblGestionAtetlal = new javax.swing.JLabel();
        paGestionEvento = new javax.swing.JPanel();
        lblGestionEvento = new javax.swing.JLabel();
        paHome = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        paAyuda = new javax.swing.JPanel();
        lblAyuda = new javax.swing.JLabel();
        paAdd = new javax.swing.JPanel();
        lblAdd = new javax.swing.JLabel();
        escritorioFino = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        paUsuario = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblOff = new javax.swing.JLabel();
        paIni = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        paGestionUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        paGestionUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        paGestionUsuarios.setAlignmentX(0.0F);
        paGestionUsuarios.setAlignmentY(0.0F);
        paGestionUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paGestionUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paGestionUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paGestionUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paGestionUsuariosMouseExited(evt);
            }
        });

        lblGestionUsuarios.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lblGestionUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        lblGestionUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionUsuarios.setText("Gestion de Usuario");
        lblGestionUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout paGestionUsuariosLayout = new javax.swing.GroupLayout(paGestionUsuarios);
        paGestionUsuarios.setLayout(paGestionUsuariosLayout);
        paGestionUsuariosLayout.setHorizontalGroup(
            paGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
            .addGroup(paGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGestionUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );
        paGestionUsuariosLayout.setVerticalGroup(
            paGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(paGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
        );

        paGestionAtleta.setBackground(new java.awt.Color(153, 153, 153));
        paGestionAtleta.setForeground(new java.awt.Color(0, 0, 0));
        paGestionAtleta.setAlignmentX(0.0F);
        paGestionAtleta.setAlignmentY(0.0F);
        paGestionAtleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paGestionAtleta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paGestionAtletaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paGestionAtletaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paGestionAtletaMouseExited(evt);
            }
        });

        lblGestionAtetlal.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lblGestionAtetlal.setForeground(new java.awt.Color(0, 0, 0));
        lblGestionAtetlal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionAtetlal.setText("Gestion de Atetla");
        lblGestionAtetlal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout paGestionAtletaLayout = new javax.swing.GroupLayout(paGestionAtleta);
        paGestionAtleta.setLayout(paGestionAtletaLayout);
        paGestionAtletaLayout.setHorizontalGroup(
            paGestionAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
            .addGroup(paGestionAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGestionAtetlal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );
        paGestionAtletaLayout.setVerticalGroup(
            paGestionAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(paGestionAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGestionAtetlal, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
        );

        paGestionEvento.setBackground(new java.awt.Color(153, 153, 153));
        paGestionEvento.setForeground(new java.awt.Color(0, 0, 0));
        paGestionEvento.setAlignmentX(0.0F);
        paGestionEvento.setAlignmentY(0.0F);
        paGestionEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paGestionEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paGestionEventoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paGestionEventoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paGestionEventoMouseExited(evt);
            }
        });

        lblGestionEvento.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lblGestionEvento.setForeground(new java.awt.Color(0, 0, 0));
        lblGestionEvento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGestionEvento.setText("Gestion de Evento");
        lblGestionEvento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout paGestionEventoLayout = new javax.swing.GroupLayout(paGestionEvento);
        paGestionEvento.setLayout(paGestionEventoLayout);
        paGestionEventoLayout.setHorizontalGroup(
            paGestionEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
            .addGroup(paGestionEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGestionEvento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );
        paGestionEventoLayout.setVerticalGroup(
            paGestionEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(paGestionEventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblGestionEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
        );

        paHome.setBackground(new java.awt.Color(153, 153, 153));
        paHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paHomeMouseExited(evt);
            }
        });

        lblHome.setBackground(new java.awt.Color(153, 153, 153));
        lblHome.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblHome.setForeground(new java.awt.Color(0, 0, 0));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("🏠");
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout paHomeLayout = new javax.swing.GroupLayout(paHome);
        paHome.setLayout(paHomeLayout);
        paHomeLayout.setHorizontalGroup(
            paHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );
        paHomeLayout.setVerticalGroup(
            paHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout paGeneralRFLayout = new javax.swing.GroupLayout(paGeneralRF);
        paGeneralRF.setLayout(paGeneralRFLayout);
        paGeneralRFLayout.setHorizontalGroup(
            paGeneralRFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paGeneralRFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(paGestionAtleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(paGestionEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        paGeneralRFLayout.setVerticalGroup(
            paGeneralRFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paGeneralRFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paGeneralRFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paGestionAtleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paGestionEvento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        paAyuda.setBackground(new java.awt.Color(153, 153, 153));
        paAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paAyudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paAyudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paAyudaMouseExited(evt);
            }
        });

        lblAyuda.setBackground(new java.awt.Color(153, 153, 153));
        lblAyuda.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblAyuda.setForeground(new java.awt.Color(0, 0, 0));
        lblAyuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pregunta.png"))); // NOI18N

        javax.swing.GroupLayout paAyudaLayout = new javax.swing.GroupLayout(paAyuda);
        paAyuda.setLayout(paAyudaLayout);
        paAyudaLayout.setHorizontalGroup(
            paAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        paAyudaLayout.setVerticalGroup(
            paAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        paAdd.setBackground(new java.awt.Color(153, 153, 153));
        paAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paAddMouseExited(evt);
            }
        });

        lblAdd.setBackground(new java.awt.Color(153, 153, 153));
        lblAdd.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblAdd.setForeground(new java.awt.Color(0, 0, 0));
        lblAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cfg.png"))); // NOI18N
        lblAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddMouseExited(evt);
            }
        });

        javax.swing.GroupLayout paAddLayout = new javax.swing.GroupLayout(paAdd);
        paAdd.setLayout(paAddLayout);
        paAddLayout.setHorizontalGroup(
            paAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paAddLayout.setVerticalGroup(
            paAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(paAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(paAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        escritorioFino.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout escritorioFinoLayout = new javax.swing.GroupLayout(escritorioFino);
        escritorioFino.setLayout(escritorioFinoLayout);
        escritorioFinoLayout.setHorizontalGroup(
            escritorioFinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioFinoLayout.setVerticalGroup(
            escritorioFinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paGeneralRF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(escritorioFino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paGeneralRF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(escritorioFino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        lblIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconMouseClicked(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        lblUser.setForeground(new java.awt.Color(0, 0, 0));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblOff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/off.png"))); // NOI18N
        lblOff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOffMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paUsuarioLayout = new javax.swing.GroupLayout(paUsuario);
        paUsuario.setLayout(paUsuarioLayout);
        paUsuarioLayout.setHorizontalGroup(
            paUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paUsuarioLayout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOff, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
        );
        paUsuarioLayout.setVerticalGroup(
            paUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblOff, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblInicio.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(0, 0, 0));
        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInicio.setText("INICIO");

        javax.swing.GroupLayout paIniLayout = new javax.swing.GroupLayout(paIni);
        paIni.setLayout(paIniLayout);
        paIniLayout.setHorizontalGroup(
            paIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paIniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        paIniLayout.setVerticalGroup(
            paIniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paIniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addComponent(paIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(paIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconMouseClicked
        System.out.println(tipoUsuario);
        System.out.println(nombreUsuario);
    }//GEN-LAST:event_lblIconMouseClicked

    private void lblOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOffMouseClicked
        cerrarSesion();
    }//GEN-LAST:event_lblOffMouseClicked
    int xMouse, yMouse;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void paGestionUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionUsuariosMouseEntered
        paGestionUsuarios.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_paGestionUsuariosMouseEntered

    private void paGestionUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionUsuariosMouseExited
        paGestionUsuarios.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_paGestionUsuariosMouseExited

    private void paGestionAtletaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionAtletaMouseEntered
        paGestionAtleta.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_paGestionAtletaMouseEntered

    private void paGestionAtletaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionAtletaMouseExited
        paGestionAtleta.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_paGestionAtletaMouseExited

    private void paGestionEventoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionEventoMouseEntered
        paGestionEvento.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_paGestionEventoMouseEntered

    private void paGestionEventoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionEventoMouseExited
        paGestionEvento.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_paGestionEventoMouseExited

    private void paHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paHomeMouseEntered
        paHome.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_paHomeMouseEntered

    private void paHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paHomeMouseExited
        paHome.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_paHomeMouseExited

    private void paAyudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paAyudaMouseEntered
        paAyuda.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_paAyudaMouseEntered

    private void paAyudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paAyudaMouseExited
        paAyuda.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_paAyudaMouseExited

    private void paAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paAddMouseEntered
        paAdd.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_paAddMouseEntered

    private void paAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paAddMouseExited
        paAdd.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_paAddMouseExited

    private void lblAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseEntered
        paAdd.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_lblAddMouseEntered

    private void lblAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseExited
        paAdd.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblAddMouseExited

    private void mostUsuarios() {
        atleta.setVisible(false);
        eventpo.setVisible(false);
        escritorioFino.remove(atleta);
        escritorioFino.remove(eventpo);

        escritorioFino.add(usuariosm);
        usuariosm.setVisible(true);
        try {
            usuariosm.setMaximum(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostGestionEvento() {
        usuariosm.setVisible(false);
        atleta.setVisible(false);
        escritorioFino.remove(usuariosm);
        escritorioFino.remove(atleta);

        escritorioFino.add(eventpo);
        eventpo.setVisible(true);
        try {
            eventpo.setMaximum(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostGestionAtleta() {
        usuariosm.setVisible(false);
        eventpo.setVisible(false);
        escritorioFino.remove(usuariosm);
        escritorioFino.remove(eventpo);

        escritorioFino.add(atleta);
        atleta.setVisible(true);
        try {
            atleta.setMaximum(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void paGestionUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionUsuariosMouseClicked
        mostUsuarios();
    }//GEN-LAST:event_paGestionUsuariosMouseClicked

    private void paGestionAtletaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionAtletaMouseClicked
        mostGestionAtleta();
    }//GEN-LAST:event_paGestionAtletaMouseClicked

    private void paGestionEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paGestionEventoMouseClicked
        mostGestionEvento();
    }//GEN-LAST:event_paGestionEventoMouseClicked

    private void paHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paHomeMouseClicked
        usuariosm.setVisible(false);
        eventpo.setVisible(false);
        atleta.setVisible(false);
    }//GEN-LAST:event_paHomeMouseClicked

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        usuariosm.setVisible(false);
        eventpo.setVisible(false);
        atleta.setVisible(false);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseEntered
        paHome.setBackground(new Color(93, 109, 126));
    }//GEN-LAST:event_lblHomeMouseEntered

    private void lblHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseExited
        paHome.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_lblHomeMouseExited

    private void paAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paAyudaMouseClicked
        JOptionPane.showMessageDialog(null, "Para eliminar, debe hacer un click derecho en la tabla eliminar, ademas de tener un mostrar eliminados y poder actualizarlos a activos nuevamente");
    }//GEN-LAST:event_paAyudaMouseClicked

    private void paAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paAddMouseClicked
        cambiarContraseñaUsuario(nombreUsuario);
    }//GEN-LAST:event_paAddMouseClicked

    private void lblAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseClicked
        cambiarContraseñaUsuario(nombreUsuario);
    }//GEN-LAST:event_lblAddMouseClicked

    private void cambiarContraseñaUsuario(String usuario) {
        if (!nombreUsuario.equals("Tester")) {
            String contrasena = JOptionPane.showInputDialog("Ingrese la nueva contraseña para el usuario " + usuario + ": ");
            if (contrasena.equals("")) {
                JOptionPane.showMessageDialog(null, "Rellene el campo");
            } else {
                try {
                    usuario = nombreUsuario;
                    String sql = "UPDATE vtjt_usuario SET usu_contrasena='contrasena' WHERE usu_nombre='" + usuario + "'";
                    Conexion c = new Conexion();
                    c.exec(sql);
                    JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente");
                    c.close();
                } catch (Exception e) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario Tester no se puede cambiar la contraseña");
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel escritorio;
    private javax.swing.JPanel escritorioFino;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblAyuda;
    private javax.swing.JLabel lblGestionAtetlal;
    private javax.swing.JLabel lblGestionEvento;
    private javax.swing.JLabel lblGestionUsuarios;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblOff;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel paAdd;
    private javax.swing.JPanel paAyuda;
    private javax.swing.JPanel paGeneralRF;
    private javax.swing.JPanel paGestionAtleta;
    private javax.swing.JPanel paGestionEvento;
    private javax.swing.JPanel paGestionUsuarios;
    private javax.swing.JPanel paHome;
    private javax.swing.JPanel paIni;
    private javax.swing.JPanel paUsuario;
    // End of variables declaration//GEN-END:variables
}
