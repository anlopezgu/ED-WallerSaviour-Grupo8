/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Data.*;
import Logic.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultListModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ANDRES
 */
public class Home extends javax.swing.JFrame {
    DefaultListModel listMetas = new DefaultListModel();
    int IngresosInt = 0;
    int EgresosInt = 0 ;
    int Cobro = 0;
    int Deuda = 0;
    int Hoy = 0;
    MinHeap Movimientos = new MinHeap(100);
    Pila Ingresos = new Pila();
    Fila Egresos =new Fila();
    Pila Ingresos2 = new Pila();
    Fila Egresos2 =new Fila();
    NodoUser usuario;
    ListaMetas Metas = new ListaMetas();
    

    
    /**
     * Creates new form Home
     * @param user
     */   
    public Home(NodoUser user) {
       /* try {
            ConexionBD.conectar();
        } catch (Exception e) {
        }*/
        //this.usuario = user;
        this.usuario=user;
        initComponents();
        jDateChooser1.setDateFormatString("dd-MM-yy");
        jList1.setModel(listMetas);
        jLabel10.setText(usuario.getName()+" "+usuario.getLastname());
        jLabel11.setText(usuario.getKey()+" - "+usuario.getAddress());
        
        String strDate1 = DateFormat.getDateInstance().format(jDateChooser1.getDate());
        String[] fecha1 = strDate1.split("/");
        int[] date1 = new int[3];
        for (int h = 0; h < 3; h++) {
            date1[h] = Integer.parseInt(fecha1[h]);
        }
        Hoy = date1[0] + (date1[1] * 31) + (date1[2] * 365);
        
        inicio();
        
        this.setLocationRelativeTo(null);
        
        
        
        
        jLabel1.setText("SALDO"+"   "+"$"+(IngresosInt+EgresosInt));
        jLabel2.setText("DEUDA"+"   "+"$"+(Deuda));
        jLabel3.setText("COBRO"+"   "+"$"+(Cobro));
        
        //jInternalFrame3.setVisible(false);
        
        
        
        
        /*XYSeries oSeries = new XYSeries("Saldo");
            
            int ingreso7 = Ingresos.Pop().getAmount();
            int ingreso6 = Ingresos.Pop().getAmount();
            int ingreso5 = Ingresos.Pop().getAmount();
            int ingreso4 = Ingresos.Pop().getAmount();
            int ingreso3 = Ingresos.Pop().getAmount();
            int ingreso2 = Ingresos.Pop().getAmount();
            int ingreso1 = Ingresos.Pop().getAmount();
            
            int egreso1 = Egresos.Peek().getAmount();
            Egresos.Dequeue();
            int egreso2 = Egresos.Peek().getAmount();
            Egresos.Dequeue();
            int egreso3 = Egresos.Peek().getAmount();
            Egresos.Dequeue();
            int egreso4 = Egresos.Peek().getAmount();
            Egresos.Dequeue();
            int egreso5 = Egresos.Peek().getAmount();
            Egresos.Dequeue();
            int egreso6 = Egresos.Peek().getAmount();
            Egresos.Dequeue();
            int egreso7 = Egresos.Peek().getAmount();
            Egresos.Dequeue();
           
            int day1 = ingreso1-egreso1;
            int day2 = ingreso2-egreso2;
            int day3 = ingreso3-egreso3;
            int day4 = ingreso4-egreso4;
            int day5 = ingreso5-egreso5;
            int day6 = ingreso6-egreso6;
            int day7 = ingreso7-egreso7;
            
            oSeries.add(1,day1);
            oSeries.add(2,day2);
            oSeries.add(3,day3);
            oSeries.add(4,day4);
            oSeries.add(5,day5);
            oSeries.add(6,day6);
            oSeries.add(7,day7);
            
            XYSeriesCollection oDataset = new XYSeriesCollection();
            oDataset.addSeries(oSeries);
            
            JFreeChart oChart = ChartFactory.createXYLineChart("Resumen de la Semana", "Dia", "Cantidad", oDataset,PlotOrientation.VERTICAL,true,false,false);
            
            ChartPanel oPanel = new ChartPanel(oChart);
            jPanel1.setLayout(new java.awt.BorderLayout());
            jPanel1.add(oPanel);
            jPanel1.validate();*/
    }

