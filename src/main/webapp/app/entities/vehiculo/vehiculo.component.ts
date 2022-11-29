import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiParseLinks, JhiAlertService } from 'ng-jhipster';

import { IVehiculo } from 'app/shared/model/vehiculo.model';
import { AccountService } from 'app/core';

import { ITEMS_PER_PAGE } from 'app/shared';
import { VehiculoService } from './vehiculo.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { VehiculoDetailsDialogComponent } from './vehiculo-detail-dialog.component';
import { VehiculoUpdateDialogComponent } from './vehiculo-update-dialog.component';


@Component({
  selector: 'jhi-vehiculo',
  templateUrl: './vehiculo.component.html'
})
export class VehiculoComponent implements OnInit, OnDestroy {
  currentAccount: any;
  vehiculos: IVehiculo[];
  error: any;
  success: any;
  eventSubscriber: Subscription;
  routeData: any;
  links: any;
  totalItems: any;
  itemsPerPage: any;
  page: any;
  predicate: any;
  previousPage: any;
  reverse: any;

  constructor(
    protected vehiculoService: VehiculoService,
    protected parseLinks: JhiParseLinks,
    protected jhiAlertService: JhiAlertService,
    protected accountService: AccountService,
    protected activatedRoute: ActivatedRoute,
    protected router: Router,
    protected eventManager: JhiEventManager,
    private modalService: NgbModal
  ) {
      this.itemsPerPage = ITEMS_PER_PAGE;
      this.routeData = this.activatedRoute.data.subscribe(data => {
      this.page = data.pagingParams.page;
      this.previousPage = data.pagingParams.page;
      this.reverse = data.pagingParams.ascending;
      this.predicate = data.pagingParams.predicate;
    });
  }

  loadAll() {
    this.vehiculoService
      .query({
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<IVehiculo[]>) => this.paginateVehiculos(res.body, res.headers),
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  loadPage(page: number) {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.transition();
    }
  }

  transition() {
    this.router.navigate(['/vehiculo'], {
      queryParams: {
        page: this.page,
        size: this.itemsPerPage,
        sort: this.predicate + ',' + (this.reverse ? 'asc' : 'desc')
      }
    });
    /*Recargar Objeto completo*/
    this.loadAll();
  }

  clear() {
    this.page = 0;
    this.router.navigate([
      '/vehiculo',
      {
        page: this.page,
        sort: this.predicate + ',' + (this.reverse ? 'asc' : 'desc')
      }
    ]);
    this.loadAll();
  }

  ngOnInit() {
    this.loadAll();
    this.accountService.identity().then(account => {
      this.currentAccount = account;
    });
    this.registerChangeInVehiculos();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: IVehiculo) {
    return item.id;
  }

  registerChangeInVehiculos() {
    this.eventSubscriber = this.eventManager.subscribe('vehiculoListModification', response => this.loadAll());
  }

  sort() {
    const result = [this.predicate + ',' + (this.reverse ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  viewModel(vehiculo) {
		const modalref = this.modalService.open(VehiculoDetailsDialogComponent);

    modalref.result.then(
		  (result) => {
        alert("Se han mostrado los detalles correctamente.");
		  }
		);

    modalref.componentInstance.vehiculo = vehiculo;
	}

  editModel(vehiculo) {
		const modalref = this.modalService.open(VehiculoUpdateDialogComponent);

    modalref.result.then(
		  (result) => {
        alert("Se han modificado los datos del vehiculo correctamente.");
        this.loadAll()
		  }
		);

    modalref.componentInstance.vehiculo = vehiculo;

    //modalref.componentInstance.ngOnInit();
	}

  getAllVehicles(){
    this.vehiculoService
      .query({
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort()
      })
      .subscribe(
        (res: HttpResponse<IVehiculo[]>) => this.paginateVehiculos(res.body, res.headers),
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  getVehiclesByType(evento) {
    console.log(evento);
    this.vehiculoService
      .query({
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
        tipo: evento
      })
      .subscribe(
        (res: HttpResponse<IVehiculo[]>) => this.paginateVehiculos(res.body, res.headers),
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  /*New getAvailableVehicles Filtre*/
  getAvailableVehicles(evento){
    this.vehiculoService
      .query({
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
        disponible: evento
      })
      .subscribe(
        (res: HttpResponse<IVehiculo[]>) => this.paginateVehiculos(res.body, res.headers),
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  /*New getNotAvailableVehicles Filtre*/
  getNotAvailableVehicles(evento){
    this.vehiculoService
      .query({
        page: this.page - 1,
        size: this.itemsPerPage,
        sort: this.sort(),
        noDisponible: evento
      })
      .subscribe(
        (res: HttpResponse<IVehiculo[]>) => this.paginateVehiculos(res.body, res.headers),
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }




  protected paginateVehiculos(data: IVehiculo[], headers: HttpHeaders) {
    this.links = this.parseLinks.parse(headers.get('link'));
    this.totalItems = parseInt(headers.get('X-Total-Count'), 10);
    this.vehiculos = data;
  }

  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}
