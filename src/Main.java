import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] estados = { "AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE" };

        // 1. Carregar os dados
        In in = new In("dados/trabalho.txt");
        Graph G = new Graph(in);

        Map<String, Integer> mapaEstados = new HashMap<>();
        for (int i = 0; i < estados.length; i++) {
            mapaEstados.put(estados[i], i);
        }

        // 2. Interação com usuário
        Scanner scanner = new Scanner(System.in);
//        System.out.println("0:AL, 1:BA, 2:CE, 3:MA, 4:PB, 5:PE, 6:PI, 7:RN, 8:SE");
//        System.out.print("Origem (ID): ");
//        int X = scanner.nextInt();
//        System.out.print("Destino (ID): ");
//        int Y = scanner.nextInt();
        System.out.println("Estados disponíveis: AL, BA, CE, MA, PB, PE, PI, RN, SE");

        System.out.print("Digite a sigla da Origem (ex: CE): ");
        String siglaX = scanner.next().toUpperCase();
        System.out.print("Digite a sigla do Destino (ex: BA): ");
        String siglaY = scanner.next().toUpperCase();

        if (!mapaEstados.containsKey(siglaX) || !mapaEstados.containsKey(siglaY)) {
            System.err.println("Erro: Sigla inválida digitada!");
            return;
        }

        int X = mapaEstados.get(siglaX);
        int Y = mapaEstados.get(siglaY);

        // 3. Rodar as buscas
        DepthFirstPaths dfs = new DepthFirstPaths(G, X);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, X);

        // 4. Mostrar Resultados
        System.out.println("\n--- RESULTADOS ---");

        // Pergunta 1
        System.out.println("Existe caminho? " + (dfs.hasPathTo(Y) ? "Sim" : "Nao"));
        
        // Pergunta 2
        System.out.print("Caminho DFS: ");
        imprimir(dfs.pathTo(Y), estados);

        // Pergunta 3
        System.out.print("Caminho BFS: ");
        imprimir(bfs.pathTo(Y), estados);

        // Pergunta 4
        System.out.print("Estados alcançáveis a partir de " + estados[X] + ": ");
        boolean encontrouAlgum = false;

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v) && v != X) {
                System.out.print(estados[v] + " ");
                encontrouAlgum = true;
            }
        }

        if (!encontrouAlgum) {
            System.out.print("Nenhum outro estado.");
        }
        System.out.println();


        // Pergunta 5
        System.out.print("Ordem de Visita DFS: ");
        imprimir(dfs.getOrder(), estados);

        // Pergunta 6
        System.out.print("Ordem de Visita BFS: ");
        imprimir(bfs.getOrder(), estados);
    }

    private static void imprimir(Iterable<Integer> list, String[] nomes) {
        if (list == null) {
            System.out.println("Nenhum.");
            return;
        }
        for (int v : list)
            System.out.print(nomes[v] + " ");
        System.out.println();
    }
}
