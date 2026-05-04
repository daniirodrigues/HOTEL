var nome = ""
val hotelNome = "Hotel Panema
val valorDiaria = 100.0
val quartos = BooleanArray(20) { false }
var continuar = true

fun lerInt(mensagem: String): Int? {
    print(mensagem)
    return readln().toIntOrNull()
}

fun exibirQuartos() {
    println("\nStatus dos quartos:")
    quartos.forEachIndexed { index, ocupado ->
        val status = if (ocupado) "Ocupado" else "Livre"
        println("Quarto ${index + 1}: $status")
    }
}

fun validarSenha(): Boolean {
    print("Informe a senha: ")
    val senha = readln()

    if (senha == "1334") return true

    println("Senha inválida.")
    return false
}

fun realizarReserva() {
    val dias = lerInt("Quantas diárias serão necessárias? ")

    if (dias == null || dias !in 1..30) {
        println("Valor inválido, $nome")
        return
    }

    val total = valorDiaria * dias
    println("O valor de $dias dias é R$$total")

    print("Nome do hóspede: ")
    val hospede = readln()

    var numeroQuarto: Int

    while (true) {
        numeroQuarto = lerInt("Escolha o quarto (1-20): ") ?: continue

        if (numeroQuarto !in 1..20) {
            println("Quarto inválido.")
        } else if (quartos[numeroQuarto - 1]) {
            println("Quarto ocupado.")
        } else {
            break
        }
    }

    println("Quarto disponível!")

    print("Confirmar reserva (S/N)? ")
    val confirmacao = readln()

    if (confirmacao.equals("S", true)) {
        quartos[numeroQuarto - 1] = true
        println("Reserva confirmada para $hospede.")
    }

    exibirQuartos()
}

fun inicio() {
    println("Bem-vindo ao $hotelNome!")
    print("Seu nome: ")
    nome = readln()

    while (!validarSenha()) {}

    while (continuar) {
        println("\n1. Reservar")
        println("2. Ver quartos")
        println("3. Sair")

        when (lerInt("Escolha: ")) {
            1 -> realizarReserva()
            2 -> exibirQuartos()
            3 -> {
                println("Até logo, $nome!")
                continuar = false
            }
            else -> println("Opção inválida.")
        }
    }
}

fun main() {
    inicio()
}