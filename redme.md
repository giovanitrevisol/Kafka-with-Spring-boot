Meu primeiro projeto utilizando Kafka.

Criando dois microservicos de forma simples:
 - o producer que via endpoint recebe as informações e envia para o kafka.
 - o consumer que fica esperando receber alguma informação e apenas exibe o que recebeu.

 requisição Post a ser enviada
 {
    "regiao": "regiao",
    "quantidade": "1527"
 }

 Para usar o kafka, ele precisa ser iniciado.
 criei um docker-compose para isso, basta rodar docker-compose up -d.
 caso não queira usar o docker vou deixar aqui os comandos utilizados.




 Sem usar docker:

1 - Baixar o Apache kafka e extrair os arquivos
https://kafka.apache.org/downloads


2 - Com os arquivos extraidos, dentro da pasta "bin" vamos usar os arquivos:
- kafka-topics
- kafka-console-consumer
- kafka-console-producer
- zookeeper-server-start
- zookeeper-server-stop
- kafka-server-start
- kafka-server-stop

na pasta do kafka abra terminal
bin/zookeeper-server-start.sh config/zookeeper.properties
   pode ser que ao rodar este comando seja exibida uma mensagem do tipo:
   Please build the jproject first by ronning './gradlew jar - PscalaVersion=2.XX'
      basta executar o comando conforme aparecer na mensagem. e rode novamente o comando
      bin/zookeeper-server-start.sh config/zookeeper.properties

abra um novo terminal e execute:
bin/kafka-server-start.sh config/server.properties

Neste ponto temos o Zookeeper e o Kafka iniciados vamos criar um topico

bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1 --topic myTopic
veja:
--create: para criar um novo topic
--bootstrap-server : define em qual kafka vamos nos conectar (localhost:9092)
--partitions quantidade de partições que nosso tópico vai ter
--replication-factor - replicação das mensagem que são enviadas para cada broker
--topic nome do tópico

para listar uos tópicos:
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

Criando nosso producer
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic myTopic
ao precionar enter aparecerá ">" entao basta digitar a mensgem e precionar enter para enviar.

criando nosso consumer
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic myTopic
   para que server o --group: para que exista um controle de mensagem que foram lidas.
   Podemos criar dois gropus para o mesmo topic assim a mesagem é enviada para os dois grupos

