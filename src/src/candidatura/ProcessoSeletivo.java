package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        imprimirSelecionados();

        String [] candidatos = {"JOÃO", "CARLA", "AUGUSTO", "MARIA", "CAIO"};

        //O rh deverá realizar uma ligação com no máximo 3 tentativas para cada candidato selecionado caso o candidato atenda, deve imprimir:
        //"CONSEGUIMOS CONTATO COM O [candidato] APÓS [tentativa] TENTATIVA(S)"
        //do contrário: "NÃO CONSEGUIMOS CONTATO COM O CANDIDATO [candidato]"

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato (String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            //terão alterações para finalizar a aplicação
            atendeu = atender();
            continuarTentando =! atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato + " NA TENTATIVA DE CONTATO " +tentativasRealizadas);
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato + " NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADAS");
        }
    }

    //auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1; //se o valor for entre 1 e 3 o candidato atendeu
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"JOÃO", "CARLA", "AUGUSTO", "MARIA", "CAIO"};
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
        for (int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n° " + (indice+1) + " é " + candidatos[indice]); //índice =! 0 para o usuário -> aparece a partir do 1
        }

        System.out.println("Forma abreviada de interação for each");

        for (String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"JOÃO", "CARLA", "AUGUSTO", "MARIA", "CAIO", "GABRIEL", "LANA", "REBECA", "VINICIUS"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase > salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            } else {
                System.out.println("O candidato " + candidato + " não foi selecionado para a vaga");
            }

            candidatosAtual++;

        }
    }

    private static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0; //2 mil no formato decimal
        if (salarioBase > salarioPretendido){
            System.out.println("ENTRAR EM CONTATO COM O CANDIDATO");
        } else if (salarioPretendido == salarioBase) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
        }

    }
}
