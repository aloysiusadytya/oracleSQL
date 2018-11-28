/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model_RS.Dokter;
import model_RS.RumahSakit;

/**
 *
 * @author user only
 */
public class TambahDokterDialog extends JDialog{
    private RumahSakit rumahSakit;
    private JLabel tambahDokterLabel;
    private JLabel idDokterLabel;
    private JTextField idDokterText;
    private JLabel namaDokterLabel;
    private JTextField namaDokterText;
    private JButton tambahButton;
    private MyDokterDialog owner;
    
    public TambahDokterDialog(MyDokterDialog owner, RumahSakit rs) {
        super(owner);
        this.owner = owner;
        rumahSakit = rs;
        init();
    }
    
    /**
     * Fungsi untuk inisialisasi
     */
    public void init(){
        // set size
        setSize(400, 300);
        // set layout
        setLayout(null);
        // tambah Tombol Tambah
        
       
        tambahButton = new JButton("Tambah");
        tambahButton.setBounds(50, 200, 100, 30);
        add(tambahButton);
        
        namaDokterLabel = new JLabel("Nama");
        namaDokterText = new JTextField();
        namaDokterLabel.setBounds(30, 40, 100, 30);
        namaDokterText.setBounds(90,40, 100, 30);
        add(namaDokterLabel);
        add(namaDokterText);
        
        idDokterLabel = new JLabel("ID Dokter");
        idDokterText = new JTextField();
        idDokterLabel.setBounds(30, 100, 100, 30);
        idDokterText.setBounds(90, 100, 100, 30);
        add(idDokterLabel);
        add(idDokterText);
        
        // set action listener button
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahDokter();
            }
        });
    }
    public void tambahDokter(){
        Dokter dr1 = new Dokter(idDokterText.getText(), namaDokterText.getText());
        rumahSakit.tambahDokter(dr1);
        owner.refreshTabelDokter();
        dispose();
    }
}
