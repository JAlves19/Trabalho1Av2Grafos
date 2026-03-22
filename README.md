# 🗺️ Simulador de Rotas - Nordeste Brasileiro (Grafos)

Este projeto utiliza a teoria de grafos para modelar as conexões terrestres entre os 9 estados da Região Nordeste do Brasil. Ele permite calcular rotas e analisar a conectividade da malha rodoviária interestadual utilizando algoritmos de busca clássicos.

## 🚀 Funcionalidades

O programa processa um grafo de 9 vértices e 15 arestas (fronteiras reais) e oferece:
- **Busca por Siglas:** Entrada amigável (ex: "CE", "BA") em vez de números de ID.
- **Verificação de Conectividade:** Checa se existe um caminho entre dois estados.
- **Busca em Profundidade (DFS):** Explora o grafo indo o mais longe possível em cada ramo antes de retroceder.
- **Busca em Largura (BFS):** Encontra o **caminho mais curto** (menor número de fronteiras) entre a origem e o destino.
- **Análise de Alcance:** Lista todos os estados que podem ser visitados a partir de um ponto de partida.
- **Ordem de Visita:** Exibe a sequência exata de exploração de cada algoritmo.

## 📍 Mapeamento de Estados
O sistema reconhece as seguintes siglas:
`AL, BA, CE, MA, PB, PE, PI, RN, SE`

## 📂 Estrutura do Projeto

- `src/`: Contém todo o código-fonte Java, incluindo a lógica principal e as implementações de suporte para Grafos (In, Bag, Graph, DFS e BFS).
- `dados/`: Contém o arquivo `trabalho.txt` com a matriz de adjacência do grafo (vértices e arestas).

## 🛠️ Como Executar

### Pré-requisitos
- Java JDK 8 ou superior instalado.

### Instruções:
1. Abra a pasta raiz do projeto em sua IDE (recomendado: VS Code).
2. O projeto foi estruturado para ser independente, contendo todas as classes necessárias na pasta `src/`.
3. Execute o arquivo `src/Main.java`.
4. Digite a sigla de origem e destino quando solicitado no terminal.

## 🧠 Diferença entre os Algoritmos (Resumo)

- **DFS (Depth-First Search):** Mergulha verticalmente no grafo. Útil para verificar conectividade total, mas pode gerar caminhos longos e "tortuosos".
- **BFS (Breadth-First Search):** Expande-se horizontalmente como uma onda. É o algoritmo ideal para determinar o caminho com o menor número de conexões (fronteiras) entre os estados.

---
**Disciplina:** Resolução de problemas com grafos.