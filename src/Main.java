import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mario mario = new Mario();
        Inimigo inimigo = new Inimigo();
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                -------------------------
                       SUPER MARIO
                -------------------------
                Condições de Vitória: Chegar a 500 pontos.
                Condições de Derrota: Perder todas as vidas.""");
        mario.mostrarStatus();

        while (true) {
            if (mario.getVidas() == 0) {
                System.out.println("-------------------------");
                System.out.println("GAME OVER! Mario perdeu todas as vidas.");
                break;
            } else if (mario.getPontos() == 500) {
                System.out.println("-------------------------");
                System.out.println("VITÓRIA! Mario conseguiu 500 pontos.");
                break;
            }

            int evento = random.nextInt(5);

            System.out.println("""
                    Escolha uma opção:
                    [ 1 ] Andar
                    [ 2 ] Pular
                    [ 3 ] Agachar
                    [ 4 ] Mostrar status
                    [ 5 ] Sair""");
            System.out.print("Sua escolha: ");
            int escolha = sc.nextInt();

            if (escolha == 4) {
                mario.mostrarStatus();
            } else if (escolha == 5) {
                System.out.println("-------------------------");
                System.out.println("Até mais!");
                break;
            } else if (evento == 0) {
                inimigo.tipoInimigo("Terrestre");
                inimigo.mostrarInfo();

                if (escolha == 1) {
                    if (mario.getEstado().equalsIgnoreCase("Pequeno")) {
                        mario.andar();
                        mario.levarDano();
                        System.out.println("Mario levou dano e perdeu 1 vida.");
                    } else if (mario.getEstado().equalsIgnoreCase("Grande")) {
                        mario.andar();
                        System.out.println("Mas mario estava grande e não perdeu vida.");
                        mario.ganharPontos(100);
                        mario.mudarEstado("Pequeno");
                    }
                } else if (escolha == 2) {
                    mario.pular();
                    mario.ganharPontos(100);
                } else if (escolha == 3){
                    if (mario.getEstado().equalsIgnoreCase("Pequeno")) {
                        mario.agachar();
                        mario.levarDano();
                        System.out.println("Mario levou dano e perdeu 1 vida.");
                    } else if (mario.getEstado().equalsIgnoreCase("Grande")) {
                        mario.agachar();
                        System.out.println("Mas mario estava grande e não perdeu vida.");
                        mario.ganharPontos(100);
                        mario.mudarEstado("Pequeno");
                    }
                }
            } else if (evento == 1) {
                inimigo.tipoInimigo("Voador");
                inimigo.mostrarInfo();

                if (escolha == 1) {
                    if (mario.getEstado().equalsIgnoreCase("Pequeno")) {
                        mario.andar();
                        mario.levarDano();
                        System.out.println("Mario levou dano e perdeu 1 vida.");
                    } else if (mario.getEstado().equalsIgnoreCase("Grande")) {
                        mario.andar();
                        System.out.println("Mas mario estava grande e não perdeu vida.");
                        mario.ganharPontos(100);
                        mario.mudarEstado("Pequeno");
                    }
                } else if (escolha == 2) {
                    if (mario.getEstado().equalsIgnoreCase("Pequeno")) {
                        mario.pular();
                        mario.levarDano();
                        System.out.println("Mario levou dano e perdeu 1 vida.");
                    } else if (mario.getEstado().equalsIgnoreCase("Grande")) {
                        mario.pular();
                        System.out.println("Mas mario estava grande e não perdeu vida.");
                        mario.ganharPontos(100);
                        mario.mudarEstado("Pequeno");
                    }
                } else if (escolha == 3){
                    mario.agachar();
                    mario.ganharPontos(100);
                }
            } else if (evento == 2) {
                System.out.println("Um buraco apareceu!");

                if (escolha == 1) {
                    if (mario.getEstado().equalsIgnoreCase("Pequeno")) {
                        mario.andar();
                        mario.levarDano();
                        System.out.println("Mario caiu no buraco e perdeu 1 vida.");
                    } else if (mario.getEstado().equalsIgnoreCase("Grande")) {
                        mario.andar();
                        System.out.println("Mas mario estava grande e não perdeu vida.");
                        mario.ganharPontos(50);
                        mario.mudarEstado("Pequeno");
                    }
                } else if (escolha == 2) {
                    mario.pular();
                    mario.ganharPontos(50);
                } else if (escolha == 3) {
                    if (mario.getEstado().equalsIgnoreCase("Pequeno")) {
                        mario.agachar();
                        mario.levarDano();
                        System.out.println("Mario caiu no buraco e perdeu 1 vida.");
                    } else if (mario.getEstado().equalsIgnoreCase("Grande")) {
                        mario.agachar();
                        System.out.println("Mas mario estava grande e não perdeu vida.");
                        mario.ganharPontos(50);
                        mario.mudarEstado("Pequeno");
                    }
                }
            } else if (evento == 3) {
                System.out.println("Cogumelo verde à frente!");

                if (escolha == 1) {
                    mario.andar();
                    mario.pegarVida();
                    System.out.println("Mario pegou o cogumelo. \nVida extra adicionada!");
                } else if (escolha == 2) {
                    mario.pular();
                    System.out.println("Mario não pegou o cogumelo.");
                } else if (escolha == 3) {
                    mario.agachar();
                    mario.pegarVida();
                    System.out.println("Mario pegou o cogumelo. \nVida extra adicionada!");
                }
            } else if (evento == 4) {
                System.out.println("Cogumelo vermelho à frente!");

                if (escolha == 1) {
                    if (mario.getEstado().equals("Pequeno")) {
                        mario.andar();
                        System.out.println("Mario pegou o cogumelo.");
                        mario.mudarEstado("Grande");
                    } else {
                        mario.andar();
                        System.out.println("Mario já está grande e não pegou o cogumelo.");
                        mario.ganharPontos(50);
                    }
                } else if (escolha == 2) {
                    mario.pular();
                    System.out.println("Mario não pegou o cogumelo.");
                } else if (escolha == 3) {
                    if (mario.getEstado().equals("Pequeno")) {
                        mario.agachar();
                        System.out.println("Mario pegou o cogumelo.");
                        mario.mudarEstado("Grande");
                    } else {
                        mario.agachar();
                        System.out.println("Mario já está grande e não pegou o cogumelo.");
                        mario.ganharPontos(50);
                    }
                }
            }
        }
    }
}