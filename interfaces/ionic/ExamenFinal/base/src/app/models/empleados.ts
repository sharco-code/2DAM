export class Empleados {
    idEmpleado: number;
    Empleado: string;
    Clave: string;
}

export class NewEmpleado {
    constructor(
        idEmpleado: number,
        Empleado: string,
        Clave: string) {};            
};

export function EmpleadosToAJSON(data): Empleados[]{
        return data["empleados"].records.map((val) => {
            
                return {
                    idEmpleado:		val[0],
                    Empleado:	    val[1],
                    Clave:	        val[2]
                }
        });               
}