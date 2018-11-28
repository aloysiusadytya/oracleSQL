/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model_RS.RumahSakit;

/**
 *
 * @author user only
 */
public class MyDokterDialog extends JDialog {

    private RumahSakit rs;
    private JTable table;
    private JButton tambahButton;
    private JButton simpanButton;
    
    public MyDokterDialog(Frame owner, boolean modal) {
        super(owner, modal);
        init();
    }

    /**
     * Fungsi untuk inisialisasi
     */
    public void init() {
        setSize(700, 500);
        // set Layout
        this.setLayout(new BorderLayout());
        // baca data rumah sakit
        rs = new RumahSakit("Panti Rapih", "Yogyakarta");
        rs.bacaDataDokter();
        // set JTable
        table = new JTable(new DokterTableModel(rs.getDaftarDokter()));
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane,BorderLayout.CENTER);
        // set tombol tambah dan simpan
        JPanel tombolPanel = new JPanel(new FlowLayout());
        // tombol untuk tambah dokter ke arrayList 
        // daftarDokter di kelas RumahSakit
        tambahButton = new JButton("Tambah Dokter");
        tombolPanel.add(tambahButton);
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahDokter();
            }
        });
        // tombol untuk simpan data arrayList Dokter ke basis data
        simpanButton = new JButton("Simpan Ke Database");
        tombolPanel.add(simpanButton);
        add(tombolPanel,BorderLayout.NORTH);
        // set visible
        setVisible(true);
    }
    /**
     * Fungsi untuk memanggil dialog tambah Dokter
     */
    public void tambahDokter(){
        TambahDokterDialog tambahDokter = new TambahDokterDialog(this, rs);
        tambahDokter.setVisible(true);
    }
    /**
     * Fungsi untuk merefresh isi tabel dokter
     */
    public void refreshTabelDokter(){
        // update table model
    }

}
