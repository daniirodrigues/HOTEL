fun cadastrarHospedes() {
    val listaHospedes = mutableListOf(
        "João Silva",
        "Ana Souza",
        "Lucas Pereira",
        "Mariana Costa",
        "Pedro Almeida",
        "Fernanda Oliveira",
        "Gustavo Santos",
        "Camila Rocha",
        "Bruno Ribeiro",
        "Juliana Martins",
        "Rafael Gomes",
        "Larissa Carvalho",
        "Diego Fernandes",
        "Patrícia Lima",
        "Felipe Barbosa"
    )

    while (true) {
        println("""
Cadastro de Hóspedes
1. Cadastrar
2. Pesquisar
3. Sair
""")

        when (readln().toIntOrNull()) {
            1 -> cadastrarNovoHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> break
            else -> println("Opção inválida.")
        }
    }
}