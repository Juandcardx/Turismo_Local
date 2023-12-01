
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controlador implements ActionListener 
{
    private VentanaPrincipal miVentanaPrincipal;
    private Cliente model1;
    private Evento evento1;
    private VentanaLogin miVentanaLogin;
    private Login miLogin;

    public controlador(VentanaLogin miVentanaLogin, Login miLogin)// Constructor que recibe la ventana de login y el modelo de login
    {
        this.miVentanaLogin = miVentanaLogin;
        this.miLogin = miLogin;
        this.miVentanaLogin.miPanelLogin.btnAccionLogin.addActionListener(this);
        this.miVentanaLogin.miPanelLogin.btnDialogo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String comando = ae.getActionCommand();

        // Verificar si el comando recibido es para la acción de login
        if(comando.equals("accionLogin"))
        {
            try 
            {
                 // Obtener usuario y contraseña ingresados por el usuario en la ventana de login
                String pUsuario = miVentanaLogin.miPanelLogin.getUsuarioLogin();
                String pContraseña = miVentanaLogin.miPanelLogin.getContraseñaLogin();
                if(miLogin.verificarLogin(pUsuario, pContraseña))
                {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!", "Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
                    this.miVentanaPrincipal = new VentanaPrincipal();
                    miVentanaPrincipal.setVisible(true);
                    miVentanaPrincipal.miPanelOperaciones.agregarOyentesBotones(this);
                    miVentanaLogin.cerrarLogin();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido", "Inicio de sesion", JOptionPane.ERROR_MESSAGE);
                }
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }

        if(comando.equals("crearRegistro"))// Verifica si el comando es para crear un registro
        {
            miVentanaLogin.crearDialogoRegistro();// Abre el diálogo de registro desde la ventana de inicio de sesión
            this.miVentanaLogin.miDialogoRegistro.agregarOyentesBotones(this);// Agrega oyentes de botones al diálogo de registro
        }

        if(comando.equals("aceptar"))
        {
            String usuario = miVentanaLogin.miDialogoRegistro.getUsuario();
            String Contraseña = miVentanaLogin.miDialogoRegistro.getContraseña();
            boolean usuarioExistente = miLogin.verificarExistenciaUsuario(usuario);
            if(usuarioExistente == true)
            {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if(usuarioExistente == false)
            {
                miLogin.registrarLogin(usuario, Contraseña);
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente", "Usuario creado", JOptionPane.INFORMATION_MESSAGE);
                miVentanaLogin.miDialogoRegistro.cerrarDialogo();
            }
        }
 
        if(comando.equals("crear"))
        {
            // Obtiene los datos del nuevo cliente desde la ventana principal
            miVentanaPrincipal.miPanelResultado.mostrarResultado("\n-------------------------------------");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("----- NUEVO CLIENTE -----");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("-------------------------------------\n");
            VentanaPrincipal venPrin = miVentanaPrincipal;   // Crea un nuevo objeto Cliente
            String gusto = venPrin.miPanelEntradaDatos.getGusto();
            String fechaSalida = venPrin.miPanelEntradaDatos.getFechaSalida();
            String nombreCliente = venPrin.miPanelEntradaDatos.getnombreCliente();
            int Presupuesto = Integer.parseInt(venPrin.miPanelEntradaDatos.getPresupuesto());

            model1 = new Cliente(fechaSalida, nombreCliente, Presupuesto, gusto); // Muestra información sobre el nuevo cliente en el panel de resultados

            venPrin.miPanelResultado.mostrarResultado("Se ha creado un nuevo cliente");
            venPrin.miPanelResultado.mostrarResultado("Nombre del cliente: " + model1.getnombreCliente());
            venPrin.miPanelResultado.mostrarResultado("La fecha en la que se ira de Socorro es " + model1.getFechaSalida());
            venPrin.miPanelResultado.mostrarResultado("Su presupesto es de $" + model1.getPresupuesto() + " pesos.");
            venPrin.miPanelResultado.mostrarResultado("Sus gustos se basan en " + model1.getGusto());

            // Desactiva el botón de "Crear" en la ventana principal y activa el botón de "Mostrar Consejo"
            venPrin.miPanelOperaciones.desactivarBotonCrear();
            venPrin.miPanelOperaciones.activarBotonMostrarConsejo();
        }

        if(comando.equals("registrarEvento")) // Verifica si el comando es "registrarEvento"
        {
            if(model1.getGusto() == "Farrear")
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("\n-----------------------------------");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("----- NUEVO EVENTO -----");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("-----------------------------------\n");
                String nombreSitio = miVentanaPrincipal.miDialogoTabla.getTfnombreSitio(); // Obtener nombre del sitio
                miVentanaPrincipal.miDialogoTabla.obtenerDatos();
                miVentanaPrincipal.miDialogoTabla.cerrarDialogo();
                evento1 = new Evento(40, nombreSitio, "01/12/2023", "Farra"); // Crear y mostrar información del evento y el grupo
                String mensaje = evento1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje);  // Mostrar advertencias relacionadas con eventos de farrear
                Grupo grupo1 = new Grupo("Farra", "Farra", nombreSitio, "12:00 pm");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("No se recomienda conducir en estado de ebriedad, tenlo en cuenta!");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Ten cuidado sobre lo que te ofrecen en la farra");
                grupo1.calcularGrupos(evento1.getNumGrupo());
            }
            if(model1.getGusto() == "Comer")
            {
                
                // Obtener nombre del restaurante
                String nombreSitio = miVentanaPrincipal.miDialogoTablaRestaurante.getTfnombreSitio();

                // Mostrar información del restaurante
                miVentanaPrincipal.miDialogoTablaRestaurante.cerrarDialogo();
                miVentanaPrincipal.miPanelResultado.mostrarResultado("\nPiensas ir a " + nombreSitio + "? Genial!");
                miVentanaPrincipal.miDialogoTablaRestaurante.obtenerDatos();

                // Crear y mostrar información del grupo
                Grupo grupo1 = new Grupo("Comida/Restaurantes", "Comer", nombreSitio + "1");
                if(model1.getPresupuesto() < 50000)
                {
                    miVentanaPrincipal.miPanelResultado.mostrarResultado("El presupuesto es menor a $50000.\nSi vas acompañado te sugerimos llevar mas dinero");
                }
            }
            if(model1.getGusto() == "Explorar")
            {
                // Obtener nombre del lugar de exploración
                String nombreSitio = miVentanaPrincipal.miDialogoTablaExploracion.getTfnombreSitio();
                miVentanaPrincipal.miDialogoTablaExploracion.cerrarDialogo();

                // Crear y mostrar información del grupo
                Grupo grupo1 = new Grupo("Actividades y Aventuras", "Explorar", nombreSitio + " 1");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Quieres ir a " + nombreSitio + "? Genial!");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Si vas a una piscina, no olvides aplicarte bloqueador!");
                miVentanaPrincipal.miDialogoTablaExploracion.obtenerDatos();
            }
            if(model1.getGusto() == "Turistear")
            {
                // Obtener nombre del lugar turístico
                String nombreSitio = miVentanaPrincipal.miDialogoTablaTurismo.getTfnombreSitio();

                // Cerrar y obtener información del diálogo
                Grupo grupo1 = new Grupo("Sitios turisticos", "Turistear", nombreSitio + " 1");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Quieres ir a " + nombreSitio + "? Excelente!");
                miVentanaPrincipal.miDialogoTablaTurismo.cerrarDialogo();
                miVentanaPrincipal.miDialogoTablaTurismo.obtenerDatos();
            }
        }

        if(comando.equals("mostrarConsejo"))  // Mostrar saludo y consejos personalizados para el usuario
        {
            miVentanaPrincipal.miPanelResultado.mostrarResultado("\nHola, " + model1.getnombreCliente() +"!.\nAqui algunos consejos: ");
            // Calcular días restantes antes del viaje y dar un consejo sobre la maleta
            int diasRestantes = model1.calcularDiasRestantes();
            if(diasRestantes <= 2)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te vas en " + diasRestantes + " dias. Alista tu maleta!.");
            }
            else
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te vas en " + diasRestantes + " dias.");
            }
            if(model1.getPresupuesto() >= 1000000) // Dar consejos relacionados con el presupuesto
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Tienes $" + model1.getPresupuesto() + " pesos.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("En cualquier caso, existe una estacion de policia en el Parque de la Independencia.");
            }
            if(model1.getPresupuesto() <= 50000)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Tienes $" + model1.getPresupuesto() + " pesos.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Si piensas hacer un retiro grande recuerda hacerlo en un corresponsal autorizado.\nEstos corresponsales quedan en el Parque de la Independencia.");
            }

            // Dar consejos específicos para los gustos del usuario
            if(model1.getGusto() == "Turistear")
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te gusta " + model1.getGusto());
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Recuerda que si quieres turistear en El Socorro existe un punto de informacion en frente de la Iglesia ubicada en el Parque de la Independencia.");
            }
            if(model1.getGusto() == "Comer" && model1.getPresupuesto() <= 50000)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te gusta " + model1.getGusto());
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Tienes $" + model1.getPresupuesto() + " pesos.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Si vas a comer acompañado se te sugiere llevar mas dinero.");
            }
            if(model1.getGusto() == "Farrear")
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Te gusta " + model1.getGusto());
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Recuerda no conducir en estado de ebriedad!.");
                miVentanaPrincipal.miPanelResultado.mostrarResultado("Se te sugiere ir acompañado de tus amigos o del grupo seleccionado para ti.");
            }
        }

        if(comando.equals("mostrarDatos"))
        {
            miVentanaPrincipal.miPanelResultado.mostrarResultado("\n-------------------------------------");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("----- MOSTRAR DATOS -----");
            miVentanaPrincipal.miPanelResultado.mostrarResultado("-------------------------------------\n");
            
            // Verificar si se ha creado algún cliente
            if(model1 == null)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("No se ha creado ningun cliente");
            }
            // Si hay un cliente y también se ha inscrito a un evento
            else if(evento1 != null)
            {
                // Mostrar información del cliente y del evento
                String mensaje1 = model1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje1);
                String mensaje = evento1.toString();
                miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje);
            }
            
            else if(evento1 == null)
            {
                miVentanaPrincipal.miPanelResultado.mostrarResultado("No se ha inscrito a ningun evento");
                if(model1 != null)
                {
                    String mensaje1 = model1.toString();
                    miVentanaPrincipal.miPanelResultado.mostrarResultado(mensaje1);
                }
            }
        }

        if(comando.equals("borrar"))
        {
            JOptionPane.showMessageDialog(null, "Se borrarán los datos.", "Borrar datos", JOptionPane.CANCEL_OPTION);

            // Mostrar mensaje de confirmación para borrar datos
            miVentanaPrincipal.miPanelEntradaDatos.borrar();// Borrar datos en los paneles correspondientes
            miVentanaPrincipal.miPanelResultado.borrar();  
            
            // Desactivar el botón "Mostrar Consejo" y activar el botón "Crear
            miVentanaPrincipal.miPanelOperaciones.desactivarBotonMostrarConsejo();  
            miVentanaPrincipal.miPanelOperaciones.activarBotonCrear();
        }

        if(comando.equals("cerrarSesion"))
        {
             // Mostrar mensaje de confirmación para cerrar sesión
            JOptionPane.showMessageDialog(null, "Se cerrará la sesión.", "Cerrar Sesion", JOptionPane.CANCEL_OPTION);
            miVentanaPrincipal.cerrarVenPrincipal();
            VentanaLogin miVentanaLogin = new VentanaLogin(); // Crear una nueva ventana de inicio de sesión y un nuevo controlador
            Login miLogin = new Login(null, null);
            controlador miControlador = new controlador(miVentanaLogin, miLogin);
        }

        if(comando.equals("dialogoTabla")) // Abrir diálogo de tabla según el gusto del usuario
        {
            if(model1.getGusto() == "Farrear")  // Verificar el gusto del usuario y crear el diálogo de tabla correspondiente
            {
                miVentanaPrincipal.crearDialogoTabla();
                this.miVentanaPrincipal.miDialogoTabla.agregarOyentesBotones(this);
            }
            if(model1.getGusto() == "Comer")
            {
                miVentanaPrincipal.crearDialogoTablaRestaurante();
                this.miVentanaPrincipal.miDialogoTablaRestaurante.agregarOyentesBotones(this);
            }
            if(model1.getGusto() == "Explorar")
            {
                miVentanaPrincipal.crearDialogoTablaExploracion();
                this.miVentanaPrincipal.miDialogoTablaExploracion.agregarOyentesBotones(this);
            }
            if(model1.getGusto() == "Turistear")
            {
                miVentanaPrincipal.crearDialogoTablaTurismo();
                this.miVentanaPrincipal.miDialogoTablaTurismo.agregarOyentesBotones(this);
            }

        }

    }
}
