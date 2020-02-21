
export class Pagoscaja {
    idPagoCaja: number;
    idCaja: number;
    Importe: number;
    Descripcion: string;
    Hora: string;
    idEmpleado: number;
    Comentario: string;
}

export class NewPagoscaja {
    constructor(
            public idPagoCaja: number,
            public idCaja: number,
            public Importe: number,
            public Descripcion: string,
            public Hora: string,
            public idEmpleado: number,
            public Comentario: string){};            
};

export function PagoscajaToAJSON(data): Pagoscaja[]{
        return data["pagoscaja"].records.map((val) => {
                return {
                    idPagoCaja:		        val[0],
                    idCaja:	                val[1],
                    Importe:	            val[2],
                    Descripcion:	        val[3],
                    Hora:	                val[4],
                    idEmpleado:             val[5],
                    Comentario:             val[6],
                }
        });               
}