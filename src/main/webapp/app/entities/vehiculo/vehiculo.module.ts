import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { ConcesionarioSharedModule } from 'app/shared';
import {
  VehiculoComponent,
  VehiculoDetailComponent,
  VehiculoUpdateComponent,
  VehiculoDeletePopupComponent,
  VehiculoDeleteDialogComponent,
  vehiculoRoute,
  vehiculoPopupRoute
} from './';
import { VehiculoDetailsDialogComponent } from './vehiculo-detail-dialog.component';
import { VehiculoUpdateDialogComponent } from './vehiculo-update-dialog.component';

const ENTITY_STATES = [...vehiculoRoute, ...vehiculoPopupRoute];

@NgModule({
  imports: [ConcesionarioSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    VehiculoComponent,
    VehiculoDetailComponent,
    VehiculoDetailsDialogComponent,
    VehiculoUpdateComponent,
    VehiculoUpdateDialogComponent,
    VehiculoDeleteDialogComponent,
    VehiculoDeletePopupComponent
  ],
  entryComponents: [VehiculoComponent, VehiculoUpdateComponent, VehiculoUpdateDialogComponent, VehiculoDeleteDialogComponent, VehiculoDetailsDialogComponent, VehiculoDeletePopupComponent],
  providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ConcesionarioVehiculoModule {
  constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
    this.languageHelper.language.subscribe((languageKey: string) => {
      if (languageKey !== undefined) {
        this.languageService.changeLanguage(languageKey);
      }
    });
  }
}
