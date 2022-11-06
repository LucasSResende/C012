import java.util.concurrent.Semaphore;

public class Fabrica extends Thread{
    public static Biscoito fabrica = new Biscoito(200);
    private int idThread;
    private Semaphore semaforo;


    public Fabrica(int id, Semaphore semaphore) {
        this.idThread = id;
        this.semaforo = semaphore;
    }

    private void processar() {
        try {
            System.out.println("Produção do produto " + (idThread + 1) + " em andamento");
            Thread.sleep((long) (Math.random() * 8000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void entrarEmLinha() {
        System.out.println("Produção do produto " + (idThread + 1)
                + " entrando em Linha");
        fabrica.usarMateriaPrima();
        processar();
        System.out.println("Produção do produto " + (idThread + 1) + " saindo da Linha");
    }

    public static void main(String[] args) {
        int numeroDePermicoes = 1;
        int numeroDeProcessos = 6;
        Semaphore semaphore = new Semaphore(numeroDePermicoes);
        Fabrica[] processos = new Fabrica[numeroDeProcessos];
        for (int i = 0; i < numeroDeProcessos; i++) {
            processos[i] = new Fabrica(i, semaphore);
            processos[i].start();
        }
    }

    public void run() {
        //SEM CONTROLE
        entrarEmLinha();
        System.out.println("Volume de matéria prima: " + fabrica.getMateriaPrima() + " Kg");

        //COM CONTROLE
//        try {
//            semaforo.acquire();
//            entrarEmLinha();
//            System.out.println("Volume de matéria prima: " + fabrica.getMateriaPrima() + " Kg");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            semaforo.release();
//       }


    }
}
