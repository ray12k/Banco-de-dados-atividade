import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private List<Pessoa> listaPessoas = new ArrayList<>();

    public BancoDeDados() {
        listaPessoas.add(new Pessoa(listaPessoas.size() + 1, "thiago"));
        listaPessoas.add(new Pessoa(listaPessoas.size() + 1, "joao"));
        listaPessoas.add(new Pessoa(listaPessoas.size() + 1, "thialison"));
    }

    public List<Pessoa> obterTodos() {
        return listaPessoas;
    }

    public Pessoa obterPorId(Integer id) {
        return listaPessoas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Pessoa> obterPorNome(String nome) {
        var nomeMinusculo = nome.toLowerCase();

        var lista = listaPessoas.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nomeMinusculo))
                .toList();

        return lista;
    }
}
