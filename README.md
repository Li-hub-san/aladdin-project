# Projecto Alladin

Este projecto foi realizado no âmbito da disciplina **Processos de Desenvolvimento de Software**, leccionada no curso de
programação Java oferecido pela Startup Madeira na iniciativa Requalificar + Digital.

O enunciado do projecto encontra-se abaixo, sub-dividido pelas diferentes funcionalidades requeridas, com links para os
ficheiros/linhas onde as mesmas se encontram implementadas.

## Problema

> Aplicando os conceitos OO que já conhece, concretize as classes necessárias para representar a funcionalidade que se descreve de seguida. Pode ser necessária a criação de classes adicionais não descritas abaixo. A correcta execução dos testes depende da estrita aderência à nomenclatura das classes apresentadas.

## Funcionalidade da lâmpada mágica

> Uma lâmpada mágica liberta génios quando esfregada (método rub).

:white_check_mark: A [`MagicLamp`](/src/models/MagicLamp.java) deverá ter um método [`rub()`](/src/models/MagicLamp.java#L75), cujo
retorna uma nova instância de um [`Genie`](/src/models/Genie.java).

> Os génios podem ser bem ou mal-humorados.

[x] O [`Genie`](/src/models/Genie.java) deverá ter as sub-classes [`HappyGenie`](/src/models/HappyGenie.java)
e [`GrumpyGenie`](/src/models/GrumpyGenie.java).

> O humor dos génios é determinado pelas condições da lâmpada: sempre que a lâmpada tiver sido esfregada um número par de vezes (sem contar a actual), o génio sai mal-humorado.

[x] Quando [`rubCounter`](/src/models/MagicLamp.java#L41) for par (sem contar a actual), retornar
um [`GrumpyGenie`](/src/models/GrumpyGenie.java) [(link para implementação)](/src/models/MagicLamp.java#L83)
.

> A quantidade de génios disponíveis é determinada no momento de encantamento da lâmpada (criação).

[x] O [`genieLimit`](/src/models/MagicLamp.java#L14) é definido no [construtor](/src/models/MagicLamp.java#L58)
da [`MagicLamp`](/src/models/MagicLamp.java).

> Depois de esgotados os génios disponíveis, já não adianta esfregar a lâmpada para obter um génio, bem ou mal-humorado: nestas condições, a lâmpada cria um pequeno demónio que responde a pedidos de forma literal mas perversa.

[x] Quando [`getAvailableGenies()`](/src/models/MagicLamp.java#L134) é igual a
0, [`rub()`](/src/models/MagicLamp.java#L75) devolve
um [`Demon`](/src/models/Demon.java) [(link para implementação)](/src/models/MagicLamp.java#L76).

> Devido a requisitos de sustentabilidade ambiental, as normas de produção exigem que as lâmpadas sejam recarregáveis.

[x] A [`MagicLamp`](/src/models/MagicLamp.java) deverá ter um método [`recharge()`](/src/models/MagicLamp.java#L103).

> Assim, é possível voltar a obter génios quando se esfrega a lâmpada (em número igual ao inicial).

[x] O método [`recharge()`](/src/models/MagicLamp.java#L103)
deverá [possibilitar o criação de mais génios](/src/models/MagicLamp.java#L105), em número igual
ao [`originalLimit`](/src/models/MagicLamp.java#L26), ao fazer [`rub()`](/src/models/MagicLamp.java#L75).

> O processo de recarregamento exige apenas que um demónio seja alimentado à lâmpada.

[x] O método [`recharge()`](/src/models/MagicLamp.java#L103) deverá requerer um [`Demon`](/src/models/Demon.java)
e [alimentá-lo](/src/models/MagicLamp.java#L106)
à [`MagicLamp`](/src/models/MagicLamp.java).

> Quando se cria uma nova lâmpada é necessário indicar a quantidade inicial de génios que é possível invocar.

[x] O construtor da [`MagicLamp`](/src/models/MagicLamp.java) deverá requerer
o [`genieLimit`](/src/models/MagicLamp.java#L58).

> É possível saber quantos génios ainda estão disponíveis na lâmpada.

[x] A [`MagicLamp`](/src/models/MagicLamp.java) deverá implementar o
método [`getAvailableGenies()`](/src/models/MagicLamp.java#L134).

> É ainda possível saber quantas vezes a lâmpada já foi recarregada.

[x] A [`MagicLamp`](/src/models/MagicLamp.java) deverá implementar o
método [`getRechargeCounter()`](/src/models/MagicLamp.java#L146).

> Quando se esfrega a lâmpada, deve-se indicar quantos desejos se espera que o génio realize (independentemente de o génio os poder negar).

[x] O método [`rub()`](/src/models/MagicLamp.java#L75) deverá requerer
o [`expectedWishCount`](/src/models/MagicLamp.java#L75), cujo será utilizado para inicializar
os [`Genie`](/src/models/Genie.java)s.

> Nota: a lâmpada liberta apenas um génio de cada vez.

[x] O método [`rub()`](/src/models/MagicLamp.java#L75) cria apenas um [`Genie`](/src/models/Genie.java) de cada vez.

## Funcionalidade do génio bem-humorado

> O génio bem-humorado concede todos os desejos que lhe forem colocados, até ao limite com que foi chamado da lâmpada. Depois do limite já não são concedidos desejos.

[x] No [`grantWish()`](/src/models/HappyGenie.java#L31)
do [`HappyGenie`](/src/models/HappyGenie.java)
, [concede todos os desejos até o limite ser atingido](/src/models/HappyGenie.java#L32).

> É possível saber quantos desejos já foram concedidos

[x] O [`HappyGenie`](/src/models/HappyGenie.java) deverá implementar o
método [`getGrantedWishes()`](/src/models/Genie.java#L74).

> e quantos ainda existem disponíveis.

[x] O [`HappyGenie`](/src/models/HappyGenie.java) deverá implementar o
método [`getAvailableWishes()`](/src/models/Genie.java#L56).

> Nota: o génio concede apenas um desejo de cada vez.

[x] O
método [`grantWish()`](/src/models/HappyGenie.java#L31) [concede apenas um desejo de cada vez](/src/models/HappyGenie.java#L31)
.

## Funcionalidade do génio mal-humorado

> O génio mal-humorado concede apenas o primeiro desejo que lhe for colocado, independentemente do limite com que foi chamado da lâmpada.

[x] No [`grantWish()`](/src/models/GrumpyGenie.java#L31)
do [`GrumpyGenie`](/src/models/GrumpyGenie.java)
, [concede apenas um desejo](/src/models/GrumpyGenie.java#L31) independentemente
do [`wishCounter`](/src/models/Genie.java#L21).

> É possível saber se o desejo já foi realizado.

[x] O [`GrumpyGenie`](/src/models/GrumpyGenie.java) deverá implementar o
método [`wishHasBeenGranted()`](/src/models/GrumpyGenie.java#L46).

## Funcionalidade do demónio reciclável

> O demónio concede todos os desejos que lhe forem colocados, independentemente do limite com que foi chamado da lâmpada.

[x] No [`grantWish()`](/src/models/Demon.java#L51)
do [`Demon`](/src/models/Demon.java), [concede todos os desejos](/src/models/Demon.java#L52).

> Se o demónio for recolocado na lâmpada (para a recarregar), já não pode realizar mais desejos.

[x] No [`grantWish()`](/src/models/Demon.java#L51)
do [`Demon`](/src/models/Demon.java)
, após o [`Demon`](/src/models/Demon.java) ser recolocado na
lâmpada [já não pode realizar mais desejos](/src/models/Demon.java#L52).

> É possível saber quantos desejos já foram concedidos.

[x] O [`Demon`](/src/models/Demon.java) deverá implementar o método [`getGrantedWishes()`](/src/models/Genie.java#L74).

> Nota: o demónio concede apenas um desejo de cada vez.

[x] O
método [`grantWish()`](/src/models/Demon.java#L51) [concede apenas um desejo de cada vez](/src/models/Demon.java#L51)
.

## Diagrama de classes dos modelos

![Diagrama de classes dos modelos](/src/resources/models.png "Diagrama de classes dos modelos")
