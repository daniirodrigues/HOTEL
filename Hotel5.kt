//5) Álcool ou gasolina?

fun main() {

    val nome = String

    var alcool_Wayne_Oil = 0.0
    var gasolina_Wayne_Oil = 0.0

    var alcool_Stark_Petrol = 0.0
    var gasolina_Stark_Petrol = 0.0


    println("Qual o valor do álcool no posto Wayne Oil?")
    alcool_Wayne_Oil = readln().toDouble()

    println("Qual o valor da gasolina no posto Wayne Oil?")
    gasolina_Wayne_Oil = readln().toDouble()


    println("Qual o valor do álcool no posto Stark Petrol?")
    alcool_Stark_Petrol = readln().toDouble()

    println("Qual o valor da gasolina no posto Stark Petrol?")
    gasolina_Stark_Petrol = readln().toDouble()



    // Regra: O álcool só compensa se for 30% mais barato que a gasolina
    val alcoolCompensaWayne = alcool_Wayne_Oil <= gasolina_Wayne_Oil * 0.7
    val alcoolCompensaStark = alcool_Stark_Petrol <= gasolina_Stark_Petrol * 0.7

    // Calculando o custo total para abastecer 42 litros
    val custoAlcoolWayne = alcool_Wayne_Oil * 42
    val custoGasolinaWayne = gasolina_Wayne_Oil * 42
    val custoAlcoolStark = alcool_Stark_Petrol * 42
    val custoGasolinaStark = gasolina_Stark_Petrol * 42

    // Determinando a melhor opção de abastecimento
    val (melhorPosto, melhorCombustivel) = when {
        alcoolCompensaWayne && custoAlcoolWayne <= custoAlcoolStark -> "Wayne Oil" to "álcool"
        alcoolCompensaStark && custoAlcoolStark < custoAlcoolWayne -> "Stark Petrol" to "álcool"
        custoGasolinaWayne <= custoGasolinaStark -> "Wayne Oil" to "gasolina"
        else -> "Stark Petrol" to "gasolina"
    }

    println("$nome, é mais barato abastecer com $melhorCombustivel no posto $melhorPosto.")
}