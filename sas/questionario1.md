## Questionário semana 2
### Questão 1:
Imagine uma empresa na qual você gostaria de trabalhar. Escolha um serviço de TIC que esta empresa possui e crie um exemplo de política de uso (um aspecto), cite um mecanismo necessário para implantação desta política e uma prática que trará um incremento na cultura dos usuários.  
Por exemplo:  
Imaginei uma empresa de turismo e pensei no sistema de venda de passagens. No processo de venda preciso coletar alguns dados do passageiro e da sua viagem. Essa informação é sensível, pois revela dados pessoais importantes do meu cliente (período que estará ausente, para onde vai, com quem vai, classe de assento no avião, onde ficará hospedado, etc...).  
Uma possível Política seria: Os dados do passageiro e da viagem devem ser protegidos de acessos indevidos e sua divulgação proibida. Somente quem realizou a venda e superiores podem ter acesso a estas informações.  
Um mecanismo seria: Sistema de vendas com proteção de dados por criptografia na base de dados, acesso restrito no sistema com vínculo com a conta do vendedor, registro (log) de acessos ao sistemas e registro de visualização dos dados dos passageiros.  
Uma forma de ampliar a cultura seria: treinamento dos vendedores em encontro presencial onde se discute possíveis problemas na divulgação de informações sensíveis de passageiros como roubo de residências, sequestros, informações financeiras, etc.
Agora é a sua vez. :-)  
***  
### Resposta
Usarei o local onde trabalho como exemplo, a Fundação de Atendimento Sócio-Educativo do Rio Grande do Sul. Na elaboração dos Planos de Atendimento Individual (PIA) dos socioeducandos é necessário total sigilo com os dados que identifiquem os mesmos para garantir o cumprimento do disposto no ECA, SINASE e PEMSEIS. Esse plano é multidisciplinar e envolve profissionais como Pedagogos, Assistentes Sociais, Psicólogos, Advogados e técnicos em Recreação.  
Uma possível política seria proteger os dados e permitir que somente as pessoas autorizadas possam visualizar e editar os documentos necessários para a elaboração do PIA.  
O mecanismo seria a utilização de computadores com usuários individuais, adoção do sistema Microsoft Teams com o pacote Office Online, em que o armazenamento dos documentos será realizado na nuvem e será possível adicionar os usuários autorizados para que possam editar e visualizar os arquivos, com controle de versão do próprio sistema da Microsoft.  
Uma forma de ampliar a cultura seria a capacitação dos usuários com a plataforma da Microsoft para que conheçam todos os seus recursos, que não se restringem somente aos emails trocados pelo Outlook e as reuniões realizadas pelo Teams.  
Obs.: A FASE, juntamente com os demais órgãos do estado, adotaram recentemente o serviço da Microsoft, os emails foram migrados do Expresso para o Outlook e as reunião foram padronizadas no Teams, mas o sistema continua sem ser utilizado em sua totalidade e os computadores continuam com usuário único de livre acesso para todos os funcionários.  

***  
***  
### Questão 2:  
No mecanismo de TIC que você imaginou, descreva como será realizada a proteção dos dados nos atributos de segurança computacional: confidencialidade, autenticidade, integridade e disponibilidade.  
No meu exemplo, o sistema de venda de passagens teria:  
Criptografia de dados para garantia da sua confidencialidade, com acesso restrito ao usuário que realizou a venda e usuários com privilégios especiais (superiores ao vendedor). Teria também restrição quanto a impressão dos dados - teria um cadastro de impressoras com privilégios de impressão diferentes, impedindo que por engano dados de um passageiro sejam impressos em algum lugar onde pessoas não autorizadas possam vê-los. Implementaria também restrições quanto a cópias de segurança (impedindo uso de pen drives, por exemplo).  
A autenticidade seria garantida por usuário/senha no sistema, com registro de hora de acesso ao sistema e a dados dos passageiros para possíveis auditorias. Caso exista a possibilidade de acesso remoto, implementaria algum tipo de chave física para acesso (token) além do nome de usuário/senha.  
A integridade dos dados seria garantida pela robustez do sistema de registros (logs) e pelo cálculo de resumo matemático (hash - vamos aprender isso mais tarde) dos registros do passageiro que são armazenados criptografados com chave restrita à direção da empresa.  
A disponibilidade seria garantida por cópias de segurança periódicas da base de dados e arquivos de configuração e registros, e pela construção de um cluster de servidores e equipamentos (evitando pontos únicos de falhas).  
Agora é sua vez... como implementar estes atributos no sistema de TIC que você escolheu?  
***  
### Resposta   
Confidencialidade: A confidencialidade é garantida pela nuvem da Microsoft, sem histórico recente de incidentes.  
Autenticidade: A autenticidade é garantida por meio de login com dois fatores de autenticação (já implantado e não opcional), sempre necessários para acessar o serviço da Microsoft.  
Integridade: A integridade também é garantida pela nuvem da Microsoft, com os planos de backups contratados.  
Disponibilidade: O serviço oferecido em nuvem pela Microsoft garante disponibilidade maior do que se utilizado em servidores internos na própria organização. A única exceção seria a necessidade de conexão com a Internet para sua utilização.  
Obs.: Todos esses atributos de segurança, em teoria, devem ser mais bem atendidos por uma empresa do porte da Microsoft em comparação a uma Fundação estadual sem recursos e pessoal suficiente para implementar uma solução própria.  





