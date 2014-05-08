package Presentacion;

import Entidades.Cliente;
import Logica.ClienteBD;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfazDB extends JFrame {

    private final JPanel panelPrincipal;
    private final JLabel eti1, eti2, eti3, eti4, eti5, eti6, eti7, eti8, eti9;
    private final ImageIcon imagenB, icon2, icon3, icon4, icon5, icon6, icon7;
    private final JTextField campo1, camp2, camp3, camp4, camp5, camp6;
    private final JButton btn1, btn2, btn3, btn4, btn5;
    private final JLabel resultado1, resul2;

    public InterfazDB() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelPrincipal.setLayout(null);
        setContentPane(panelPrincipal);
        setTitle("Banco Feliz de M\u00e9xico");

        imagenB = new ImageIcon(getClass().getResource("banco_1.jpg"));

        String txt1 = "<html><body><font size=5>"
                + "Base de datos Banco Feliz de M\u00e9xico</font></body></html>";
        eti1 = new JLabel(txt1);
        eti1.setBounds(10, 10, 600, 240);
        eti1.setForeground(new Color(0x2F00FF));
        eti1.setVerticalTextPosition(SwingConstants.TOP);
        eti1.setIcon(imagenB);
        panelPrincipal.add(eti1);
        String texto = "<html><body><br><br><font size=4>Bienvenido</font><br>"
                + "Ingresa correctamente los datos en los campos"
                + "<br><br>Buscar cliente por nombre: <br></body></html>";
        eti2 = new JLabel(texto);
        eti2.setBounds(264, 50, 500, 30);
        panelPrincipal.add(eti2);

        campo1 = new JTextField();
        campo1.setBounds(400, 320, 240, 20);
        panelPrincipal.add(campo1);

        icon2 = new ImageIcon(getClass().getResource("ic_action_search.png"));
        btn1 = new JButton("Buscar", icon2);
        btn1.setBackground(new Color(0x4A94DF));
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(new Actionbuscar());//Metodo que activa funciones del boton 
        btn1.setBounds(650, 305, 120, 50);
        panelPrincipal.add(btn1);

        icon3 = new ImageIcon(getClass().getResource("ic_action_add_person.png"));
        eti3 = new JLabel("Agregar un cliente");
        eti3.setIcon(icon3);
        eti3.setForeground(Color.red);
        eti3.setBounds(10, 250, 200, 50);
        panelPrincipal.add(eti3);

        eti4 = new JLabel("Agregar o consultar nombre del cliente:");
        eti4.setBounds(10, 300, 230, 20);
        panelPrincipal.add(eti4);

        camp2 = new JTextField();
        camp2.setBounds(10, 320, 240, 20);
        panelPrincipal.add(camp2);

        eti5 = new JLabel("Agregar direcci\u00f3n:");
        eti5.setBounds(10, 350, 150, 20);
        panelPrincipal.add(eti5);

        camp3 = new JTextField();
        camp3.setBounds(10, 370, 240, 20);
        panelPrincipal.add(camp3);

        eti6 = new JLabel("Telefono:");
        eti6.setBounds(10, 400, 70, 20);
        panelPrincipal.add(eti6);

        camp4 = new JTextField();
        camp4.setBounds(10, 420, 240, 20);
        panelPrincipal.add(camp4);

        eti7 = new JLabel("Prestamo solicitado:");
        eti7.setBounds(10, 450, 130, 20);
        panelPrincipal.add(eti7);

        camp5 = new JTextField();
        camp5.setBounds(10, 470, 240, 20);
        panelPrincipal.add(camp5);

        eti8 = new JLabel("Fue atendido por: ");
        eti8.setBounds(10, 500, 130, 20);
        panelPrincipal.add(eti8);

        camp6 = new JTextField();
        camp6.setBounds(10, 520, 240, 20);
        panelPrincipal.add(camp6);

        resultado1 = new JLabel("<html><body>Busca primero el cliente para saber si existe,"
                + "<br>si es asi podras editar todos los campos del cliente,<br> llenando nuevamente. "
                + "<br>Para consultar solo agrega el nombre del cliente."
                + "<br>Para eliminar, inserta el nombre en el campo cliente.</body></html>");
        resultado1.setBounds(264, 40, 400, 200);
        panelPrincipal.add(resultado1);

        icon4 = new ImageIcon(getClass().getResource("ic_action_accept.png"));
        btn2 = new JButton("Alta", icon4);
        btn2.setBounds(264, 305, 120, 50);
        btn2.setBackground(new Color(0x49FF00));
        btn2.addActionListener(new InsertarD());

        panelPrincipal.add(btn2);

        icon5 = new ImageIcon(getClass().getResource("ic_action_discard.png"));
        btn3 = new JButton("Baja", icon5);
        btn3.setBackground(new Color(0xF34E7A));
        btn3.addActionListener(new Eliminar());
        btn3.setBounds(264, 365, 120, 50);
        panelPrincipal.add(btn3);

        icon6 = new ImageIcon(getClass().getResource("ic_action_import_export.png"));
        btn4 = new JButton("Consulta", icon6);
        btn4.setBackground(new Color(0xFFEB6A));
        btn4.addActionListener(new Consultar());
        btn4.setBounds(264, 425, 120, 50);
        panelPrincipal.add(btn4);

        icon7 = new ImageIcon(getClass().getResource("ic_action_edit.png"));
        btn5 = new JButton("Editar", icon7);
        btn5.setBackground(new Color(0x77F8C6));
        btn5.addActionListener(new Actualizar());
        btn5.setBounds(264, 485, 120, 50);
        panelPrincipal.add(btn5);

        resul2 = new JLabel("");
        resul2.setBounds(264, 120, 250, 20);
        panelPrincipal.add(resul2);

        eti9 = new JLabel("Rsultado de consulta");
        eti9.setBounds(400, 350, 500, 100);
        panelPrincipal.add(eti9);

    }
    Cliente Bcliente;

    private class Actionbuscar implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            ComparaC();            
            String codigo = campo1.getText();
            Bcliente = cliente.Bcliente(codigo);
            if (Bcliente != null) {
                JOptionPane.showMessageDialog(null, "El cliente si existe!\nEditalo!", "Informaci\u00f3n", JOptionPane.INFORMATION_MESSAGE);
                campo1.setText("");
            } else {
                resultado1.setText("No existe cliente");
            }
        }
    }

    private class InsertarD implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            CompararD();
            String nombre = camp2.getText();
            String dir = camp3.getText();
            String tel = camp4.getText();
            int pres = Integer.parseInt(camp5.getText());
            String emple = camp6.getText();
            if (cliente.Insertar(nombre, dir, tel, pres, emple)) {
                JOptionPane.showMessageDialog(null, "Se agrego un cliente", "Informaci\u00f3n", JOptionPane.INFORMATION_MESSAGE);
                camp2.setText("");
                camp3.setText("");
                camp4.setText("");
                camp5.setText("");
                camp6.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar\nInresa correctamente todo de nuevo", "Informaci\u00f3n", JOptionPane.WARNING_MESSAGE);

            }

        }
    }

    private class Eliminar implements ActionListener {

        public void actionPerformed(ActionEvent e) {            
            String nombre = camp2.getText();
            if (cliente.Eliminar(nombre)) {
                JOptionPane.showMessageDialog(null, "ELIMINADO", "Alerta", JOptionPane.WARNING_MESSAGE);
                camp2.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ELIMINO", "Alerta", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    private class Actualizar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            CompararD();

            if (Bcliente != null) {
                Bcliente.setNombreCliente(camp2.getText());
                Bcliente.setDireccion(camp3.getText());
                Bcliente.setTel(camp4.getText());
                Bcliente.setPrestamo(Integer.parseInt(camp5.getText()));
                Bcliente.setNombreEmple(camp6.getText());
                if (cliente.Actualizar(Bcliente)) {
                    JOptionPane.showMessageDialog(null, "Actualizado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
                    camp2.setText("");
                    camp3.setText("");
                    camp4.setText("");
                    camp5.setText("");
                    camp6.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Alerta", JOptionPane.INFORMATION_MESSAGE);

                }
            }

        }
    }

    private class Consultar implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            
            String codigo = camp2.getText();
            Bcliente = cliente.Bcliente(codigo);
            if (Bcliente != null) {
                eti9.setText("<html><body> El nombre del cliente es: "+Bcliente.getNombreCliente()+"<br>"+"El telefono del cliente es: "+Bcliente.getTel()+
                        "<br>Su direcci\u00f3n es: "+Bcliente.getDireccion()+
                        "<br>El prestamo fue de: "+Bcliente.getPrestamo()+
                        "<br>Fue atendido por: "+Bcliente.getNombreEmple()+"</body></html>");
                camp2.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el cliente", "Alerta", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    public void CompararD() {
        if (camp2.getText().trim().isEmpty() || camp3.getText().trim().isEmpty() || camp4.getText().trim().isEmpty()
                || camp5.getText().trim().isEmpty() || camp6.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Te falta llenar algun campo", "Informaci\u00f3n", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ComparaB() {
        if (camp2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llena el campo por favor!", "Informaci\u00f3n", JOptionPane.WARNING_MESSAGE);

        }
    }

    public void ComparaC() {
        if (campo1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llena el campo por favor!", "Informaci\u00f3n", JOptionPane.WARNING_MESSAGE);

        }
    }
    ClienteBD cliente = new ClienteBD();
}