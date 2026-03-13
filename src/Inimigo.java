public class Inimigo {
    private String tipoInimigo;

    public void tipoInimigo(String tipoInimigo) {
        this.tipoInimigo = tipoInimigo;
    }

    public void mostrarInfo() {
        System.out.println("Um inimigo " + tipoInimigo + " apareceu!");
    }
}