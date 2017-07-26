package form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.daos.LivroDao;
import br.com.casadocodigo.models.Livro;
import lombok.Getter;

@Model
public class AdminListaLivrosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LivroDao livroDao;

	private List<Livro> livros = new ArrayList<>();

	public List<Livro> getLivros() {
		livros = livroDao.listAll();

		return livros;
	}

}
