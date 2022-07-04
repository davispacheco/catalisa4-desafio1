package jogoAdivinharNumero;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean repeticaoInstrucoes = true;
        boolean repeticaoNivelDificuldade = true;
        boolean repeticaoJogar = true;
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Jogo para adivinhar um número.");
        while (repeticaoInstrucoes) {
            System.out.println("Deseja instruções, sim ou não?");
            String opcao1 = input.next();
            if (!opcao1.equalsIgnoreCase("s") && !opcao1.equalsIgnoreCase("sim") && !opcao1.equalsIgnoreCase("n") && !opcao1.equalsIgnoreCase("não") && !opcao1.equalsIgnoreCase("nao")) {
                System.out.println("Resposta inválida.");
                repeticaoInstrucoes = true;
            } else if (opcao1.equalsIgnoreCase("s") || opcao1.equalsIgnoreCase("sim")) {
                System.out.println("O jogo consiste em adivinhar um número que o computador vai escolher.");
                System.out.println("Se o número que digitar for igual ao sorteado, você ganha 10 pontos.");
                System.out.println("Se o número digitado for um a mais ou a menos que o sorteado, você ganha 5 pontos.");
                System.out.println("Se errar, você perderá o jogo.");
                System.out.println("Há três níveis de dificuldade.");
                System.out.println("1: Fácil. O número sorteado vai de 0 a 10.");
                System.out.println("2: Médio. O número sorteado vai de 0 a 100.");
                System.out.println("3: Difícil. O número sorteado vai de 0 a 1000.");
                System.out.println("Boa sorte!");
                repeticaoInstrucoes = false;
            } else {
                repeticaoInstrucoes = false;
            }
        }
        int numeroMaximo = 0;
        while (repeticaoNivelDificuldade) {
            System.out.println("Escolha um nível de dificuldade.");
            System.out.println("1: Fácil;");
            System.out.println("2: Médio;");
            System.out.println("3: Difícil;");
            System.out.println("4: Desistir.");
            String opcao2 = input.next();
            switch (opcao2) {
                case "1":
                    numeroMaximo = 10;
                    repeticaoNivelDificuldade = false;
                    break;
                case "2":
                    numeroMaximo = 100;
                    repeticaoNivelDificuldade = false;
                    break;
                case "3":
                    numeroMaximo = 1000;
                    repeticaoNivelDificuldade = false;
                    break;
                case "4":
                    System.out.println("Desistiu.\nFim do jogo!");
                    repeticaoNivelDificuldade = false;
                    repeticaoJogar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    repeticaoNivelDificuldade = true;
            }
        }
        if (repeticaoJogar) {
            ArrayList<Integer> numerosDigitados = new ArrayList<>();
            int pontuacao = 0;
            int tentativas = 0;
            System.out.println("Digite um número, de 0 a " + numeroMaximo + ":");
            int numeroAleatorio = random.nextInt(numeroMaximo);
            while (repeticaoJogar) {
                System.out.println((tentativas + 1) + "ª tentativa:");
                int respostaUsuario = input.nextInt();
                if (respostaUsuario < 0) {
                    System.out.println("O número digitado não pode ser negativo.");
                    repeticaoJogar = true;
                } else if (respostaUsuario > numeroMaximo) {
                    System.out.println("O número digitado é maior que seu nível de dificuldade atual.");
                    repeticaoJogar = true;
                } else if (respostaUsuario == numeroAleatorio) {
                    numerosDigitados.add(respostaUsuario);
                    pontuacao += 10;
                    System.out.println("Parabéns, você acertou!\nO número era: " + numeroAleatorio);
                    repeticaoJogar = false;
                    tentativas++;
                } else {
                    numerosDigitados.add(respostaUsuario);
                    int numeroMaior = numeroAleatorio + 1;
                    int numeroMenor = numeroAleatorio - 1;
                    tentativas++;
                    if (respostaUsuario == numeroMaior) {
                        pontuacao += 5;
                        repeticaoJogar = true;
                        System.out.println("O número é menor!");
                    } else if (respostaUsuario == numeroMenor) {
                        pontuacao += 5;
                        repeticaoJogar = true;
                        System.out.println("O número é maior!");
                    } else {
                        repeticaoJogar = false;
                        System.out.println("Você perdeu o jogo!\nO número correto era: " + numeroAleatorio);
                    }
                }
            }
            System.out.println("Sua pontuação é: " + pontuacao);
            System.out.println("Quantidade de tentativas: " + tentativas);
            System.out.println("Números digitados:");
            for (int numeroDigitado : numerosDigitados) {
                System.out.println(numeroDigitado);
            }
        }
        input.close();
    }
}
