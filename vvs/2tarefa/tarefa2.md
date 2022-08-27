# Inspeções Estática com PMD  
## Aluno: Alexandre de Mesquita Fabian    
## Professor: Rodrigo Prestes Machado  

### Utilizado Projeto https://github.com/amfabian/tpack  

[Commit com as correções](https://github.com/amfabian/tpack/commit/020dbbf25c648e53497d058e8743522875f27b2a)  

### Apontamento:  
>   Falta de Comentário em Classe no [arquivo](https://github.com/amfabian/tpack/blob/master/src/main/java/edu/ifrs/tpack/TpackApplication.java)  linhas 28:35  
### Correção:
>  Criado comentário descrevendo classe.

***
### Apontamento:  
>   Método não usado no [arquivo](https://github.com/amfabian/tpack/blob/master/src/main/java/edu/ifrs/tpack/model/Question.java) linhas 69:75  
### Correção:  
>   Método comentado.

***
### Apontamento: 
>   Tamanho do bloco de comentários em diversos arquivos. Licença Apache. linhas 01:16

### Correção feita no [arquivo](https://github.com/amfabian/tpack/blob/master/pmd.xml):  

>   `<rule ref="category/java/documentation.xml/CommentSize">`  
>   `<properties>`  
>   `<property name="maxLines" value="18" />`  
>   ` <property name="maxLineLength" value="80" />`  
>   `</properties>`  
>   `</rule>`  


