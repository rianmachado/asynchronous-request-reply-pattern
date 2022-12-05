## Asynchronous Request Reply Pattern

No desenvolvimento de aplicativos modernos, é normal que os aplicativos cliente — geralmente códigos executados em um cliente da Web (navegador) — dependam de APIs remotas para fornecer lógica de negócios e funcionalidade de composição. Essas APIs podem estar diretamente relacionadas ao aplicativo ou podem ser serviços compartilhados fornecidos por terceiros. Normalmente, essas chamadas de API ocorrem no protocolo HTTP(S) e seguem a semântica REST.

Na maioria dos casos, as APIs para um aplicativo cliente são projetadas para responder rapidamente, na ordem de 100 ms ou menos. Muitos fatores podem afetar a latência da resposta, incluindo:

A pilha de hospedagem de um aplicativo.
Componentes de segurança.
A localização geográfica relativa do chamador e do back-end.
Infraestrutura de rede.
Carga atual.
O tamanho da carga útil da solicitação.
Comprimento da fila de processamento.
O tempo para o back-end processar a solicitação.
Qualquer um desses fatores pode adicionar latência à resposta. Alguns podem ser mitigados expandindo o back-end. Outros, como infraestrutura de rede, estão fora do controle do desenvolvedor do aplicativo. A maioria das APIs pode responder com rapidez suficiente para que as respostas cheguem de volta pela mesma conexão. O código do aplicativo pode fazer uma chamada de API síncrona de maneira não bloqueante, dando a aparência de processamento assíncrono, o que é recomendado para operações vinculadas a E/S.

Em alguns cenários, no entanto, o trabalho feito pelo back-end pode ser de longa duração, na ordem de segundos, ou pode ser um processo em segundo plano executado em minutos ou mesmo horas. Nesse caso, não é viável esperar a conclusão do trabalho antes de responder à solicitação. Essa situação é um problema potencial para qualquer padrão de solicitação-resposta síncrona.

Algumas arquiteturas resolvem esse problema usando um message broker para separar os estágios de solicitação e resposta. Essa separação geralmente é obtida pelo uso do padrão de nivelamento de carga baseado em fila . Essa separação pode permitir que o processo do cliente e a API de back-end sejam dimensionados de forma independente. Mas essa separação também traz complexidade adicional quando o cliente requer notificação de sucesso, pois essa etapa precisa se tornar assíncrona.

Muitas das mesmas considerações discutidas para aplicativos cliente também se aplicam a chamadas de API REST de servidor para servidor em sistemas distribuídos — por exemplo, em uma arquitetura de microsserviços.


## Pré requisitos
* Java 11 and later
* Lombok
* Docker (Para execução do Postgres)

## Start da aplicação
- inicie o containner Postgres
`docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 --name quarkus_test -e POSTGRES_USER=quarkus_test -e POSTGRES_PASSWORD=quarkus_test -e POSTGRES_DB=quarkus_test -p 5432:5432 postgres:11.5`

- inicie o containner Redis
 e o Redis  execute: `docker run -d -p 6379:6379 -i -t redis`

- Agora vamos realizar o start da aplicação `mvn compile quarkus:dev`
