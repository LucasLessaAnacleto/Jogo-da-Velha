import java.util.Random;
import java.util.Scanner;
public class main{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        Random rand = new Random();
        int opcao = 0;
        boolean fim = true;
        String mensagem = "";
        while(opcao == 1){
            System.out.println("O que Deseja? ");
            System.out.println("Digite 1 para começar uma partida ");
            System.out.println("Ou digite outro numero para fechar o jogo");
            opcao = ler.nextInt();
            if (opcao == 1){  //IF PRINCIPAL
            jogo.inicializarTabuleiro();    
            System.out.println();
            System.out.print("nome jogador 1: ");
            String jogador1 = ler.next();
            System.out.print("nome jogador 2: ");
            String jogador2 = ler.next();
            jogo.declaraNome(jogador1, jogador2);
            if (rand.nextInt(99) % 2 == 0)
            jogo.alterna();
            System.out.println(jogo.getNome()+" começa!!");
            System.out.println("Boa Partida e que o Melhor Vença...");
            System.out.println();
            jogo.imprimirTabuleiro();
            int line,col;
            while(fim){ // LOOP DO GAME
                if (jogo.ProximaRodada()){
                    System.out.println("Vez do "+jogo.getNome()+" atacar");
                    System.out.println("Escolha a posição que deseja marcar "+jogo.getSimbolo());
                    System.out.println("Digite a linha(1-3): ");
                    line = ler.nextInt();
                    System.out.println("Digite a coluna(1-3): ");
                    col = ler.nextInt();
                    jogo.realizarJogada(line, col);
                    jogo.imprimirTabuleiro();
                    if (jogo.verificaVitoria() == 0){
                        System.out.println("digite um caracter e de enter para prosseguir");
                        ler.next();
                    }else{
                        System.out.println("O "+jogo.getNome()+" VENCEUU!!!");    
                        System.out.println("Parabéns");
                        jogo.alterna();
                        System.out.println("Não foi dessa vez "+jogo.getNome()+" :{"); 
                        fim = false;
                    }
                }else{
                    fim = false;
                    System.out.println("Deu Velha!!! Mais sorte da próxima vez");
                }
            }
            System.out.println("digite um caracter e de enter para finalizar");
            ler.next();
            }//IF PRINCIPAL
        }
            
        
            
    }
}


