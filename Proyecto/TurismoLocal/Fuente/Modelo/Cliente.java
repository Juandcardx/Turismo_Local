import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Cliente // Se define la clase cliente 
{
    private int presupuesto;
    private String gusto;
    private String nombreCliente;
    private String fechaSalida;

    public Cliente(String pFechaSalida, String pnombreCliente, int pPresupuesto, String pGusto)
    {
        this.nombreCliente = pnombreCliente;
        this.presupuesto = pPresupuesto;
        this.fechaSalida = pFechaSalida;
        this.gusto = pGusto;
    }

    public Cliente(String pnombreCliente, int pPresupuesto, String pGusto) // Constructor con fecha de salida, nombre, presupuesto y gusto
    {
        this.nombreCliente = pnombreCliente;
        this.presupuesto = pPresupuesto;
        this.gusto = pGusto;
    }
// Métodos getter y setter para presupuesto
    public int getPresupuesto()
    {
        return this.presupuesto;
    }

    public void setPresupuesto(int pPresupuesto)
    {
        this.presupuesto = pPresupuesto;
    }
// Métodos getter y setter para nombreCliente
    public String getnombreCliente()
    {
        return this.nombreCliente;
    }

    public void setNombreCliente(String pnombreCliente)
    {
        this.nombreCliente = pnombreCliente;
    }
// Métodos getter y setter para fechaSalida
    public String getFechaSalida()
    {
        return this.fechaSalida;
    }

    public void setFechaSalida(String pFechaSalida)
    {
        this.fechaSalida = pFechaSalida;
    }
// Método toString para obtener una representación en cadena de la instancia
    public String toString()
    {
        return "Nombre del cliente: " + getnombreCliente() + "\nPresupuesto del cliente: " + getPresupuesto() + "\nGustos del cliente: " + getGusto() + "\nFecha a la que se ira el cliente: " + getFechaSalida();
    }
// Método getter para gusto
    public String getGusto() 
    {
        return gusto;
    }
// Método setter para gusto
    public void setGusto(String gusto) 
    {
        this.gusto = gusto;
    }
// Método para calcular los días restantes hasta la fecha de salida
    public int calcularDiasRestantes() 
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaSalida = LocalDate.parse(this.fechaSalida, formatter);
        LocalDate fechaActual = LocalDate.now();
        long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaSalida);
        return (int) diasRestantes;
    }
}