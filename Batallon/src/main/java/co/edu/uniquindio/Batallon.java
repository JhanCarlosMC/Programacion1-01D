package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.LinkedList;

public class Batallon {
    private String nombre;
    private String id;

    private LinkedList<VehiculoApoyo> listVehiculosApoyo;
    private LinkedList<VehiculoBlindado> listVehiculosBlindados;
    private LinkedList<VehiculoTransporteTropa> listVehiculosTransporteTropa;

    private LinkedList<Vehiculo> listVehiculos;

    private LinkedList<Mision> listMisiones;

    public Batallon(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;

        this.listVehiculosApoyo = new LinkedList<>();
        this.listVehiculosBlindados = new LinkedList<>();
        this.listVehiculosTransporteTropa = new LinkedList<>();
        this.listMisiones = new LinkedList<>();
        this.listVehiculos = new LinkedList<>();
    }

    public boolean registrarMision(LocalDate fechaMision, String ubicacionMision,
                                   LinkedList listPersonal, String idVehiculomision){
        boolean flag = false;

        //Convertir de int a string
        String cantMisionesActuales = String.valueOf(listMisiones.size()+1);

        Mision newMision = new Mision(cantMisionesActuales,fechaMision,ubicacionMision);

        for(Vehiculo vehiculo : listVehiculos){
            if (vehiculo.getId().equals(idVehiculomision)){
                newMision.setTheVehiculo(vehiculo);

                LinkedList<Mision> listTempo = vehiculo.getListMisiones();
                listTempo.add(newMision);

                vehiculo.setListMisiones(listTempo);
                listMisiones.add(newMision);
                flag = true;
                break;
            }
        }

        return flag;
    }

    //Vehiculo mayor cantidad de misiones

    public Vehiculo vehiculoMayorCantMisiones(){
        Vehiculo vehiculoMaxCantMisiones = null;
        int maxCantMisiones = 0;
        for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
            if (vehiculoApoyo.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoApoyo.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoApoyo;
            }
        }for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
            if (vehiculoBlindado.getMisionesCompletadas() > maxCantMisiones) {
                maxCantMisiones = vehiculoBlindado.getMisionesCompletadas();
                vehiculoMaxCantMisiones = vehiculoBlindado;
            }
        }for (VehiculoTransporteTropa transporteTropas : listVehiculosTransporteTropa) {
            if(transporteTropas.getMisionesCompletadas() > maxCantMisiones){
                maxCantMisiones = transporteTropas.getMisionesCompletadas();
                vehiculoMaxCantMisiones = transporteTropas;
            }
        }
        return vehiculoMaxCantMisiones;
    }

    //Calcular kilometraje promedio por tipo de vehículo
    public double kilometrajePromedioTropas (){
        double sumaTropas = 0;
        double promedioTropas = 0;
        for(VehiculoTransporteTropa newTransporteTropas : listVehiculosTransporteTropa){
            sumaTropas = newTransporteTropas.getKilometraje()+sumaTropas;
        }
        promedioTropas = sumaTropas/listVehiculosTransporteTropa.size();
        return promedioTropas;

    }

    public double kilometrajePromedioApoyo(){
        double sumaApoyos = 0;
        double promedioApoyos = 0;
        for(VehiculoApoyo newApoyo : listVehiculosApoyo){
            sumaApoyos = newApoyo.getKilometraje()+sumaApoyos;
        }
        promedioApoyos = sumaApoyos/listVehiculosApoyo.size();
        return promedioApoyos;
    }

    public double kilometrajePromedioBlindado(){
        double sumaBlindados = 0;
        double promedioBlindados = 0;
        for(VehiculoBlindado newBlindado : listVehiculosBlindados){
            sumaBlindados = newBlindado.getKilometraje()+sumaBlindados;
        }

        promedioBlindados = sumaBlindados/listVehiculosBlindados.size();
        return promedioBlindados;
    }

    //Obtener el vehículo con más misiones completadas
    public LinkedList<Mision> filtroMisionesUbiFechas(String ubicacion, LocalDate fechaInicio, LocalDate fechaFin) {
        LinkedList<Mision> misionesFiltro = new LinkedList<>();
        for (Mision i : listMisiones) {
            if (i.getUbicacion().equals(ubicacion) && ((i.getFecha().isEqual(fechaInicio) || i.getFecha().
                    isAfter(fechaInicio)) && (i.getFecha().isEqual(fechaFin) || i.getFecha().isBefore(fechaFin)))) {
                misionesFiltro.add(i);
            }

        }
        return misionesFiltro;
    }

    public LinkedList<Vehiculo> obtenerVehiculosCantMisiones() {
        LinkedList<Vehiculo> vehiculosMisionesCompletadas = new LinkedList<>();


        for (VehiculoApoyo vehiculo : listVehiculosApoyo) {
            if (vehiculo.getMisionesCompletadas() > 50){
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for(VehiculoBlindado vehiculo : listVehiculosBlindados){
            if (vehiculo.getMisionesCompletadas() > 50){
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        for(VehiculoTransporteTropa vehiculo : listVehiculosTransporteTropa){
            if (vehiculo.getMisionesCompletadas() > 50){
                vehiculosMisionesCompletadas.add(vehiculo);
            }
        }

        return vehiculosMisionesCompletadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedList<VehiculoApoyo> getListVehiculosApoyo() {
        return listVehiculosApoyo;
    }

    public void setListVehiculosApoyo(LinkedList<VehiculoApoyo> listVehiculosApoyo) {
        this.listVehiculosApoyo = listVehiculosApoyo;
    }

    public LinkedList<VehiculoBlindado> getListVehiculosBlindados() {
        return listVehiculosBlindados;
    }

    public void setListVehiculosBlindados(LinkedList<VehiculoBlindado> listVehiculosBlindados) {
        this.listVehiculosBlindados = listVehiculosBlindados;
    }

    public LinkedList<VehiculoTransporteTropa> getListVehiculosTransporteTropa() {
        return listVehiculosTransporteTropa;
    }

    public void setListVehiculosTransporteTropa(LinkedList<VehiculoTransporteTropa> listVehiculosTransporteTropa) {
        this.listVehiculosTransporteTropa = listVehiculosTransporteTropa;
    }

    public LinkedList<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(LinkedList<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    public LinkedList<Mision> getListMisiones() {
        return listMisiones;
    }

    public void setListMisiones(LinkedList<Mision> listMisiones) {
        this.listMisiones = listMisiones;
    }
}
