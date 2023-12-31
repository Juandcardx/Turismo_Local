
import javax.swing.JFrame;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    //----------------------
    //Atributos
    //----------------------
    public PanelEntradaDatos miPanelEntradaDatos;
    public PanelOperaciones miPanelOperaciones;
    public PanelResultados miPanelResultado;
    public DialogoTabla miDialogoTabla;
    public DialogoTablaRestaurante miDialogoTablaRestaurante;
    public DialogoTablaExploracion miDialogoTablaExploracion;
    public DialogoTablaTurismo miDialogoTablaTurismo;

    //-------------------------
    //Métodos
    //-------------------------
    
    //Metodo constructor
    public VentanaPrincipal()
    {
        //Definición del contenedor de la ventana
        setLayout(null);

        miPanelEntradaDatos = new PanelEntradaDatos();
        miPanelEntradaDatos.setBounds(10, 10, 780, 200);
        this.add(miPanelEntradaDatos);
       

        //Creación y adición del PanelOperaciones
        miPanelOperaciones = new PanelOperaciones();
        miPanelOperaciones.setBounds(410,240,380,240);
        this.add(miPanelOperaciones);
        
        //Creación y adición del PanelOperaciones
        miPanelResultado = new PanelResultados();
        miPanelResultado.setBounds(10,240,385,240);
        this.add(miPanelResultado);
        
        
        //Caracteristicas de la ventana
        setTitle("Turismo Local");
        setSize(820,520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        this.getContentPane().setBackground(Color.decode("#483838"));
    }

    public void cerrarVenPrincipal()
    {
        this.dispose();
    }

    public void crearDialogoTabla()
    {
        miDialogoTabla = new DialogoTabla();
    }

    public void crearDialogoTablaRestaurante()
    {
        miDialogoTablaRestaurante = new DialogoTablaRestaurante();
    }

    public void crearDialogoTablaExploracion()
    {
        miDialogoTablaExploracion = new DialogoTablaExploracion();
    }

    public void crearDialogoTablaTurismo()
    {
        miDialogoTablaTurismo = new DialogoTablaTurismo();
    }
}