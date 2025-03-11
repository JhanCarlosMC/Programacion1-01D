public class Empresa {
    private String nit;
    private String nombre;
    private Empleado[] listEmpleados;

    public Empresa(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        listEmpleados = new Empleado[50];
    }

    public Empleado[] buscarEmpleadosSalarioAlto() {
        Empleado[] empleadosSalarioAlto = listEmpleados;

//        empleadosSalarioAlto = encontrarListaEmpleadosSinNulos(empleadosSalarioAlto);

        for (int i = 0; i < empleadosSalarioAlto.length; i++) {
            for (int j = 0; j < empleadosSalarioAlto.length; j++) {
                if (empleadosSalarioAlto[i].getSalario() < empleadosSalarioAlto[j].getSalario()) {
                    empleadosSalarioAlto[i] = empleadosSalarioAlto[j];
                }
            }
        }
        return empleadosSalarioAlto;
    }

//    private Empleado[] encontrarListaEmpleadosSinNulos(Empleado[] empleadosSalarioAlto) {
//
//    }


    //Cargos Gerente Administrador Auxiliar
    public Empleado[] buscarEmpleadosCargo(String cargoBuscar) {
        int cantEmpleadosCargo = 0;

        for (int i = 0; i < listEmpleados.length; i++) {
            if (listEmpleados[i].getCargo().equals(cargoBuscar)) {
                cantEmpleadosCargo++;
            }
        }

        Empleado[] empleadosCargo = new Empleado[cantEmpleadosCargo];
        int pepitoIndex = 0;

        for (int i = 0; i < listEmpleados.length; i++) {
            if (listEmpleados[i].getCargo().equals(cargoBuscar)) {
                empleadosCargo[pepitoIndex] = listEmpleados[i];
                pepitoIndex++;
            }
        }
        return empleadosCargo;
    }

    public boolean eliminarEmpleado(String idEliminar, Empleado empleadoEliminado) {
        int indiceEmpleado = buscarEmpleadID(idEliminar);

        if (indiceEmpleado != -1) {
            listEmpleados[indiceEmpleado] = null;
            return true;
        }
        return false;
    }

    public boolean actualizarEmpleado(String idBuscar, Empleado empleadoActualizado) {
        int indiceEmpleado = buscarEmpleadID(idBuscar);

        if (indiceEmpleado != -1) {
            listEmpleados[indiceEmpleado] = empleadoActualizado;
            return true;
        }
        return false;
    }

    public int buscarEmpleadID(String idBuscar) {
        for (int i = 0; i < listEmpleados.length; i++) {
            if (listEmpleados[i].getId().equals(idBuscar)) {
                return i;
            }
        }
        return -1;
    }

    public boolean calcularNomina(){

    }

    public boolean crearEmpleado(Empleado newEmpleado) {

        int indice = encontrarPosicionValida();

        if (verificarIdEmpleado(newEmpleado.getId())
                && indice != -1) {
            newEmpleado = asignarSalario(newEmpleado);
            listEmpleados[indice] = newEmpleado;
            return true;
        }
        return false;
    }

    //Cargos Gerente Administrador Auxiliar
    public Empleado asignarSalario(Empleado empleado) {
        //Primer llamado al metodo de calcularSegunCargo
        empleado.setSalario(calcularSalarioCargo(empleado.getCargo()));
        //Segundo llamado metodo de calcularSegunTiempo
        empleado.setSalario(
                calcularIncremento(
                    empleado.getTiempoEmpresa(), empleado.getSalario()));

        return empleado;
    }

    public double calcularIncremento(int tiempoEmpresa, double salario){
        double salarioIncremento = 0;

        if(tiempoEmpresa >= 10){
            salarioIncremento = (salario * 0.15)+salario;
        }else if(tiempoEmpresa >= 5){
            salarioIncremento = (salario * 0.10)+salario;
        }else if (tiempoEmpresa >= 3){
            salarioIncremento = (salario * 0.05)+salario;
        }


        return salarioIncremento;
    }

    public String calcularNomina(){
        int nominaTotal = 0;
        String nominaCadena = "";

        for (int i = 0; i < listEmpleados.length; i++) {
            nominaCadena += "Empleado: " + listEmpleados[i].getNombre()
            + "Salario a Pagar: " + listEmpleados[i].getSalario() +"\n";

            nominaTotal += listEmpleados[i].getSalario();
        }
        nominaCadena += "Total de pago empleados: " + Math.round(nominaTotal*10)/10;
        nominaCadena += "\n";
    }

    public double calcularSalarioCargo(String cargo) {
        double salario = 0;

        switch (cargo.toLowerCase()) {
            case "auxiliar":
                salario = 1500000.00;
                break;
            case "administrador":
                salario = 2000000.00;
                break;
            case "gerente":
                salario = 3000000.00;
                break;
            default:
                salario = 1000000.00;
                break;
        }

        return salario;
    }

    public int encontrarPosicionValida() {
        for (int i = 0; i < listEmpleados.length; i++) {
            if (listEmpleados[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean verificarIdEmpleado(String idEmpleado) {
        boolean flag = true;

        for (int i = 0; i < listEmpleados.length; i++) {
            if (listEmpleados[i].getId().equals(idEmpleado)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public Empleado[] getListEmpleados() {
        return listEmpleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
