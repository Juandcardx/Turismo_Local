import java.io.*;

public class Login // Se define la clase Login
{
    private String Usuario;
    private String Contraseña;
// Constructor con usuario y contraseña
    public Login(String pUsuario, String pConstraseña)
    {
        this.Usuario = pUsuario;
        this.Contraseña = pConstraseña;
    }
// Métodos getter y setter para el usuario
    public String getUsuario() 
    {
        return Usuario;
    }

    public void setUsuario(String usuario) 
    {
        Usuario = usuario;
    }
// Métodos getter y setter para la contraseña
    public String getContraseña() 
    {
        return Contraseña;
    }

    public void setContraseña(String contraseña)
    {
        Contraseña = contraseña;
    }
// Método para verificar el inicio de sesión
    public boolean verificarLogin(String usuario, String Contraseña)
    {
        boolean resultado = false;
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try 
        {
            File archivo = new File("Login.txt");
            reader = new FileReader(archivo);
            bufferedReader = new BufferedReader(reader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) 
            {
                String[] credenciales = linea.split(":");
                if (credenciales[0].equals(usuario) && credenciales[1].equals(Contraseña)) 
                {
                    resultado = true;
                    break;
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try {
                if (bufferedReader != null) 
                {
                    bufferedReader.close();
                }
                if (reader != null) 
                {
                    reader.close();
                }
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
        return resultado;
    }
// Método para registrar un nuevo usuario
    public boolean registrarLogin(String usuario, String Contraseña)
    {
        boolean resultado = false;
        FileWriter writer = null;
        try {
            File archivo = new File("Login.txt");
            writer = new FileWriter(archivo, true);
            writer.write(usuario + ":" + Contraseña + "\n");
            resultado = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    // Método para verificar la existencia de un usuario
    public boolean verificarExistenciaUsuario(String usuario)
    {
        boolean existe = false;
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try 
        {
            File archivo = new File("Login.txt");
            reader = new FileReader(archivo);
            bufferedReader = new BufferedReader(reader);
            String linea;
            while ((linea = bufferedReader.readLine()) != null) 
            {
                String[] credenciales = linea.split(":");
                if (credenciales[0].equals(usuario)) 
                {
                    existe = true;
                    break;
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try {
                if (bufferedReader != null) 
                {
                    bufferedReader.close();
                }
                if (reader != null) 
                {
                    reader.close();
                }
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }
        return existe;
    }
}
