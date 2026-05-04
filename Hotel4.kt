import kotlin.math.ceil

fun organizarEvento() {
    println("Parte 1: Quantidade de Convidados")
    print("Qual o número de convidados para o seu evento? ")
    val convidados = readln().toIntOrNull() ?: return

    if (convidados < 0 || convidados > 350) {
        println("Quantidade de convidados superior à capacidade máxima")
        return
    }

    val auditorio = if (convidados <= 150) "Laranja" else "Colorado"
    val cadeirasExtras = if (convidados in 151..350) convidados - 150 else 0

    println("Use o auditório $auditorio${if (cadeirasExtras > 0) " (inclua mais $cadeirasExtras cadeiras)" else ""}")
    println("Agora vamos ver a agenda do evento.")

    println("Parte 2: Agenda")
    print("Qual o dia do evento? ")
    val diaSemana = readln().lowercase()

    print("Qual é a hora do evento? ")
    val hora = readln().toIntOrNull() ?: return

    val disponivel = when (diaSemana) {
        "segunda", "terça", "quarta", "quinta", "sexta" -> hora in 7..23
        "sábado", "domingo" -> hora in 7..15
        else -> false
    }

    if (!disponivel) {
        println("Auditório indisponível")
        return
    }

    print("Qual o nome da empresa? ")
    val empresa = readln()

    println("Auditório reservado para $empresa. ${diaSemana.replaceFirstChar { it.uppercase() }} às ${hora}h.")

    println("Parte 3: Equipe de Serviço")
    print("Qual a duração do evento em horas? ")
    val duracao = readln().toIntOrNull() ?: return

    val garcons = ceil(convidados / 12.0).toInt() + (duracao / 2)
    val custoGarcons = garcons * 10.50 * duracao

    println("São necessários $garcons garçons.")
    println("Custo: R$ %.2f".format(custoGarcons))

    println("Parte 4: Buffet")

    val cafe = convidados * 0.2
    val agua = convidados * 0.5
    val salgados = convidados * 7

    val custoCafe = cafe * 0.80
    val custoAgua = agua * 0.40
    val custoSalgados = ceil(salgados / 100.0) * 34.0
    val custoBuffet = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de ${cafe.toInt()}L de café, ${agua.toInt()}L de água, $salgados salgados.")

    println("Parte 5: Conferência")
    println("Evento no Auditório $auditorio")
    println("Empresa: $empresa")
    println("Data: ${diaSemana.replaceFirstChar { it.uppercase() }}, ${hora}h às ${hora + duracao}h")
    println("Duração: ${duracao}h")
    println("Garçons: $garcons")
    println("Convidados: $convidados")
    println("Custo garçons: R$ %.2f".format(custoGarcons))
    println("Custo buffet: R$ %.2f".format(custoBuffet))
    println("Total: R$ %.2f".format(custoGarcons + custoBuffet))

    print("Gostaria de efetuar a reserva? S/N: ")
    val resposta = readln()

    if (resposta.equals("S", true)) {
        println("$empresa, reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }
}