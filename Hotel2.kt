fun cadastroHospedes() {
    println("Qual o valor padrão da diária?")
    val valorPadrao = readln().toDoubleOrNull() ?: return

    var total = 0.0
    var gratuidade = 0
    var meia = 0

    while (true) {
        println("Nome do hóspede:")
        val nome = readln()

        println("Idade do hóspede:")
        val idade = readln().toIntOrNull() ?: continue

        when {
            idade < 6 -> {
                println("$nome possui gratuidade.")
                gratuidade++
            }
            idade > 60 -> {
                println("$nome paga meia.")
                meia++
                total += valorPadrao / 2
            }
            else -> {
                println("$nome paga inteira.")
                total += valorPadrao
            }
        }

        println("Digite 'PARE' para encerrar ou ENTER para continuar:")
        val opcao = readln()

        if (opcao.equals("PARE", true)) {
            println("\nResumo:")
            println("Total: R$ %.2f".format(total))
            println("Gratuidades: $gratuidade")
            println("Meias: $meia")
            break
        }
    }
}