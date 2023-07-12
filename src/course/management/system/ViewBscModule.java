package course.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class ViewBscModule extends JFrame{

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        new ViewBscModule().setVisible(true);
    }

    public void bscmodule() {
        try {
            connect con = new connect();
            String sql = "select * from bscmodule";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    public ViewBscModule() {
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 288);
        scrollPane.setBackground(new Color(43, 128, 168));
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
            }
        });
        table.setBackground(new Color(204, 204, 255));
        table.setForeground(Color.BLACK);
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        scrollPane.setViewportView(table);

        JLabel l1 = new JLabel("BscIT Module Details");
        l1.setForeground(new Color(0, 0, 0));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 26));
        l1.setBounds(250, 20, 400, 47);
        contentPane.add(l1);

        JLabel l2 = new JLabel("<--");
        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                BscModule home = new BscModule();
                home.setVisible(true);
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        l2.setBounds(97, 89, 72, 33);
        contentPane.add(l2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "BscIT Modules",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(68, 59, 790, 370);
        panel.setBackground(new Color(204, 204, 255));
        contentPane.add(panel);

        bscmodule();
    }
}
