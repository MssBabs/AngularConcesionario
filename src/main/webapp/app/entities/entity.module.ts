import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'vehiculo',
        loadChildren: './vehiculo/vehiculo.module#ConcesionarioVehiculoModule'
      },
      {
        path: 'cliente',
        loadChildren: './cliente/cliente.module#ConcesionarioClienteModule'
      },
      {
        path: 'compra-venta',
        loadChildren: './compra-venta/compra-venta.module#ConcesionarioCompraVentaModule'
      },
      {
        path: 'trabajador',
        loadChildren: './trabajador/trabajador.module#ConcesionarioTrabajadorModule'
      },
      {
        path: 'cliente',
        loadChildren: './cliente/cliente.module#ConcesionarioClienteModule'
      },
      {
        path: 'compra-venta',
        loadChildren: './compra-venta/compra-venta.module#ConcesionarioCompraVentaModule'
      },
      {
        path: 'trabajador',
        loadChildren: './trabajador/trabajador.module#ConcesionarioTrabajadorModule'
      },
      {
        path: 'comision',
        loadChildren: './comision/comision.module#ConcesionarioComisionModule'
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ConcesionarioEntityModule {}
