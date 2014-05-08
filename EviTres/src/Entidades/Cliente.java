package Entidades;

public class Cliente {

    private int id_cliente;
    private String nombreCliente;
    private String direccion;
    private String tel;
    private int prestamo;
    private String nombreEmple;

    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTel() {
        return tel;
    }

    public int getPrestamo() {
        return prestamo;
    }

    public String getNombreEmple() {
        return nombreEmple;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }

    public void setNombreEmple(String nombreEmple) {
        this.nombreEmple = nombreEmple;
    }
}
