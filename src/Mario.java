public class Mario {
    private int vidas, pontos;
    private String estado;

    Mario() {
        vidas = 3;
        pontos = 0;
        estado = "Pequeno";
    }

    public int getVidas() {
        return vidas;
    }

    public String getEstado() {
        return estado;
    }

    public int getPontos() {
        return pontos;
    }

    public int levarDano() {
        return vidas--;
    }

    public void pegarVida() {
        vidas++;
    }

    public void ganharPontos(int pontos) {
        this.pontos += pontos;
        System.out.printf("Ganhou %d pontos!%n", pontos);
    }

    public void mudarEstado(String novoEstado) {
        estado = novoEstado;
        System.out.println("Mudou o estado para " + novoEstado + "!");
    }

    public void andar() {
        System.out.println("Mario andou.");
    }

    public void pular() {
        System.out.println("Mario pulou.");
    }

    public void agachar() {
        System.out.println("Mario agachou.");
    }

    public void mostrarStatus() {
        System.out.printf("""
                -----STATUS DO MARIO-----
                Vidas: %d
                Pontos: %d
                Estado: %s
                -------------------------%n""", vidas, pontos, estado);
    }
}