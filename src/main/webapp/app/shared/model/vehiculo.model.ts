import { Moment } from 'moment';

export const enum Tipo {
  COCHE = 'COCHE',
  MOTO = 'MOTO',
  PATINETE = 'PATINETE',
  BICICLETA = 'BICICLETA'
}

export interface IVehiculo {
  id?: number;
  modelo?: string;
  tipo?: Tipo;
  precio?: number;
  matricula?: string;
  marca?: string;
  date?: Moment;
}

export class Vehiculo implements IVehiculo {
  constructor(
    public id?: number,
    public modelo?: string,
    public tipo?: Tipo,
    public precio?: number,
    public matricula?: string,
    public marca?: string,
    public date?: Moment
  ) {}
}
