/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import java.io.IOException;
import javax.swing.JFileChooser;
import cern.colt.matrix.linalg.SingularValueDecomposition;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author WIN8
 */
public class MainFrame extends javax.swing.JFrame {

    private Weight bobot;
    private final MatrixOperator matrixGen;
    private PopupController popup;
    private Centroid popupPusat;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.setTitle("Text Clustering");
        this.setLocationRelativeTo(null);
        matrixGen =  new MatrixOperator();
        popupPusat = new Centroid();
        popup = new PopupController();
        radioButtonKMeans.setEnabled(false);
        radioButtonKMeansSVD.setEnabled(false);
        radioButtonFuzzy.setEnabled(false);
        radioButtonFuzzySVD.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCluster = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        buttonMuatDokumen = new javax.swing.JButton();
        textFieldPathDokumen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        radioButtonKMeans = new javax.swing.JRadioButton();
        radioButtonKMeansSVD = new javax.swing.JRadioButton();
        radioButtonFuzzy = new javax.swing.JRadioButton();
        radioButtonFuzzySVD = new javax.swing.JRadioButton();
        buttonCluster = new javax.swing.JButton();
        textFieldK = new javax.swing.JTextField();
        labelK = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCluster = new javax.swing.JTable();
        labelClusterMethod = new javax.swing.JLabel();
        textfieldDokumen = new javax.swing.JTextField();
        labelTerm = new javax.swing.JLabel();
        labelDokumen = new javax.swing.JLabel();
        textfieldTerm = new javax.swing.JTextField();
        labelWaktu = new javax.swing.JLabel();
        waktuEksekusi = new javax.swing.JLabel();
        labelIterasi = new javax.swing.JLabel();
        iterasi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program TA Novita");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonMuatDokumen.setText("Muat");
        buttonMuatDokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMuatDokumenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonMuatDokumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldPathDokumen, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonMuatDokumen)
                    .addComponent(textFieldPathDokumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroupCluster.add(radioButtonKMeans);
        radioButtonKMeans.setText("K-Means");
        radioButtonKMeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonKMeansActionPerformed(evt);
            }
        });

        buttonGroupCluster.add(radioButtonKMeansSVD);
        radioButtonKMeansSVD.setText("K-Means + SVD");

        buttonGroupCluster.add(radioButtonFuzzy);
        radioButtonFuzzy.setText("Fuzzy C Means");

        buttonGroupCluster.add(radioButtonFuzzySVD);
        radioButtonFuzzySVD.setText("Fuzzy C Means + SVD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonKMeans)
                    .addComponent(radioButtonKMeansSVD)
                    .addComponent(radioButtonFuzzy)
                    .addComponent(radioButtonFuzzySVD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(radioButtonKMeans)
                .addGap(18, 18, 18)
                .addComponent(radioButtonKMeansSVD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(radioButtonFuzzy)
                .addGap(18, 18, 18)
                .addComponent(radioButtonFuzzySVD)
                .addContainerGap())
        );

        buttonCluster.setText("Mulai");
        buttonCluster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClusterActionPerformed(evt);
            }
        });

        labelK.setText("Jumlah Cluster (k):");

        tableCluster.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableCluster);

        labelClusterMethod.setText("Cluster Method:");

        textfieldDokumen.setEditable(false);

        labelTerm.setText("Jumlah Term:");

        labelDokumen.setText("Jumlah Dokumen:");

        textfieldTerm.setEditable(false);

        labelWaktu.setText("Waktu Eksekusi:");

        labelIterasi.setText("Iterasi:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelClusterMethod)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelK)
                                        .addGap(36, 36, 36)
                                        .addComponent(textFieldK, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonCluster, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelTerm)
                                            .addComponent(textfieldTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textfieldDokumen)
                                            .addComponent(labelDokumen))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(labelIterasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iterasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelWaktu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(waktuEksekusi)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(labelClusterMethod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTerm)
                            .addComponent(labelDokumen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfieldDokumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelWaktu)
                            .addComponent(waktuEksekusi)
                            .addComponent(labelIterasi)
                            .addComponent(iterasi))
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelK))
                        .addGap(18, 18, 18)
                        .addComponent(buttonCluster)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMuatDokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMuatDokumenActionPerformed
        // TODO add your handling code here:
