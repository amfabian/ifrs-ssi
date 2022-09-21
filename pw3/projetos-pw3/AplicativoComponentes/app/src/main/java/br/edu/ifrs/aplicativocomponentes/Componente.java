package br.edu.ifrs.aplicativocomponentes;

public class Componente {
    private String nome;
    public Componente(){}
    public Componente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome;
    }

    public static Componente componentes[] = {new Componente("Spinner"),new Componente("ToggleButton"),
                                              new Componente("Switch"),new Componente("Checkbox"),
                                              new Componente("RadioButton")};
}
