public class JogoDaVelha {

    private char[][] tabuleiro = new char[3][3];
    private int jogadorAtual = 1;
    private int jogadas = 0;
    //private int erro = 0;
    private final String[] nome = new String[2]; 

    //                   MÉTODOS DA CLASSE
    
    //metodos referente a tabuleiro

    public void imprimirTabuleiro() {
        System.out.println(" -----");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + "|");
            }
            System.out.println();
            System.out.println(" -----");
        }
    }

    public void inicializarTabuleiro() {
        jogadorAtual = 1;
        jogadas = 0;
       // erro = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private boolean posicaoEstaVazia(int linha, int coluna) {
        return tabuleiro[linha][coluna] == '-';
    }

    //metodos referentes a declarações e gerencio de propriedades

    public void declaraNome(String jogador1, String jogador2){
        nome[0] = jogador1;
        nome[1] = jogador2; 
    }

    public void alterna(){
        if(jogadorAtual == 1)
            jogadorAtual = 2;
        else
            jogadorAtual = 1;
    }

    public int getJogadorAtual(){
        return jogadorAtual;
    }

    public String getNome(){
        return nome[jogadorAtual-1];
    }

    public boolean ProximaRodada(){
        jogadas++;
        if (jogadas>9){
            jogadas=0;
            return false;
        }else{
            return true; 
        }
    }

    public String getSimbolo(){
        return jogadorAtual == 1 ? "X" : "O";
    }

    //metodos referentes a jogabilidade

    public void realizarJogada(int linha, int coluna) {
        if (((linha <= 3) && (linha >= 0)) && ((coluna <= 3) && (coluna >= 0))) {
            
            if (jogadorAtual == 1) {
                if (posicaoEstaVazia(linha-1, coluna-1)) {
                    tabuleiro[linha-1][coluna-1] = 'X';
                    jogadorAtual = 2;
                } else {
                 //   erro = 2;
                }
            } else {
                if (posicaoEstaVazia(linha-1, coluna-1)) {
                    tabuleiro[linha-1][coluna-1] = 'O';
                    jogadorAtual = 1;
                } else {
                 //   erro = 2;
                }
            }

        } 
    }

    public int verificaVitoria(){
        int venceu = 0;
        int[] posicao = new int[10]; // posicao vai de 1-9
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (tabuleiro[i][j] == 'X') {
                  posicao[calcPosi(i,j)] = 1; // calcPois transforma o indice de linha e coluna na posicao correspondente em 1-9 
                }else if (tabuleiro[i][j] == 'O') {
                    posicao[calcPosi(i,j)] = 2;  
                }
            }
        }
        for (int i = 1;i<=3;i++) {
            for(int j = 1;j<=2;j++){
                if((posicao[i]==j && posicao[i+3]==j && posicao[i+6]==j)||(posicao[calcPosi(i-1,0)]==j && posicao[calcPosi(i-1,1)]==j && posicao[calcPosi(i-1,2)]==j)){
                   venceu = j;
                   break; 
                }else 
                if (((i == 1)&&(posicao[1]==j && posicao[5]==j && posicao[9]==j))||((i == 3)&&(posicao[3]==j && posicao[5]==j && posicao[7]==j))){
                    venceu = j;
                    break; 
                }
            }
        }
        if(venceu != 0){
           jogadorAtual = venceu;
        }
        return venceu;
        
   
    }

  /*   public void verificarErro() {
        if (erro == 1) {
            return "Erro: você digitou um número fora dos limites.";
        } else if (erro == 2) {
            return "Erro: posição já preenchida. Tente novamente.";
        }
    } */

    //metodos de suporte

    private int calcPosi(int linha,int coluna){
        linha = (linha*3); // linha 0 = 0  linha 1 = 3  linha 2 = 6   ex:linha 1 = 3
        coluna++;//coluna 0 = 1  coluna 1 = 2 coluna 2 = 3   ex:coluna 2 = 3
        return linha + coluna;// 3 + 3 = 6
    }
}
