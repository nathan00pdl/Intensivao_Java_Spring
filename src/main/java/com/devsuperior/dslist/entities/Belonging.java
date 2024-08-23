package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Classe 'Pertencimento' -> cada jogo pertence a qual lista (qual posição na lista)

@Entity  //Configuração da classe para equivaler a uma tabela do banco relacional
@Table (name = "tb_belonging")
public class Belonging {  

	@EmbeddedId
	private BelongingPK id = new BelongingPK();

	private Integer position;
	
	public Belonging () {}
	public Belonging (Game game, GameList list, Integer position) {
		id.setGame(game);
		id.setList(list);
		this.position = position;
	}
	
	public BelongingPK getId() {
		return id;
	}
	public void setId(BelongingPK id) {
		this.id = id;
	}
	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}	
}