//        textFieldPathDokumen.setText("");
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select Folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                String selectedFolder = chooser.getSelectedFile().toString();
                textFieldPathDokumen.setText(selectedFolder);
                System.out.println("getSelectedFile() : " + selectedFolder); 
                
                bobot = new Weight(selectedFolder);
                bobot.doPembobotan();

                if(bobot.getListDocument().isEmpty()){
                    JOptionPane.showMessageDialog(null,"isEmpty",
                            "Gagal Muat", JOptionPane.ERROR_MESSAGE);
                }else{
                    textfieldTerm.setText(String.valueOf(bobot.getGlobalTermList().getTotalTerm()));
                    textfieldDokumen.setText(String.valueOf(bobot.getListDocument().size()));
                    radioButtonKMeans.setEnabled(true);
                    radioButtonKMeansSVD.setEnabled(true);
                    radioButtonFuzzy.setEnabled(true);
                    radioButtonFuzzySVD.setEnabled(true);
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null," CATCH : File di dalam folder terpilih tidak dapat diproses", 
                        "Gagal Muat", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            System.out.println("Gagal Muat");
        }
    }//GEN-LAST:event_buttonMuatDokumenActionPerformed

    private void buttonClusterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClusterActionPerformed
        // TODO add your handling code here:
        if(textFieldK.getText().isEmpty() || Integer.valueOf(textFieldK.getText()) < 1){
            JOptionPane.showMessageDialog(null,"Nilai K tidak boleh kosong atau nol", 
                    "Gagal", JOptionPane.ERROR_MESSAGE);
        }else if(Integer.valueOf(textFieldK.getText()) >= bobot.getListDocument().size()){
            JOptionPane.showMessageDialog(null,"Nilai K tidak boleh sama atau lebih dari jumlah dokumen", 
                    "Gagal", JOptionPane.ERROR_MESSAGE);
        }else{
             if(radioButtonKMeans.isSelected()){

                System.out.println("\n--------------KMeans------------------------\n");
                DoubleMatrix2D data = new DenseDoubleMatrix2D(matrixGen.transpose(bobot.getHasilPembobotan()));
                KMeans kmeans = new KMeans(data, Integer.valueOf(textFieldK.getText()));
                kmeans.cluster();
                System.out.println(kmeans.getPartition());
                populateTable(kmeans.getPartition());
                popup.showPusatCluster(kmeans.getMeans());
                waktuEksekusi.setText(String.valueOf(kmeans.getExecTime()) + " s");
                iterasi.setText(String.valueOf(kmeans.getTotalIterations()));

            }else if(radioButtonKMeansSVD.isSelected()){

                System.out.println("\n--------------KMeans + SVD------------------------\n");
                DoubleMatrix2D data = new DenseDoubleMatrix2D(bobot.getHasilPembobotan());
                SingularValueDecomposition svd = new SingularValueDecomposition(data);
                System.out.println("U:\n");
                System.out.println(svd.getU() + "\n");
                System.out.println("S:\n");
                System.out.println(svd.getS() + "\n");
                System.out.println("Vt:\n");
                System.out.println(svd.getV().viewDice() + "\n");
                System.out.println("U*S:");
                double[][] US = matrixGen.multiply(svd.getU(), svd.getS());
                System.out.println("S*V:");
                double[][] SV = matrixGen.multiply(svd.getS(), svd.getV().viewDice());
                System.out.println("\n");
                System.out.println("Do SVD");
                DimensionReduction reduksi = new DimensionReduction(bobot.getGlobalTermList(), bobot.getListDocument(), US);
                reduksi.doReduksiDimensi();

                DoubleMatrix2D reducedMatrix = new DenseDoubleMatrix2D(reduksi.getReducedMatrix());
                DoubleMatrix2D transposedSV = new DenseDoubleMatrix2D(matrixGen.transpose(SV));
                KMeans kmeans = new KMeans(reducedMatrix, transposedSV, Integer.valueOf(textFieldK.getText()));
                kmeans.cluster();
                System.out.println(kmeans.getPartition());
                populateTable(kmeans.getPartition());
                popup.showPusatCluster(kmeans.getMeans());
                waktuEksekusi.setText(String.valueOf(kmeans.getExecTime()) + " s");
                iterasi.setText(String.valueOf(kmeans.getTotalIterations()));

            }else if(radioButtonFuzzy.isSelected()){

                System.out.println("\n--------------Fuzzy C Means------------------------\n");
                DoubleMatrix2D data = new DenseDoubleMatrix2D(matrixGen.transpose(bobot.getHasilPembobotan()));
                FuzzyCMeans fuzzycmeans = new FuzzyCMeans(data, Integer.valueOf(textFieldK.getText()));
                fuzzycmeans.cluster();
                System.out.println(fuzzycmeans.getPartition());
                populateTable(fuzzycmeans.getPartition());
                popup.showPusatCluster(fuzzycmeans.getMeans());
                waktuEksekusi.setText(String.valueOf(fuzzycmeans.getExecTime()) + " s");
                iterasi.setText(String.valueOf(fuzzycmeans.getTotalIterations()));

            }else if(radioButtonFuzzySVD.isSelected()){

                System.out.println("\n--------------Fuzzy C Means + SVD------------------------\n");
                DoubleMatrix2D data = new DenseDoubleMatrix2D(bobot.getHasilPembobotan());
                SingularValueDecomposition svd = new SingularValueDecomposition(data);
                System.out.println("U:\n");
                System.out.println(svd.getU() + "\n");
                System.out.println("S:\n");
                System.out.println(svd.getS() + "\n");
                System.out.println("Vt:\n");
                System.out.println(svd.getV().viewDice() + "\n");
                System.out.println("U*S:");
                double[][] US = matrixGen.multiply(svd.getU(), svd.getS());
                System.out.println("S*V:");
                double[][] SV = matrixGen.multiply(svd.getS(), svd.getV().viewDice());
                System.out.println("\n");
                System.out.println("Do SVD");
                DimensionReduction reduksi = new DimensionReduction(bobot.getGlobalTermList(), bobot.getListDocument(), US);
                reduksi.doReduksiDimensi();

                DoubleMatrix2D reducedMatrix = new DenseDoubleMatrix2D(reduksi.getReducedMatrix());
                DoubleMatrix2D transposedSV = new DenseDoubleMatrix2D(matrixGen.transpose(SV));
                FuzzyCMeans fuzzycmeans = new FuzzyCMeans(reducedMatrix, transposedSV, Integer.valueOf(textFieldK.getText()));
                fuzzycmeans.cluster();
                System.out.println(fuzzycmeans.getPartition());
                populateTable(fuzzycmeans.getPartition());
                popup.showPusatCluster(fuzzycmeans.getMeans());
                waktuEksekusi.setText(String.valueOf(fuzzycmeans.getExecTime()) + " s");
                iterasi.setText(String.valueOf(fuzzycmeans.getTotalIterations()));

            }
        }
    }//GEN-LAST:event_buttonClusterActionPerformed

    private void radioButtonKMeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonKMeansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonKMeansActionPerformed

    void populateTable(DoubleMatrix2D hasilClustering){
        DefaultTableModel tabelModel = new DefaultTableModel(hasilClustering.rows(), hasilClustering.columns());
        for(int i=0; i<hasilClustering.rows(); i++){
            double max = Integer.MIN_VALUE;
            int idx = 0;
            for(int j=0; j<hasilClustering.columns(); j++){
//                  tabelModel.setValueAt(hasilClustering.get(i, j), i, j);
                if(hasilClustering.get(i, j) > max){
                     max = hasilClustering.get(i, j);
                     idx = j;
                }         
            }
            tabelModel.setValueAt(bobot.getListDocument().get(i).getJudul(), i, idx);
        } 
        
        tableCluster.setModel(tabelModel);

    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCluster;
    private javax.swing.ButtonGroup buttonGroupCluster;
    private javax.swing.JButton buttonMuatDokumen;
    private javax.swing.JLabel iterasi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelClusterMethod;
    private javax.swing.JLabel labelDokumen;
    private javax.swing.JLabel labelIterasi;
    private javax.swing.JLabel labelK;
    private javax.swing.JLabel labelTerm;
    private javax.swing.JLabel labelWaktu;
    private javax.swing.JRadioButton radioButtonFuzzy;
    private javax.swing.JRadioButton radioButtonFuzzySVD;
    private javax.swing.JRadioButton radioButtonKMeans;
    private javax.swing.JRadioButton radioButtonKMeansSVD;
    private javax.swing.JTable tableCluster;
    private javax.swing.JTextField textFieldK;
    private javax.swing.JTextField textFieldPathDokumen;
    private javax.swing.JTextField textfieldDokumen;
    private javax.swing.JTextField textfieldTerm;
    private javax.swing.JLabel waktuEksekusi;
    // End of variables declaration//GEN-END:variables
}
