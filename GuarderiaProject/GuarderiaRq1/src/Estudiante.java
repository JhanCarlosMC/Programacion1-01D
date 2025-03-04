public class Estudiante {
    //Atributos clase
    private String nombre;
    private int edad;
    private String genero;
    private String identificacion;
    private String alergias;
    private String nombreAcudiente;
    private String numeroContacto;

    //Constructor
    public Estudiante(String nombre, int edad, String genero,
                      String identificacion, String alergias,
                      String nombreAcudiente, String numeroContacto) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.identificacion = identificacion;
        this.alergias = alergias;
        this.nombreAcudiente = nombreAcudiente;
        this.numeroContacto = numeroContacto;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", alergias='" + alergias + '\'' +
                ", nombreAcudiente='" + nombreAcudiente + '\'' +
                ", numeroContacto='" + numeroContacto + '\'' +
                '}';
    }

    //Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
}
