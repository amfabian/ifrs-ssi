# Características do modelo
Principal ideia do padrão arquitetural MVC é a separação dos conceitos
Separa a arquitetura do Software em três camadas  
* Model
* View 
* Controller

# Model  

* Responsável pela manipulação de DADOS.  
  
* Responsável também pela validação.  

# View  

* A camada de interação com o usuário.

* Apenas faz a exibição dos dados  

# Controller  

* Responsável pelas requisições do usuário.  

* Seus métodos controlam qual model usar e qual view apresentar.  


# Quando aplicar

- Quando se deseja facilitar a manutenção do código e aumentar a sua reutilização.    

- Pode ser utilizado em diversos tipos de projetos e independe da linguagem.  

- Bastante difundido no mercado.  

# Vantagens  

- Segurança: Controller atua como filtro não deixando erro chegar no model  
- Organização: Maior Organização, mais facilidade de manutenção (encontrar erros)
- Eficiência: Aplicação fica mais leve, dividida em três componentes  
- Tempo: devs podem trabalhar em parelelo, maiog rapidez na entrega  
- Transformação: Mais fácil implementar mudanças   
 Redução do acoplamento
 Possibilidade de reescrita da GUI ou do Controller

# Desvantagens
- Maior Complexidade    
- Arquitetura mais dificil de entender    
- Separa os arquivos de Interface do Usuário   
- Falta de restriçãod e acesso nos métodos do Controller

# Exemplo(s) de software(s) que utiliza(m) o padrão de arquitetura selecionado

- Softwares desenvolvidos com Ruby on Rails, Struts, Spring MVC, Laravel, Django, Etc...


# Referências  