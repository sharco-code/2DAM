
export class Caja {
    idCaja: number;
    Fecha: string;
    DineroCambio: number;
}

export class NewCaja {
    constructor(
            public idCaja: number,
            public Fecha: string,
            public DineroCambio: number){};            
};

export function CajaToAJSON(data): Caja[]{
        return data["caja"].records.map((val) => {
                return {
                    idCaja:		        val[0],
                    Fecha:	            val[1],
                    DineroCambio:	    val[2]
                }
        });               
}