export interface IComision {
  id?: number;
  porciento?: number;
  numeroVentas?: number;
}

export class Comision implements IComision {
  constructor(
    public id?: number,
    public porciento?: number,
    public numeroVentas?: number
    ) {}
}
