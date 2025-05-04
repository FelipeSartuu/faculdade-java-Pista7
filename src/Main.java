import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BEM-VINDO AO JOGO DO ROBÔ ===");
        System.out.println("Objetivo: Leve o robô (R) até a linha de chegada (F) em 7 movimentos.");
        System.out.println("Cuidado com os obstáculos (_) e não saia da pista!");
        System.out.println("\nCOMANDOS:");
        System.out.println(" - Para mover o robô, digite uma direção seguida do número de passos.");
        System.out.println(" - Exemplo: 'direita 3' ou 'cima 2'");
        System.out.println("Direções válidas: cima, baixo, esquerda, direita");
        System.out.println("\nPressione 1 para iniciar o jogo.");

        int opcao = scanner.nextInt();
        if (opcao != 1) {
            System.out.println("Jogo encerrado.");
            return;
        }

        String[][] pista = {
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {"_", "_", "_", "_", "_", "_", "_", "_", "_", " "},
                {"_", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {"_", " ", "_", "_", "_", "_", "_", "_", "_", " "},
                {"F", " ", " ", " ", " ", " ", " ", " ", "_", " "},
                {"_", "_", "_", "_", "_", "_", "_", " ", " ", " "},
                {"_", " ", " ", " ", " ", " ", " ", " ", "_", " "},
                {"_", " ", "_", "_", "_", "_", "_", "_", "_", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", "_", "_", "_", "_", "_", "_", "_", "_", " "}
        };

        int x = 0;
        int y = 0;

        for (int i = 1; i <= 7; i++) {
            System.out.println("\n=== Movimento " + i + " ===");

            for (int linha = 0; linha < 10; linha++) {
                for (int coluna = 0; coluna < 10; coluna++) {
                    if (coluna == x && linha == y) {
                        System.out.print("R ");
                    } else {
                        System.out.print(pista[linha][coluna] + " ");
                    }
                }
                System.out.println();
            }

            System.out.print("\nDigite seu comando (ex: direita 9): ");
            String comando = scanner.next();
            int d = scanner.nextInt();

            int novoX = x;
            int novoY = y;

            if (comando.equalsIgnoreCase("direita")) {
                novoX += d;
            } else if (comando.equalsIgnoreCase("esquerda")) {
                novoX -= d;
            } else if (comando.equalsIgnoreCase("cima")) {
                novoY -= d;
            } else if (comando.equalsIgnoreCase("baixo")) {
                novoY += d;
            } else {
                System.out.println("Comando inválido. Fim do jogo.");
                return;
            }

            if (novoX < 0 || novoX > 9 || novoY < 0 || novoY > 9) {
                System.out.println("Robô saiu da pista! Fim de jogo.");
                return;
            } else if (pista[novoY][novoX].equals("_")) {
                System.out.println("Robô bateu em um obstáculo! Fim de jogo.");
                return;
            } else if (pista[novoY][novoX].equals("F") && i < 7) {
                System.out.println("Robô chegou cedo demais na linha de chegada! Você perdeu.");
                return;
            }

            x = novoX;
            y = novoY;
        }

        System.out.println("\n=== Fim dos movimentos ===");
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                if (coluna == x && linha == y) {
                    System.out.print("R ");
                } else {
                    System.out.print(pista[linha][coluna] + " ");
                }
            }
            System.out.println();
        }

        System.out.println();
        if (pista[y][x].equals("F")) {
            System.out.println("Parabéns! Robô chegou na linha de chegada com 7 movimentos! Vitória!");
        } else {
            System.out.println("Robô não chegou à linha de chegada. Tente novamente.");
        }
    }
}