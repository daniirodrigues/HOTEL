fun main() {
    print("Qual o seu nome? ")
    val nome = readln()

    var menorValor = Double.MAX_VALUE
    var empresaMaisBarata = ""

    do {
        println("Qual o nome da empresa?")
        val empresa = readln()

        println("Qual o valor por aparelho?")
        val valorPorAparelho = readln().toDouble()

        println("Qual a quantidade de aparelhos?")
        val quantidadeAparelhos = readln().toInt()

        println("Qual a porcentagem de desconto?")
        val percentualDesconto = readln().toDouble()

        println("Qual o número mínimo de aparelhos para conseguir o desconto?")
        val quantidadeMinimaParaDesconto = readln().toInt()

        // Calculando o valor total sem desconto
        var total = valorPorAparelho * quantidadeAparelhos

        // Aplicando desconto, se aplicável
        if (quantidadeAparelhos >= quantidadeMinimaParaDesconto) {
            total -= total * (percentualDesconto / 100)
        }

        println("O serviço de $empresa custará R$ ${"%.2f".format(total)}")

        // Verifica se esse é o menor orçamento até agora
        if (total < menorValor) {
            menorValor = total
            empresaMaisBarata = empresa
        }

        print("Deseja informar novos dados, $nome? (S/N) ")
        val resposta = readln().uppercase()
    } while (resposta == "S")

    println("O orçamento de menor valor é o de $empresaMaisBarata por R$ ${"%.2f".format(menorValor)}")
}