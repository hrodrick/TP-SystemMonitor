/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import monitor.Monitor;
import monitor.NICS.INIC;
import persistencia.ArchivoJSON;

/**
 *
 * @author Rodrigo Soria
 */
public class UserInterface extends javax.swing.JFrame {

    Monitor monitor;
    Danger peligro=new Danger();;
    public UserInterface() {
        initComponents();
        jTextArea1.setEditable(false);
        jTextArea1.setFocusable(false);
        jTextArea2.setFocusable(false);
        jTextArea2.setEditable(false);
    }

    public UserInterface(Monitor m) {
        this();
        this.monitor = m;
        //MICRO 
        lblCpuArquitectura.setText(monitor.getMicro().esDe64Bits() ? "x64" : "x86");
        lblCpuMarca.setText(monitor.getMicro().getFabricanteCPU());
        lblCpuModelo.setText(monitor.getMicro().getModeloCPU());
        lblCpuNucleosFisicos.setText(Integer.toString(monitor.getMicro().getNucleosFisicosCPU()));
        lblCpuNucleosLogicos.setText(Integer.toString(monitor.getMicro().getNucleosLogicosCPU()));
        lblCpuFamilia.setText(monitor.getMicro().getFamiliaCPU());
        lblCpuNombre.setText(monitor.getMicro().getNombreCPU());
        //MOTHER
        lblMotherMarca.setText(monitor.getPlacaMadre().getMarcaMother());
        lblMotherModelo.setText(monitor.getPlacaMadre().getModeloMother());
        //SO
        lblOsFamilia.setText(monitor.getSistemaOperativo().getFamiliaOS());
        lblOsVersion.setText(monitor.getSistemaOperativo().getVersionOS());
        lblOsEdicion.setText(monitor.getSistemaOperativo().getEdicionOS());
        lblOsFabricante.setText(monitor.getSistemaOperativo().getFabricanteOS());
        //MEMORIA
        lblRAMTotal.setText(Long.toString(monitor.getMemoria().getMemFisicaTotal() / 1024 / 1024) + "mb");
        lblMemoriaSwapTot.setText(Long.toString(monitor.getMemoria().getMemSwapTotal() / 1024 / 1024) + "mb");
    }

    public void actualizarDatosSensorYCarga() {
        /*
        if(monitor.getMemoria().getMemSwapUso() >= monitor.getMemoria().getMemSwapTotal()*0.05){
            peligro.setVisible(true);
            try {            
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            peligro.setVisible(false);
        }         
        */
        lblTempCpu.setText(monitor.getSensores().getTempCPU().shortValue() + "°C");
        DecimalFormat df = new DecimalFormat("0.00");
        lblUsoCpu.setText(df.format(100 * monitor.getMicro().getUsoActualCPU()) + "%");
        lblCpuVoltaje.setText(df.format(100 * monitor.getSensores().getVoltajeCPU()) + " W");
        lblUsoRam.setText(String.valueOf(monitor.getMemoria().getMemFisicaUso() / 1024 / 1024) + "mb");
        lblUsoRamDisponible.setText(String.valueOf(monitor.getMemoria().getMemFisicaDisponible() / 1024 / 1024) + "mb");
        lblUsoSWAP.setText(String.valueOf(monitor.getMemoria().getMemSwapUso() / 1024 / 1024) + "mb");
        lblUsoSWAPDisponible.setText(String.valueOf(monitor.getMemoria().getMemSwapDisponible() / 1024 / 1024) + "mb");
       
        
        //Esta funcion agrega toda la informacion de networks a un text area
        cargarNIC(monitor.getNetworks().getNics());
        cargarVelVentiladores(monitor.getSensores().getVelVentiladores());
    }

    public Integer getFrecuenciaActualizacion() {
        return sliderFrecuencia.getValue();
    }

    public void cargarNIC(ArrayList<INIC> nics) {
        jTextArea1.setText("");
        for (int i = 0; i < nics.size(); i++) {
            jTextArea1.setText(jTextArea1.getText()
                             + "Nombre: " + nics.get(i).getNombre()
                             + "\nMacAdress: " + nics.get(i).getMacAdress());

            String ipv4[] = nics.get(i).getIPv4();

            for (int j = 0; j < ipv4.length; j++) {
                jTextArea1.setText(jTextArea1.getText() + "\nipv4: " + ipv4[j]);
            }

            jTextArea1.setText(jTextArea1.getText()
                            + "\nBytes enviados: " + nics.get(i).getBytesEnviados() / 1024 + "kb."
                            + "\nBytes Recibidos: " + nics.get(i).getBytesRecibidos() / 1024 + "kb."
                            + "\n-----------------------------" + "\n");
        }
    }

