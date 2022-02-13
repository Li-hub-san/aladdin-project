# aladdin-project

# Problema

Aplicando os conceitos OO que já conhece, concretize as classes necessárias para representar a
funcionalidade que se descreve de seguida. Pode ser necessária a criação de classes adicionais não
descritas abaixo. A correcta execução dos testes depende da estrita aderência à nomenclatura das
classes apresentadas.

# Funcionalidade da lâmpada mágica

Uma lâmpada mágica liberta génios quando esfregada (método rub). Os génios podem ser bem ou mal-
humorados. O humor dos génios é determinado pelas condições da lâmpada: sempre que a lâmpada tiver
sido esfregada um número par de vezes (sem contar a actual), o génio sai mal-humorado. A quantidade
de génios disponíveis é determinada no momento de encantamento da lâmpada (criação). Depois de
esgotados os génios disponíveis, já não adianta esfregar a lâmpada para obter um génio, bem ou mal-
humorado: nestas condições, a lâmpada cria um pequeno demónio que responde a pedidos de forma
literal mas perversa. Devido a requisitos de sustentabilidade ambiental, as normas de produção
exigem que as lâmpadas sejam recarregáveis. Assim, é possível voltar a obter génios quando se
esfrega a lâmpada (em número igual ao inicial). O processo de recarregamento exige apenas que um
demónio seja alimentado à lâmpada.
<br>**Quando se cria uma nova lâmpada é necessário indicar a quantidade inicial de génios que é
possível invocar**.
<br>É possível saber quantos génios ainda estão disponíveis na lâmpada.
<br>É ainda possível saber quantas vezes a lâmpada já foi recarregada.
<br>Quando se esfrega a lâmpada, deve-se indicar quantos desejos se espera que o génio realize (
independentemente de o génio os poder negar).
<br>Nota: a lâmpada liberta apenas um génio de cada vez.

# Funcionalidade do génio bem-humorado

O génio bem-humorado concede todos os desejos que lhe forem colocados, até ao limite com que foi
chamado da lâmpada. Depois do limite já não são concedidos desejos. É possível saber quantos desejos
já foram concedidos e quantos ainda existem disponíveis. Nota: o génio concede apenas um desejo de
cada vez. Funcionalidade do génio mal-humorado O génio mal-humorado concede apenas o primeiro desejo
que lhe for colocado, independentemente do limite com que foi chamado da lâmpada. É possível saber
se o desejo já foi realizado.

# Funcionalidade do demónio reciclável

O demónio concede todos os desejos que lhe forem colocados, independentemente do limite com que foi
chamado da lâmpada. Se o demónio for recolocado na lâmpada (para a recarregar), já não pode realizar
mais desejos. É possível saber quantos desejos já foram concedidos.
<br>Nota: o demónio concede apenas um desejo de cada vez.