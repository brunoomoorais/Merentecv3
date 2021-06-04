package br.etec.merenda.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.etec.merenda.model.Cardapio;
import br.etec.merenda.model.CardapioPrato;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Date> {
	
	/*@Query("select"
			+ "	c.dt_cardapio as Data,"
			+ "	p.qt_carboidrato as Carboidrato,"
			+ " p.nm_descricao as Descricao,"
			+ " p.qt_fibra as Fibra,"
			+ " p.qt_gordura_saturada as GorduraSaturada,"
			+ " p.qt_gordura_total as GorduraTotal,"
			+ " p.qt_gordura_trans as GorduraTrans,"
			+ " p.nm_prato as Nome,"
			+ " p.qt_peso as Peso,"
			+ " p.qt_proteina as Proteina,"
			+ " p.qt_sodio as Sodio,"
			+ " qt_valor_energetico as ValorEnergetico"
			+ " from tb_cardapio c join tb_prato p on c.fk_cd_prato = p.id where c.dt_cardapio >= ?1 order by c.dt_cardapio")*/
	@Query("select c from Cardapio c where c.data >= ?1")
	List<Cardapio> CardapioOrderByDate(Date data);
	
}