    public void cargarVelVentiladores(int vel[]) {
        jTextArea2.setText("");
        for (int i = 0; i < vel.length; i++) {
            jTextArea2.setText("\nventilador 1: " + vel[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSOCPU = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblOsFabricante = new javax.swing.JLabel();
        lblOsFamilia = new javax.swing.JLabel();
        lblOsVersion = new javax.swing.JLabel();
        lblOsEdicion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCpuNombre = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblCpuArquitectura = new javax.swing.JLabel();
        lblCpuNucleosLogicos = new javax.swing.JLabel();
        lblCpuNucleosFisicos = new javax.swing.JLabel();
        lblCpuModelo = new javax.swing.JLabel();
        lblCpuFamilia = new javax.swing.JLabel();
        lblCpuMarca = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanelMotherMemoria = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblRAMTotal = new javax.swing.JLabel();
        lblMemoriaSwapTot = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblMotherMarca = new javax.swing.JLabel();
        lblMotherModelo = new javax.swing.JLabel();
        jPanelEstadoSistema = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblCpuVoltaje = new javax.swing.JLabel();
        lblTempCpu = new javax.swing.JLabel();
        lblUsoCpu = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblUsoSWAPDisponible = new javax.swing.JLabel();
        lblUsoSWAP = new javax.swing.JLabel();
        lblUsoRamDisponible = new javax.swing.JLabel();
        lblUsoRam = new javax.swing.JLabel();
        jPanelCoolers = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanelSlider = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        sliderFrecuencia = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSOCPU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Sistema Operativo");

        jLabel2.setText("Fabricante:");

        jLabel3.setText("Familia:");

        jLabel4.setText("Version:");

        jLabel5.setText("Edicion:");

        lblOsFabricante.setText("Microsoft");

        lblOsFamilia.setText("Windows");

        lblOsVersion.setText("10");

        lblOsEdicion.setText("Home");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("CPU");

        lblCpuNombre.setText("I7 6700 3.4 Ghz");

        jLabel23.setText("Marca:");

        jLabel24.setText("Familia:");

        jLabel25.setText("Modelo:");

        jLabel26.setText("Nucleos:");

        jLabel27.setText("Hilos:");

        jLabel28.setText("Arquitectura:");

        lblCpuArquitectura.setText("xn");

        lblCpuNucleosLogicos.setText("Threads");

        lblCpuNucleosFisicos.setText("Cores");

        lblCpuModelo.setText("Model");

        lblCpuFamilia.setText("Family");

        lblCpuMarca.setText("Vendor");

        jButton1.setText("Exportar a .json");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSOCPULayout = new javax.swing.GroupLayout(jPanelSOCPU);
        jPanelSOCPU.setLayout(jPanelSOCPULayout);
        jPanelSOCPULayout.setHorizontalGroup(
            jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSOCPULayout.createSequentialGroup()
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSOCPULayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(jPanelSOCPULayout.createSequentialGroup()
                                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOsEdicion)
                                    .addComponent(lblOsVersion)
                                    .addComponent(lblOsFamilia)
                                    .addComponent(lblOsFabricante)))
                            .addComponent(lblCpuNombre)
                            .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSOCPULayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCpuMarca))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelSOCPULayout.createSequentialGroup()
                                    .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel24))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCpuFamilia)
                                        .addComponent(lblCpuModelo)
                                        .addComponent(lblCpuNucleosFisicos)
                                        .addComponent(lblCpuNucleosLogicos)
                                        .addComponent(lblCpuArquitectura))))))
                    .addGroup(jPanelSOCPULayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel6))
                    .addGroup(jPanelSOCPULayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanelSOCPULayout.setVerticalGroup(
            jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSOCPULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblOsFabricante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblOsFamilia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblOsVersion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblOsEdicion))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblCpuMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCpuNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblCpuFamilia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblCpuModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblCpuNucleosFisicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblCpuNucleosLogicos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblCpuArquitectura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel22.setText("Controladores  de red");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 187, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel7.setText("Placa Madre");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("Memoria");

        jLabel9.setText("RAM Total: ");

        jLabel10.setText("SWAP Total:");

        lblRAMTotal.setText("4096 MB");

        lblMemoriaSwapTot.setText("4096 MB");

        jLabel13.setText("Marca:");

        jLabel14.setText("Modelo:");

        lblMotherMarca.setText("Gigabyte Co.");

        lblMotherModelo.setText("H-110-MA");

        javax.swing.GroupLayout jPanelMotherMemoriaLayout = new javax.swing.GroupLayout(jPanelMotherMemoria);
        jPanelMotherMemoria.setLayout(jPanelMotherMemoriaLayout);
        jPanelMotherMemoriaLayout.setHorizontalGroup(
            jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                .addGroup(jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblRAMTotal))
                            .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMemoriaSwapTot)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMotherModelo))
                            .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMotherMarca))))
                    .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMotherMemoriaLayout.setVerticalGroup(
            jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotherMemoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblRAMTotal)
                    .addComponent(jLabel13)
                    .addComponent(lblMotherMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMotherMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblMemoriaSwapTot)
                    .addComponent(jLabel14)
                    .addComponent(lblMotherModelo))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setText("Estado del sistema en tiempo real");

        jLabel12.setText("Uso CPU:");

        jLabel15.setText("Temp CPU:");

        jLabel16.setText("Voltaje CPU:");

        lblCpuVoltaje.setText("43.5W");

        lblTempCpu.setText("33.8ºC");

        lblUsoCpu.setText("34.6 %");

        jLabel17.setText("Uso RAM:");

        jLabel18.setText("RAM disp:");

        jLabel19.setText("Uso Swap:");

        jLabel20.setText("Swap disp:");

        lblUsoSWAPDisponible.setText("2048 MB");

        lblUsoSWAP.setText("2048 MB");

        lblUsoRamDisponible.setText("2048 MB");

        lblUsoRam.setText("2048 MB");

        javax.swing.GroupLayout jPanelEstadoSistemaLayout = new javax.swing.GroupLayout(jPanelEstadoSistema);
        jPanelEstadoSistema.setLayout(jPanelEstadoSistemaLayout);
        jPanelEstadoSistemaLayout.setHorizontalGroup(
            jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                        .addGroup(jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(lblUsoCpu))
                            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTempCpu))
                            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCpuVoltaje)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUsoSWAP))
                            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsoRamDisponible))
                            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsoRam))
                            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUsoSWAPDisponible))))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEstadoSistemaLayout.setVerticalGroup(
            jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadoSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblUsoCpu)
                    .addComponent(jLabel17)
                    .addComponent(lblUsoRam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblTempCpu)
                    .addComponent(jLabel18)
                    .addComponent(lblUsoRamDisponible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblCpuVoltaje)
                    .addComponent(jLabel19)
                    .addComponent(lblUsoSWAP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEstadoSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblUsoSWAPDisponible))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCoolers.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel21.setText("Velocidad de los ventiladores");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanelCoolersLayout = new javax.swing.GroupLayout(jPanelCoolers);
        jPanelCoolers.setLayout(jPanelCoolersLayout);
        jPanelCoolersLayout.setHorizontalGroup(
            jPanelCoolersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoolersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCoolersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCoolersLayout.setVerticalGroup(
            jPanelCoolersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoolersLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setText("Frecuencia de actualizacion");

        javax.swing.GroupLayout jPanelSliderLayout = new javax.swing.GroupLayout(jPanelSlider);
        jPanelSlider.setLayout(jPanelSliderLayout);
        jPanelSliderLayout.setHorizontalGroup(
            jPanelSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSliderLayout.createSequentialGroup()
                .addGroup(jPanelSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSliderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sliderFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSliderLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSliderLayout.setVerticalGroup(
            jPanelSliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSliderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(sliderFrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSOCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEstadoSistema, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMotherMemoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCoolers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSOCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelMotherMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelEstadoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCoolers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArchivoJSON archivo = new ArchivoJSON();
        String directorio = JOptionPane.showInputDialog("Donde desea guardar el archivo? ");

        String fecha = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        archivo.escribir(monitor.toJson(),"C:\\"+directorio+".Json");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCoolers;
    private javax.swing.JPanel jPanelEstadoSistema;
    private javax.swing.JPanel jPanelMotherMemoria;
    private javax.swing.JPanel jPanelSOCPU;
    private javax.swing.JPanel jPanelSlider;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblCpuArquitectura;
    private javax.swing.JLabel lblCpuFamilia;
    private javax.swing.JLabel lblCpuMarca;
    private javax.swing.JLabel lblCpuModelo;
    private javax.swing.JLabel lblCpuNombre;
    private javax.swing.JLabel lblCpuNucleosFisicos;
    private javax.swing.JLabel lblCpuNucleosLogicos;
    private javax.swing.JLabel lblCpuVoltaje;
    private javax.swing.JLabel lblMemoriaSwapTot;
    private javax.swing.JLabel lblMotherMarca;
    private javax.swing.JLabel lblMotherModelo;
    private javax.swing.JLabel lblOsEdicion;
    private javax.swing.JLabel lblOsFabricante;
    private javax.swing.JLabel lblOsFamilia;
    private javax.swing.JLabel lblOsVersion;
    private javax.swing.JLabel lblRAMTotal;
    private javax.swing.JLabel lblTempCpu;
    private javax.swing.JLabel lblUsoCpu;
    private javax.swing.JLabel lblUsoRam;
    private javax.swing.JLabel lblUsoRamDisponible;
    private javax.swing.JLabel lblUsoSWAP;
    private javax.swing.JLabel lblUsoSWAPDisponible;
    private javax.swing.JSlider sliderFrecuencia;
    // End of variables declaration//GEN-END:variables
}
