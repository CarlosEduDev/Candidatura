package processo_seletivo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class candidatura {
    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        String[] candidatos = {"Felipe", "Maria", "Paulo", "Julia", "Leona"};

        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando){
                tentativas++;
            }else{
                System.out.println("Contato realizado com sucesso");
            }
        }while(continuarTentando && tentativas < 3);

        if (atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativas + " tentativa");
        }else{
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"Felipe", "Maria", "Paulo", "Julia", "Leona"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for(int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de número " + (indice + 1) + " é " + candidatos[indice]);
        }

    }

    static void selecaoCandidatos(){
        String[] candidatos = {"Felipe", "Maria", "Paulo", "Julia", "Leona", "Gustavo", "João"};

        int candidatosSelecionados = 0;

        int candidatosAtual = 0;

        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }

    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidatos(double salarioPretendido){

        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        } else{
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
