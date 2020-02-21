package pojos;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Esta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="can")
	private Cancion cancion;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cod")
	private Disco disco;
	
	

	public Esta() {
		super();
	}

	public Esta(Cancion cancion, Disco disco) {
		super();
		this.cancion = cancion;
		this.disco = disco;
	}

	public Cancion getCancion() {
		return cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancion == null) ? 0 : cancion.hashCode());
		result = prime * result + ((disco == null) ? 0 : disco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esta other = (Esta) obj;
		if (cancion == null) {
			if (other.cancion != null)
				return false;
		} else if (!cancion.equals(other.cancion))
			return false;
		if (disco == null) {
			if (other.disco != null)
				return false;
		} else if (!disco.equals(other.disco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Esta [cancion=" + cancion + ", disco=" + disco + "]";
	}
	
	
	
	
	

}
