import javax.swing.JOptionPane;

public class Grupo extends Evento  // Se define la clase Grupo que hereda de Evento
{
    private static int numPersonas;
    private String nomGrupo;
    private String gustos;
    private static String horaReunion;    
    private String tipoActividad;

    // Constructor con tipo de actividad, gustos, nombre del grupo y hora de reunión
    public Grupo(String ptipoActividad, String pGustos, String pNomGrupo, String pHoraReunion)
    {
        super(numPersonas, pNomGrupo, pHoraReunion, ptipoActividad);
        this.gustos = pGustos;
        Grupo.horaReunion = pHoraReunion;
        this.nomGrupo = pNomGrupo;
        this.tipoActividad = ptipoActividad;
    }
// Constructor con tipo de actividad, gustos y nombre del grupo
    public Grupo(String ptipoActividad, String pGustos, String pNomGrupo)
    {
        super(numPersonas, pNomGrupo, horaReunion, pGustos);
        this.gustos = pGustos;
        this.nomGrupo = pNomGrupo;
        this.tipoActividad = ptipoActividad;
        
    }
// Métodos getter y setter para la hora de reunión
    public String getHoraReunion() 
    {
        return horaReunion;
    }
    public void setHoraReunion(String horaReunion) 
    {
        Grupo.horaReunion = horaReunion;
    }
    // Métodos getter y setter para el nombre del grupo
    public String getNomGrupo() 
    {
        return nomGrupo;
    }
    public void setNomGrupo(String nomGrupo) 
    {
        this.nomGrupo = nomGrupo;
    }
    // Métodos getter y setter para el número de personas
    public static int getNumPersonas() 
    {
        return numPersonas;
    }
    public static void setNumPersonas(int numPersonas) 
    {
        Grupo.numPersonas = numPersonas;
    }
    // Métodos getter y setter para los gustos
    public String getGustos() 
    {
        return gustos;
    }
    public void setGustos(String gustos) 
    {
        this.gustos = gustos;
    }
    // Métodos getter y setter para el tipo de actividad
    public String gettipoActividad()
    {
        return this.tipoActividad;
    }
    public void settipoActividad(String ptipoActividad)
    {
        this.tipoActividad = ptipoActividad;
    }
// Método para calcular grupos según el número de personas
    public void calcularGrupos(int numPersonas)
    {
        int numGrupos = (numPersonas/5);
        int sobrantes = numPersonas % 5;
        if (sobrantes == 0) 
        {
            int grupoSobrante = numGrupos + 1;
            JOptionPane.showMessageDialog(null, "Numero grupo incompleto: " + grupoSobrante, "Grupo faltante", JOptionPane.OK_CANCEL_OPTION);
        }
        int posicionGrupo = (int)(Math.random() * numGrupos) + 1;
        JOptionPane.showMessageDialog(null, "Numero de grupos totales con 5 personas: " + numGrupos + "\nA usted se le asigno el grupo: " + posicionGrupo, "Evento registrado", JOptionPane.OK_CANCEL_OPTION);
    }
}