    private Home() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        panel3 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(119, 244, 30));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel3.setText("Cobro ");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 220, 23));

        jLabel1.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel1.setText("Saldo");
        jLabel1.setToolTipText("");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 23));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel2.setText("Deuda");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 220, 23));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 230));

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad:");
        panel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 79, 22));

        jTextField1.setBorder(null);
        panel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, 30));

        jLabel8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel8.setText("Categoria:");
        panel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 79, -1));

        jTextField2.setBorder(null);
        panel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 150, 30));

        jDateChooser1.setBackground(new java.awt.Color(93, 194, 21));
        jDateChooser1.setForeground(new java.awt.Color(93, 194, 21));
        jDateChooser1.setDate(jCalendar1.getDate());
        panel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 181, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(53, 172, 67));
        jButton4.setText("Ingreso");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(240, 35, 45));
        jButton5.setText("Egreso");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 90, 30));

        jProgressBar3.setValue(77);
        jProgressBar3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel2.add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -60, 130, 31));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 0, 12)); // NOI18N
        jLabel5.setText("xxxxxxxxx");
        panel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -60, 93, 31));

        jSeparator1.setForeground(new java.awt.Color(1, 1, 1));
        panel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 150, 20));

        jSeparator3.setForeground(new java.awt.Color(1, 1, 1));
        panel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 82, 150, 20));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 270, 300));

        panel3.setBackground(new java.awt.Color(53, 172, 67));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setFont(new java.awt.Font("Decker", 0, 10)); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        panel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 409, 263));

        jButton2.setFont(new java.awt.Font("Decker", 0, 10)); // NOI18N
        jButton2.setText("Estadisticas");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 100, 20));

        jCalendar1.setFont(new java.awt.Font("Decker", 0, 10)); // NOI18N
        panel3.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 200, 110));

        jList1.setFont(new java.awt.Font("Decker", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        panel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 190, 150));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel4.setText("Metas");
        panel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 70, 50));

        jButton3.setFont(new java.awt.Font("Decker", 0, 10)); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 80, -1));

        jButton1.setFont(new java.awt.Font("Decker", 0, 10)); // NOI18N
        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 100, -1));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel6.setText("Nueva meta:");
        panel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel9.setText("Valor:");
        panel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jTextField3.setBackground(new java.awt.Color(53, 172, 67));
        jTextField3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        panel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 130, -1));

        jTextField4.setBackground(new java.awt.Color(53, 172, 67));
        jTextField4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jTextField4.setBorder(null);
        panel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 130, -1));

        jSeparator2.setBackground(new java.awt.Color(93, 194, 21));
        jSeparator2.setForeground(new java.awt.Color(1, 1, 1));
        panel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, 20));

        jSeparator4.setBackground(new java.awt.Color(93, 194, 21));
        jSeparator4.setForeground(new java.awt.Color(1, 1, 1));
        panel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 130, 20));

        jButton6.setFont(new java.awt.Font("Decker", 0, 10)); // NOI18N
        jButton6.setText("Completado");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 100, -1));

        jLabel10.setFont(new java.awt.Font("Decker", 0, 26)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Nombre");
        panel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 200, 40));

        jLabel11.setFont(new java.awt.Font("Decker", 0, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("usuario - correo@correo.com");
        jLabel11.setToolTipText("");
        panel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 200, 10));

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 760, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
            XYSeries oSeries = new XYSeries("Saldo");
            
            int ingreso7 = Integer.parseInt(Ingresos2.Pop().getAmount());
            int ingreso6 = Integer.parseInt(Ingresos2.Pop().getAmount());
            int ingreso5 = Integer.parseInt(Ingresos2.Pop().getAmount());
            int ingreso4 = Integer.parseInt(Ingresos2.Pop().getAmount());
            int ingreso3 = Integer.parseInt(Ingresos2.Pop().getAmount());
            int ingreso2 = Integer.parseInt(Ingresos2.Pop().getAmount());
            int ingreso1 = Integer.parseInt(Ingresos2.Pop().getAmount());
            
            int egreso1 = Integer.parseInt(Egresos2.Peek().getAmount());
            Egresos2.Dequeue();
            int egreso2 = Integer.parseInt(Egresos2.Peek().getAmount());
            Egresos2.Dequeue();
            int egreso3 = Integer.parseInt(Egresos2.Peek().getAmount());
            Egresos2.Dequeue();
            int egreso4 = Integer.parseInt(Egresos2.Peek().getAmount());
            Egresos2.Dequeue();
            int egreso5 = Integer.parseInt(Egresos2.Peek().getAmount());
            Egresos2.Dequeue();
            int egreso6 = Integer.parseInt(Egresos2.Peek().getAmount());
            Egresos2.Dequeue();
            int egreso7 = Integer.parseInt(Egresos2.Peek().getAmount());
            Egresos2.Dequeue();
           
            int day1 = ingreso1-egreso1;
            int day2 = ingreso2-egreso2;
            int day3 = ingreso3-egreso3;
            int day4 = ingreso4-egreso4;
            int day5 = ingreso5-egreso5;
            int day6 = ingreso6-egreso6;
            int day7 = ingreso7-egreso7;
            
            oSeries.add(1,day1);
            oSeries.add(2,day2);
            oSeries.add(3,day3);
            oSeries.add(4,day4);
            oSeries.add(5,day5);
            oSeries.add(6,day6);
            oSeries.add(7,day7);
            
            XYSeriesCollection oDataset = new XYSeriesCollection();
            oDataset.addSeries(oSeries);
            
            JFreeChart oChart = ChartFactory.createXYLineChart("Resumen de la Semana", "Dia", "Cantidad", oDataset,PlotOrientation.VERTICAL,true,false,false);
            
            ChartPanel oPanel = new ChartPanel(oChart);
            jPanel1.setLayout(new java.awt.BorderLayout());
            jPanel1.add(oPanel);
            jPanel1.validate();
        
    }//GEN-LAST:event_jButton2ActionPerformed
    private  void inicio() {
        
        try {
        Movimientos = ConexionBD.getData(usuario.getKey());
        } catch (Exception e) {}
        
        
        
        
        
                
        String dateNodoMin = Movimientos.peekMin().getFecha();
        String[] fechamin = dateNodoMin.split("/");
        int[] datemin = new int[3];
        for (int h = 0; h < 3; h++) {
            datemin[h] = Integer.parseInt(fechamin[h]);
        }
        int fechaMin = datemin[0] + (datemin[1] * 31) + (datemin[2] * 365);
        
        while (Movimientos.isEmpty() == false && fechaMin <= Hoy) {
            
            try {
                NodoDinero NodoX = Movimientos.extractMin();
                Movimientos.insert(NodoX);
            } catch (Exception e) {
                break;
            }
            NodoDinero NodoX = Movimientos.extractMin();
            
            if (Integer.parseInt(NodoX.getAmount()) > 0) {
                Ingresos.Push(NodoX);
                Ingresos2.Push(NodoX);
                
            } else {
                Egresos.Enqueue(NodoX);
                Egresos2.Enqueue(NodoX);
                
            }
            String dateNodoMin2 = Movimientos.peekMin().getFecha();
            String[] fechamin2 = dateNodoMin2.split("/");
            int[] datemin2 = new int[3];
            for (int h = 0; h < 3; h++) {
                datemin2[h] = Integer.parseInt(fechamin2[h]);
            }
            fechaMin = datemin2[0] + (datemin2[1] * 31) + (datemin2[2] * 365);
        }

        while (Movimientos.isEmpty()==false) {
            try {
                NodoDinero NodoX = Movimientos.extractMin();
                Movimientos.insert(NodoX);
            } catch (Exception e) {
                break;
            }
            NodoDinero NodoX = Movimientos.extractMin();

            if (Integer.parseInt(NodoX.getAmount()) > 0) {
                Cobro = Cobro + Integer.parseInt(NodoX.getAmount());
            } else {
                Deuda = Deuda + Integer.parseInt(NodoX.getAmount());
            }
        }
        
        
        Fila acEgr = Egresos;
        
        while (acEgr.Empty() == false) {
            EgresosInt = EgresosInt + Integer.parseInt(acEgr.Peek().getAmount());
            acEgr.Dequeue();

        }

        Pila acIng = Ingresos;
        
        while (acIng.Empty() == false) {
            IngresosInt = IngresosInt + Integer.parseInt(acIng.Pop().getAmount());

        }
        
        try {
        Metas = ConexionBD.getMetas(usuario.getKey());
        } catch (Exception e) {}
        
        while(Metas.Empty()==false){
            
            NodoMeta newMe = Metas.TopFront();
            
            String nMeta = newMe.getName()+"  $ "+newMe.getAmount();
            listMetas .addElement(nMeta);
            try{
            Metas.PopFront();}
            catch(Exception e){
            break;}
            
        }
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nMeta = jTextField3.getText()+"  $ "+jTextField4.getText();
        NodoMeta newM = new NodoMeta(jTextField4.getText(), jTextField3.getText());
        ConexionBD.nuevaMeta(usuario.getKey(), "metas", jTextField3.getText(),newM);
        
        listMetas .addElement(nMeta);
        jTextField3.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String strDate = DateFormat.getDateInstance().format(jDateChooser1.getDate());
        
        NodoDinero NewIn = new NodoDinero("-"+jTextField1.getText(),jTextField2.getText(),strDate);
        String[] fecha1 = strDate.split("/");
        int[] date1 = new int[3];
        for (int h = 0; h < 3; h++) {
            date1[h] = Integer.parseInt(fecha1[h]);
        }
        int fecha1Int = date1[0] + (date1[1] * 31) + (date1[2] * 365);
        if (Hoy >= fecha1Int) {
            Egresos.Enqueue(NewIn);
            EgresosInt = EgresosInt + Integer.parseInt("-"+jTextField1.getText());
            jLabel1.setText("SALDO" + "   " + "$" + (IngresosInt + EgresosInt));
        } else {
            Deuda = Deuda + Integer.parseInt("-"+jTextField1.getText());
            jLabel2.setText("DEUDA" + "   " + "$" + (Deuda));
        }
        String uuid = java.util.UUID.randomUUID().toString();
        ConexionBD.insertarDatos(usuario.getKey(),"movimientos",uuid,NewIn);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String strDate = DateFormat.getDateInstance().format(jDateChooser1.getDate());

        NodoDinero NewIn = new NodoDinero(jTextField1.getText(),jTextField2.getText(),strDate);
        String[] fecha1 = strDate.split("/");
        int[] date1 = new int[3];
        for (int h = 0; h < 3; h++) {
            date1[h] = Integer.parseInt(fecha1[h]);
        }
        int fecha1Int = date1[0] + (date1[1] * 31) + (date1[2] * 365);
        if (Hoy >= fecha1Int){
            Ingresos.Push(NewIn);
            IngresosInt=IngresosInt+Integer.parseInt(jTextField1.getText());
            jLabel1.setText("SALDO"+"   "+"$"+(IngresosInt+EgresosInt));
        }else{
            Cobro = Cobro+Integer.parseInt(jTextField1.getText());
            jLabel3.setText("COBRO"+"   "+"$"+(Cobro) );
        }
        

        String uuid = java.util.UUID.randomUUID().toString();
        ConexionBD.insertarDatos(usuario.getKey(),"movimientos",uuid,NewIn);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int delete = jList1.getSelectedIndex();
        String selected = jList1.getSelectedValue();
        
        String[] metdata = new String[2];
        metdata=selected.split("  ");
        
        ConexionBD.eliminarMeta(usuario.getKey(), "metas",metdata[0]);
        
        listMetas.remove(delete);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int delete = jList1.getSelectedIndex();
        String selected = jList1.getSelectedValue();
        
        String[] metdata = new String[2];
        metdata=selected.split("  ");
        
        ConexionBD.eliminarMeta(usuario.getKey(), "metas",metdata[0]);
        
        String[] valor = new String[2];
        valor=metdata[1].split(" ");
        System.out.println(valor[1]);
        
        String strDate = DateFormat.getDateInstance().format(jDateChooser1.getDate());
        
        NodoDinero NewIn = new NodoDinero("-"+valor[1],metdata[0],strDate);
        String[] fecha1 = strDate.split("/");
        int[] date1 = new int[3];
        for (int h = 0; h < 3; h++) {
            date1[h] = Integer.parseInt(fecha1[h]);
        }
        int fecha1Int = date1[0] + (date1[1] * 31) + (date1[2] * 365);
        if (Hoy >= fecha1Int) {
            Egresos.Enqueue(NewIn);
            EgresosInt = EgresosInt + Integer.parseInt("-"+valor[1]);
            jLabel1.setText("SALDO" + "   " + "$" + (IngresosInt + EgresosInt));
        } else {
            Deuda = Deuda + Integer.parseInt("-"+valor[1]);
            jLabel2.setText("DEUDA" + "   " + "$" + (Deuda));
        }
        String uuid = java.util.UUID.randomUUID().toString();
        ConexionBD.insertarDatos(usuario.getKey(),"movimientos",uuid,NewIn);
        
        
        listMetas.remove(delete);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    // End of variables declaration//GEN-END:variables
 

}
