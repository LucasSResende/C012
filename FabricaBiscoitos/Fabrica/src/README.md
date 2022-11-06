<h1> Trabalho de seção crítica </h1>

Projeto baseado em uma ideia simples de uma linha de produção de biscoitos.

Os comentários na Main:

```
entrarEmLinha();
System.out.println("Volume de matéria prima: " + fabrica.getMateriaPrima() + " Kg");
```
São para rodar o código de seção crítica sem controle
E a parte logo abaixo do código:

```
    try {
        semaforo.acquire();
        entrarEmLinha();
        System.out.println("Volume de matéria prima: " + fabrica.getMateriaPrima() + " Kg");
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        semaforo.release();
    }
```
