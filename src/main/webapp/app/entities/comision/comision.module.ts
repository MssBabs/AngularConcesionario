import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { ConcesionarioSharedModule } from 'app/shared';
import {
  ComisionComponent,
  ComisionDetailComponent,
  ComisionUpdateComponent,
  ComisionDeletePopupComponent,
  ComisionDeleteDialogComponent,
  comisionRoute,
  comisionPopupRoute
} from './';

const ENTITY_STATES = [...comisionRoute, ...comisionPopupRoute];

@NgModule({
  imports: [ConcesionarioSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    ComisionComponent,
    ComisionDetailComponent,
    ComisionUpdateComponent,
    ComisionDeleteDialogComponent,
    ComisionDeletePopupComponent
  ],
  entryComponents: [ComisionComponent, ComisionUpdateComponent, ComisionDeleteDialogComponent, ComisionDeletePopupComponent],
  providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ConcesionarioComisionModule {
  constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
    this.languageHelper.language.subscribe((languageKey: string) => {
      if (languageKey !== undefined) {
        this.languageService.changeLanguage(languageKey);
      }
    });
  }
}
