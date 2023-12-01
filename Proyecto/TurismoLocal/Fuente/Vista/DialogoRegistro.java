import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Se define la clase DialogoRegistro que hereda de JDialog
public class DialogoRegistro extends JDialog
{
    private JLabel lbTitulo;
    private JLabel lbUsuario;
    private JLabel lbContraseña;
    private JTextField txUsuario;
    private JTextField txContraseña;
    private JButton btAceptar;

    // Constructor de la clase
    public DialogoRegistro()
    {
        setLayout(null);

        lbTitulo = new JLabel("Registro Usuario", JLabel.CENTER);
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        lbTitulo.setBounds(60,20,280,30);
        add(lbTitulo);

        lbUsuario = new JLabel("Usuario = ", JLabel.CENTER);
        lbUsuario.setFont(new Font("Arial", Font.BOLD, 25));
        lbUsuario.setBounds(35,140,200,20);
        add(lbUsuario);

        lbContraseña = new JLabel("Contraseña = ", JLabel.CENTER);
        lbContraseña.setFont(new Font("Arial", Font.BOLD, 25));
        lbContraseña.setBounds(10,170,200,20);
        add(lbContraseña);

        txUsuario= new JTextField();
        txUsuario.setFont(new Font("Arial", Font.BOLD, 15));
        txUsuario.setBounds(200,140,100,25);
        add(txUsuario);
        
        txContraseña= new JTextField();
        txContraseña.setFont(new Font("Arial", Font.BOLD, 15));
        txContraseña.setBounds(200,170,100,25);
        add(txContraseña);

        btAceptar = new JButton("Aceptar");
        btAceptar.setFont(new Font("Arial", Font.BOLD, 25));
        btAceptar.setBounds(60,250,260,25);
        btAceptar.setActionCommand("aceptar");
        add(btAceptar);

        setTitle("Crear Usuario y Contraseña");
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBackground(Color.decode("#D2D79F"));
    }
// Método para obtener el texto del campo de usuario
    public String getUsuario() 
    {
        return txUsuario.getText();
    }
// Método para obtener el texto del campo de contraseña
    public String getContraseña() 
    {
        return txContraseña.getText();
    }
// Método para agregar oyentes a los botones
    public void agregarOyentesBotones(ActionListener pAL)
    {
        btAceptar.addActionListener(pAL);
    }
// Método para cerrar el diálogo
    public void cerrarDialogo()
    {
        this.dispose();
    }  
}
