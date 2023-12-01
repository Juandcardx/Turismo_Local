public class Evento //Se crea la clase evento 
{
    private int numGrupo;
    private String nombreSitio;
    private String fechaApertura;
    private String tipoEvento;
// Constructor con número de grupo, nombre del sitio, fecha de apertura y tipo de evento
    public Evento(int numGrupo, String nombreSitio, String fechaApertura, String tipoEvento) 
    {
        this.numGrupo = numGrupo;
        this.nombreSitio = nombreSitio;
        this.fechaApertura = fechaApertura;
        this.tipoEvento = tipoEvento;
    }
// Métodos getter y setter para el número de grupo
    public int getNumGrupo() 
    {
        return numGrupo;
    }
    public String getNombreSitio() 
    {
        return nombreSitio;
    }
    public String getFechaApertura() 
    {
        return fechaApertura;
    }
    public void setNumGrupo(int numGrupo) 
    {
        this.numGrupo = numGrupo;
    }
    public void setNombreSitio(String nombreSitio) 
    {
        this.nombreSitio = nombreSitio;
    }
    public void setFechaApertura(String fechaApertura) 
    {
        this.fechaApertura = fechaApertura;
    }
    // Método getter para el tipo de evento
    public String getTipoEvento() 
    {
        return tipoEvento;
    }
    // Método setter para el tipo de evento
    public void setTipoEvento(String tipoEvento) 
    {
        this.tipoEvento = tipoEvento;
    }
    // Método toString para obtener una representación en cadena de la instancia
    public String toString()
    {
        return "Se asistira a: " + getNombreSitio() + "\nTipo evento: " + getTipoEvento() + "\nNumero de personas que asistiran: " + getNumGrupo() + "\nFecha en la que se llevara a cabo el evento: " + getFechaApertura();
    }
}
