var nome = ""
val hotelNome = "Hotel Panema" // Corrigido: fechamento de aspas
val valorDiaria = 100.0
val quartos = BooleanArray(20) { false }
var continuar = true

fun lerInt(mensagem: String): Int? {
    print(mensagem)
    // toIntOrNull evita que o programa quebre se o usuário digitar letras
    return readlnOrNull()?.toIntOrNull()
}

fun exibirQuartos() {
    println("\n--- Status dos Quartos ---")
    quartos.forEachIndexed { index, ocupado ->
        val status = if (ocupado) "Ocupado" else "Livre"
        println("Quarto ${index + 1}: $status")
    }
}

fun validarSenha(): Boolean {
    print("Informe a senha de acesso: ")
    val senha = readln()

    if (senha == "1334") return true

    println("Senha inválida. Tente novamente.")
    return false
}

fun realizarReserva() {
    val dias = lerInt("Quantas diárias serão necessárias? ")

    // Validação de diárias (máximo 30 dias)
    if (dias == null || dias !in 1..30) {
        println("Valor inválido, $nome. O período deve ser entre 1 e 30 dias.")
        return
    }

    val total = valorDiaria * dias
    println("O valor de $dias diária(s) é R$$total")

    print("Nome do hóspede: ")
    val hospede = readln()
    
    if (hospede.isBlank()) {
        println("Nome do hóspede não pode ser vazio.")
        return
    }

    var numeroQuarto: Int = 0

    // Loop para encontrar um quarto válido e disponível
    while (true) {
        val entrada = lerInt("Escolha o quarto (1-20): ")
        if (entrada == null || entrada !in 1..20) {
            println("Quarto inválido. Digite um número entre 1 e 20.")
            continue
        }

        if (quartos[entrada - 1]) {
            println("Quarto já está ocupado. Escolha outro.")
        } else {
            numeroQuarto = entrada
            break
        }
    }

    println("Quarto $numeroQuarto está disponível!")
    print("Confirmar reserva para $hospede (S/N)? ")
    val confirmacao = readln()

    if (confirmacao.equals("S", ignoreCase = true)) {
        quartos[numeroQuarto - 1] = true
        println("Reserva confirmada com sucesso para $hospede no quarto $numeroQuarto.")
    } else {
        println("Reserva cancelada.")
    }

    exibirQuartos()
}

fun inicio() {
    println("--- Bem-vindo ao $hotelNome ---")
    print("Por favor, informe seu nome: ")
    nome = readln()

    // O programa só segue se a senha estiver correta
    while (!validarSenha()) { }

    println("\nOlá $nome, é um prazer ter você conosco!")

    while (continuar) {
        println("\nMENU PRINCIPAL")
        println("1. Realizar Reserva")
        println("2. Verificar Status dos Quartos")
        println("3. Sair")

        when (lerInt("Escolha uma opção: ")) {
            1 -> realizarReserva()
            2 -> exibirQuartos()
            3 -> {
                println("Muito obrigado e até logo, $nome!")
                continuar = false
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun main() {
    inicio()
}
